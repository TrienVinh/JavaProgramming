package BUS;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
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

import DTO.NhaCungCap;
import DTO.Pair;
import DTO.PhieuNhapHang;
import DTO.SachTimKiem;
import DTO.TheLoai;
import GUI.ThemSachDialog;

public class PhieuNhapDialogController {
	private JTextField jtfSoSachNhap, jtfSearchSach, jtfSearchTL, jtfMaPN, jtfMaNV;
	private JComboBox<String> jcbMaNCC;
	private JDateChooser jdcNgayNhap;
	private JList<String> jlSachNhap; // Danh cho JList Sach Nhap
	private JPanel jpnViewTL, jpnViewSach;
	private JButton jbtnThem, jbtnBo, jbtnThemSach, jbtnLapPhieu;
	private JLabel jlbMsg;
	private String maNV;
	private JFrame frame;
	private JDialog dialog;

	private JMenuItem jmiLamMoi;

	private JTable jtbSach, jtbTL;
	private TableRowSorter<TableModel> rowSorterSach, rowSorterTL;

	private TheLoaiService tlService;
	private SachService sService;
	private PhieuNhapService pnService;
	private NhaCungCapService nccService;

	private List<TheLoai> listTheLoai; // List de the hien le jtbTL
	private List<Pair<String, String>> listSachNhapDB; // List Danh cho database khi lap phieu Pair<maSach , SoLuong -
														// GiaTien>

	private List<SachTimKiem> listSach;// List de the hien len jtbSachNhap
	private List<String> listSachNhap; // List de the hien len JList Sach Nhap

	public PhieuNhapDialogController(JTextField jtfSoSachNhap, JTextField jtfSearchSach, JTextField jtfSearchTL,
			JTextField jtfMaPN, JTextField jtfMaNV, JComboBox<String> jcbMaNCC, JDateChooser jdcNgayNhap,
			JList<String> jlSachNhap, JPanel jpnViewTL, JPanel jpnViewSach, JButton jbtnThem, JButton jbtnBo,
			JButton jbtnThemSach, JButton jbtnLapPhieu, JLabel jlbMsg, String maNV, JFrame frame, JDialog dialog) {
		super();
		this.jtfSoSachNhap = jtfSoSachNhap;
		this.jtfSearchSach = jtfSearchSach;
		this.jtfSearchTL = jtfSearchTL;
		this.jtfMaPN = jtfMaPN;
		this.jtfMaNV = jtfMaNV;
		this.jcbMaNCC = jcbMaNCC;
		this.jdcNgayNhap = jdcNgayNhap;
		this.jlSachNhap = jlSachNhap;
		this.jpnViewTL = jpnViewTL;
		this.jpnViewSach = jpnViewSach;
		this.jbtnThem = jbtnThem;
		this.jbtnBo = jbtnBo;
		this.jbtnThemSach = jbtnThemSach;
		this.jbtnLapPhieu = jbtnLapPhieu;
		this.jlbMsg = jlbMsg;
		this.maNV = maNV;
		this.frame = frame;
		this.dialog = dialog;

		jtfMaNV.setEditable(false);
		jdcNgayNhap.setEnabled(false);

		tlService = new TheLoaiServiceImp();
		sService = new SachServiceimp();
		pnService = new PhieuNhapServiceImp();
		nccService = new NhaCungCapServiceImp();

		listTheLoai = tlService.getListTheLoai();

	}

	String search = "Tìm Kiếm...";
	String[] columnNameSach = { "STT", "Tên Sách", "Thể Loại", "Số Lượng", "Giá Tiền" };
	String[] columnNameTL = { "STT", "Tên Thể Loại" };

	public void resetDataForDialog() {
		listSach = sService.getListSachTimKiem();
		listSachNhap = new ArrayList<String>();
		listSachNhapDB = new ArrayList<Pair<String, String>>();

		String ma = pnService.getLastId();
		if (!ma.equals("")) {
			PhieuNhapHang.setsId(ma);
		}
		jtfMaPN.setText(PhieuNhapHang.getsId());

		jtfMaNV.setText(maNV);
		jtfSoSachNhap.setText("1");
		jtfSearchSach.setText(search);
		jtfSearchTL.setText(search);

		jcbMaNCC.setModel(new DefaultComboBoxModel<String>(getComboBoxFromListNCC()));
		jdcNgayNhap.setDate(Calendar.getInstance().getTime());

		jlbMsg.setText("");

		jtbSach = new JTable();
		setModelForJTableAndSetPanel(jtbSach, listSach, columnNameSach, jpnViewSach);
		rowSorterSach = new TableRowSorter<TableModel>(jtbSach.getModel());
		jtbSach.setRowSorter(rowSorterSach);
	}

