package BUS;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.ChiTietPhieuMuon;
import DTO.ChiTietPhieuNhap;
import DTO.Pair;
import DTO.PhieuMuon;
import DTO.PhieuNhapHang;

public class ThongTinPhieuMuonController {
	private JTextField jtfMaPM, jtfMaDG, jtfMaNV, jtfTenDG, jtfTenNV, jtfNgayMuon, jtfHanTra;
	private JLabel jlbHoanTat, jlbTongSTT, jlbTongSlMuon, jlbTongSlTra;
	private JButton jbtnThoat;
	private JDialog dialog;
	private JPanel jpnView;

	public ThongTinPhieuMuonController(JTextField jtfMaPM, JTextField jtfMaDG, JTextField jtfMaNV, JTextField jtfTenDG,
			JTextField jtfTenNV, JTextField jtfNgayMuon, JTextField jtfHanTra, JLabel jlbHoanTat, JLabel jlbTongSTT,
			JLabel jlbTongSlMuon, JLabel jlbTongSlTra, JButton jbtnThoat, JDialog dialog, JPanel jpnView) {
		super();
		this.jtfMaPM = jtfMaPM;
		this.jtfMaDG = jtfMaDG;
		this.jtfMaNV = jtfMaNV;
		this.jtfTenDG = jtfTenDG;
		this.jtfTenNV = jtfTenNV;
		this.jtfNgayMuon = jtfNgayMuon;
		this.jtfHanTra = jtfHanTra;
		this.jlbHoanTat = jlbHoanTat;
		this.jlbTongSTT = jlbTongSTT;
		this.jlbTongSlMuon = jlbTongSlMuon;
		this.jlbTongSlTra = jlbTongSlTra;
		this.jbtnThoat = jbtnThoat;
		this.dialog = dialog;
		this.jpnView = jpnView;
	}

	public ThongTinPhieuMuonController(JTextField jtfMaPN, JTextField jtfMaDG, JTextField jtfMaNV, JTextField jtfTenDG,
			JTextField jtfTenNV, JTextField jtfNgayMuon, JLabel jlbTongSTT, JLabel jlbTongSlMuon, JButton jbtnThoat,
			JDialog dialog, JPanel jpnView) {
		super();
		this.jtfMaPM = jtfMaPN;
		this.jtfMaDG = jtfMaDG;
		this.jtfMaNV = jtfMaNV;
		this.jtfTenDG = jtfTenDG;
		this.jtfTenNV = jtfTenNV;
		this.jtfNgayMuon = jtfNgayMuon;
		this.jlbTongSTT = jlbTongSTT;
		this.jlbTongSlMuon = jlbTongSlMuon;
		this.jbtnThoat = jbtnThoat;
		this.dialog = dialog;
		this.jpnView = jpnView;
	}

