package BUS;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
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

import DTO.ChiTietPhieuMuon;
import DTO.Pair;
import DTO.Person;
import DTO.PhieuMuon;
import GUI.PhieuMuonDialog;
import GUI.PhieuTraDialog;
import GUI.ThongTinPersonDialog;
import GUI.ThongTinPhieuMuonDialog;

public class PhieuMuonPanelController {
	private JButton jbtnThem, jbtnCapNhat;
	private JTextField jtfSearch;
	private JPanel jpnView;

	private PhieuMuonService pmService;
	private TableRowSorter<TableModel> rowSorter;
	private List<PhieuMuon> listItem;
	private JTable table;
	private String maNV;
	private JFrame frame;

	private JMenuItem jmiTTDG, jmiTTNV, jmiTTPM, jmiLamMoi;

	public PhieuMuonPanelController(JButton jbtnThem, JButton jbtnCapNhat, JTextField jtfSearch, JPanel jpnView,
			String maNV, JFrame frame) {
		super();
		this.jbtnThem = jbtnThem;
		this.jbtnCapNhat = jbtnCapNhat;
		this.jtfSearch = jtfSearch;
		this.jpnView = jpnView;
		this.maNV = maNV;
		this.frame = frame;

		pmService = new PhieuMuonServiceImp();
		listItem = pmService.getListPhieuMuon();

	}

	String[] columnName = { "STT", "Mã PM", "Mã ĐG", "Mã NV", "Ngày Mượn", "Ngày Phải Trả", "Tổng Số Sách Mượn",
			"Hoàn Trả" };
	String s = " Vui lòng nhập thông tin bạn muốn tìm...";

	public void setView() {
		jtfSearch.setText(s);

		table = new JTable();
		setDataForTable(table, rowSorter);
		JPopupMenu pop = new JPopupMenu();
		jmiTTDG = new JMenuItem("Thông tin Độc Giả");
		jmiTTNV = new JMenuItem("Thông tin Nhân Viên");
		jmiTTPM = new JMenuItem("Thông tin Phiếu Mượn");
		jmiLamMoi = new JMenuItem("Làm Mới");

		pop.add(jmiTTDG);
		pop.add(jmiTTNV);
		pop.add(jmiTTPM);
		pop.add(jmiLamMoi);

		addPopup(table, pop);

		JScrollPane pane = new JScrollPane(table);
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(pane);
		jpnView.validate();
		jpnView.repaint();

	}

	public void setEvent() {
//		Tao su kien Khi textField Search dc focus
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

		jbtnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				PhieuMuonDialog dialog = new PhieuMuonDialog(frame, true, maNV);
				dialog.setVisible(true);
			}
		});

		jbtnCapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();

				if (row != -1) {
					row = table.convertRowIndexToModel(row);
					PhieuMuon pm = listItem.get(row);
					if (!pm.isHoan_Tra()) {

						List<Pair<ChiTietPhieuMuon, String>> listCtpm = pmService.getListChiTiet(pm.getMa_Phieu_Muon());
						PhieuTraDialog dialog = new PhieuTraDialog(frame, true, maNV, listCtpm, pm);
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Phiếu Mượn đã trả hết");
					}
				}
			}
		});

		jmiLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				listItem = pmService.getListPhieuMuon();
				setDataForTable(table, rowSorter);
			}
		});

		jmiTTDG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int row = table.getSelectedRow();
				if (row != -1) {
					row = table.convertRowIndexToModel(row);
					String maPM = listItem.get(row).getMa_Phieu_Muon();
					Person dg = pmService.getDocGiaFromPhieuMuon(maPM);
					ThongTinPersonDialog dialog = new ThongTinPersonDialog(frame, true, dg);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);

				}
			}
		});
		jmiTTNV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int row = table.getSelectedRow();
				if (row != -1) {
					row = table.convertRowIndexToModel(row);
					String maPM = listItem.get(row).getMa_Phieu_Muon();
					Person dg = pmService.getNhanVienFromPhieuMuon(maPM);
					ThongTinPersonDialog dialog = new ThongTinPersonDialog(frame, true, dg);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);

				}
			}
		});
		jmiTTPM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int row = table.getSelectedRow();
				if (row != -1) {
					row = table.convertRowIndexToModel(row);
					PhieuMuon pm = listItem.get(row);
					String maPM = pm.getMa_Phieu_Muon();
					String sql = "select concat(doc_gia.ho, ' ' , doc_gia.ten) as tenDG ,concat(nhan_vien.ho, ' ' , nhan_vien.ten) as tenNV from phieu_muon INNER JOIN doc_gia ON phieu_muon.ma_doc_gia = doc_gia.ma_doc_gia INNER JOIN nhan_vien ON phieu_muon.ma_nhan_vien = nhan_vien.ma_nhan_vien where ma_phieu_muon = '"
							+ maPM + "'";
					Pair<String, String> ten = pmService.getTenDGAndTenNV(sql);

					List<Pair<ChiTietPhieuMuon, String>> listChiTiet = pmService.getListChiTiet(maPM);

					ThongTinPhieuMuonDialog dialog = new ThongTinPhieuMuonDialog(frame, true, pm, ten, listChiTiet);
					dialog.setVisible(true);
				}
			}
		});
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

	public void setDataForTable(JTable jtb, TableRowSorter<TableModel> rowSorter) {
		DefaultTableModel model = new ClassModel().getModel(listItem, columnName);
		jtb.setModel(model);
		rowSorter = new TableRowSorter<TableModel>(jtb.getModel());
		jtb.setRowSorter(rowSorter);
		jtb.setRowHeight(50);
		jtb.getTableHeader().setPreferredSize(new Dimension(100, 50));
		jtb.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 16));
		jtb.setFont(new Font("tahoma", Font.PLAIN, 14));
	}
}