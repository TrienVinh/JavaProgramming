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
import java.io.IOException;
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

import DTO.TheLoai;

public class QuanLyTheLoaiController {
	private JTextField jtfMaTheLoai, jtfTenTheLoai, jtfSearch;
	private JButton jbtnAdd, jbtnEdit, jbtnRemove, jbtnPrint;
	private JMenuItem jmiLamMoi;
	private JPanel jpnView;
	private JLabel jlbMsg;

	private TheLoaiService tlService = null;
	private List<TheLoai> listItem;
	private TableRowSorter<TableModel> rowSorter;
	private JTable table;

	public QuanLyTheLoaiController(JTextField jtfMaTheLoai, JTextField jtfTenTheLoai, JTextField jtfSearch,
			JButton jbtnAdd, JButton jbtnEdit, JButton jbtnRemove, JButton jbtnPrint, JPanel jpnView,
			JMenuItem jmiLamMoi, JLabel jlbMsg) {
		super();
		this.jtfMaTheLoai = jtfMaTheLoai;
		this.jtfTenTheLoai = jtfTenTheLoai;
		this.jtfSearch = jtfSearch;
		this.jbtnAdd = jbtnAdd;
		this.jbtnEdit = jbtnEdit;
		this.jbtnRemove = jbtnRemove;
		this.jbtnPrint = jbtnPrint;
		this.jpnView = jpnView;
		this.jmiLamMoi = jmiLamMoi;
		this.jlbMsg = jlbMsg;

		this.tlService = new TheLoaiServiceImp();
		listItem = tlService.getListTheLoai();

	}

	private String s = " Vui lòng nhập thông tin bạn muốn tìm...";
	private String[] columnName = { "STT", "Ma The Loai", "Ten The Loai" };

	public void resetData() {
		if (listItem.size() > 0) {
			String text = tlService.getLastid();
			int id = Integer.parseInt(ClassSupport.findString(text, "(\\d+)"));
			TheLoai.setsId(++id);
		}
		jtfMaTheLoai.setText(TheLoai.getsId());
//		jtfMaTheLoai.setEnabled(false);
		jtfMaTheLoai.setEditable(false);

		jtfTenTheLoai.setText("");
		jtfTenTheLoai.requestFocus();

		jtfSearch.setText(s);
		jlbMsg.setText("");
	}

	public void setDataToTable(JTable jtb, List<TheLoai> list, String[] columnName) {
		DefaultTableModel model = new ClassModel().getModel(list, columnName);
		jtb.setModel(model);
		this.rowSorter = new TableRowSorter<TableModel>(jtb.getModel());
		jtb.setRowSorter(rowSorter);

	}

	public void setView() {

		resetData();

		table = new JTable();
		setDataToTable(table, listItem, columnName);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
					int row = table.getSelectedRow();
					row = table.convertRowIndexToModel(row);
					TheLoai tl = listItem.get(row);
					jtfMaTheLoai.setText(tl.getMa_The_Loai());
					jtfTenTheLoai.setText(tl.getTen_The_Loai());
				}
			}
		});

		table.setRowHeight(50);
		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 14));

		JScrollPane scroll = new JScrollPane(table);

		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(scroll);
		jpnView.validate();
		jpnView.repaint();
	}

	public void setEvent() {
		jtfTenTheLoai.requestFocus();

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

				if (jtfSearch.getText().trim().equals(""))
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

		jmiLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setView();
			}
		});

		jbtnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String ten;
				if (ClassSupport.checkText(jtfTenTheLoai.getText(), ".+")) {
					String id = jtfMaTheLoai.getText();
					ten = jtfTenTheLoai.getText();
					TheLoai tl = new TheLoai(id);
					tl.setTen_The_Loai(ten);
					if (tlService.addTheLoai(tl)) {
//						setView();
						listItem.add(tl);
						setDataToTable(table, listItem, columnName);
						resetData();
						jlbMsg.setText("Thêm thành công!");
					} else
						jlbMsg.setText("Thêm thất bại!");
				} else
					jlbMsg.setText("Tên thể loại không hợp lệ!");
			}
		});

		jbtnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String ten;
				int row = table.getSelectedRow();
				if (row != -1) {
					if (ClassSupport.checkText(jtfTenTheLoai.getText(), ".+")) {
						String id = jtfMaTheLoai.getText();
						ten = jtfTenTheLoai.getText();
						TheLoai tl = new TheLoai(id);
						tl.setTen_The_Loai(ten);
						if (tlService.editTheLoai(tl)) {
//						setView();
							row = table.convertRowIndexToModel(row);
							listItem.set(row, tl);
							setDataToTable(table, listItem, columnName);
							resetData();
							jlbMsg.setText("Sửa thành công!");
						} else
							jlbMsg.setText("Sửa thất bại!");
					} else
						jlbMsg.setText("Tên thể loại không hợp lệ!");
				}
			}
		});

		jbtnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				if (row != -1) {
					int choose = JOptionPane.showConfirmDialog(null, "Ban co thuc su muon xoa doi tuong nay???");
					if (choose == 0) {
						row = table.convertRowIndexToModel(row);

						if (tlService.removeTheLoai(listItem.get(row).getMa_The_Loai())) {
//							setView();
							listItem.remove(row);
							setDataToTable(table, listItem, columnName);

							jlbMsg.setText("Xoa thành công!");
						} else
							jlbMsg.setText("Xoa thất bại!");
					}

				}
			}
		});

		jbtnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				HSSFWorkbook workBook = new HSSFWorkbook();
				HSSFSheet sheet = workBook.createSheet("The Loai");

				HSSFRow row = null;
				Cell cell = null;

				HSSFCellStyle cellType = createCellTypeForHeader(sheet);

				row = sheet.createRow(1);

				cell = row.createCell(1);
				cell.setCellStyle(cellType);
				cell.setCellValue("STT");

				cell = row.createCell(2);
				cell.setCellStyle(cellType);
				cell.setCellValue("Mã Thể Loại");

				cell = row.createCell(3);
				cell.setCellStyle(cellType);
				cell.setCellValue("Tên Thể Loại");

				for (int i = 0; i < listItem.size(); i++) {
					TheLoai tl = listItem.get(i);
					row = sheet.createRow(2 + i);

					cell = row.createCell(1);
					cell.setCellValue(i + 1 + "");

					cell = row.createCell(2);
					cell.setCellValue(tl.getMa_The_Loai());

					cell = row.createCell(3);
					cell.setCellValue(tl.getTen_The_Loai());
				}

				for (int i = 1; i < 4; i++) {
					sheet.autoSizeColumn(i);
				}
				File file = new File("E:/TheLoai.xls");
				try {
					FileOutputStream fos = new FileOutputStream(file);
					workBook.write(fos);
					fos.close();
					workBook.close();
					jlbMsg.setText("In thanh cong vao file : " + file.getPath());
				} catch (IOException e1) {

					e1.printStackTrace();
					jlbMsg.setText("In that bai");
				}
			}
		});
	}

	public HSSFCellStyle createCellTypeForHeader(HSSFSheet sheet) {

		HSSFFont font = sheet.getWorkbook().createFont();
		font.setFontName("Time New Roman");
		font.setBold(true);
		font.setFontHeightInPoints((short) 14);

		HSSFCellStyle cellType = sheet.getWorkbook().createCellStyle();
		cellType.setFont(font);

		return cellType;
	}
}
