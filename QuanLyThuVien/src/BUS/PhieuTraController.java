package BUS;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import DTO.ChiTietPhieuMuon;
import DTO.Pair;
import DTO.PhieuMuon;
import DTO.PhieuPhat;
import GUI.PhieuPhatDialog;

public class PhieuTraController {
	private JButton jbtnThem, jbtnBo, jbtnCapNhat, jbtnPhat;
	private JTextField jtfSoLuong, jtfMaPM, jtfMaDG, jtfTenDG, jtfMaNV, jtfSearch;
	private JDateChooser jdcNgayMuon, jdcNgayPhaiTra, jdcNgayTra;
	private JList<String> sachTra; // JList for Sach Tra
	private JList<String> jlTinhTrangTra;
	private JPanel jpnViewSachMuon;
	private List<Pair<ChiTietPhieuMuon, String>> listItem; // Main List
	private JTable jtbSachMuon;
	private PhieuMuon pm;
	private String maNV;
	private JLabel jlbMsg;
	private JDialog dialog;

	private TableRowSorter<TableModel> rowSorter;
	private PhieuMuonService pmService;
	private List<String> sachTras; // List for JList Sach Tra
	private List<ChiTietPhieuMuon> DanhSachTra; // List for Database ( Pair<MaSach , SoLuong>)
	private List<Pair<String, Integer>> DanhSachMuon; // List for JTable Sach Muon ( Pair<TenSach , SoLuong>)
	private List<String> contentTinhTrang;
	private SachService sachService;

	public PhieuTraController(JButton jbtnThem, JButton jbtnBo, JButton jbtnCapNhat, JTextField jtfSoLuong,
			JTextField jtfMaPM, JTextField jtfMaDG, JTextField jtfTenDG, JTextField jtfMaNV, JTextField jtfSearch,
			JDateChooser jdcNgayMuon, JDateChooser jdcNgayPhaiTra, JDateChooser jdcNgayTra, JList<String> sachTra,
			JPanel jpnViewSachMuon, List<Pair<ChiTietPhieuMuon, String>> listItem, PhieuMuon pm, String maNV,
			JLabel jlbMsg, JList<String> tinhTrang, JButton jbtnPhat, JDialog dialog) {
		super();
		this.jbtnThem = jbtnThem;
		this.jbtnBo = jbtnBo;
		this.jbtnCapNhat = jbtnCapNhat;
		this.jtfSoLuong = jtfSoLuong;
		this.jtfMaPM = jtfMaPM;
		this.jtfMaDG = jtfMaDG;
		this.jtfTenDG = jtfTenDG;
		this.jtfMaNV = jtfMaNV;
		this.jtfSearch = jtfSearch;
		this.jdcNgayMuon = jdcNgayMuon;
		this.jdcNgayPhaiTra = jdcNgayPhaiTra;
		this.jdcNgayTra = jdcNgayTra;
		this.sachTra = sachTra;
		this.jpnViewSachMuon = jpnViewSachMuon;
		this.listItem = listItem;
		this.pm = pm;
		this.maNV = maNV;
		this.jlbMsg = jlbMsg;
		this.jlTinhTrangTra = tinhTrang;
		this.jbtnPhat = jbtnPhat;
		this.dialog = dialog;

		pmService = new PhieuMuonServiceImp();
		sachTras = new ArrayList<String>();
		DanhSachTra = new ArrayList<ChiTietPhieuMuon>();
		DanhSachMuon = getListSachMuonFromMainList(listItem);
		contentTinhTrang = new ArrayList<String>();
		sachService = new SachServiceimp();
	}

	String[] columnName = { "STT", "Tên Sách", "Số Lượng Mượn" };
	String s = "Tìm kiếm...";

