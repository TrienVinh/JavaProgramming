package BUS;

import java.awt.BorderLayout;
import java.awt.Cursor;
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
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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

import com.toedter.calendar.JDateChooser;

import DTO.NhanVien;
import DTO.Person;

public class QuanLyNhanVienController {
	private JTextField jtfMaNhanVien, jtfSoDienThoai, jtfCMND, jtfHo, jtfTen, jtfEmail, jtfSearch;
	private JTextArea jtaDiaChi;
	private JComboBox<String> jcbNgheNghiep;
	private JRadioButton jrbNam, jrbNu;
	private JDateChooser jdcNgaySinh;
	private JButton jbtnThem, jbtnSua, jbtnXoa, jbtnInBaoCao;
	private JPanel jpnView;
	private JMenuItem jmiRefresh;
	private JTable table;

	private NhanVienService nvService = null;
	private List<NhanVien> listItem;
	private TableRowSorter<TableModel> rowSorter;

	public QuanLyNhanVienController(JTextField jtfMaNhanVien, JTextField jtfSoDienThoai, JTextField jtfCMND,
			JTextField jtfHo, JTextField jtfEmail, JTextArea jtaDiaChi, JComboBox<String> jcbNgheNghiep,
			JRadioButton jrbNam, JRadioButton jrbNu, JDateChooser jdcNgaySinh, JButton jbtnThem, JButton jbtnSua,
			JButton jbtnXoa, JButton jbtnInBaoCao, JPanel jpnView, JMenuItem jmiRefresh, JTextField jtfSearch,
			JTextField jtfTen) {
		super();
		this.jtfMaNhanVien = jtfMaNhanVien;
		this.jtfSoDienThoai = jtfSoDienThoai;
		this.jtfCMND = jtfCMND;
		this.jtfHo = jtfHo;
		this.jtfEmail = jtfEmail;
		this.jtaDiaChi = jtaDiaChi;
		this.jcbNgheNghiep = jcbNgheNghiep;
		this.jrbNam = jrbNam;
		this.jrbNu = jrbNu;
		this.jdcNgaySinh = jdcNgaySinh;
		this.jbtnThem = jbtnThem;
		this.jbtnSua = jbtnSua;
		this.jbtnXoa = jbtnXoa;
		this.jbtnInBaoCao = jbtnInBaoCao;
		this.jpnView = jpnView;
		this.jmiRefresh = jmiRefresh;
		this.jtfSearch = jtfSearch;
		this.jtfTen = jtfTen;

		nvService = new NhanVienServiceImp();

		listItem = new ArrayList<NhanVien>();
		listItem = nvService.getListNhanVien();
	}

	String[] columnName = { "STT", "Mã NV", "Họ", "Tên", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "Chức Vụ", "CMND",
			"Email", "Số Điện Thoại" };

	public void setDataToTable(JTable jtb, List<NhanVien> list, String[] columnName) {
		DefaultTableModel model = new ClassModel().getModel(list, columnName);
		jtb.setModel(model);
		this.rowSorter = new TableRowSorter<TableModel>(jtb.getModel());
		jtb.setRowSorter(rowSorter);

	}

	public void setView() {

		resetData();

		table = new JTable();
		setDataToTable(table, listItem, columnName);

		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 16));
		table.setRowHeight(50);

		jdcNgaySinh.setDateFormatString("dd/MM/yyyy");
		jdcNgaySinh.setFont(new Font("tahoma", Font.PLAIN, 14));

//		Sét sự kiện khi click vào table khi muốn xoá hay muốn sửa
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
					int row = table.getSelectedRow();
//					row = table.convertRowIndexToModel(row);
					Person nv = listItem.get(row);

					jtfMaNhanVien.setText(nv.getMa_Doi_Tuong());
					jtfHo.setText(nv.getHo());
					jtfTen.setText(nv.getTen());
					jtfCMND.setText(nv.getCMND());
					jtfEmail.setText(nv.getEmail());
					jtfSoDienThoai.setText(nv.getSo_Dien_Thoai());
					jrbNu.setSelected(!nv.isGioi_Tinh());
					jtaDiaChi.setText(nv.getDia_Chi());
					jdcNgaySinh.setDate(nv.getNgay_Sinh());
					for (int i = 0; i < jcbNgheNghiep.getItemCount(); i++) {
						if (nv.getChuc_Vu().contains((String) jcbNgheNghiep.getItemAt(i))) {
							jcbNgheNghiep.setSelectedIndex(i);
							break;
						}
					}
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

//		Các sự kiện của JTextField Họ Tên
//		Enter
		jtfHo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfTen.requestFocus();
				}
			}
		});

		jtfTen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfEmail.requestFocus();
				}
			}
		});

//		Các sự kiện của JTextField Email
//		Enter
		jtfEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jcbNgheNghiep.requestFocus();
				}
			}
		});

