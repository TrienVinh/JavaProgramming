package BUS;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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

import DTO.Pair;
import DTO.PhieuMuon;
import DTO.SachTimKiem;
import DTO.TheLoai;

public class PhieuMuonDialogController {
	private JPanel jpnViewTheLoai, jpnViewSach;
	private JList<String> jlSachMuon;
	private JTextField jtfMaPM, jtfTenDG, jtfMaNV, jtfCMND, jtfSearchTL, jtfSearchSach, jtfSoSachMuon;
	private JDateChooser jdcNgayMuon, jdcNgayPhaiTra;
	private JButton jbtnThem, jbtnBo, jbtnLapPhieu;
	private JDialog dialog;
	private JLabel jlbMsg;

	private List<SachTimKiem> listSach;
	private List<TheLoai> listTheLoai;
	private JTable jtbSach, jtbTheLoai;

	private SachService sachsv;
	private TheLoaiService theLoaisv;
	private PhieuMuonService phieuMuonsv;

	private Date date;
	private List<String> sachMuons; // Dung de hien thi sach muon len view
	private List<Pair<String, Integer>> DanhSachMuon; // Dung de luu thong tin sach xuong database
	private String maNV;

	private TableRowSorter<TableModel> rowSorterSach, rowSorterTheLoai;
	private JMenuItem jmiLamMoi;
	private JMenuItem jmiLamMoiSachMuon;

	public PhieuMuonDialogController(JPanel jpnViewTheLoai, JPanel jpnViewSach, JList<String> jlSachMuon,
			JTextField jtfMaPM, JTextField jtfTenDG, JTextField jtfMaNV, JTextField jtfCMND, JTextField jtfSearchTL,
			JTextField jtfSearchSach, JDateChooser jdcNgayMuon, JDateChooser jdcNgayPhaiTra, JButton jbtnThem,
			JButton jbtnBo, JButton jbtnLapPhieu, JTextField jtfSoSachMuon, String maNV, JDialog dialog,
			JLabel jlbMsg) {
		super();
		this.jpnViewTheLoai = jpnViewTheLoai;
		this.jpnViewSach = jpnViewSach;
		this.jlSachMuon = jlSachMuon;
		this.jtfMaPM = jtfMaPM;
		this.jtfTenDG = jtfTenDG;
		this.jtfMaNV = jtfMaNV;
		this.jtfCMND = jtfCMND;
		this.jtfSearchTL = jtfSearchTL;
		this.jtfSearchSach = jtfSearchSach;
		this.jdcNgayMuon = jdcNgayMuon;
		this.jdcNgayPhaiTra = jdcNgayPhaiTra;
		this.jbtnThem = jbtnThem;
		this.jbtnBo = jbtnBo;
		this.jbtnLapPhieu = jbtnLapPhieu;
		this.jtfSoSachMuon = jtfSoSachMuon;
		this.maNV = maNV;
		this.dialog = dialog;
		this.jlbMsg = jlbMsg;

		listSach = new ArrayList<SachTimKiem>();
		listTheLoai = new ArrayList<TheLoai>();

		sachsv = new SachServiceimp();
		theLoaisv = new TheLoaiServiceImp();
		phieuMuonsv = new PhieuMuonServiceImp();

		date = Calendar.getInstance().getTime();

		listSach = sachsv.getListSachTimKiem();
		listTheLoai = theLoaisv.getListTheLoai();

		sachMuons = new ArrayList<String>();

	}

	String[] columnNameSach = { "STT", "Tên Sách", " Tác Giả", "Thể Loại", "Số Lượng" };
	String[] columnNameTheLoai = { "STT", "Tên Thể Loại" };
	String searchSach = " Nhap thong tin muon tim...", searchTL = " Nhap thong tin muon tim...";