	public void setView() {

		resetDataForDialog();

		jtbTL = new JTable();
		setModelForJTableAndSetPanel(jtbTL, listTheLoai, columnNameTL, jpnViewTL);
		rowSorterTL = new TableRowSorter<TableModel>(jtbTL.getModel());
		jtbTL.setRowSorter(rowSorterTL);

		setModelForJList(jlSachNhap, listSachNhap);

		JPopupMenu pop = new JPopupMenu();
		jmiLamMoi = new JMenuItem("Làm Mới");
		pop.add(jmiLamMoi);
		addPop(jtbTL, pop);

	}

	public void setEvent() {

		jtfSearchSach.addFocusListener(new FocusEvent(search, jtfSearchSach));
		jtfSearchSach.getDocument().addDocumentListener(new documentEvent(search, rowSorterSach, jtfSearchSach));

		jtfSearchTL.addFocusListener(new FocusEvent(search, jtfSearchTL));
		jtfSearchTL.getDocument().addDocumentListener(new documentEvent(search, rowSorterTL, jtfSearchTL));

		jtbSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				jtfSoSachNhap.setText("1");
				jtfSoSachNhap.selectAll();
				jtfSoSachNhap.requestFocus();
			}
		});

		jtbTL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = jtbTL.getSelectedRow();
				if (row != -1) {
					row = jtbTL.convertRowIndexToModel(row);
					String theLoai = listTheLoai.get(row).getTen_The_Loai();
					rowSorterSach.setRowFilter(RowFilter.regexFilter("(?i)" + theLoai));
				}
			}
		});

		jmiLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rowSorterSach.setRowFilter(null);
			}
		});

		jbtnThemSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ThemSachDialog dialog = new ThemSachDialog(frame, true);
				dialog.setView();
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);

				listSach = sService.getListSachTimKiem();

				DefaultTableModel model = getModel(listSach, columnNameSach);
				jtbSach.setModel(model);
				setSizeForJTable(jtbSach);
