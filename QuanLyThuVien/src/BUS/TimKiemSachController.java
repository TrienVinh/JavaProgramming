package BUS;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DTO.Pair;
import DTO.Sach;
import DTO.SachTimKiem;
import DTO.ViTri;

public class TimKiemSachController {
	private JTextField jtfTenSach, jtfGiaTien;
	private JComboBox<String> jcobMaTG, jcobMaNXB, jcobMaVT;
	private JButton jbtnSearch;
	private JMenuItem jmiLamMoi;
	private JPanel jpnView;
	private JList<String> jlMaTL, jlMaNN;

	private JTable table;
	private List<Sach> listItem;
	private List<SachTimKiem> listSachTimKiem;
	private SachService tkSachsv;
	private String[] theLoai, ngonNgu, tacGia, viTri, NXB;

	public TimKiemSachController(JTextField jtfTenSach, JTextField jtfGiaTien, JComboBox<String> jcobMaTG,
			JComboBox<String> jcobMaNXB, JComboBox<String> jcobMaVT, JButton jbtnSearch, JMenuItem jmiLamMoi,
			JPanel jpnView, JList<String> jlMaTL, JList<String> jlMaNN) {
		super();
		this.jtfTenSach = jtfTenSach;
		this.jtfGiaTien = jtfGiaTien;
		this.jcobMaTG = jcobMaTG;
		this.jcobMaNXB = jcobMaNXB;
		this.jcobMaVT = jcobMaVT;
		this.jbtnSearch = jbtnSearch;
		this.jmiLamMoi = jmiLamMoi;
		this.jpnView = jpnView;
		this.jlMaTL = jlMaTL;
		this.jlMaNN = jlMaNN;

		tkSachsv = new SachServiceimp();
		listItem = new ArrayList<Sach>();

		NXB = tkSachsv.getComboBoxMaNXB();
		jcobMaNXB.setModel(new DefaultComboBoxModel<String>(NXB));

		tacGia = tkSachsv.getComboBoxMaTG();
		jcobMaTG.setModel(new DefaultComboBoxModel<String>(tacGia));

		viTri = tkSachsv.getComboBoxMaVT();
		jcobMaVT.setModel(new DefaultComboBoxModel<String>(viTri));

		theLoai = tkSachsv.getComboBoxMaTL();
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

		ngonNgu = tkSachsv.getComboBoxMaNN();
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

	String[] columnName = { "STT", "Ma Sach", "Ten Sach", "Tac Gia", "The Loai", "Ma NCC", "So Khu", "So Ke", "So Ngan",
			"So Luong", "Ngon Ngu", "So Trang", "Gia Tien" };

	public void resetData() {

		listItem = tkSachsv.getListSach();
		listSachTimKiem = getListSearchSachFromSach(listItem);

		if (listItem.size() > 0) {
			int id = Integer.parseInt(ClassSupport.findString(tkSachsv.getLastId(), "(\\d+)"));
			Sach.setsId(++id);
		}
		jtfTenSach.setText("");
		jtfGiaTien.setText("");

		jcobMaNXB.setSelectedIndex(-1);
		jcobMaTG.setSelectedIndex(-1);
		jcobMaVT.setSelectedIndex(-1);

	}

	public void setView() {

		resetData();

		DefaultTableModel model = new ClassModel().getModel(listSachTimKiem, columnName);
		table = new JTable(model);

		table.setFont(new Font("tahoma", Font.PLAIN, 15));
		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 17));
		table.setRowHeight(50);

		setSizeTable();

//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				int row = table.getSelectedRow();
//				if (e.getClickCount() == 2 && row != -1) {
//					row = table.convertRowIndexToModel(row);
//					Sach s = listItem.get(row);
//					jtfMaSach.setText(s.getMa_Sach());
//					jtfTenSach.setText(s.getTen_Sach());
//					jtfSoLuong.setText(s.getSo_Luong() + "");
//					jtfSoTrang.setText(s.getSo_Trang() + "");
//
//					jtfGiaTien.setText(s.getGia_Tien() + "");
//
//					for (int i = 0; i < jcobMaNXB.getItemCount(); i++) {
//						String nxb = (String) jcobMaNXB.getItemAt(i);
//						if (nxb.contains(s.getMa_NXB())) {
//							jcobMaNXB.setSelectedIndex(i);
//							break;
//						}
//					}
//
//					for (int i = 0; i < jcobMaTG.getItemCount(); i++) {
//						String tg = (String) jcobMaTG.getItemAt(i);
//						if (tg.contains(s.getMa_Tac_Gia())) {
//							jcobMaTG.setSelectedIndex(i);
//							break;
//						}
//					}
//
//					for (int i = 0; i < jcobMaVT.getItemCount(); i++) {
//						String vt = (String) jcobMaVT.getItemAt(i);
//						if (vt.contains(s.getMa_Vi_Tri())) {
//							jcobMaVT.setSelectedIndex(i);
//							break;
//						}
//					}
//
//					int j = 0;
//					String[] tl = s.getThe_Loai().split(", ");
//					int[] so = new int[theLoai.length];
//					for (int i = 0; i < theLoai.length; i++) {
//						if (theLoai[i].contains(tl[j])) {
//							so[j] = i;
//							j++;
//							if (j == tl.length)
//								break;
//						}
//					}
//					jlMaTL.setSelectedIndices(so);
//
//					j = 0;
//					so = Arrays.copyOf(so, ngonNgu.length);
//					String[] nn = s.getNgon_Ngu().split(", ");
//					for (int i = 0; i < ngonNgu.length; i++) {
//						if (ngonNgu[i].contains(nn[j])) {
//							so[j] = i;
//							j++;
//							if (j == nn.length)
//								break;
//						}
//					}
//					jlMaNN.setSelectedIndices(so);
//				}
//			}
//		});

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