	@SuppressWarnings("deprecation")
	public void setView() {

		int id = (phieuMuonsv.getLastId().equals("")) ? 999
				: Integer.parseInt(ClassSupport.findString(phieuMuonsv.getLastId(), "(\\d++)"));
		PhieuMuon.setsId(++id);

		jtfMaPM.setText(PhieuMuon.getsId());
		jdcNgayMuon.setDate(date);
		date.setDate(date.getDate() + 7);
		jdcNgayPhaiTra.setDate(date);
		jtfCMND.setText("");
		jtfTenDG.setText("");

		jtfMaNV.setText(maNV);
		jtfMaNV.setEditable(false);

		jtfSearchSach.setText(searchSach);
		jtfSearchTL.setText(searchTL);
		jtfSoSachMuon.setText("1");

		setModelForJList(sachMuons);

		jtbSach = new JTable();
		JPopupMenu jpop = new JPopupMenu();
		jmiLamMoi = new JMenuItem("Làm Mới");
		jpop.add(jmiLamMoi);
		addPopup(jtbSach, jpop);

		JPopupMenu jpopSachMuon = new JPopupMenu();
		jmiLamMoiSachMuon = new JMenuItem("Làm Mới Sách Mượn");
		jpopSachMuon.add(jmiLamMoiSachMuon);
		addPopup(jlSachMuon, jpopSachMuon);

		setViewForPanel(jpnViewSach, jtbSach, listSach, columnNameSach);
		rowSorterSach = new TableRowSorter<TableModel>(jtbSach.getModel());
		jtbSach.setRowSorter(rowSorterSach);

		jtbTheLoai = new JTable();
		setViewForPanel(jpnViewTheLoai, jtbTheLoai, listTheLoai, columnNameTheLoai);
		rowSorterTheLoai = new TableRowSorter<TableModel>(jtbTheLoai.getModel());
		jtbTheLoai.setRowSorter(rowSorterTheLoai);

		DanhSachMuon = new ArrayList<Pair<String, Integer>>();

	}

	public void setEvent() {

		jtfSoSachMuon.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (jtfSoSachMuon.getText().compareTo("") == 0) {
					jtfSoSachMuon.setText("1");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {

				jtfSoSachMuon.selectAll();
			}
		});

