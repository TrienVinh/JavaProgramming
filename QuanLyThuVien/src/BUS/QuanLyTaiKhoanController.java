package BUS;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import DTO.TaiKhoan;

public class QuanLyTaiKhoanController {
	private JTextField jtfMaTaiKhoan, jtfTenDangNhap, jtfSearch;
	private JPasswordField jpfMatKhau, jpfNhapLai;
	private JComboBox<String> jcobMaNhanVien, jcobQuyen;
	private JButton jbtnThem, jbtnXoa, jbtnSua, jbtnInBaoCao;
	private JTable table;
	private JCheckBox jcbTinhTrang;
	private JPanel jpnView;
	private JMenuItem jmiLamMoi;
	private JLabel jlbMsg;

	private List<TaiKhoan> listItem;
	private TaiKhoanService tkService;
	private TableRowSorter<TableModel> rowSorter;

	public QuanLyTaiKhoanController(JTextField jtfMaTaiKhoan, JTextField jtfTenDangNhap, JPasswordField jpfMatKhau,
			JPasswordField jpfNhapLai, JComboBox<String> jcbMaNhanVien, JButton jbtnThem, JButton jbtnXoa,
			JButton jbtnSua, JButton jbtnInBaoCao, JCheckBox jcbTinhTrang, JPanel jpnView, JTextField jtfSearch,
			JComboBox<String> jcbQuyen, JMenuItem jmiLamMoi, JLabel jlbMsg) {
		super();
		this.jtfMaTaiKhoan = jtfMaTaiKhoan;
		this.jtfTenDangNhap = jtfTenDangNhap;
		this.jpfMatKhau = jpfMatKhau;
		this.jpfNhapLai = jpfNhapLai;
		this.jcobMaNhanVien = jcbMaNhanVien;
		this.jbtnThem = jbtnThem;
		this.jbtnXoa = jbtnXoa;
		this.jbtnSua = jbtnSua;
		this.jbtnInBaoCao = jbtnInBaoCao;
		this.jcbTinhTrang = jcbTinhTrang;
		this.jpnView = jpnView;
		this.jtfSearch = jtfSearch;
		this.jcobQuyen = jcbQuyen;
		this.jmiLamMoi = jmiLamMoi;
		this.jlbMsg = jlbMsg;

		listItem = new ArrayList<>();
		tkService = new TaiKhoanServiceImp();
		listItem = tkService.getListTaiKhoan();
	}

	public void resetData() {
//		String text = tkService.getLastUser().getMa_Tai_Khoan();
		if (listItem.size() > 0) {
			int id = Integer
					.parseInt(ClassSupport.findString(listItem.get(listItem.size() - 1).getMa_Tai_Khoan(), "(\\d+)"));

			TaiKhoan.setsId(++id);
		}

		jtfMaTaiKhoan.setEnabled(false);
		jtfMaTaiKhoan.setText(TaiKhoan.getsId());

		jtfTenDangNhap.setText("");
		jtfTenDangNhap.requestFocus();

		jpfMatKhau.setText("");
		jpfMatKhau.setEnabled(true);

		jpfNhapLai.setText("");
		jpfNhapLai.setEnabled(true);

		jcobMaNhanVien.setModel(new DefaultComboBoxModel<String>(tkService.getListMaNhanVien()));
		jcobMaNhanVien.setEnabled(true);

		jtfSearch.setText("Nhập thông tin bạn muốn tìm kiếm...");
		jlbMsg.setText("");
	}