				setView();
			}
		});

		jbtnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String tenSach = jtfTenSach.getText();
				String tacGia = (jcobMaTG.getSelectedIndex() == -1) ? ""
						: ((String) jcobMaTG.getSelectedItem()).split(" - ")[1];
				String nxb = (jcobMaNXB.getSelectedIndex() == -1) ? ""
						: ((String) jcobMaNXB.getSelectedItem()).split(" - ")[1];
				String viTri = (jcobMaNXB.getSelectedIndex() == -1) ? ""
						: ((String) jcobMaVT.getSelectedItem()).split(" - ")[0];

				Pair<String, String> theLoai = getStringFromList(jlMaTL.getSelectedValuesList());
				Pair<String, String> ngonNgu = getStringFromList(jlMaNN.getSelectedValuesList());

				String giaTien = jtfGiaTien.getText();

				List<SachTimKiem> list = new ArrayList<SachTimKiem>();
				for (int i = 0; i < listSachTimKiem.size(); i++) {
					SachTimKiem sachtk = listSachTimKiem.get(i);
					if (sachtk.getTen_Sach().contains(tenSach) && sachtk.getNgon_Ngu().contains(ngonNgu.getV())
							&& sachtk.getNXB().contains(nxb) && listItem.get(i).getMa_Vi_Tri().contains(viTri)
							&& (sachtk.getGia_Tien() + "").contains(giaTien) && sachtk.getTac_Gia().contains(tacGia)
							&& sachtk.getThe_Loai().contains(theLoai.getV())) {
						list.add(sachtk);
					}
				}

				DefaultTableModel model = new ClassModel().getModel(list, columnName);
				table.setModel(model);
				setSizeTable();
			}
		});

	}

	public Pair<String, String> getStringFromList(List<String> list) {
		Pair<String, String> pair = new Pair<String, String>();
		String ten = "", id = "";
		for (String s : list) {
			String[] split = s.split("-");
			ten += split[1].trim() + ", ";
			id += split[0].trim() + ", ";
		}
		if (ten.length() > 0)
			ten = ten.substring(0, ten.length() - 2);
		else
			ten = "";
		if (ten.length() > 0)
			id = id.substring(0, id.length() - 2);
		else
			id = "";
		pair.setK(id);
		pair.setV(ten);
		return pair;
	}

	public List<SachTimKiem> getListSearchSachFromSach(List<Sach> listSach) {
		List<SachTimKiem> listTimKiem = new ArrayList<SachTimKiem>();
		for (Sach s : listSach) {
			SachTimKiem sachTk = new SachTimKiem(s);
			String tG = getStringFromMa(s.getMa_Tac_Gia(), this.tacGia);
			String NXB = getStringFromMa(s.getMa_NXB(), this.NXB);
			ViTri vt = getViTriFromMaVT(s.getMa_Vi_Tri(), viTri);

			sachTk.setTac_Gia(tG);
			sachTk.setNXB(NXB);
			sachTk.setSo_Khu(vt.getSo_Khu());
			sachTk.setSo_Ke(vt.getSo_Ke());
			sachTk.setSo_Ngan(vt.getSo_Ngan());
			listTimKiem.add(sachTk);
		}
		return listTimKiem;
	}

	public String getStringFromMa(String ma, String[] type) {
		String s = "";
		for (String string : type) {
			if (string.contains(s)) {
				s = string.split("-")[1].trim();
				break;
			}
		}
		return s;
	}

	public ViTri getViTriFromMaVT(String maVT, String[] viTri) {
		ViTri vt = null;
		for (String string : viTri) {
			if (string.contains(maVT)) {
				String[] arr = string.split(" - ");
				String khu = ClassSupport.findString(arr[1], "(\\d+)");

				String ke = ClassSupport.findString(arr[2], "(\\d+)");

				String ngan = ClassSupport.findString(arr[3], "(\\d+)");
				vt = new ViTri(maVT, Integer.parseInt(ke), Integer.parseInt(khu), Integer.parseInt(ngan));
				break;
			}
		}
		return vt;
	}

	public void setSizeTable() {
		table.getColumnModel().getColumn(0).setPreferredWidth(8);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(20);
		table.getColumnModel().getColumn(7).setPreferredWidth(15);
		table.getColumnModel().getColumn(9).setPreferredWidth(30);

		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(15);
		table.getColumnModel().getColumn(11).setPreferredWidth(30);
	}
}