		jtfCMND.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfTenDG.requestFocus();
				}
			}
		});

		jtfTenDG.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jdcNgayMuon.requestFocus();
				}
			}
		});

		jtfSearchSach.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {

				String text = jtfSearchSach.getText();
				if (!text.equals(searchSach) && text.trim().length() > 0) {
					rowSorterSach.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				} else
					rowSorterSach.setRowFilter(null);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				String text = jtfSearchSach.getText();
				if (!text.equals(searchSach) && text.trim().length() > 0) {
					rowSorterSach.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				} else
					rowSorterSach.setRowFilter(null);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});

		jtfSearchTL.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {

				String text = jtfSearchTL.getText();
				if (!text.equals(searchTL) && text.trim().length() > 0) {
					rowSorterTheLoai.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				} else
					rowSorterTheLoai.setRowFilter(null);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				String text = jtfSearchTL.getText();
				if (!text.equals(searchTL) && text.trim().length() > 0) {
					rowSorterTheLoai.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				} else
					rowSorterTheLoai.setRowFilter(null);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});

		jtfSearchSach.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (jtfSearchSach.getText().equals(""))
					jtfSearchSach.setText(searchSach);
			}

			@Override
			public void focusGained(FocusEvent e) {

				if (jtfSearchSach.getText().equals(searchSach))
					jtfSearchSach.setText("");
				else
					jtfSearchSach.selectAll();
			}
		});

		jtbTheLoai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = jtbTheLoai.getSelectedRow();
				if (e.getClickCount() == 2 && row != -1) {
					row = jtbTheLoai.convertRowIndexToModel(row);
					String theLoai = listTheLoai.get(row).getTen_The_Loai();
					rowSorterSach.setRowFilter(RowFilter.regexFilter("(?i)" + theLoai));
				}
			}
		});

		jtfSearchTL.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (jtfSearchTL.getText().equals(""))
					jtfSearchTL.setText(searchTL);
			}

			@Override
			public void focusGained(FocusEvent e) {

				if (jtfSearchTL.getText().equals(searchTL))
					jtfSearchTL.setText("");
				else
					jtfSearchTL.selectAll();
			}
		});

		jmiLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rowSorterSach.setRowFilter(null);
			}
		});

		jmiLamMoiSachMuon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (String string : sachMuons) {
					// Giam so luong khi loai bo sach trong list luu xuong database
					String[] temp = string.split(" - ");
					// sachMuons.get(0) = S1000 - Conan x 1 => temp[0] = S1000 , temp[1] = Conan x 1
					String maSach = temp[0].trim();
					int soLuong = Integer.parseInt(ClassSupport.findString(temp[1], "(\\d+)"));

					// Loai bo het sach da muon trong list hien thi xuong database
					DanhSachMuon.clear();
					// end

					// Cap nhat so luong cho list Sach
					Pair<String, Integer> pair = new Pair<String, Integer>(maSach, soLuong * -1);
					updateSoLuongForSach(listSach, pair);
					// end.
				}
				resetListSachMuon();
			}
		});

		jtbSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (!jtfSoSachMuon.getText().equals("1"))
					jtfSoSachMuon.setText("1");
				jtfSoSachMuon.requestFocus();
			}
		});

		jtfSoSachMuon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					btnThemClick();
			}
		});

		jbtnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnThemClick();
			}
		});

		jbtnBo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int[] indexSelected = new int[sachMuons.size()];
				indexSelected = jlSachMuon.getSelectedIndices();
				for (int i : indexSelected) {

					// Giam so luong khi loai bo sach trong list luu xuong database
					String[] temp = sachMuons.get(i).split(" - ");
					// sachMuons.get(0) = S1000 - Conan x 1 => temp[0] = S1000 , temp[1] = Conan x 1
					String maSach = temp[0].trim();
					int soLuong = Integer.parseInt(ClassSupport.findString(temp[1], "(\\d+)"));
					// Giam so luong
					for (Pair<String, Integer> pair : DanhSachMuon) {
						if (pair.getK().equals(maSach)) {
							pair.setV(pair.getV() - soLuong);
							break;
						}
					}
					// end.

					// Loai bo sach da xoa trong list hien thi len View
					sachMuons.remove(i);
					// end

					// Load Lai JList
					setModelForJList(sachMuons);
					// end.

					// Cap nhat so luong cho list Sach
					Pair<String, Integer> pair = new Pair<String, Integer>(maSach, soLuong * -1);
					updateSoLuongForSach(listSach, pair);
					// end.
				}
			}
		});

		jbtnLapPhieu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (DanhSachMuon.size() > 0) {

					String maPM = jtfMaPM.getText();
					String CMND = jtfCMND.getText();
					if (ClassSupport.checkText(CMND, "\\d{12}")) {

						String tenDG = jtfTenDG.getText();
						if (ClassSupport.checkText(tenDG, ".+")) {

							String maNV = jtfMaNV.getText();
							Date ngayMuon = jdcNgayMuon.getDate();
							Date ngayPhaiTra = jdcNgayPhaiTra.getDate();

							int tongSachMuon = 0;
							for (Pair<String, Integer> pair : DanhSachMuon) {
								tongSachMuon += pair.getV();
							}

							PhieuMuon pm = new PhieuMuon(maPM, tongSachMuon, "", maNV, ngayMuon, ngayPhaiTra, false);
							if (phieuMuonsv.addPhieuMuon(pm, DanhSachMuon, new Pair<String, String>(CMND, tenDG))) {
								jlbMsg.setText("Hoàn Tất Hoá Đơn");
								resetListSachMuon();
							} else
								jlbMsg.setText("Thất Bại");
						} else {
							jlbMsg.setText("Tên Độc Giả không được để trống!");
						}
					} else {
						jlbMsg.setText("CMND phải 12 số. Xin hãy kiểm tra lai.!");
					}

				} else
					jlbMsg.setText("Danh sach muon chua co!");
			}
		});

		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				if (sachMuons.size() > 0) {
					int choose = JOptionPane.showConfirmDialog(null,
							"Phiếu Mượn chưa thanh toán. Bạn có chắc muốn thoát???");
					if (choose == 0)
						dialog.dispose();
				} else
					dialog.dispose();
			}
		});
	}

	public void btnThemClick() {
		int row = jtbSach.getSelectedRow();
		if (row != -1) {

			row = jtbSach.convertRowIndexToModel(row);

			SachTimKiem sachTk = listSach.get(row);
			int soLuong = Integer.parseInt(jtfSoSachMuon.getText());

			if (sachTk.getSo_Luong() >= soLuong) {
				String thongTinSach = sachTk.getMa_Sach() + " - " + sachTk.getTen_Sach() + " x " + soLuong;

				// Load Thong tin len View
				sachMuons.add(thongTinSach);
				setModelForJList(sachMuons);
				// end Load.

				// Cap nhat du lieu trong List de luu xuong database
				boolean check = false;
				for (Pair<String, Integer> item : DanhSachMuon) {
					if (item.getK().compareTo(sachTk.getMa_Sach()) == 0) {
						item.setV(item.getV() + soLuong);
						check = true;
						break;
					}
				}
				Pair<String, Integer> pair = new Pair<String, Integer>(sachTk.getMa_Sach(), soLuong);
				if (!check) {
					DanhSachMuon.add(pair);
				}
				// end.

				// Cap nhat so luong cho list Sach
				updateSoLuongForSach(listSach, pair);
				// end.
			} else {
				JOptionPane.showMessageDialog(null, "Số lượng sách không đủ!");
				jtfSoSachMuon.requestFocus();
			}
		}
	}

	public void updateSoLuongForSach(List<SachTimKiem> list, Pair<String, Integer> pair) {
		for (SachTimKiem sachTimKiem : list) {
			if (sachTimKiem.getMa_Sach().compareTo(pair.getK()) == 0) {
				sachTimKiem.setSo_Luong(sachTimKiem.getSo_Luong() - pair.getV());
				break;
			}
		}
		DefaultTableModel model = setModelForTable(list, columnNameSach);
		jtbSach.setModel(model);
		setRowHeightForTable(jtbSach);
	}

	public void resetData() {
		jlbMsg.setText("");
		jtfCMND.setText("");
		jtfTenDG.setText("");
		resetListSachMuon();
	}

	public void resetListSachMuon() {
		sachMuons.clear();
		setModelForJList(sachMuons);
	}

	public <E> void setViewForPanel(JPanel jpnView, JTable jtb, List<E> list, String[] columnName) {
		DefaultTableModel model = setModelForTable(list, columnName);
		jtb.setModel(model);
		setRowHeightForTable(jtb);

		JScrollPane pane = new JScrollPane(jtb);

		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(pane);
		jpnView.validate();
		jpnView.repaint();
	}

	public void setModelForJList(List<String> model) {
		jlSachMuon.setModel(new AbstractListModel<String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getElementAt(int index) {

				return model.get(index);
			}

			@Override
			public int getSize() {

				return model.size();
			}

		});
	}

	public <E> DefaultTableModel setModelForTable(List<E> listItem, String[] columnName) {
		DefaultTableModel model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		model.setRowCount(0);
		model.setColumnIdentifiers(columnName);
		int count = 1;
		for (E e : listItem) {
			if (e instanceof TheLoai) {
				TheLoai tl = (TheLoai) e;
				model.addRow(new Object[] { count++, tl.getTen_The_Loai() });
			} else if (e instanceof SachTimKiem) {
				SachTimKiem s = (SachTimKiem) e;
				model.addRow(
						new Object[] { count++, s.getTen_Sach(), s.getTac_Gia(), s.getThe_Loai(), s.getSo_Luong() });
			}
		}
		return model;
	}

	public void setRowHeightForTable(JTable tbl) {
		tbl.setRowHeight(50);
		tbl.setFont(new Font("tahoma", Font.PLAIN, 14));

		tbl.getTableHeader().setPreferredSize(new Dimension(100, 50));
		tbl.getColumnModel().getColumn(0).setPreferredWidth(15);
	}

	private void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