//		Các sự kiện của JComboBox Nghe Nghiep
//		Enter
		jcbNgheNghiep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jdcNgaySinh.requestFocus();
				}
			}
		});

//		Các sự kiện của JDateChooser NgaySinh
//		Enter
		jdcNgaySinh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtaDiaChi.requestFocus();
				}
			}
		});

//		Các sự kiện của JTextArea DiaChi
//		Enter
		jtaDiaChi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfSoDienThoai.requestFocus();
				}
			}
		});

//		Các sự kiện của JTextField SoDienThoai
//		Enter
		jtfSoDienThoai.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfCMND.requestFocus();
				}
			}
		});

//		Các sự kiện của JTextField CMND
//		Enter
		jtfCMND.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jbtnThem.requestFocus();
				}
			}
		});

//		Các sự kiện của JMenuItem refresh
		jmiRefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setView();
			}
		});

		jbtnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnInBaoCao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

//		Các sự kiện của JButton Thêm
//		1. Click
		jbtnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String ho = jtfHo.getText().trim();
				String ten = jtfTen.getText().trim();
				String email = jtfEmail.getText();
				String diaChi = jtaDiaChi.getText();
				String phone = jtfSoDienThoai.getText();
				String cmnd = jtfCMND.getText();
				String ngheNghiep = (String) jcbNgheNghiep.getSelectedItem();

				if (!ClassSupport.checkText(ho, "[\\pL\\pMn+\\s+]+")) {
					JOptionPane.showMessageDialog(null, "Họ Tên không khớp!", null, JOptionPane.ERROR_MESSAGE);
				} else {
					if (!ClassSupport.checkText(email, "\\w+@[a-z]+(\\.[a-z]+){1,2}")) {
						JOptionPane.showMessageDialog(null, "Email ko khớp!", null, JOptionPane.ERROR_MESSAGE);
					} else {
						if (!ClassSupport.checkText(phone, "\\d{10}")) {
							JOptionPane.showMessageDialog(null, "Số Điện Thoại ko khớp! (10 số)", null,
									JOptionPane.ERROR_MESSAGE);
						} else {
							if (!ClassSupport.checkText(cmnd, "\\d{12}")) {
								JOptionPane.showMessageDialog(null, "CMND ko khớp! (12 số)", null,
										JOptionPane.ERROR_MESSAGE);
							} else {
								NhanVien nv = new NhanVien(jtfMaNhanVien.getText(), ho, phone, diaChi, cmnd, email,
										ngheNghiep, jdcNgaySinh.getDate(), jrbNam.isSelected(), ten);
								if (nvService.addNhanVien(nv)) {
									JOptionPane.showMessageDialog(null, "Thêm thành công!", null,
											JOptionPane.INFORMATION_MESSAGE);
									listItem.add(nv);
									setDataToTable(table, listItem, columnName);
									resetData();
//									setView();
								} else {
									JOptionPane.showMessageDialog(null, "Thêm thất bại!", null,
											JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
					}
				}

			}
		});

//		Các sự kiện của JButton Sửa
//		1. Click
		jbtnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String ho = jtfHo.getText().trim();
				String ten = jtfTen.getText().trim();
				String email = jtfEmail.getText();
				String diaChi = jtaDiaChi.getText();
				String phone = jtfSoDienThoai.getText();
				String cmnd = jtfCMND.getText();
				String ngheNghiep = (String) jcbNgheNghiep.getSelectedItem();
				int row = table.getSelectedRow();
				if (row != -1) {
					if (!ClassSupport.checkText(ho, "[\\pL\\pMn+\\s+]+")) {
						JOptionPane.showMessageDialog(null, "Họ Tên không khớp!", null, JOptionPane.ERROR_MESSAGE);
					} else {
						if (!ClassSupport.checkText(email, "\\w+@[a-z]+(\\.[a-z]+){1,2}")) {
							JOptionPane.showMessageDialog(null, "Email ko khớp!", null, JOptionPane.ERROR_MESSAGE);
						} else {
							if (!ClassSupport.checkText(phone, "\\d{10}")) {
								JOptionPane.showMessageDialog(null, "Số Điện Thoại ko khớp! (10 số)", null,
										JOptionPane.ERROR_MESSAGE);
							} else {
								if (!ClassSupport.checkText(cmnd, "\\d{12}")) {
									JOptionPane.showMessageDialog(null, "CMND ko khớp! (12 số)", null,
											JOptionPane.ERROR_MESSAGE);
								} else {
									NhanVien nv = new NhanVien(jtfMaNhanVien.getText(), ho, phone, diaChi, cmnd, email,
											ngheNghiep, jdcNgaySinh.getDate(), jrbNam.isSelected(), ten);
									if (nvService.insertNhanVien(nv)) {
										row = table.convertRowIndexToModel(row);
										JOptionPane.showMessageDialog(null, "Sửa thành công!", null,
												JOptionPane.INFORMATION_MESSAGE);
										listItem.set(row, nv);
										setDataToTable(table, listItem, columnName);
										resetData();
//										setView();
									} else {
										JOptionPane.showMessageDialog(null, "Sửa thất bại!", null,
												JOptionPane.INFORMATION_MESSAGE);
									}
								}
							}
						}
					}

				}
			}
		});