	public void setView() {

		String maPM = pm.getMa_Phieu_Muon();

		jtfMaPM.setText(maPM);
		jtfMaPM.setEditable(false);

		jtfTenDG.setText(pmService.getDocGiaFromPhieuMuon(maPM).getHo_Ten());
		jtfTenDG.setEditable(false);

		jtfMaDG.setText(pm.getMa_Doc_Gia());
		jtfMaDG.setEditable(false);

		jtfMaNV.setText(maNV);
		jtfMaNV.setEditable(false);

		jtfSearch.setText(s);
		jtfSoLuong.setText("1");

		jdcNgayMuon.setDate(pm.getNgay_Muon());
		jdcNgayMuon.setEnabled(false);

		jdcNgayPhaiTra.setDate(pm.getNgay_Phai_Tra());
		jdcNgayTra.setDate(Calendar.getInstance().getTime());

		jlbMsg.setText("");

		jtbSachMuon = new JTable();
		setDataForTable(jtbSachMuon, DanhSachMuon, columnName);
		rowSorter = new TableRowSorter<TableModel>(jtbSachMuon.getModel());
		jtbSachMuon.setRowSorter(rowSorter);

		JScrollPane pane = new JScrollPane(jtbSachMuon);
		jpnViewSachMuon.removeAll();
		jpnViewSachMuon.setLayout(new BorderLayout());
		jpnViewSachMuon.add(pane);
		jpnViewSachMuon.validate();
		jpnViewSachMuon.repaint();

		jbtnPhat.setEnabled(false);

		contentTinhTrang.add("Bình Thường");
		contentTinhTrang.add("Mất Sách");
		contentTinhTrang.add("Hư Hại Sách");
		setDataForJList(contentTinhTrang, jlTinhTrangTra);
		jlTinhTrangTra.setSelectedIndex(0);

		if (jdcNgayPhaiTra.getDate().before(jdcNgayTra.getDate())) {
			jbtnPhat.setEnabled(true);
		} else {
			jbtnPhat.setEnabled(false);
		}
	}

	public void setEvent() {
		jtfSearch.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {

				String text = jtfSearch.getText();
				if (!text.equals(s) && text.trim().length() > 0) {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				} else
					rowSorter.setRowFilter(null);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				String text = jtfSearch.getText();
				if (!text.equals(s) && text.trim().length() > 0) {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				} else
					rowSorter.setRowFilter(null);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});

