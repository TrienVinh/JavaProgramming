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

import DTO.DocGia;
import DTO.Person;

public class QuanLyDocGiaController {
	private JTextField jtfMaDocGia, jtfSoDienThoai, jtfCMND, jtfHo, jtfTen, jtfEmail, jtfSearch;
	private JTextArea jtaDiaChi;
	private JComboBox<String> jcbNgheNghiep;
	private JRadioButton jrbNam, jrbNu;
	private JDateChooser jdcNgaySinh;
	private JButton jbtnThem, jbtnSua, jbtnXoa, jbtnInBaoCao;
	private JPanel jpnView;
	private JMenuItem jmiRefresh;
	private JTable table;

	private DocGiaService dgService = null;
	private List<DocGia> listItem;
	private TableRowSorter<TableModel> rowSorter = null;

	public QuanLyDocGiaController(JTextField jtfMaDocGia, JTextField jtfSoDienThoai, JTextField jtfCMND,
			JTextField jtfHo, JTextField jtfEmail, JTextArea jtaDiaChi, JComboBox<String> jcbNgheNghiep,
			JRadioButton jrbNam, JRadioButton jrbNu, JDateChooser jdcNgaySinh, JButton jbtnThem, JButton jbtnSua,
			JButton jbtnXoa, JButton jbtnInBaoCao, JPanel jpnView, JMenuItem jmiRefresh, JTextField jtfSearch,
			JTextField jtfTen) {
		super();
		this.jtfMaDocGia = jtfMaDocGia;
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

		dgService = new DocGiaServiceImp();

		listItem = new ArrayList<DocGia>();
		listItem = dgService.getListDocGia();
	}

	String[] columnName = { "STT", "M?? ??G", "H???", "T??n", "Gi???i T??nh", "Ng??y Sinh", "?????a Ch???", "Ngh??? Nghi???p", "CMND",
			"Email", "S??? ??i???n Tho???i" };

	public void setDataToTable(JTable jtb, List<DocGia> list, String[] columnName) {
		DefaultTableModel model = new ClassModel().getModel(list, columnName);
		jtb.setModel(model);
		rowSorter = new TableRowSorter<TableModel>(jtb.getModel());
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

//		S??t s??? ki???n khi click v??o table khi mu???n xo?? hay mu???n s???a
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
					int row = table.getSelectedRow();
//					row = table.convertRowIndexToModel(row);
					Person dg = listItem.get(row);

					jtfMaDocGia.setText(dg.getMa_Doi_Tuong());
					jtfHo.setText(dg.getHo());
					jtfTen.setText(dg.getTen());
					jtfCMND.setText(dg.getCMND());
					jtfEmail.setText(dg.getEmail());
					jtfSoDienThoai.setText(dg.getSo_Dien_Thoai());
					jrbNu.setSelected(!dg.isGioi_Tinh());
					jtaDiaChi.setText(dg.getDia_Chi());
					jdcNgaySinh.setDate(dg.getNgay_Sinh());
					for (int i = 0; i < jcbNgheNghiep.getItemCount(); i++) {
						if (dg.getChuc_Vu().contains((String) jcbNgheNghiep.getItemAt(i))) {
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

//		C??c s??? ki???n c???a JTextField H??? T??n
//		Enter
		jtfHo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfEmail.requestFocus();
				}
			}
		});

//		C??c s??? ki???n c???a JTextField Email
//		Enter
		jtfEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jcbNgheNghiep.requestFocus();
				}
			}
		});

//		C??c s??? ki???n c???a JComboBox Nghe Nghiep
//		Enter
		jcbNgheNghiep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jdcNgaySinh.requestFocus();
				}
			}
		});

//		C??c s??? ki???n c???a JDateChooser NgaySinh
//		Enter
		jdcNgaySinh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtaDiaChi.requestFocus();
				}
			}
		});