	public void setDataToTable(JTable jtb, List<TaiKhoan> list, String[] columnName) {
		DefaultTableModel model = new ClassModel().getModel(list, columnName);
		jtb.setModel(model);
		rowSorter = new TableRowSorter<TableModel>(jtb.getModel());
		jtb.setRowSorter(rowSorter);
		jtb.setRowHeight(50);
		jtb.getTableHeader().setPreferredSize(new Dimension(100, 50));
		jtb.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 16));
		jtb.setFont(new Font("tahoma", Font.PLAIN, 14));
	}

	String[] columnName = { "STT", "Mã Tài Khoản", "Tên Đăng Nhập", "Mật Khẩu", "Quyền", "Tình Trạng", "Mã NV" };

	public void setView() {
		resetData();
//		DefaultTableModel model = new ClassModel().getModel(listItem, columnName);

//		table = new JTable(model);

		table = new JTable();
		setDataToTable(table, listItem, columnName);
//		rowSorter = new TableRowSorter<TableModel>(table.getModel());
//		table.setRowSorter(rowSorter);

//		table.setRowHeight(50);
//		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
//		table.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 14));

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
					int row = table.getSelectedRow();
					row = table.convertRowIndexToModel(row);
					TaiKhoan tk = listItem.get(row);
					jtfMaTaiKhoan.setEnabled(false);
					jtfMaTaiKhoan.setText(tk.getMa_Tai_Khoan());
					jtfTenDangNhap.setText(tk.getTen_Dang_Nhap());
					jpfMatKhau.setText(tk.getMat_Khau());
					for (int i = 0; i < jcobQuyen.getItemCount(); i++) {
						String item = (String) jcobQuyen.getItemAt(i);
						String quyen = (tk.isAdmin()) ? "Admin" : "Nhan Vien";
						if (item.equalsIgnoreCase(quyen)) {
							jcobQuyen.setSelectedIndex(i);
							break;
						}
					}
//					for (int i = 0; i < jcobMaNhanVien.getItemCount(); i++) {
//						String item = (String) jcobMaNhanVien.getItemAt(i);
//						String quyen = tk.getMa_Nhan_Vien();
//						if (item.contains(quyen)) {
//							jcobMaNhanVien.setSelectedIndex(i);
//							break;
//						}
//					}
					jpfMatKhau.setEnabled(false);
					jpfNhapLai.setEnabled(false);
					jcobMaNhanVien.setEnabled(false);
					jlbMsg.setText("Mật khẩu và Mã nhân viên không được thay đổi!");
					jpfNhapLai.setText("");
					jcbTinhTrang.setSelected(tk.isTinh_Trang());
				}
			}
		});

		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);

		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(scroll);
		jpnView.validate();
		jpnView.repaint();
	}

	public void setEvent() {

//		Tao su kien Khi textField Search dc focus
		String s = "Nhập thông tin bạn muốn tìm kiếm...";
		jtfSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				if (jtfSearch.getText().equalsIgnoreCase(s)) {
					jtfSearch.setText("");
				} else {
					jtfSearch.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (jtfSearch.getText().equals("")) {
					jtfSearch.setText(s);
				}
			}
		});

