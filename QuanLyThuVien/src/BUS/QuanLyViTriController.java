package BUS;

import java.awt.BorderLayout;
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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
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

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import DTO.ViTri;

public class QuanLyViTriController {
	private JTextField jtfMaVT, jtfSoKe, jtfSoKhu, jtfSoNgan, jtfSearch;
	private JButton jbtnThem, jbtnSua, jbtnXoa, jbtnInBaoCao;
	private JLabel jlbMsg;
	private JMenuItem jmiLamMoi;
	private JPanel jpnView;

	private List<ViTri> listItem;
	private ViTtriService vtService;
	private JTable table;
	private TableRowSorter<TableModel> rowSorter;

	public QuanLyViTriController(JTextField jtfMaVT, JTextField jtfSoKe, JTextField jtfSoKhu, JTextField jtfSoNgan,
			JTextField jtfSearch, JButton jbtnThem, JButton jbtnSua, JButton jbtnXoa, JButton jbtnInBaoCao,
			JLabel jlbMsg, JMenuItem jmiLamMoi, JPanel jpnView) {
		super();
		this.jtfMaVT = jtfMaVT;
		this.jtfSoKe = jtfSoKe;
		this.jtfSoKhu = jtfSoKhu;
		this.jtfSoNgan = jtfSoNgan;
		this.jtfSearch = jtfSearch;
		this.jbtnThem = jbtnThem;
		this.jbtnSua = jbtnSua;
		this.jbtnXoa = jbtnXoa;
		this.jbtnInBaoCao = jbtnInBaoCao;
		this.jlbMsg = jlbMsg;
		this.jmiLamMoi = jmiLamMoi;
		this.jpnView = jpnView;

		vtService = new ViTriServiceImp();
		listItem = vtService.getListViTri();
	}

	String s = " Vui long nhap thong tin ban muon tim...";
	String[] columnName = { "STT", "Ma VT", "So Ke", "So Khu", "So Ngan" };

	public void setDataToTable(JTable jtb, List<ViTri> list, String[] columnName) {
		DefaultTableModel model = new ClassModel().getModel(list, columnName);
		jtb.setModel(model);
		this.rowSorter = new TableRowSorter<TableModel>(jtb.getModel());
		jtb.setRowSorter(rowSorter);

	}

	public void resetData() {

		if (listItem.size() > 0) {
			int id = Integer.parseInt(ClassSupport.findString(vtService.getLastId(), "(\\d+)"));
			ViTri.setsId(++id);
		}
		jtfMaVT.setText(ViTri.getsId());
		jtfMaVT.setEditable(false);
		jtfSearch.setText(s);
		jtfSoKe.setText("");
		jtfSoKhu.setText("");
		jtfSoNgan.setText("");
		jlbMsg.setText("");
	}

