package BUS;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
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

import DTO.Pair;
import DTO.Sach;

public class SachController {
	private JTextField jtfMaSach, jtfTenSach, jtfSoLuong, jtfSoTrang, jtfGiaTien, jtfSearch;
	private JComboBox<String> jcobMaTG, jcobMaNXB, jcobMaVT;
	private JLabel jlbMsg;
	private JButton jbtnThem, jbtnSua, jbtnXoa, jbtnPrint;
	private JMenuItem jmiLamMoi;
	private JPanel jpnView;
	private JList<String> jlMaTL, jlMaNN;
	private JTextField jycNamXB;

	private JTable table;
	private List<Sach> listItem;
	private TableRowSorter<TableModel> rowSorter;
	private SachService sachsv;
	private String[] theLoai, ngonNgu;

	public SachController(JTextField jtfMaSach, JTextField jtfTenSach, JTextField jtfSoLuong, JTextField jtfSoTrang,
			JTextField jtfGiaTien, JTextField jtfSearch, JComboBox<String> jcobMaTG, JComboBox<String> jcobMaNXB,
			JComboBox<String> jcobMaVT, JLabel jlbMsg, JButton jbtnThem, JButton jbtnSua, JButton jbtnXoa,
			JButton jbtnPrint, JMenuItem jmiLamMoi, JPanel jpnView, JList<String> jlMaTL, JList<String> jlMaNN,
			JTextField jycNamXB) {
		super();
		this.jtfMaSach = jtfMaSach;
		this.jtfTenSach = jtfTenSach;
		this.jtfSoLuong = jtfSoLuong;
		this.jtfSoTrang = jtfSoTrang;
		this.jtfGiaTien = jtfGiaTien;
		this.jtfSearch = jtfSearch;
		this.jcobMaTG = jcobMaTG;
		this.jcobMaNXB = jcobMaNXB;
		this.jcobMaVT = jcobMaVT;
		this.jlbMsg = jlbMsg;
		this.jbtnThem = jbtnThem;
		this.jbtnSua = jbtnSua;
		this.jbtnXoa = jbtnXoa;
		this.jbtnPrint = jbtnPrint;
		this.jmiLamMoi = jmiLamMoi;
		this.jpnView = jpnView;
		this.jlMaTL = jlMaTL;
		this.jlMaNN = jlMaNN;
		this.jycNamXB = jycNamXB;

		sachsv = new SachServiceimp();
		listItem = new ArrayList<Sach>();

		jcobMaNXB.setModel(new DefaultComboBoxModel<String>(sachsv.getComboBoxMaNXB()));
		jcobMaTG.setModel(new DefaultComboBoxModel<String>(sachsv.getComboBoxMaTG()));
		jcobMaVT.setModel(new DefaultComboBoxModel<String>(sachsv.getComboBoxMaVT()));

		theLoai = sachsv.getComboBoxMaTL();
		jlMaTL.setModel(new AbstractListModel<String>() {

			private static final long serialVersionUID = 1L;

			public String getElementAt(int index) {
				return theLoai[index];
			}

			@Override
			public int getSize() {

				return theLoai.length;
			}
		});

		ngonNgu = sachsv.getComboBoxMaNN();
		jlMaNN.setModel(new AbstractListModel<String>() {

			private static final long serialVersionUID = 1L;

			public String getElementAt(int index) {
				return ngonNgu[index];
			}

			@Override
			public int getSize() {

				return ngonNgu.length;
			}
		});

	}

	String s = " Vui long nhap thong tin ban muon tim...";
	String[] columnName = { "STT", "Ma Sach", "Ten Sach", "Ma TG", "The Loai", "Ma VT", "Ma NCC", "So Luong",
			"Ngon Ngu", "So Trang", "Gia Tien" };

	public void resetData() {
		listItem = sachsv.getListSach();
		if (listItem.size() > 0) {
			int id = Integer.parseInt(ClassSupport.findString(sachsv.getLastId(), "(\\d+)"));
			Sach.setsId(++id);
		}
		jtfMaSach.setText(Sach.getsId());
		jtfMaSach.setEditable(false);
		jtfSoTrang.setText("");
		jtfTenSach.setText("");
		jtfGiaTien.setText("");
		jtfSoLuong.setText("");
		jtfSearch.setText(s);

		jcobMaNXB.setSelectedIndex(0);
		jcobMaTG.setSelectedIndex(0);
		jcobMaVT.setSelectedIndex(0);

	}

