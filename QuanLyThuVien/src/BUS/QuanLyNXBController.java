package BUS;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
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

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;

import DTO.NhaXuatBan;

public class QuanLyNXBController {
	private JTextField jtfMaNXB, jtfTenNXB, jtfDiaChi, jtfEmail, jtfSearch;
	private JButton jbtnAdd, jbtnEdit, jbtnRemove, jbtnPrint;
	private JLabel jlbMsg;
	private JPanel jpnView;
	private TableRowSorter<TableModel> rowSorter = null;
	private List<NhaXuatBan> listItem;

	private NhaXuatBanService nxbService = null;
	private JTable table;

	public QuanLyNXBController(JTextField jtfMaNXB, JTextField jtfTenNXB, JTextField jtfDiaChi, JTextField jtfEmail,
			JButton jbtnAdd, JButton jbtnEdit, JButton jbtnRemove, JButton jbtnPrint, JLabel jlbMsg, JPanel jpnView,
			JTextField jtfSearch) {
		super();
		this.jtfMaNXB = jtfMaNXB;
		this.jtfTenNXB = jtfTenNXB;
		this.jtfDiaChi = jtfDiaChi;
		this.jtfEmail = jtfEmail;
		this.jbtnAdd = jbtnAdd;
		this.jbtnEdit = jbtnEdit;
		this.jbtnRemove = jbtnRemove;
		this.jbtnPrint = jbtnPrint;
		this.jlbMsg = jlbMsg;
		this.jpnView = jpnView;
		this.jtfSearch = jtfSearch;

		this.listItem = new ArrayList<>();
		nxbService = new NhaXuatBanServiceImp();
		listItem = nxbService.getListNhaXuatBan();
	}

	String s = " Vui l??ng nh???p th??ng tin b???n c???n t??m...";
	String[] columnName = { "STT", "M?? NXB", "T??n NXB", "?????a Ch???", "Email" };

	public void resetData() {
		jlbMsg.setText("");
		jtfSearch.setText(s);
		if (listItem.size() > 0) {
			String text = ClassSupport.findString(nxbService.getLastid(), "(\\d+)");
			int id = Integer.parseInt(text);

			NhaXuatBan.setsId(++id);
		}
		jtfMaNXB.setText(NhaXuatBan.getsId());
		jtfMaNXB.setEditable(false);

		jtfTenNXB.setText("");
		jtfTenNXB.requestFocus();

		jtfDiaChi.setText("");
		jtfEmail.setText("");
	}