	public void setView() {

		resetData();

		table = new JTable();
		setDataToTable(table, listItem, columnName);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				if (e.getClickCount() == 2 && row != -1) {
					row = table.convertRowIndexToModel(row);
					ViTri vt = listItem.get(row);
					jtfMaVT.setText(vt.getMa_Vi_Tri());
					jtfSoKe.setText(vt.getSo_Ke() + "");
					jtfSoKhu.setText(vt.getSo_Khu() + "");
					jtfSoNgan.setText(vt.getSo_Ngan() + "");
				}
			}
		});

		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 14));
		table.setRowHeight(50);
		JScrollPane pane = new JScrollPane(table);

		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(pane);
		jpnView.validate();
		jpnView.repaint();
	}

	public void setEvent() {
		jtfSoKhu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfSoKe.requestFocus();
				}
			}
		});

		jtfSoKe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jtfSoNgan.requestFocus();
				}
			}
		});

		jtfSoNgan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jbtnThem.requestFocus();
				}
			}
		});

		jmiLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resetData();
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

		jtfSearch.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {

				String text = jtfSearch.getText();
				if (!text.equals(s) && text.trim().length() > 0)
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				else
					rowSorter.setRowFilter(null);

			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				String text = jtfSearch.getText();
				if (!text.equals(s) && text.trim().length() > 0)
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				else
					rowSorter.setRowFilter(null);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});

		jbtnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String soKe = jtfSoKe.getText();
				if (ClassSupport.checkText(soKe, "\\d+")) {
					String soKhu = jtfSoKhu.getText();
					if (ClassSupport.checkText(soKhu, "\\d+")) {
						String soNgan = jtfSoKhu.getText();
						if (ClassSupport.checkText(soNgan, "\\d+")) {
							int khu = Integer.parseInt(soKhu);
							int ke = Integer.parseInt(soKe);
							int ngan = Integer.parseInt(soNgan);
							String ma = jtfMaVT.getText();
							ViTri vt = new ViTri(ma, ke, khu, ngan);

							if (!vtService.searchViTri(vt))
								if (vtService.addViTri(vt)) {
//									setView();
									listItem.add(vt);
									setDataToTable(table, listItem, columnName);
									resetData();
									jlbMsg.setText("Them Thanh Cong!");
								} else
									jlbMsg.setText("Them That Bai!");
							else
								jlbMsg.setText("So Ke , So Khu , So Ngan da ton tai roi!");

						} else {
							jlbMsg.setText("Noi dung So Ngan khong hop le! ( So )");
						}
					} else {
						jlbMsg.setText("Noi dung So Khu khong hop le! ( So )");
					}
				} else {
					jlbMsg.setText("Noi dung So Ke khong hop le! ( So )");
				}
			}
		});
		jbtnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String soKe = jtfSoKe.getText();
				if (ClassSupport.checkText(soKe, "\\d+")) {
					String soKhu = jtfSoKhu.getText();
					if (ClassSupport.checkText(soKhu, "\\d+")) {
						String soNgan = jtfSoKhu.getText();
						if (ClassSupport.checkText(soNgan, "\\d+")) {
							int khu = Integer.parseInt(soKhu);
							int ke = Integer.parseInt(soKe);
							int ngan = Integer.parseInt(soNgan);
							String ma = jtfMaVT.getText();
							ViTri vt = new ViTri(ma, ke, khu, ngan);

							if (!vtService.searchViTri(vt))
								if (vtService.editViTri(vt)) {
//									setView();
									int row = table.getSelectedRow();
									row = table.convertRowIndexToModel(row);
									listItem.set(row, vt);
									setDataToTable(table, listItem, columnName);
									resetData();

									jlbMsg.setText("Sua Thanh Cong!");
								} else
									jlbMsg.setText("Sua That Bai!");
							else
								jlbMsg.setText("So Ke , So Khu , So Ngan da ton tai roi!");

						} else {
							jlbMsg.setText("Noi dung So Ngan khong hop le! ( So )");
						}
					} else {
						jlbMsg.setText("Noi dung So Khu khong hop le! ( So )");
					}
				} else {
					jlbMsg.setText("Noi dung So Ke khong hop le! ( So )");
				}
			}
		});

		jbtnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				if (row != -1) {
					int choose = JOptionPane.showConfirmDialog(null, "Ban co muon xoa doi tuong nay???");
					if (choose == 0) {
						row = table.convertRowIndexToModel(row);
						ViTri vt = listItem.get(row);
						if (vtService.removeViTri(vt.getMa_Vi_Tri())) {
//							setView();
							listItem.remove(row);
							setDataToTable(table, listItem, columnName);
							jlbMsg.setText("Xoa Thanh Cong!");
						} else
							jlbMsg.setText("Xoa That bai!");
					}
				}
			}
		});

		jmiLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resetData();
			}
		});

		jbtnInBaoCao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				HSSFWorkbook workBook = new HSSFWorkbook();
				HSSFSheet sheet = workBook.createSheet("Vi Tri");

				HSSFRow row = null;
				Cell cell = null;

				row = sheet.createRow(1);

				HSSFCellStyle cellStyle = createCellStyleForHeader(sheet);

				cell = row.createCell(1);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("STT");

				cell = row.createCell(2);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("MA VT");
				cell = row.createCell(3);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("SO KHU");

				cell = row.createCell(4);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("SO KE");

				cell = row.createCell(5);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("SO NGAN");

				for (int i = 0; i < listItem.size(); i++) {
					ViTri vt = listItem.get(i);
					row = sheet.createRow(2 + i);

					cell = row.createCell(1);
					cell.setCellValue(i + 1);

					cell = row.createCell(2);
					cell.setCellValue(vt.getMa_Vi_Tri());

					cell = row.createCell(3);
					cell.setCellValue(vt.getSo_Khu());

					cell = row.createCell(4);
					cell.setCellValue(vt.getSo_Ke());

					cell = row.createCell(5);
					cell.setCellValue(vt.getSo_Ngan());
				}

				for (int i = 0; i < table.getModel().getColumnCount(); i++) {
					sheet.autoSizeColumn(i);
				}
				try {
					File file = new File("ViTri.xls");
					FileOutputStream fos = new FileOutputStream(file);
					workBook.write(fos);
					fos.close();
					workBook.close();
					jlbMsg.setText("In thanh cong vao file : " + file.getPath());
				} catch (Exception e2) {

					e2.printStackTrace();
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
