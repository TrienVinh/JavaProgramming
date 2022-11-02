package BUS;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.util.Rotation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.toedter.calendar.JDateChooser;

import DTO.ChiTietPhieuMuon;
import DTO.DocGia;
import DTO.Pair;
import DTO.PhieuMuon;
import DTO.PhieuPhat;
import DTO.Sach;
import GUI.PhieuPhatDialog;
import GUI.ThongTinPhieuMuonDialog;

public class ThongKeController {
	private JPanel jpnView, jpnThongKe, jpnTitle;
	private JList<String> jlThongKe;
	private ThongKeService tkService;
	private JFrame frame;

	public ThongKeController(JPanel jpnView, JPanel jpnThongKe, JList<String> jlThongKe, JFrame frame,
			JPanel jpnTitle) {
		super();
		this.jpnView = jpnView;
		this.jpnThongKe = jpnThongKe;
		this.jlThongKe = jlThongKe;
		this.jpnTitle = jpnTitle;
		this.frame = frame;
		tkService = new ThongKeServiceImp();
	}

	public void setView() {
		jlThongKe.setSelectedIndex(3);
		String sql = "SELECT doc_gia.* , sum(tong_so_sach_muon) as so_luong_muon from phieu_muon  INNER JOIN doc_gia ON phieu_muon.ma_doc_gia = doc_gia.ma_doc_gia GROUP BY (phieu_muon.ma_doc_gia)";
		List<Pair<DocGia, Double>> listPair = tkService.getListDocGia(sql);
		bieuDoCot(getListPairFromDocGia(listPair), 3);
	}