//		Tao su kien Khi textField Search thay doi text
		jtfSearch.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {

				String text = jtfSearch.getText();
				if (!text.equals(s) && text.trim().length() > 0) {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				String text = jtfSearch.getText();
				if (!text.equals(s) && text.trim().length() > 0) {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});

		jmiLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setView();
			}
		});

		jtfTenDangNhap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jcobMaNhanVien.requestFocus();
				}
			}
		});
		jcobMaNhanVien.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jcobQuyen.requestFocus();
				}
			}
		});
		jcobQuyen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jpfMatKhau.requestFocus();
				}
			}
		});
		jpfMatKhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jpfNhapLai.requestFocus();
				}
			}
		});
		jpfNhapLai.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jcbTinhTrang.requestFocus();
				}
			}
		});
		jbtnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnInBaoCao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		jbtnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String matKhau = String.valueOf(jpfMatKhau.getPassword());
				String nhapLai = String.valueOf(jpfNhapLai.getPassword());
				if (matKhau.compareTo(nhapLai) != 0) {
					jlbMsg.setText("Mật Khẩu nhập lại không chính xác!");
				} else {
					int maTaiKhoan = Integer.parseInt(ClassSupport.findString(jtfMaTaiKhoan.getText(), "(\\d+)"));
					String tenDangNhap = jtfTenDangNhap.getText();
					String maNhanVien = ((String) jcobMaNhanVien.getSelectedItem()).split("-")[0].trim();
					boolean quyen = (((String) jcobQuyen.getSelectedItem()).compareTo("Admin") == 0) ? true : false;
					boolean tinhTrang = jcbTinhTrang.isSelected();
					TaiKhoan tk = new TaiKhoan(maTaiKhoan, tenDangNhap, matKhau, tinhTrang,
							Calendar.getInstance().getTime(), quyen, maNhanVien);
					if (tkService.addTaiKhoan(tk)) {
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						listItem.add(tk);
						setDataToTable(table, listItem, columnName);
						resetData();
//						setView();
					} else {
						JOptionPane.showMessageDialog(null, "Thêm thất bại!");
					}
				}
			}
		});

		jbtnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String tenDangNhap = jtfTenDangNhap.getText();
				boolean quyen = (((String) jcobQuyen.getSelectedItem()).compareTo("Admin") == 0) ? true : false;
				boolean tinhTrang = jcbTinhTrang.isSelected();
				int row = table.getSelectedRow();
				row = table.convertRowIndexToModel(row);

				TaiKhoan tk = listItem.get(row);
				tk.setTen_Dang_Nhap(tenDangNhap);
				tk.setTinh_Trang(tinhTrang);
				tk.setAdmin(quyen);

				if (tkService.edtTaiKhoan(tk)) {
					JOptionPane.showMessageDialog(null, "Sua thành công!");
					listItem.set(row, tk);
					setDataToTable(table, listItem, columnName);
					resetData();
//					setView();
				} else {
					JOptionPane.showMessageDialog(null, "Sua thất bại!");
				}

			}
		});

		jbtnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "Hãy chọn đối tượng đế thao tác!");
				} else {
					row = table.convertRowIndexToModel(row);
					int choose = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xoá đối tượng này???");
					if (choose == 0) {
						if (tkService.removeTaiKhoa(listItem.get(row).getMa_Tai_Khoan())) {
							JOptionPane.showMessageDialog(null, "Xoa thành công!");
							listItem.remove(row);
							setDataToTable(table, listItem, columnName);
							resetData();
//							setView();
						} else {
							JOptionPane.showMessageDialog(null, "Xoa thất bại!");
						}
					}
				}
			}
		});

		jbtnInBaoCao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					HSSFWorkbook workBook = new HSSFWorkbook();
					HSSFSheet sheet = workBook.createSheet();

					HSSFRow row = null;
					Cell cell = null;

					HSSFCellStyle cellStyle = createCellStyleForHeader(sheet);

					row = sheet.createRow(1);
					cell = row.createCell(1, CellType.NUMERIC);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("STT");

					cell = row.createCell(2);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("MA TK");

					cell = row.createCell(3);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Ten DN");

					cell = row.createCell(4);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("MatKhau");

					cell = row.createCell(5);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Quyen");

					cell = row.createCell(6);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Tinh Trang");

					cell = row.createCell(7);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Ma NV");

					for (int i = 0; i < listItem.size(); i++) {
						TaiKhoan tk = listItem.get(i);

						row = sheet.createRow(2 + i);
						cell = row.createCell(1, CellType.NUMERIC);
						cell.setCellValue(i + 1);

						cell = row.createCell(2);
						cell.setCellValue(tk.getMa_Tai_Khoan());

						cell = row.createCell(3);
						cell.setCellValue(tk.getTen_Dang_Nhap());

						cell = row.createCell(4);
						cell.setCellValue(tk.getMat_Khau());

						cell = row.createCell(5);
						cell.setCellValue(tk.isAdmin() ? "Admin" : "Nhan Vien");

						cell = row.createCell(6, CellType.BOOLEAN);
						cell.setCellValue(tk.isTinh_Trang());

						cell = row.createCell(7);
						cell.setCellValue(tk.getMa_Nhan_Vien());
					}

					for (int i = 1; i < 8; i++) {
						sheet.autoSizeColumn(i);
					}

					File file = new File("E:/TaiKhoan.xls");
					FileOutputStream fos = new FileOutputStream(file);
					workBook.write(fos);
					fos.close();
					workBook.close();
					JOptionPane.showMessageDialog(null, "In thanh cong! " + file.getPath());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "In that bai!");
				}
			}
		});
	}

	public HSSFCellStyle createCellStyleForHeader(HSSFSheet sheet) {
		HSSFFont font = sheet.getWorkbook().createFont();
		font.setFontName("Times New Roman");
		font.setBold(true);
		font.setFontHeightInPoints((short) 14);

		HSSFCellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setFont(font);

		return cellStyle;
	}
}