//		Các sự kiện của JButton Xoá
//		1. Click
		jbtnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				row = table.convertRowIndexToModel(row);
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "Hãy chọn 1 đối tượng để thực hiện");
				} else {
					int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xoá độc giả này???");
					if (check == 0) {
						if (nvService.removeNhanVien(listItem.get(row).getMa_Doi_Tuong())) {
							JOptionPane.showMessageDialog(null, "Xoá thành công!");
							listItem.remove(row);
							setDataToTable(table, listItem, columnName);
							resetData();
//							setView();
						} else {
							JOptionPane.showMessageDialog(null, "Xoá thất công!");
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
					row = sheet.createRow(1);

					HSSFCellStyle cellStyle = createCellTypeForHeader(sheet);

					Cell cell = null;
					cell = row.createCell(1);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Mã NV");

					cell = row.createCell(2);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Họ Tên");

					cell = row.createCell(3);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Giới Tính");

					cell = row.createCell(4);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Ngày Sinh");

					cell = row.createCell(5);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Địa Chỉ");

					cell = row.createCell(6);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Nghề Nghiệp");

					cell = row.createCell(7);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Email");

					cell = row.createCell(8);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("SĐT");

					cell = row.createCell(9);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("CMND");

					for (int i = 0; i < listItem.size(); i++) {
						Person ps = listItem.get(i);
						row = sheet.createRow(2 + i);

						cell = row.createCell(1);
						cell.setCellValue(ps.getMa_Doi_Tuong());

						cell = row.createCell(2);
						cell.setCellValue(ps.getHo_Ten());

						cell = row.createCell(3);
						cell.setCellValue(ps.isGioi_Tinh() ? "Nam" : "Nữ");

						cell = row.createCell(4);
						cell.setCellValue(new SimpleDateFormat("dd/MM/yyyy").format(ps.getNgay_Sinh()));

						cell = row.createCell(5);
						cell.setCellValue(ps.getDia_Chi());

						cell = row.createCell(6);
						cell.setCellValue(ps.getChuc_Vu());

						cell = row.createCell(7);
						cell.setCellValue(ps.getEmail());

						cell = row.createCell(8);
						cell.setCellValue(ps.getSo_Dien_Thoai());

						cell = row.createCell(9);
						cell.setCellValue(ps.getCMND());
					}

					for (int i = 1; i < 10; i++) {
						sheet.autoSizeColumn(i);
					}

					File file = new File("E:/NhanVien.xls");
					FileOutputStream fos = new FileOutputStream(file);
					workBook.write(fos);
					fos.close();
					workBook.close();
					JOptionPane.showMessageDialog(null, "Báo Cáo đã dc lưu ở file " + file.getPath());
				} catch (Exception e2) {

					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Báo Cáo bị lỗi");
				}

			}
		});

		String s = " Nhập thông tin bạn muốn tìm kiếm...";
		jtfSearch.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (jtfSearch.getText().equals("")) {
					jtfSearch.setText(s);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {

				if (jtfSearch.getText().compareTo(s) == 0) {
					jtfSearch.setText("");
				} else {
					jtfSearch.selectAll();
				}
			}
		});

		jtfSearch.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {

				String text = jtfSearch.getText();
				if (!text.contains(s) && text.trim().length() > 0) {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				} else {
					rowSorter.setRowFilter(null);
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				String text = jtfSearch.getText();
				if (!text.contains(s) && text.trim().length() > 0) {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				} else {
					rowSorter.setRowFilter(null);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
	}

	public void resetData() {
//		Sét lại mã nhan vien theo số lượng danh sách nhan vien.
		String ps = nvService.getLastNhanVien();
		int lastId = Integer.parseInt(ClassSupport.findString(ps, "(\\d+)"));
		NhanVien.setsId(++lastId);

		jtfMaNhanVien.setText(NhanVien.getMa_Nhan_Vien());
		jtfHo.setText("");
		jtfCMND.setText("");
		jtfEmail.setText("");
		jtfSoDienThoai.setText("");
		jrbNu.setSelected(false);
		jtaDiaChi.setText("");
		jtfSearch.setText(" Nhập thông tin bạn muốn tìm kiếm...");
		try {
			jdcNgaySinh.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/1910"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	public HSSFCellStyle createCellTypeForHeader(HSSFSheet sheet) {
		HSSFFont font = sheet.getWorkbook().createFont();
		font.setFontName("Times New Roman");
		font.setBold(true);
		font.setFontHeightInPoints((short) 14);

		HSSFCellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setFont(font);

		return cellStyle;
	}
}