//				setModelForJTableAndSetPanel(jtbSach, listSachTimKiem, columnNameSach, jpnViewSach);
			}

		});

		jtfSoSachNhap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnThemClick();
				}
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
				int[] selectedJList = jlSachNhap.getSelectedIndices();
				for (int i : selectedJList) {
					String sachNhap = listSachNhap.get(i);

					// update List Sach Nhap Database
					updateForListStringDatabase(listSachNhapDB, sachNhap, -1);

				}

				List<String> listTemp = new ArrayList<String>();
				for (int i = 0; i < listSachNhap.size(); i++) {
					boolean isOk = false;
					for (int j : selectedJList) {
						if (i == j) {
							isOk = true;
							break;
						}
					}
					if (!isOk) {
						listTemp.add(listSachNhap.get(i));
					}
				}
				listSachNhap.clear();
				listSachNhap = listTemp;
				setModelForJList(jlSachNhap, listSachNhap);

			}
		});

		jbtnLapPhieu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int choose = JOptionPane.showConfirmDialog(null, "Hãy kiểm tra kĩ thông tin.\nNhấn OK để tiếp tục.");
				if (choose == 0) {
					String ma = jtfMaPN.getText();
					String maNV = jtfMaNV.getText();
					String maNCC = ((String) jcbMaNCC.getSelectedItem()).split(" - ")[0];
					Date ngayNhap = jdcNgayNhap.getDate();

					PhieuNhapHang pn = new PhieuNhapHang(ma, tongSoLuong, tongTien, maNCC, maNV, ngayNhap);
					if (pnService.addPhieuNhap(pn, listSachNhapDB)) {
						resetDataForDialog();
						listSachNhap.clear();
						setModelForJList(jlSachNhap, listSachNhap);
						jlbMsg.setText("Thêm Thành Công!");
					} else
						jlbMsg.setText("Thêm Thất Bại!");
				}
			}
		});
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				if (listSachNhap.size() > 0) {
					int choose = JOptionPane.showConfirmDialog(null, "Hoá đơn chưa thanh toán.\nBạn có muốn thoát???");
					if (choose == 0) {
						dialog.dispose();
					}
				} else {
					dialog.dispose();
				}
			}
		});
		;
	}

	int tongSoLuong = 0, tongTien = 0;

	public void btnThemClick() {
		int row = jtbSach.getSelectedRow();
		System.out.println(row);
		if (row != -1) {
			row = jtbSach.convertRowIndexToModel(row);

			String soLuong = jtfSoSachNhap.getText();
			if (ClassSupport.checkText(soLuong, "\\d+")) {

				int sl = Integer.parseInt(soLuong);
				SachTimKiem stk = listSach.get(row);
				String sachNhap = stk.getMa_Sach() + " - " + stk.getTen_Sach() + " x " + soLuong + " - "
						+ stk.getGia_Tien() * sl;

				// update JList Sach Nhap
				listSachNhap.add(sachNhap);
				setModelForJList(jlSachNhap, listSachNhap);

				// update List Sach Nhap Database
				updateForListStringDatabase(listSachNhapDB, sachNhap, 1);

			} else
				JOptionPane.showMessageDialog(null, "Số Lượng Nhập không hợp lệ!");
		}
	}

	public void updateForListStringDatabase(List<Pair<String, String>> list, String sachNhap, int type) {
		String[] temp = sachNhap.split(" - ");
		// sachNhap = S1000 - Conan x 10 - 1000000;
		// => temp[0] = S1000 , temp[1] = Conan x 10 , temp[2] = 1000000;

		int soLuong = Integer.parseInt(ClassSupport.findString(temp[1], "(\\d+)"));
		int giaTien = Integer.parseInt(temp[2]);

		tongSoLuong += soLuong * type;
		tongTien += giaTien * type;

		boolean checkSach = false;
		for (Pair<String, String> pair : list) {
			if (pair.getK().compareTo(temp[0].trim()) == 0) {
				String[] item2 = pair.getV().split(" - ");
				// temp[0] = soLuong , temp[1] = giaTien;

				item2[0] = Integer.parseInt(item2[0]) + soLuong * type + "";
				item2[1] = Integer.parseInt(item2[1]) + giaTien * type + "";

				pair.setV(item2[0] + " - " + item2[1]);
				checkSach = true;
				break;
			}
		}

		if (!checkSach) {

			Pair<String, String> pair = new Pair<String, String>(temp[0], soLuong + " - " + temp[2]);
			list.add(pair);
		}
	}

	public void setModelForJList(JList<String> jl, List<String> list) {
		jl.setModel(new DefaultListModel<String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getElementAt(int index) {

				return list.get(index);
			}

			@Override
			public int getSize() {

				return list.size();
			}
		});
	}

	public <E> DefaultTableModel getModel(List<E> list, String[] columnName) {
		DefaultTableModel model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}

		};

		model.setColumnIdentifiers(columnName);
		model.setRowCount(0);
		int count = 1;
		for (E e : list) {
			if (e instanceof TheLoai) {
				TheLoai tl = (TheLoai) e;
				model.addRow(new Object[] { count++, tl.getTen_The_Loai() });

			} else if (e instanceof SachTimKiem) {
				SachTimKiem stk = (SachTimKiem) e;
				model.addRow(new Object[] { count++, stk.getTen_Sach(), stk.getThe_Loai(), stk.getSo_Luong(),
						stk.getGia_Tien() });
			}
		}
		return model;
	}

	public <E> void setModelForJTableAndSetPanel(JTable jtb, List<E> list, String[] columnName, JPanel jpnView) {
		DefaultTableModel model = getModel(list, columnName);
		jtb.setModel(model);

		setSizeForJTable(jtb);

		JScrollPane pane = new JScrollPane(jtb);

		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(pane);
		jpnView.validate();
		jpnView.repaint();
	}

	public void setSizeForJTable(JTable jtb) {
		jtb.getTableHeader().setPreferredSize(new Dimension(100, 50));
		jtb.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 16));

		jtb.setRowHeight(50);
		jtb.setFont(new Font("tahoma", Font.PLAIN, 14));
	}

	public String[] getComboBoxFromListNCC() {
		List<NhaCungCap> listNCC = nccService.getListNhaCungCap();
		String[] combo = new String[listNCC.size()];
		for (int i = 0; i < listNCC.size(); i++) {
			NhaCungCap ncc = listNCC.get(i);

			combo[i] = ncc.getMa_NCC() + " - " + ncc.getHo_Ten();
		}
		return combo;
	}

	public void addPop(Component cmp, JPopupMenu pop) {
		cmp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {

				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void showMenu(MouseEvent e) {
				pop.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public class FocusEvent implements FocusListener {

		private String text;
		private JTextField jtf;

		public FocusEvent(String text, JTextField jtf) {
			super();
			this.text = text;
			this.jtf = jtf;
		}

		@Override
		public void focusGained(java.awt.event.FocusEvent e) {

			if (jtf.getText().equals(text))
				jtf.setText("");
			else
				jtf.selectAll();
		}

		@Override
		public void focusLost(java.awt.event.FocusEvent e) {

			if (jtf.getText().equals(""))
				jtf.setText(text);
		}

	}

	public class documentEvent implements DocumentListener {

		private String text;
		private TableRowSorter<TableModel> row;
		private JTextField jtf;

		public documentEvent(String text, TableRowSorter<TableModel> row, JTextField jtf) {
			super();
			this.text = text;
			this.row = row;
			this.jtf = jtf;
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			String s = jtf.getText();
			if (!s.equals(text) && s.trim().length() > 0) {
				row.setRowFilter(RowFilter.regexFilter("(?i)" + s));
			} else
				row.setRowFilter(null);
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			String s = jtf.getText();
			if (!s.equals(text) && s.trim().length() > 0) {
				row.setRowFilter(RowFilter.regexFilter("(?i)" + s));
			} else
				row.setRowFilter(null);
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