	public void setView() {

		resetData();

		DefaultTableModel model = new ClassModel().getModel(listItem, columnName);
		table = new JTable(model);

		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 14));
		table.setRowHeight(50);

		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);
		table.getColumnModel().getColumn(6).setPreferredWidth(20);
		table.getColumnModel().getColumn(7).setPreferredWidth(30);
		table.getColumnModel().getColumn(9).setPreferredWidth(30);

		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(80);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				jlbMsg.setText("The Loai va Ngon Ngu khi sua phai chon lai!");
				int row = table.getSelectedRow();
				if (e.getClickCount() == 2 && row != -1) {
					row = table.convertRowIndexToModel(row);
					Sach s = listItem.get(row);
					jtfMaSach.setText(s.getMa_Sach());
					jtfTenSach.setText(s.getTen_Sach());
					jtfSoLuong.setText(s.getSo_Luong() + "");
					jtfSoTrang.setText(s.getSo_Trang() + "");

					jtfGiaTien.setText(s.getGia_Tien() + "");

					for (int i = 0; i < jcobMaNXB.getItemCount(); i++) {
						String nxb = (String) jcobMaNXB.getItemAt(i);
						if (nxb.contains(s.getMa_NXB())) {
							jcobMaNXB.setSelectedIndex(i);
							break;
						}
					}

					for (int i = 0; i < jcobMaTG.getItemCount(); i++) {
						String tg = (String) jcobMaTG.getItemAt(i);
						if (tg.contains(s.getMa_Tac_Gia())) {
							jcobMaTG.setSelectedIndex(i);
							break;
						}
					}

					for (int i = 0; i < jcobMaVT.getItemCount(); i++) {
						String vt = (String) jcobMaVT.getItemAt(i);
						if (vt.contains(s.getMa_Vi_Tri())) {
							jcobMaVT.setSelectedIndex(i);
							break;
						}
					}

					int j = 0;
					String[] tl = s.getThe_Loai().split(", ");
					int[] soTL = new int[0];
					for (int i = 0; i < theLoai.length; i++) {
						if (theLoai[i].contains(tl[j])) {
							soTL = Arrays.copyOf(soTL, j + 1);
							soTL[j] = i;
							j++;
							if (j == tl.length)
								break;
						}
					}
					jlMaTL.setSelectedIndices(soTL);

					j = 0;
					int[] soNN = new int[0];
					String[] nn = s.getNgon_Ngu().split(", ");
					for (int i = 0; i < ngonNgu.length; i++) {
						if (ngonNgu[i].contains(nn[j])) {
							soNN = Arrays.copyOf(soNN, j + 1);
							soNN[j] = i;
							j++;
							if (j == nn.length)
								break;
						}
					}
					jlMaNN.setSelectedIndices(soTL);
				}
			}
		});

		rowSorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(rowSorter);

		JScrollPane pane = new JScrollPane(table);
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(pane);
		jpnView.validate();
		jpnView.repaint();
	}

	public void setEvent() {
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

		jbtnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String ten = jtfTenSach.getText();
				if (ClassSupport.checkText(ten, ".+")) {

					String soLuong = jtfSoLuong.getText();
					if (ClassSupport.checkText(soLuong, "(\\d+)")) {

						List<String> ngonNgu = jlMaNN.getSelectedValuesList();
						if (ngonNgu.size() > 0) {

							List<String> theLoai = jlMaTL.getSelectedValuesList();
							if (theLoai.size() > 0) {
								String soTrang = jtfSoTrang.getText();
								if (ClassSupport.checkText(soTrang, "\\d+")) {

									String giaTien = jtfGiaTien.getText();
									if (ClassSupport.checkText(giaTien, "\\d+")) {

										String ma = jtfMaSach.getText();
										String maTG = ((String) jcobMaTG.getSelectedItem()).split("-")[0].trim();
										String maNXB = ((String) jcobMaNXB.getSelectedItem()).split("-")[0].trim();
										String maVT = ((String) jcobMaVT.getSelectedItem()).split("-")[0].trim();

										Pair<String, String> tL = getStringFromList(theLoai);
										Pair<String, String> nN = getStringFromList(ngonNgu);

										int sl = Integer.parseInt(soLuong);
										int st = Integer.parseInt(soTrang);
										int gt = Integer.parseInt(giaTien);
										int namXB = Integer.parseInt(jycNamXB.getText());

										Sach s = new Sach(ma, gt, sl, st, ten, maTG, tL.getV(), maNXB, maVT, nN.getV(),
												namXB);
										if (sachsv.addSach(s, tL.getK(), nN.getK())) {
											setView();
											jlbMsg.setText("Them Thang Cong!");
										} else
											jlbMsg.setText("Them That Bai!");
									} else {
										jlbMsg.setText("Gia Tien phai la 1 con so!");
									}
								} else {
									jlbMsg.setText("So Trang khong dc de trong!");
								}
							} else {
								jlbMsg.setText("The Loai chua duoc chon");
							}
						} else {
							jlbMsg.setText("Ngon Ngu chua duoc chon!");
						}
					} else {
						jlbMsg.setText("So Luong phai la 1 con so!");
					}
				} else {
					jlbMsg.setText("Ten Sach khong dc de trong!");
				}
			}
		});
		jbtnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String ten = jtfTenSach.getText();
				if (ClassSupport.checkText(ten, ".+")) {

					String soLuong = jtfSoLuong.getText();
					if (ClassSupport.checkText(soLuong, "(\\d+)")) {

						List<String> ngonNgu = jlMaNN.getSelectedValuesList();
						if (ngonNgu.size() > 0) {

							List<String> theLoai = jlMaTL.getSelectedValuesList();
							if (theLoai.size() > 0) {
								String soTrang = jtfSoTrang.getText();
								if (ClassSupport.checkText(soTrang, "\\d+")) {

									String giaTien = jtfGiaTien.getText();
									if (ClassSupport.checkText(giaTien, "\\d+")) {

										String ma = jtfMaSach.getText();
										String maTG = ((String) jcobMaTG.getSelectedItem()).split("-")[0].trim();
										String maNXB = ((String) jcobMaNXB.getSelectedItem()).split("-")[0].trim();
										String maVT = ((String) jcobMaVT.getSelectedItem()).split("-")[0].trim();

										Pair<String, String> tL = getStringFromList(theLoai);
										Pair<String, String> nN = getStringFromList(ngonNgu);

										int sl = Integer.parseInt(soLuong);
										int st = Integer.parseInt(soTrang);
										int gt = Integer.parseInt(giaTien);
										int namXB = Integer.parseInt(jycNamXB.getText());

										Sach s = new Sach(ma, gt, sl, st, ten, maTG, tL.getV(), maNXB, maVT, nN.getV(),
												namXB);
										if (sachsv.editSach(s, tL.getK(), nN.getK())) {
											setView();
											jlbMsg.setText("Sua Thang Cong!");
										} else
											jlbMsg.setText("Sua That Bai!");
									} else {
										jlbMsg.setText("Gia Tien phai la 1 con so!");
									}
								} else {
									jlbMsg.setText("So Trang khong dc de trong!");
								}
							} else {
								jlbMsg.setText("The Loai chua duoc chon");
							}
						} else {
							jlbMsg.setText("Ngon Ngu chua duoc chon!");
						}
					} else {
						jlbMsg.setText("So Luong phai la 1 con so!");
					}
				} else {
					jlbMsg.setText("Ten Sach khong dc de trong!");
				}
			}
		});

		jbtnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				if (row != -1) {
					row = table.convertRowIndexToModel(row);
					int choose = JOptionPane.showConfirmDialog(null, "Ban co chac muon xoa doi tuong nay???");
					if (choose == 0) {
						Sach s = listItem.get(row);
						if (sachsv.removeSach(s.getMa_Sach())) {
							setView();
							jlbMsg.setText("Xoa Thanh Cong!");
						} else {
							jlbMsg.setText("Xoa That Bai!");
						}
					}
				}
			}
		});

		jbtnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				HSSFWorkbook workBook = new HSSFWorkbook();
				HSSFSheet sheet = workBook.createSheet();

				HSSFRow row = null;
				Cell cell = null;

				HSSFCellStyle cellStyle = createCellStyleForHeader(sheet);

				row = sheet.createRow(1);

				cell = row.createCell(1);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("STT");

				cell = row.createCell(2);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("Ma Sach");

				cell = row.createCell(3);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("Ten Sach");

				cell = row.createCell(4);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("Ma TG");

				cell = row.createCell(5);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("Ma TL");

				cell = row.createCell(6);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("Ma NXB");

				cell = row.createCell(7);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("Ma VT");

				cell = row.createCell(8);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("So Luong");

				cell = row.createCell(9);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("Ngon Ngu");

				cell = row.createCell(10);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("So Trang");

				cell = row.createCell(11);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("Gia Tien");

				for (int i = 0; i < listItem.size(); i++) {
					Sach s = listItem.get(i);
					row = sheet.createRow(2 + i);

					cell = row.createCell(1);
					cell.setCellValue(i + 1);

					cell = row.createCell(2);
					cell.setCellValue(s.getMa_Sach());

					cell = row.createCell(3);
					cell.setCellValue(s.getTen_Sach());

					cell = row.createCell(4);
					cell.setCellValue(s.getMa_Tac_Gia());

					cell = row.createCell(5);
					cell.setCellValue(s.getMa_Tac_Gia());

					cell = row.createCell(6);
					cell.setCellValue(s.getThe_Loai());

					cell = row.createCell(7);
					cell.setCellValue(s.getMa_Vi_Tri());

					cell = row.createCell(8);
					cell.setCellValue(s.getSo_Luong());

					cell = row.createCell(9);
					cell.setCellValue(s.getNgon_Ngu());

					cell = row.createCell(10);
					cell.setCellValue(s.getSo_Trang());

					cell = row.createCell(11);
					cell.setCellValue(s.getGia_Tien());
				}

				for (int j = 0; j < table.getColumnCount(); j++) {
					sheet.autoSizeColumn(j);
				}
				try {
					File file = new File("Sach.txt");
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

	public Pair<String, String> getStringFromList(List<String> list) {
		Pair<String, String> pair = new Pair<String, String>();
		String ten = "", id = "";
		for (String s : list) {
			String[] split = s.split("-");
			ten += split[1].trim() + ", ";
			id += split[0].trim() + ", ";
		}
		ten = ten.substring(0, ten.length() - 2);
		id = id.substring(0, id.length() - 2);
		pair.setK(id);
		pair.setV(ten);
		return pair;
	}
}
