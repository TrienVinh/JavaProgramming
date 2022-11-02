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

import DTO.ChiTietPhieuMuon;
import DTO.Pair;
import DTO.PhieuMuon;
import DTO.PhieuPhat;
import GUI.PhieuPhatDialog;
import GUI.ThongTinPhieuMuonDialog;

public class QuanLyPhieuPhatController {
	private JButton jbtnThem;
	private JTextField jtfSearch;
	private JPanel jpnView;
	private JFrame frame;

	private List<PhieuPhat> listItem;
	private PhieuPhatService ppService;
	private PhieuMuonService pmService;
	private JTable jtbPhieuPhat;
	private TableRowSorter<TableModel> rowSorter;
	private JMenuItem jmiPM, jmiLamMoi;

	public QuanLyPhieuPhatController(JButton jbtnThem, JTextField jtfSearch, JPanel jpnView, JFrame frame) {
		super();
		this.jbtnThem = jbtnThem;
		this.jtfSearch = jtfSearch;
		this.jpnView = jpnView;
		this.frame = frame;

		ppService = new PhieuPhatServiceImp();
		pmService = new PhieuMuonServiceImp();

	}

	String s = "Vui lòng nhập thông tin muốn tìm...";
	String[] columnName = { "STT", "Mã PM", "Mã Sách", "Lý Do", "Tiền Phạt" };

	public void setDataToTable(JTable jtb, String[] columnName) {
		listItem = ppService.getListPhieuPhat();
		DefaultTableModel model = new ClassModel().getModel(listItem, columnName);
		jtb.setModel(model);
		this.rowSorter = new TableRowSorter<TableModel>(jtb.getModel());
		jtb.setRowSorter(rowSorter);

	}

	public void setView() {
		jtfSearch.setText(s);

		jtbPhieuPhat = new JTable();
		setDataToTable(jtbPhieuPhat, columnName);
		jtbPhieuPhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = jtbPhieuPhat.getSelectedRow();
				if (e.getClickCount() == 2 && row != -1) {
					row = jtbPhieuPhat.convertRowIndexToModel(row);
					PhieuPhat pp = listItem.get(row);
					String sql = "select ten_sach from sach where ma_sach = '" + pp.getMa_Sach() + "'";
					String tenS = (String) ppService.getSomeThingFromSql(sql);

					String tenDG = pmService.getDocGiaFromPhieuMuon(pp.getMa_Phieu_Muon()).getHo_Ten();

					Pair<String, String> pair = new Pair<String, String>(tenDG, tenS);
					PhieuPhatDialog dialog = new PhieuPhatDialog(frame, true, pp, pair);
					dialog.setLocationRelativeTo(null);
					dialog.setEnableForButtonPhat(false);
					dialog.setVisible(true);
				}
			}
		});

		jtbPhieuPhat.setRowHeight(50);
		jtbPhieuPhat.setFont(new Font("tahoma", Font.PLAIN, 14));
		jtbPhieuPhat.getTableHeader().setPreferredSize(new Dimension(100, 50));
		jtbPhieuPhat.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 16));

		JScrollPane pane = new JScrollPane(jtbPhieuPhat);

		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(pane);
		jpnView.validate();
		jpnView.repaint();

		JPopupMenu pop = new JPopupMenu();
		jmiPM = new JMenuItem("Thông tin Phiếu Mượn");
		jmiLamMoi = new JMenuItem("Làm Mới");
		pop.add(jmiPM);
		pop.add(jmiLamMoi);
		addPop(jtbPhieuPhat, pop);
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

		jbtnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				PhieuPhat pp = new PhieuPhat();
				Pair<String, String> pair = new Pair<String, String>("", "");
				PhieuPhatDialog dialog = new PhieuPhatDialog(frame, true, pp, pair);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
//				setDataToTable(jtbPhieuPhat, columnName);
			}
		});

		jmiPM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = jtbPhieuPhat.getSelectedRow();
				if (row != -1) {
					row = jtbPhieuPhat.convertRowIndexToModel(row);
					String maPM = listItem.get(row).getMa_Phieu_Muon();
					PhieuMuon pm = pmService.getPhieuMuonFromMa(maPM);
					List<Pair<ChiTietPhieuMuon, String>> listChiTiet = pmService.getListChiTiet(maPM);
					Pair<String, String> ten = new Pair<String, String>(
							pmService.getDocGiaFromPhieuMuon(maPM).getHo_Ten(),
							pmService.getNhanVienFromPhieuMuon(maPM).getHo_Ten());
					ThongTinPhieuMuonDialog dialog = new ThongTinPhieuMuonDialog(frame, true, pm, ten, listChiTiet);
					dialog.setVisible(true);
				}
			}
		});

		jmiLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setView();
			}
		});

	}

	public void addPop(Component cmp, final JPopupMenu pop) {
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
}