	public void setDataToTable(JTable jtb, List<NhaXuatBan> list, String[] columnName) {
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
		table.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 14));
		table.setRowHeight(50);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				if (e.getClickCount() == 2 && row != -1) {
					row = table.convertRowIndexToModel(row);
					NhaXuatBan tg = listItem.get(row);
					jtfMaNXB.setText(tg.getMa_NXB());
					jtfTenNXB.setText(tg.getHo_Ten());
					jtfDiaChi.setText(tg.getDia_Chi());
					jtfEmail.setText(tg.getEmail());
				}
			}
		});

		JScrollPane scroll = new JScrollPane(table);
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(scroll);
		jpnView.validate();
		jpnView.repaint();

	}

	public void setEvent() {
		jtfTenNXB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfDiaChi.requestFocus();
				}
			}
		});

		jtfDiaChi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfEmail.requestFocus();
				}
			}
		});

		jtfEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jbtnAdd.requestFocus();
				}
			}
		});

		jtfSearch.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (jtfSearch.getText().equals("")) {
					jtfSearch.setText(s);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {

				if (jtfSearch.getText().equalsIgnoreCase(s)) {
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

		jbtnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (ClassSupport.checkText(jtfTenNXB.getText(), ".+")) {
					if (ClassSupport.checkText(jtfDiaChi.getText(), ".+")) {
						if (ClassSupport.checkText(jtfEmail.getText(), "\\w+@[a-z]+(\\.[a-z]+){1,2}")) {
							String id = jtfMaNXB.getText();
							String ten = jtfTenNXB.getText();
							String diaChi = jtfDiaChi.getText();
							String email = jtfEmail.getText();
							NhaXuatBan tg = new NhaXuatBan(id, ten, diaChi, email);
							if (nxbService.addNhaXuatBan(tg)) {
//								setView();
								listItem.add(tg);
								setDataToTable(table, listItem, columnName);
								resetData();
								jlbMsg.setText("Them thanh cong!");
							} else {
								jlbMsg.setText("Them that bai!");
							}
						} else {
							jtfEmail.requestFocus();
							jlbMsg.setText("Email khong hop le!");
						}
					} else {
						jtfDiaChi.requestFocus();
						jlbMsg.setText("Dia chi kh??ng ???????c ????? tr???ng!");
					}
				} else {
					jtfTenNXB.requestFocus();
					jlbMsg.setText("T??n t??c gi??? kh??ng ???????c ????? tr???ng!");
				}
			}
		});

		jbtnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				if (row != -1) {
					if (ClassSupport.checkText(jtfTenNXB.getText(), ".+")) {
						if (ClassSupport.checkText(jtfDiaChi.getText(), ".+")) {
							if (ClassSupport.checkText(jtfEmail.getText(), "\\w+@[a-z]+(\\.[a-z]+){1,2}")) {
								String id = jtfMaNXB.getText();
								String ten = jtfTenNXB.getText();
								String diaChi = jtfDiaChi.getText();
								String email = jtfEmail.getText();
								NhaXuatBan tg = new NhaXuatBan(id, ten, diaChi, email);
								listItem.set(table.getSelectedRow(), tg);
								if (nxbService.editNhaXuatBan(tg)) {
									row = table.convertRowIndexToModel(row);
									listItem.set(row, tg);
									setDataToTable(table, listItem, columnName);
									resetData();
//									setView();
									jlbMsg.setText("Sua thanh cong!");
								} else {
									jlbMsg.setText("Sua that bai!");
								}
							} else {
								jtfEmail.requestFocus();
								jlbMsg.setText("Email khong hop le!");
							}
						} else {
							jtfDiaChi.requestFocus();
							jlbMsg.setText("Dia chi kh??ng ???????c ????? tr???ng!");
						}
					} else {
						jtfTenNXB.requestFocus();
						jlbMsg.setText("T??n t??c gi??? kh??ng ???????c ????? tr???ng!");
					}
				}
			}
		});

		jbtnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				if (row != -1) {
					int choose = JOptionPane.showConfirmDialog(null, "Ban co chac muon xoa doi tuong nay ???");
					if (choose == 0) {
						row = table.convertRowIndexToModel(row);
						NhaXuatBan tg = listItem.get(row);
						if (nxbService.removeNhaXuatBan(tg.getMa_NXB())) {
//							setView();
							listItem.remove(row);
							setDataToTable(table, listItem, columnName);
							resetData();
							jlbMsg.setText("Xoa thanh cong!");
						} else {
							jlbMsg.setText("Xoa that bai!");
						}
					}
				} else {
					jlbMsg.setText("Vui long chon doi tuong de thao tac");
				}
			}
		});

		jbtnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				HSSFWorkbook workBook = new HSSFWorkbook();
				HSSFSheet sheet = workBook.createSheet("Tac Gia");

				sheet.setAutobreaks(true);

				HSSFRow row = null;
				Cell cell = null;

				CellStyle cellType = createStyleForHeader(sheet);
				row = sheet.createRow(1);

				cell = row.createCell(1);
				cell.setCellStyle(cellType);
				cell.setCellValue("STT");

				cell = row.createCell(2);
				cell.setCellStyle(cellType);
				cell.setCellValue("Ma Tac Gia");

				cell = row.createCell(3);
				cell.setCellStyle(cellType);
				cell.setCellValue("Ten Tac Gia");

				cell = row.createCell(4);
				cell.setCellStyle(cellType);
				cell.setCellValue("Dia Chi");

				cell = row.createCell(5);
				cell.setCellStyle(cellType);
				cell.setCellValue("Email");

				for (int i = 0; i < listItem.size(); i++) {
					NhaXuatBan tg = listItem.get(i);
					row = sheet.createRow(2 + i);

					cell = row.createCell(1, CellType.STRING);
					cell.setCellValue(i + 1);

					cell = row.createCell(2, CellType.STRING);
					cell.setCellValue(tg.getMa_NXB());

					cell = row.createCell(3, CellType.STRING);
					cell.setCellValue(tg.getHo_Ten());

					cell = row.createCell(4, CellType.STRING);
					cell.setCellValue(tg.getDia_Chi());

					cell = row.createCell(5, CellType.STRING);
					cell.setCellValue(tg.getEmail());

				}

				for (int i = 0; i < 6; i++) {
					sheet.autoSizeColumn((short) (i));
				}
				File file = new File("E:/NhaXuatBan.xls");
				try {
					FileOutputStream fos = new FileOutputStream(file);
					workBook.write(fos);
					fos.close();
					workBook.close();
					jlbMsg.setText("In Bao Cao thanh cong vao file + " + file.getPath());
				} catch (Exception e2) {

					e2.printStackTrace();
					jlbMsg.setText("In that bai!");
				}
			}
		});
	}

	private CellStyle createStyleForHeader(HSSFSheet sheet) {
		// Create font
		HSSFFont font = sheet.getWorkbook().createFont();
		font.setFontName("Times New Roman");
		font.setBold(true);
		font.setFontHeightInPoints((short) 14); // font size

		// Create CellStyle
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setFont(font);
//        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        cellStyle.setBorderBottom(BorderStyle.THIN);
		return cellStyle;
	}
}
