package BUS;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
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

import DTO.ChiTietPhieuNhap;
import DTO.Pair;
import DTO.PhieuNhapHang;
import GUI.PhieuNhapDialog;
import GUI.ThongTinPhieuMuonDialog;

public class QuanLyPhieuNhapController {
	private JTextField jtfSearch;
	private JButton jbtnThem;
	private JPanel jpnView;
	private JFrame frame;
	private String maNV;

	private PhieuNhapService pnService;
	private List<PhieuNhapHang> listItem;
	private JTable jtb;
	private TableRowSorter<TableModel> rowSorter;
	private JMenuItem jmiLamMoi, jmiThongTin;

	public QuanLyPhieuNhapController(JTextField jtfSearch, JButton jbtnThem, JPanel jpnView, JFrame frame,
			String maNV) {
		super();
		this.jtfSearch = jtfSearch;
		this.jbtnThem = jbtnThem;
		this.jpnView = jpnView;
		this.frame = frame;
		this.maNV = maNV;

		pnService = new PhieuNhapServiceImp();
		listItem = pnService.getListPhieuNhap();
	}

	String s = "Nhập thông tin bạn muốn tìm kiếm...";
	String[] columnName = { "STT", "Mã PN", "Mã NCC", "Mã NV", " Ngày Nhập", "Tổng Số Lượng", "Tổng Giá Tiền" };

	public void setView() {
		jtfSearch.setText(s);
		DefaultTableModel model = new ClassModel().getModel(listItem, columnName);

		jtb = new JTable(model);
		rowSorter = new TableRowSorter<TableModel>(jtb.getModel());
		jtb.setRowSorter(rowSorter);
		jtb.setFont(new Font("tahoma", Font.PLAIN, 14));
		jtb.setRowHeight(50);

		jtb.getTableHeader().setPreferredSize(new Dimension(100, 50));
		jtb.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 16));

		// add Popup cho JTable
		JPopupMenu pop = new JPopupMenu();
		jmiLamMoi = new JMenuItem("Làm Mới");
		jmiThongTin = new JMenuItem("Thông Tin Phiếu Nhập");
		pop.add(jmiThongTin);
		pop.add(jmiLamMoi);
		addPop(jtb, pop);

		JScrollPane pane = new JScrollPane(jtb);
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(pane);
		jpnView.validate();
		jpnView.repaint();
	}

	public void setEvent() {
		jtfSearch.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (jtfSearch.getText().equals("")) {
					jtfSearch.setText(s);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {

				if (jtfSearch.getText().equals(s)) {
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
				} else {
					rowSorter.setRowFilter(null);
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				String text = jtfSearch.getText();
				if (!text.equals(s) && text.trim().length() > 0) {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				} else {
					rowSorter.setRowFilter(null);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});

		jbtnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				PhieuNhapDialog dialog = new PhieuNhapDialog(frame, true, maNV);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);

			}
		});

		jmiLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				listItem = pnService.getListPhieuNhap();
				DefaultTableModel model = new ClassModel().getModel(listItem, columnName);
				jtb.setModel(model);
			}
		});
		jmiThongTin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int row = jtb.getSelectedRow();
				if (row != -1) {
					row = jtb.convertRowIndexToModel(row);
					PhieuNhapHang pn = listItem.get(row);

					String sql = "SELECT concat(ten_NCC,' - ' , concat(nhan_vien.ho ,' ' , nhan_vien.ten)) from phieu_nhap_hang INNER JOIN nha_cung_cap ON phieu_nhap_hang.ma_NCC = nha_cung_cap.ma_NCC , nhan_vien WHERE phieu_nhap_hang.ma_phieu_nhap = 'PN1000' AND phieu_nhap_hang.ma_nhan_vien = nhan_vien.ma_nhan_vien ";
					String[] temp = ((String) pnService.getSomeThing(sql)).split(" - ");
					Pair<String, String> ten = new Pair<String, String>(temp[0], temp[1]);
					List<Pair<ChiTietPhieuNhap, String>> listChiTiet = pnService.getListChiTiet(pn.getMaPN());
					ThongTinPhieuMuonDialog dialog = new ThongTinPhieuMuonDialog(frame, true, pn, ten, listChiTiet);
					dialog.setLocationRelativeTo(null);
					dialog.setViewForPN();
					dialog.setVisible(true);
				}
			}
		});
	}

	public void addPop(Component cmp, final JPopupMenu pop) {
		cmp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (e.isPopupTrigger())
					showMenu(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {

				if (e.isPopupTrigger())
					showMenu(e);
			}

			public void showMenu(MouseEvent e) {
				pop.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