		jtfSearch.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (jtfSearch.getText().equals(""))
					jtfSearch.setText(s);
			}

			@Override
			public void focusGained(FocusEvent e) {

				if (jtfSearch.getText().equals(s))
					jtfSearch.setText("");
				else
					jtfSearch.selectAll();
			}
		});

		jtbSachMuon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				jtfSoLuong.setText("1");
				jtfSoLuong.requestFocus();

			}
		});

		jtfSoLuong.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				jtfSoLuong.selectAll();
			}
		});

		jbtnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = jtbSachMuon.getSelectedRow();
				if (row != -1) {
					row = jtbSachMuon.convertRowIndexToModel(row);

					// Kiem tra So Luong co hop le khong
					if (ClassSupport.checkText(jtfSoLuong.getText().trim(), "\\d+")) {

						int soLuong = Integer.parseInt(jtfSoLuong.getText());
						// Lay Sach khi chon tu bang sach muon
						Pair<String, Integer> pair = DanhSachMuon.get(row);
						// end.

						if (soLuong <= pair.getV()) {
							btnThemClick(row, soLuong, pair);
						} else {
							JOptionPane.showMessageDialog(null, "Số Lượng Trả đã vượt quá Số Lượng Mượn");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Số Lượng không hợp lệ!!!");
					jtfSoLuong.requestFocus();
				}
			}
		});

		jbtnBo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int[] indexSelected = sachTra.getSelectedIndices();
				if (indexSelected.length > 0) {
					for (int i : indexSelected) {

						String[] temp = sachTras.get(i).split(" - ");
						// S1000 - Conan x 1 => temp[0] = S1000 , temp[1] = Conan x 1;

						// remove sach tra trong JList sach tra
						sachTras.remove(i);
						// end.

						int soLuong = Integer.parseInt(ClassSupport.findString(temp[1], "(\\d+)"));
						// Update so luong cho Danh Sach Tra
						ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();

						ctpm.setMa_Phieu_Muon(pm.getMa_Phieu_Muon());
						ctpm.setMa_Sach(temp[0]);
						ctpm.setSo_Luong_Tra(soLuong * -1);
						ctpm.setNgay_tra(jdcNgayTra.getDate());
						ctpm.setTinh_Trang_Tra("");

						updateSoLuongForListSachTra(ctpm);

						// end.

						// update soLuong cho Table
						for (int j = 0; j < DanhSachMuon.size(); j++) {
							if (listItem.get(j).getK().getMa_Sach().compareTo(temp[0]) == 0) {
								DanhSachMuon.get(j).setV(DanhSachMuon.get(j).getV() + soLuong);
							}
						}
						setDataForTable(jtbSachMuon, DanhSachMuon, columnName);
					}
				}
			}
		});

		jlTinhTrangTra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (jlTinhTrangTra.getSelectedIndex() != 0) {
					jbtnPhat.setEnabled(true);
				} else
					jbtnPhat.setEnabled(false);

			}
		});

		jbtnCapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (DanhSachTra.size() > 0) {

					// update Hoan Tra cho Phieu Muon
					boolean check = true;
					for (Pair<String, Integer> pair : DanhSachMuon) {
						if (pair.getV() != 0) {
							check = false;
							break;
						}
					}

					if (check) {
						pmService.updateHoanTraForPhieuMuon(pm.getMa_Phieu_Muon());
					}
					// end.

					if (!pmService.editPhieuTra(DanhSachTra)) {

						resetData();
						jlbMsg.setText("Cập nhật thất bại!");
					} else {
						resetData();
						jlbMsg.setText("Cập nhật thành công!");
					}
				}
			}
		});

		jbtnPhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = jtbSachMuon.getSelectedRow();
				if (row != -1) {
					row = jtbSachMuon.convertRowIndexToModel(row);

					// Kiem tra So Luong co hop le khong
					if (ClassSupport.checkText(jtfSoLuong.getText().trim(), "\\d+")) {

						int soLuong = Integer.parseInt(jtfSoLuong.getText());
						// Lay Sach khi chon tu bang sach muon
						Pair<String, Integer> pair = DanhSachMuon.get(row);
						// end.

						if (soLuong <= pair.getV()) {
							row = jtbSachMuon.convertRowIndexToModel(row);
							// Lấy Ngày Trả và Ngày Phải Trả
							Pair<Date, Date> date = new Pair<Date, Date>(jdcNgayTra.getDate(),
									jdcNgayPhaiTra.getDate());

							// Lấy Tên ĐG và Tên Sách
							Pair<String, String> ten = new Pair<String, String>(jtfTenDG.getText(),
									DanhSachMuon.get(row).getK());

							// Lấy Số Lượng Sách Phạt và Mã Sách Phạt
							String maSach = listItem.get(row).getK().getMa_Sach();
							String sql = "select gia_tien from sach where ma_sach = '" + maSach + "'";
							Pair<Integer, Integer> sach = new Pair<Integer, Integer>(
									Integer.parseInt(jtfSoLuong.getText()),
									(Integer) sachService.getSomeThingFromSach(sql));

							// Lấy Lý do
							int[] item = jlTinhTrangTra.getSelectedIndices();
							String lyDo = "";
							for (int i : item) {
								lyDo += contentTinhTrang.get(i) + ", ";
							}
							lyDo = lyDo.substring(0, lyDo.length() - 2);
							if (jdcNgayTra.getDate().after(jdcNgayPhaiTra.getDate())) {
								lyDo += ", " + "Trễ Hạn";
							}

							// Lấy Phiếu Phạt
							PhieuPhat pp = new PhieuPhat(pm.getMa_Phieu_Muon(), maSach, lyDo, 0);
							PhieuPhatDialog view = new PhieuPhatDialog(dialog, true, pp, ten, date, sach);
							view.setLocationRelativeTo(null);
							view.setVisible(true);

							btnThemClick(row, soLuong, pair);
							jlTinhTrangTra.setSelectedIndex(0);

						} else {
							JOptionPane.showMessageDialog(null, "Số Lượng Trả đã vượt quá Số Lượng Mượn");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Số Lượng không hợp lệ!!!");
						jtfSoLuong.requestFocus();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Chưa trọn sách!!!");
				}
			}
		});

		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				if (DanhSachTra.size() > 0) {
					int choose = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát???");
					if (choose == 0)
						dialog.dispose();
				} else
					dialog.dispose();
			}

			@Override
			public void windowOpened(WindowEvent e) {

				JOptionPane.showMessageDialog(null, "Hãy kiểm tra kĩ sách trước khi nhập thông tin!");
			}
		});
	}

	public void resetData() {
		jlbMsg.setText("");
		DanhSachTra.clear();
		sachTras.clear();
		setDataForJList(sachTras, sachTra);
	}

	public DefaultTableModel getmodel(List<Pair<String, Integer>> listItem, String[] columnName) {
		DefaultTableModel model = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};

		model.setRowCount(0);
		model.setColumnIdentifiers(columnName);
		int count = 1;
		for (Pair<String, Integer> pair : listItem) {
			model.addRow(new Object[] { count++, pair.getK(), pair.getV() });
		}

		return model;
	}

	public void updateSoLuongForListSachTra(ChiTietPhieuMuon ctpm) {
		// Update so luong cho Danh Sach Tra

		boolean checkSach = false;
		for (ChiTietPhieuMuon ct : DanhSachTra) {
			if (ct.getMa_Sach().compareTo(ctpm.getMa_Sach()) == 0) {
				ct.setSo_Luong_Tra(ct.getSo_Luong_Tra() + ctpm.getSo_Luong_Tra());
				checkSach = true;
				break;
			}
		}
		if (!checkSach) {
			DanhSachTra.add(ctpm);
		}
		setDataForJList(sachTras, sachTra);
		// end.

	}

	public void setDataForJList(List<String> listItem, JList<String> jList) {
		jList.setModel(new AbstractListModel<String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getElementAt(int index) {

				return listItem.get(index);
			}

			@Override
			public int getSize() {

				return listItem.size();
			}
		});
	}

	public List<Pair<String, Integer>> getListSachMuonFromMainList(List<Pair<ChiTietPhieuMuon, String>> mainList) {
		List<Pair<String, Integer>> listMuon = new ArrayList<Pair<String, Integer>>();

		for (Pair<ChiTietPhieuMuon, String> pairMain : mainList) {
			Pair<String, Integer> pair = new Pair<String, Integer>();
			pair.setK(pairMain.getV());
			pair.setV(pairMain.getK().getSo_Luong_Muon() - pairMain.getK().getSo_Luong_Tra());
			listMuon.add(pair);
		}
		return listMuon;
	}

	public <E> void setDataForTable(JTable tbl, List<Pair<String, Integer>> list, String[] columnName) {
		DefaultTableModel model = getmodel(list, columnName);
		tbl.setModel(model);

		tbl.setRowHeight(50);
		tbl.getTableHeader().setPreferredSize(new Dimension(100, 50));
		tbl.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 16));
		tbl.setFont(new Font("tahoma", Font.BOLD, 14));
	}

	public void btnThemClick(int row, int soLuong, Pair<String, Integer> pair) {
		// Lay ma sach tu MainList
		String maSach = listItem.get(row).getK().getMa_Sach();
		// end.

		// Update so luong cho table Danh Sach Muon
		DanhSachMuon.get(row).setV(pair.getV() - soLuong);
		setDataForTable(jtbSachMuon, DanhSachMuon, columnName);
		// end.

		// Update so luong cho Danh Sach Tra
		ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();

		ctpm.setMa_Phieu_Muon(pm.getMa_Phieu_Muon());
		ctpm.setMa_Sach(maSach);
		ctpm.setSo_Luong_Tra(soLuong);
		ctpm.setNgay_tra(jdcNgayTra.getDate());

		// Xet cac truong hop cho Tinh trang tra de lap phieu phat
		// 1. Sach.
		String tinhTrang = "";
		int[] selectedTinhTrangTra = jlTinhTrangTra.getSelectedIndices();
		for (int i : selectedTinhTrangTra) {
			tinhTrang += contentTinhTrang.get(i) + ", ";
		}
		tinhTrang = tinhTrang.substring(0, tinhTrang.length() - 2);
		// 2. Tre Han.
		if (jdcNgayTra.getDate().after(jdcNgayPhaiTra.getDate()))
			tinhTrang += ", " + "Trễ Hạn";

		ctpm.setTinh_Trang_Tra(tinhTrang);
		// end.

		updateSoLuongForListSachTra(ctpm);
		// end.

		// update sach cho JList sach tra
		sachTras.add(maSach + " - " + pair.getK() + " x " + soLuong + " - " + tinhTrang);
		setDataForJList(sachTras, sachTra);
		// end.
	}

}