	public void setView(PhieuMuon pm, Pair<String, String> ten, List<Pair<ChiTietPhieuMuon, String>> listChiTiet) {
		jtfMaPM.setEditable(false);
		jtfHanTra.setEditable(false);
		jtfMaDG.setEditable(false);
		jtfMaNV.setEditable(false);
		jtfNgayMuon.setEditable(false);
		jtfTenDG.setEditable(false);
		jtfTenNV.setEditable(false);

		jtfMaPM.setText(pm.getMa_Phieu_Muon());
		jtfHanTra.setText(new SimpleDateFormat("dd/MM/yyyy").format(pm.getNgay_Phai_Tra()));
		jtfMaDG.setText(pm.getMa_Doc_Gia());
		jtfMaNV.setText(pm.getMa_Nhan_Vien());
		jtfNgayMuon.setText(new SimpleDateFormat("dd/MM/yyyy").format(pm.getNgay_Muon()));
		jtfTenDG.setText(ten.getK());
		jtfTenNV.setText(ten.getV());

		int y = 350, yAdd = 40, tongMuon = 0, tongTra = 0;
		for (int i = 1; i <= listChiTiet.size(); i++) {
			Pair<ChiTietPhieuMuon, String> pair = listChiTiet.get(i - 1);
			ChiTietPhieuMuon ct = pair.getK();
			y = 350 + yAdd * i;
			// 177 350 53 22
			JLabel jlbSTT = new JLabel();
			setAttributeForComponent(177, y, 53, 22, i + "", jlbSTT);

			// 237 350 147 22
			JLabel jlbTenSach = new JLabel();
			setAttributeForComponent(237, y, 147, 22, pair.getV(), jlbTenSach);

			// 394 350 129 22
			JLabel jlbSLMuon = new JLabel();
			setAttributeForComponent(394, y, 129, 22, ct.getSo_Luong_Muon() + "", jlbSLMuon);
			tongMuon += ct.getSo_Luong_Muon();

			// 541 350 109 22
			JLabel jlbSLTra = new JLabel();
			setAttributeForComponent(541, y, 109, 22, ct.getSo_Luong_Tra() + "", jlbSLTra);
			jpnView.add(jlbSLTra);
			tongTra += ct.getSo_Luong_Tra();

			// 656 350 109 22
			JLabel jlbNgayTra = new JLabel();
			setAttributeForComponent(656, y, 109, 22,
					(ct.getNgay_tra() == null) ? "Trống" : new SimpleDateFormat("dd/MM/yyyy").format(ct.getNgay_tra()),
					jlbNgayTra);

			// 775 350 229 22
			JLabel jlbTinhTrangTra = new JLabel();
			setAttributeForComponent(394, y, 129, 22, ct.getTinh_Trang_Tra(), jlbTinhTrangTra);

		}

		y = 360 + yAdd * 4;
		JLabel jlbTong = new JLabel();
		setAttributeForComponent(39, y, 120, 25, "Tổng", jlbTong);

		setAttributeForComponent(177, y, 53, 22, listChiTiet.size() + "", jlbTongSTT);

		// 394 350 129 22
		setAttributeForComponent(394, y, 129, 22, tongMuon + "", jlbTongSlMuon);

		// 541 350 109 22
		setAttributeForComponent(541, y, 109, 22, tongTra + "", jlbTongSlTra);

		jlbHoanTat.setText(pm.isHoan_Tra() ? "Đã Trả" : "Chưa Trả");

	}

	public void setViewForPN(PhieuNhapHang pn, Pair<String, String> ten,
			List<Pair<ChiTietPhieuNhap, String>> listChiTiet) {
		jtfMaPM.setEditable(false);
		jtfMaDG.setEditable(false);
		jtfMaNV.setEditable(false);
		jtfNgayMuon.setEditable(false);
		jtfTenDG.setEditable(false);
		jtfTenNV.setEditable(false);

		jtfMaPM.setText(pn.getMaPN());
		jtfMaDG.setText(pn.getMaNCC());
		jtfMaNV.setText(pn.getMaNV());
		jtfNgayMuon.setText(new SimpleDateFormat("dd/MM/yyyy").format(pn.getNgay_Nhap()));
		jtfTenDG.setText(ten.getK());
		jtfTenNV.setText(ten.getV());

		int y = 350, yAdd = 40;
		for (int i = 1; i <= listChiTiet.size(); i++) {
			Pair<ChiTietPhieuNhap, String> pair = listChiTiet.get(i - 1);
			ChiTietPhieuNhap ct = pair.getK();
			y = 350 + yAdd * i;
			// 177 350 53 22
			JLabel jlbSTT = new JLabel();
			setAttributeForComponent(177, y, 53, 22, i + "", jlbSTT);

			// 237 350 147 22
			JLabel jlbTenSach = new JLabel();
			setAttributeForComponent(237, y, 147, 22, pair.getV(), jlbTenSach);

			// 394 350 129 22
			JLabel jlbSLMuon = new JLabel();
			setAttributeForComponent(394, y, 129, 22, ct.getSo_Luong() + "", jlbSLMuon);

			// 775 350 229 22
			JLabel jlbGiaTien = new JLabel();
			setAttributeForComponent(541, y, 129, 22, ct.getTong_Gia_Tien() + "", jlbGiaTien);

		}

		y = 360 + yAdd * 4;
		JLabel jlbTong = new JLabel();
		setAttributeForComponent(39, y, 120, 25, "Tổng", jlbTong);

		setAttributeForComponent(177, y, 53, 22, listChiTiet.size() + "", jlbTongSTT);

		// 394 350 129 22
		setAttributeForComponent(394, y, 129, 22, pn.getSo_Luong() + "", jlbTongSlMuon);

	}

	public void setEvent() {
		jbtnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				dialog.dispose();
			}
		});
	}

	public void setAttributeForComponent(int x, int y, int width, int height, String content, JLabel jlb) {
		jlb.setText(content);
		jlb.setBounds(x, y, width, height);
		jlb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jpnView.add(jlb);
	}
}