	public void setEvent() {
		jlThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int choose = jlThongKe.getSelectedIndex();
				switch (choose) {

				case 1: {
					String sql = "SELECT sach.ma_sach, ten_sach , sum(so_luong_muon) as so_luong FROM sach INNER JOIN chi_tiet_phieu_muon on sach.ma_sach = chi_tiet_phieu_muon.ma_sach GROUP by (chi_tiet_phieu_muon.ma_sach) HAVING SUM(so_luong_muon) > (SELECT AVG(so_luong_muon) from chi_tiet_phieu_muon) LIMIT 3";
					List<Pair<String, Pair<String, Double>>> listPair = tkService.getListTwoPair(sql);
					bieuDoCot(listPair, choose);
					setViewForPanel(jpnTitle, new JPanel());
					break;
				}
				case 2: {
					String sql = "SELECT sach.ma_sach,ten_sach, SUM(so_luong_muon)as so_luong FROM sach INNER JOIN chi_tiet_phieu_muon ON sach.ma_sach = chi_tiet_phieu_muon.ma_sach GROUP BY (chi_tiet_phieu_muon.ma_sach) HAVING SUM(so_luong_muon) <= (SELECT AVG(so_luong_muon) from chi_tiet_phieu_muon) LIMIT 3 ";
					List<Pair<String, Pair<String, Double>>> listPair = tkService.getListTwoPair(sql);
					sql = " select sach.ma_sach, ten_sach , 0 as so_luong from sach where ma_sach not in (select ma_sach from chi_tiet_phieu_muon)";
					List<Pair<String, Pair<String, Double>>> listTemp = tkService.getListTwoPair(sql);
					if (listTemp.size() > 0) {
						listPair.addAll(listTemp);
					}
					bieuDoCot(listPair, choose);
					setViewForPanel(jpnTitle, new JPanel());
					break;
				}

				case 0: {
					String sql = "SELECT sach.ma_sach, ten_sach , format(SUM(so_luong_muon) / (SELECT SUM(so_luong_muon) from chi_tiet_phieu_muon) * 100 , 2) as so_luong FROM sach INNER JOIN chi_tiet_phieu_muon on sach.ma_sach = chi_tiet_phieu_muon.ma_sach GROUP BY(chi_tiet_phieu_muon.ma_sach)";
					List<Pair<String, Pair<String, Double>>> listPair = tkService.getListTwoPair(sql);
					sql = "select sach.ma_sach, ten_sach , 0 as so_luong from sach where ma_sach not in (select ma_sach from chi_tiet_phieu_muon)";
					List<Pair<String, Pair<String, Double>>> listTemp = tkService.getListTwoPair(sql);
					if (listTemp.size() > 0) {
						listPair.addAll(listTemp);
					}
					bieuDoTron(listPair);
					setViewForPanel(jpnTitle, new JPanel());
					break;
				}
				case 3: {
					String sql = "SELECT doc_gia.ma_doc_gia ,concat(doc_gia.ho ,' ' ,doc_gia.ten) , sum(tong_so_sach_muon) as so_luong_muon from phieu_muon  INNER JOIN doc_gia ON phieu_muon.ma_doc_gia = doc_gia.ma_doc_gia GROUP BY (phieu_muon.ma_doc_gia)";
					List<Pair<String, Pair<String, Double>>> listPair = tkService.getListTwoPair(sql);
					bieuDoCot(listPair, choose);
					setViewForPanel(jpnTitle, new JPanel());
					break;
				}
				case 4: {
					String sql = "SELECT * from phieu_muon WHERE hoan_tra = 0";

					setViewForPanel(jpnView, setTablePhieuMuon(sql, choose));

					setViewForPanel(jpnThongKe, new JPanel());
					setViewForPanel(jpnTitle, new JPanel());
					break;
				}
				case 5: {

					String sql = "SELECT * from phieu_muon WHERE ngay_phai_tra < '"
							+ new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) + "'";
					setViewForPanel(jpnView, setTablePhieuMuon(sql, choose));

					setViewForPanel(jpnThongKe, new JPanel());
					setViewForPanel(jpnTitle, new JPanel());
					break;
				}
				case 6: {
					setViewForPanel(jpnView, new JPanel());
					JPanel jpn = null;
					if (choose == 6) {
						jpn = addLabelForPanel(choose);
					} else
						jpn = new JPanel();
					jpn.add(addLabelForPanel(choose));
					setViewForPanel(jpnTitle, jpn);
					setViewForPanel(jpnThongKe, new JPanel());
					break;
				}
				case 7: {
					String sql = "SELECT sach.ma_sach, ten_sach , ma_tac_gia , ma_nxb , nam_xuat_ban ,ma_vi_tri,gia_tien,so_trang , sum(so_luong_muon - so_luong_tra) as so_luong FROM sach INNER JOIN chi_tiet_phieu_muon on sach.ma_sach = chi_tiet_phieu_muon.ma_sach GROUP by (chi_tiet_phieu_muon.ma_sach)";
					setViewForPanel(jpnTitle, new JPanel());
					setViewForPanel(jpnView, setTableSach(sql, choose));
					setViewForPanel(jpnThongKe, new JPanel());
					break;
				}
				case 8: {
					String sql = "SELECT doc_gia.ma_doc_gia ,concat(doc_gia.ho ,' ' ,doc_gia.ten) , count(giay_phat.ma_sach) FROM phieu_muon INNER JOIN doc_gia ON phieu_muon.ma_doc_gia = doc_gia.ma_doc_gia INNER JOIN giay_phat ON phieu_muon.ma_phieu_muon = giay_phat.ma_phieu_muon GROUP BY (giay_phat.ma_phieu_muon) LIMIT 3";
					List<Pair<String, Pair<String, Double>>> listPair = tkService.getListTwoPair(sql);
					setViewForPanel(jpnTitle, new JPanel());
					bieuDoCot(listPair, choose);
					setPanelThongKe(listPair);
					break;
				}
				default:
					break;
				}
			}
		});

	}

	public <E> void bieuDoCot(List<Pair<String, Pair<String, Double>>> listPair, int choose) {
		// Pair<String,Pair<String,Double>> String1 la ma Sach , String 2 la ten sach

		double maxSize = 0;
		if (listPair.size() > 0) {

			// Tao toa do cho cac item trong dataset
			int size = listPair.size();
			// Tao list toa do cho cac Item
			List<Pair<Integer, Integer>> listItemSpace = new ArrayList<Pair<Integer, Integer>>();
			// TotalView = 750 - 40 * 2= 670 ( 40 la do setItemMargin(.1) * 2 chia đều cho 2
			// bên )
			// spaceItem = 150 / (size - 1) khoảng cách giữa các item
			int totalView = 670, spaceItem = 150;
			if (size > 1)
				// spaceItem = 150 khi size >= 2, khi size = 1 thì size - 1 = 0 => Error
				spaceItem /= (size - 1);
			// biên trái của item đầu tiên tại toạ độ 102( itemMin ) , biên phải là
			int itemMin = 102, widthItem = (totalView - 150) / size;
			for (int i = 0; i < size; i++) {
				Pair<Integer, Integer> pair = new Pair<Integer, Integer>();
				pair.setK(itemMin);
				pair.setV(itemMin + widthItem);
				listItemSpace.add(pair);
				itemMin += widthItem + spaceItem;

			}
			// end tạo toạ độ

			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			String rowTitle = "Tên Sách";
			if (choose == 3) {
				rowTitle = "Tên Khách hàng";
			}
			for (int i = 0; i < listPair.size(); i++) {
				Pair<String, Double> pair = listPair.get(i).getV();
				dataset.addValue(pair.getV(), rowTitle, pair.getK());
				if (pair.getV() > maxSize)
					maxSize = pair.getV();
			}

			JFreeChart chart = null;
			if (choose == 1) {
				chart = ChartFactory.createBarChart("Sách được mượn nhiều nhất", "Tên Sách", "Số Lượng", dataset);
			} else if (choose == 2)
				chart = ChartFactory.createBarChart("Sách được mượn ít nhất", "Tên Sách", "Số Lượng", dataset);
			else if (choose == 8)
				chart = ChartFactory.createBarChart("Khách hàng thường xuyên bị phạt", "Tên Khách hàng", "Số Lần Phạt",
						dataset);
			else
				chart = ChartFactory.createBarChart("Khách hàng thường xuyên mượn sách", "Khách hàng", "Số Lần Mượn",
						dataset);

			// Set Propertise for Bieu do cot
			CategoryPlot plot = chart.getCategoryPlot();
			plot.setOutlineStroke(new BasicStroke(3));

			plot.getRangeAxis().setAutoRange(false);
			// Set height cua bieu do cot
			plot.getRangeAxis().setRange(0.0, maxSize + 1);
			plot.getRangeAxis().setTickLabelFont(new Font("tahoma", Font.PLAIN, 14));

			NumberAxis Axis = (NumberAxis) plot.getRangeAxis();
			// Set khoang cach cua cac so
			Axis.setTickUnit(new NumberTickUnit(0.5));

			BarRenderer render = (BarRenderer) plot.getRenderer();

			// Set khoang cach tu bien trai den Cot
			render.setItemMargin(-1);
			// Set max width of Cot trong BarChart
//			render.setMaximumBarWidth(.10);

			ChartPanel panel = new ChartPanel(chart);
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					if (e.getClickCount() == 2) {
						int x = e.getX();
						for (int i = 0; i < size; i++) {
							Pair<Integer, Integer> pair = listItemSpace.get(i);
							if (x > pair.getK() && x < pair.getV()) {
								if (choose == 3) {
									String sql = "select phieu_muon.* from phieu_muon where ma_doc_gia='"
											+ listPair.get(i).getK() + "'";
									setViewForPanel(jpnThongKe, setTablePhieuMuon(sql, choose));
								} else if (choose == 8) {
									String sql = "SELECT giay_phat.* from giay_phat INNER JOIN phieu_muon ON giay_phat.ma_phieu_muon = phieu_muon.ma_phieu_muon WHERE phieu_muon.ma_doc_gia = '"
											+ listPair.get(i).getK() + "'";
									setViewForPanel(jpnThongKe, setTablePhieuPhat(sql, choose));
								} else {
									String sql = "SELECT sach.ma_sach,ten_sach,ma_tac_gia, ma_nxb, so_trang, gia_tien, nam_xuat_ban, ma_vi_tri, SUM(so_luong_muon)as so_luong FROM sach INNER JOIN chi_tiet_phieu_muon ON sach.ma_sach = chi_tiet_phieu_muon.ma_sach where sach.ma_sach='"
											+ listPair.get(i).getK() + "'";
									setViewForPanel(jpnThongKe, setTableSach(sql, choose));
								}
							}

						}
					}
				}
			});
			setViewForPanel(jpnView, panel);
			setPanelThongKe(listPair);
		}
	}

	public void bieuDoTron(List<Pair<String, Pair<String, Double>>> listPair) {
		if (listPair.size() > 0) {
			DefaultPieDataset dataset = new DefaultPieDataset();

			List<Pair<String, Double>> listTemp = new ArrayList<Pair<String, Double>>();
			for (Pair<String, Pair<String, Double>> pairMain : listPair) {
				Pair<String, Double> pair = pairMain.getV();
				dataset.setValue(pair.getK() + "( " + pair.getV() + "% )", pair.getV());
				listTemp.add(pair);
			}
			JFreeChart chart = ChartFactory.createPieChart3D("Tỉ lệ sách được mượn", dataset, true, true, false);

			PiePlot3D pie = (PiePlot3D) chart.getPlot();

//			đặt góc bắt đầu (135 hoặc 150 độ để dữ liệu nhỏ có nhiều không gian hơn ở bên trái)
//			pie.setStartAngle(360);
			pie.setDirection(Rotation.CLOCKWISE);

//			Một lá cờ cho biết biểu đồ hình tròn là hình tròn, hoặc kéo dài thành hình elip.
//			pie.setCircular(true);
			pie.setLabelGap(0.02);
			pie.setLabelFont(new Font("tahoma", Font.PLAIN, 18));
			pie.setForegroundAlpha(0.5f);
			pie.setOutlineStroke(new BasicStroke(3));

			ChartPanel panel = new ChartPanel(chart);
			setViewForPanel(jpnView, panel);

			setPanelThongKeForBieuDoTron(listTemp);
		}
	}

	public void setViewForPanel(JPanel jpn, Component cmp) {
		jpn.removeAll();
		jpn.setLayout(new BorderLayout());
		jpn.add(cmp, BorderLayout.CENTER);
		jpn.validate();
		jpn.repaint();

	}

	public void setPanelThongKe(List<Pair<String, Pair<String, Double>>> listPair) {
		JLabel jlb = (JLabel) setAttributeForCmp("- Danh Sách", 10, 30, 300, 27, 1);

		JPanel jpn = new JPanel();
		jpn.setLayout(null);
		jpn.add(jlb);

		int x = 20, y = 30, addY = 30;
		for (int i = 0; i < listPair.size(); i++) {
			Pair<String, Double> pair = listPair.get(i).getV();
			y = 30 + addY * (i + 1);

			JLabel text = (JLabel) setAttributeForCmp(" + " + pair.getK() + " x " + pair.getV(), x, y, 500, 27, 1);
			jpn.add(text);
		}

		setViewForPanel(jpnThongKe, jpn);
	}

	public void setPanelThongKeForBieuDoTron(List<Pair<String, Double>> listPair) {
		JLabel jlb = (JLabel) setAttributeForCmp("- Danh Sách", 10, 30, 300, 27, 1);

		JPanel jpn = new JPanel();
		jpn.setLayout(null);
		jpn.add(jlb);

		int x = 20, y = 30, addY = 30;
		for (int i = 0; i < listPair.size(); i++) {
			Pair<String, Double> pair = listPair.get(i);
			y = 30 + addY * (i + 1);

			JLabel text = (JLabel) setAttributeForCmp(" + " + pair.getK() + " x " + pair.getV(), x, y, 500, 27, 1);
			jpn.add(text);
		}

		setViewForPanel(jpnThongKe, jpn);
	}

	public JScrollPane setTablePhieuMuon(String sql, int choose) {

		String[] columnName = { "STT", "Mã PM", "Mã ĐG", "Mã NV", "Ngày Mượn", "Ngày Phải Trả", "Tổng Số Sách Mượn",
				"Hoàn Trả" };
		List<PhieuMuon> listPhieuMuon = tkService.getPhieuMuon(sql);
		DefaultTableModel model = new ClassModel().getModel(listPhieuMuon, columnName);
		JTable tbl = new JTable(model);

		tbl.setRowHeight(50);
		tbl.getTableHeader().setPreferredSize(new Dimension(100, 50));
		tbl.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 16));
		tbl.setFont(new Font("tahoma", Font.PLAIN, 14));
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tbl.getSelectedRow();
				if (e.getClickCount() == 2 && row != -1) {
					PhieuMuon pm = listPhieuMuon.get(row);
					String maPM = pm.getMa_Phieu_Muon();
					List<Pair<ChiTietPhieuMuon, String>> listChiTiet = tkService.getListChiTiet(maPM);

					String sql = "select concat(doc_gia.ho ,' ', doc_gia.ten) , concat(nhan_vien.ho,' ',nhan_vien.ten) from phieu_muon inner join doc_gia on phieu_muon.ma_doc_gia = doc_gia.ma_doc_gia inner join nhan_vien on phieu_muon.ma_nhan_vien = nhan_vien.ma_nhan_vien where phieu_muon.ma_phieu_muon ='"
							+ maPM + "'";
					Pair<String, String> ten = tkService.getTen(sql);
					ThongTinPhieuMuonDialog dialog = new ThongTinPhieuMuonDialog(frame, true, pm, ten, listChiTiet);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				}
			}
		});

		return new JScrollPane(tbl);

	}

	public JScrollPane setTablePhieuPhat(String sql, int choose) {

		String[] columnName = { "STT", "Mã PM", "Mã Sách", "Lý Do", "Tiền Phạt" };
		List<PhieuPhat> listPhieuPhat = tkService.getListPhieuPhat(sql);
		DefaultTableModel model = new ClassModel().getModel(listPhieuPhat, columnName);
		JTable tbl = new JTable(model);

		tbl.setRowHeight(50);
		tbl.getTableHeader().setPreferredSize(new Dimension(100, 50));
		tbl.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 16));
		tbl.setFont(new Font("tahoma", Font.PLAIN, 14));
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tbl.getSelectedRow();
				if (e.getClickCount() == 2 && row != -1) {
					PhieuPhat pp = listPhieuPhat.get(row);
					String maPM = pp.getMa_Phieu_Muon();
					String maSach = pp.getMa_Sach();

					String sql = "select concat(doc_gia.ho ,' ', doc_gia.ten) , sach.ten_sach from phieu_muon INNER JOIN giay_phat ON phieu_muon.ma_phieu_muon = giay_phat.ma_phieu_muon INNER JOIN doc_gia ON phieu_muon.ma_doc_gia = doc_gia.ma_doc_gia INNER JOIN sach on giay_phat.ma_sach = sach.ma_sach WHERE giay_phat.ma_phieu_muon = '"
							+ maPM + "' AND giay_phat.ma_sach = '" + maSach + "'";
					Pair<String, String> ten = tkService.getTen(sql);
					PhieuPhatDialog dialog = new PhieuPhatDialog(frame, true, pp, ten);
					dialog.setEnableForButtonPhat(false);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				}
			}
		});

		return new JScrollPane(tbl);

	}

	public JScrollPane setTableSach(String sql, int choose) {

		String[] columnName = { "STT", "Ma Sach", "Ten Sach", "Ma TG", "The Loai", "Ma VT", "Ma NCC", "So Luong",
				"Ngon Ngu", "So Trang", "Gia Tien" };
		List<Sach> listSach = tkService.getListSach(sql);
		DefaultTableModel model = new ClassModel().getModel(listSach, columnName);
		JTable tbl = new JTable(model);

		tbl.setRowHeight(50);
		tbl.getTableHeader().setPreferredSize(new Dimension(100, 50));
		tbl.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 16));
		tbl.setFont(new Font("tahoma", Font.PLAIN, 14));

		return new JScrollPane(tbl);

	}

	public Component setAttributeForCmp(String text, int x, int y, int width, int height, int type) {
		Component cmp = null;
		if (type == 1) {
			cmp = new JLabel(text);
		} else if (type == 2)
			cmp = new JTextField(text);
		else if (type == 3) {
			cmp = new JButton(text);
		}

		cmp.setFont(new Font("tahoma", Font.PLAIN, 20));
		cmp.setBounds(x, y, width, height);
		return cmp;
	}

	public JPanel addLabelForPanel(int choose) {

		try {
			JPanel pn = new JPanel();
			pn.setLayout(null);
			JLabel jlb = (JLabel) setAttributeForCmp("Từ ngày", 20, 20, 100, 25, 1);
			pn.add(jlb);

			JDateChooser jdcFrom = new JDateChooser(new SimpleDateFormat("dd/MM/yyyy").parse("1/1/2000"));
			jdcFrom.setBounds(110, 20, 170, 25);
			jdcFrom.setDateFormatString("dd/MM/yyyy");
			jdcFrom.setFont(new Font("tahoma", Font.PLAIN, 20));
			pn.add(jdcFrom);
			if (choose == 6) {
				JLabel jlb2 = (JLabel) setAttributeForCmp("Đến ngày", 300, 20, 100, 25, 1);
				pn.add(jlb2);

				JDateChooser jdcTo = new JDateChooser(Calendar.getInstance().getTime());
				jdcTo.setBounds(420, 20, 170, 25);
				jdcTo.setDateFormatString("dd/MM/yyyy");
				jdcTo.setFont(new Font("tahoma", Font.PLAIN, 20));
				pn.add(jdcTo);

				JButton jbtn = (JButton) setAttributeForCmp("Tìm Kiếm", 600, 20, 150, 25, 3);
				pn.add(jbtn);
				jbtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						String sql = "select * from phieu_muon where ngay_muon > '"
								+ new SimpleDateFormat("yyyy/MM/dd").format(jdcFrom.getDate()) + "' and ngay_muon < '"
								+ new SimpleDateFormat("yyyy/MM/dd").format(jdcTo.getDate()) + "'";
						setViewForPanel(jpnView, setTablePhieuMuon(sql, choose));

					}
				});

			}
			return pn;
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return null;
	}

	public List<Pair<String, Pair<String, Double>>> getListPairFromL(List<Sach> listSach) {
		List<Pair<String, Pair<String, Double>>> listPair = new ArrayList<Pair<String, Pair<String, Double>>>();
		for (Sach sach : listSach) {
			String maSach = sach.getMa_Sach();
			Pair<String, Double> pair = new Pair<String, Double>(sach.getTen_Sach(), (double) sach.getSo_Luong());
			listPair.add(new Pair<String, Pair<String, Double>>(maSach, pair));

		}
		return listPair;
	}

	public List<Pair<String, Pair<String, Double>>> getListPairFromDocGia(List<Pair<DocGia, Double>> listDocGia) {
		List<Pair<String, Pair<String, Double>>> listPair = new ArrayList<Pair<String, Pair<String, Double>>>();
		for (Pair<DocGia, Double> pair : listDocGia) {
			String maDG = pair.getK().getMa_Doi_Tuong();
			Pair<String, Double> pairItem = new Pair<String, Double>(pair.getK().getHo_Ten(), pair.getV());
			listPair.add(new Pair<String, Pair<String, Double>>(maDG, pairItem));
		}
		return listPair;
	}
}