//		C??c s??? ki???n c???a JTextArea DiaChi
//		Enter
		jtaDiaChi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfSoDienThoai.requestFocus();
				}
			}
		});

//		C??c s??? ki???n c???a JTextField SoDienThoai
//		Enter
		jtfSoDienThoai.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfCMND.requestFocus();
				}
			}
		});

//		C??c s??? ki???n c???a JTextField CMND
//		Enter
		jtfCMND.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jbtnThem.requestFocus();
				}
			}
		});

//		C??c s??? ki???n c???a JMenuItem refresh
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
//		C??c s??? ki???n c???a JButton Th??m
//		1. Click
		jbtnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String ho = jtfHo.getText();
				String ten = jtfTen.getText();
				String email = jtfEmail.getText();
				String diaChi = jtaDiaChi.getText();
				String phone = jtfSoDienThoai.getText();
				String cmnd = jtfCMND.getText();
				String ngheNghiep = (String) jcbNgheNghiep.getSelectedItem();

				if (!ClassSupport.checkText(ho, "[\\pL\\pMn+\\s+]+")) {
					JOptionPane.showMessageDialog(null, "H??? T??n kh??ng kh???p!", null, JOptionPane.ERROR_MESSAGE);
				} else {
					if (!ClassSupport.checkText(email, "\\w+@[a-z]+(\\.[a-z]+){1,2}")) {
						JOptionPane.showMessageDialog(null, "Email ko kh???p!", null, JOptionPane.ERROR_MESSAGE);
					} else {
						if (!ClassSupport.checkText(phone, "\\d{10}")) {
							JOptionPane.showMessageDialog(null, "S??? ??i???n Tho???i ko kh???p! (10 s???)", null,
									JOptionPane.ERROR_MESSAGE);
						} else {
							if (!ClassSupport.checkText(cmnd, "\\d{12}")) {
								JOptionPane.showMessageDialog(null, "CMND ko kh???p! (12 s???)", null,
										JOptionPane.ERROR_MESSAGE);
							} else {
								DocGia dg = new DocGia(jtfMaDocGia.getText(), ho, phone, diaChi, cmnd, email,
										ngheNghiep, jdcNgaySinh.getDate(), jrbNam.isSelected(), ten);
								if (dgService.addDocGia(dg)) {
									JOptionPane.showMessageDialog(null, "Th??m th??nh c??ng!", null,
											JOptionPane.INFORMATION_MESSAGE);
									listItem.add(dg);
									setDataToTable(table, listItem, columnName);
									resetData();
//									setView();
								} else {
									JOptionPane.showMessageDialog(null, "Th??m th???t b???i!", null,
											JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
					}
				}

			}
		});

//		C??c s??? ki???n c???a JButton S???a
//		1. Click
		jbtnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String ho = jtfHo.getText();
				String ten = jtfTen.getText();
				String email = jtfEmail.getText();
				String diaChi = jtaDiaChi.getText();
				String phone = jtfSoDienThoai.getText();
				String cmnd = jtfCMND.getText();
				String ngheNghiep = (String) jcbNgheNghiep.getSelectedItem();

				if (!ClassSupport.checkText(ho, "[\\pL\\pMn+\\s+]+")) {
					JOptionPane.showMessageDialog(null, "H??? T??n kh??ng kh???p!", null, JOptionPane.ERROR_MESSAGE);
				} else {
					if (!ClassSupport.checkText(email, "\\w+@[a-z]+(\\.[a-z]+){1,2}")) {
						JOptionPane.showMessageDialog(null, "Email ko kh???p!", null, JOptionPane.ERROR_MESSAGE);
					} else {
						if (!ClassSupport.checkText(phone, "\\d{10}")) {
							JOptionPane.showMessageDialog(null, "S??? ??i???n Tho???i ko kh???p! (10 s???)", null,
									JOptionPane.ERROR_MESSAGE);
						} else {
							if (!ClassSupport.checkText(cmnd, "\\d{12}")) {
								JOptionPane.showMessageDialog(null, "CMND ko kh???p! (12 s???)", null,
										JOptionPane.ERROR_MESSAGE);
							} else {
								DocGia dg = new DocGia(jtfMaDocGia.getText(), ho, phone, diaChi, cmnd, email,
										ngheNghiep, jdcNgaySinh.getDate(), jrbNam.isSelected(), ten);
								if (dgService.insertDocGia(dg)) {
									JOptionPane.showMessageDialog(null, "S???a th??nh c??ng!", null,
											JOptionPane.INFORMATION_MESSAGE);
									int row = table.getSelectedRow();
									row = table.convertRowIndexToModel(row);
									listItem.set(row, dg);
									setDataToTable(table, listItem, columnName);
									resetData();
//									setView();
								} else {
									JOptionPane.showMessageDialog(null, "S???a th???t b???i!", null,
											JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
					}
				}

			}
		});

//		C??c s??? ki???n c???a JButton Xo??
//		1. Click
		jbtnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				row = table.convertRowIndexToModel(row);
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "H??y ch???n 1 ?????i t?????ng ????? th???c hi???n");
				} else {
					int check = JOptionPane.showConfirmDialog(null, "B???n c?? ch???c mu???n xo?? ?????c gi??? n??y???");
					if (check == 0) {
						if (dgService.removeDocGia(listItem.get(row).getMa_Doi_Tuong())) {
							JOptionPane.showMessageDialog(null, "Xo?? th??nh c??ng!");
							listItem.remove(row);
							setDataToTable(table, listItem, columnName);
							resetData();
//							setView();
						} else {
							JOptionPane.showMessageDialog(null, "Xo?? th???t c??ng!");
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

					HSSFCellStyle cellStyle = createCellStypeForHeader(sheet);

					Cell cell = null;
					cell = row.createCell(1);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("M?? DG");

					cell = row.createCell(2);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("H??? T??n");

					cell = row.createCell(3);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Gi???i T??nh");

					cell = row.createCell(4);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Ng??y Sinh");

					cell = row.createCell(5);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("?????a Ch???");

					cell = row.createCell(6);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Ngh??? Nghi???p");

					cell = row.createCell(7);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("Email");

					cell = row.createCell(8);
					cell.setCellStyle(cellStyle);
					cell.setCellValue("S??T");

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
						cell.setCellValue(ps.isGioi_Tinh() ? "Nam" : "N???");

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

					File file = new File("E:/DocGia.xls");
					FileOutputStream fos = new FileOutputStream(file);
					workBook.write(fos);
					fos.close();
					workBook.close();
					JOptionPane.showMessageDialog(null, "B??o C??o ???? dc l??u ??? file " + file.getPath());
				} catch (Exception e2) {

					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "B??o C??o b??? l???i");
				}

			}
		});

		String s = " Nh???p th??ng tin b???n mu???n t??m ki???m...";
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
//		S??t l???i m?? ?????c gi??? theo s??? l?????ng danh s??ch ?????c gi???.
		if (listItem.size() > 0) {
			DocGia.setsId(dgService.getLastDocGia());
		}

		jtfMaDocGia.setText(DocGia.getMa_Doc_Gia());
		jtfHo.setText("");
		jtfTen.setText("");
		jtfCMND.setText("");
		jtfEmail.setText("");
		jtfSoDienThoai.setText("");
		jrbNu.setSelected(false);
		jtaDiaChi.setText("");
		jtfSearch.setText(" Nh???p th??ng tin b???n mu???n t??m ki???m...");
		try {
			jdcNgaySinh.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/1910"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	public HSSFCellStyle createCellStypeForHeader(HSSFSheet sheet) {
		HSSFFont font = sheet.getWorkbook().createFont();
		font.setFontName("Times New Roman");
		font.setBold(true);
		font.setFontHeightInPoints((short) 14);

		HSSFCellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setFont(font);

		return cellStyle;
	}
}
