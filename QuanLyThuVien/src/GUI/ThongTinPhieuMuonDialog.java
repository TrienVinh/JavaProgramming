package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import BUS.ThongTinPhieuMuonController;
import DTO.ChiTietPhieuMuon;
import DTO.ChiTietPhieuNhap;
import DTO.Pair;
import DTO.PhieuMuon;
import DTO.PhieuNhapHang;

public class ThongTinPhieuMuonDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField jtfMaPM;
	private JTextField jtfMaDG;
	private JTextField jtfTenDG;
	private JTextField jtfMaNV;
	private JTextField jtfTenNV;
	private JTextField jtfNgayMuon;
	private JTextField jtfHanTra;
	private JLabel jlbHoanTat, jlbTongSTT, jlbTongMuon, jlbTongTra, lblMPm, lblMaDG, lblTenDG, jlbNgayNhap, jlbSachNhap,
			jlbSoLuong, jlbGiaTien, lblHoanTat, lblNgyTr, lblTnhTrngTr, jlbHanTra;
	private JButton jbtnThoat;
	private JPanel jpnView;

	/**
	 * Create the dialog.
	 * 
	 * @wbp.parser.constructor
	 */
	public ThongTinPhieuMuonDialog(JFrame frame, boolean check, PhieuMuon pm, Pair<String, String> ten,
			List<Pair<ChiTietPhieuMuon, String>> listChiTiet) {
		super(frame, check);
		init();
		ThongTinPhieuMuonController control = new ThongTinPhieuMuonController(jtfMaPM, jtfMaDG, jtfMaNV, jtfTenDG,
				jtfTenNV, jtfNgayMuon, jtfHanTra, jlbHoanTat, jlbTongSTT, jlbTongMuon, jlbTongTra, jbtnThoat, this,
				jpnView);
		control.setView(pm, ten, listChiTiet);
		control.setEvent();
	}

	public ThongTinPhieuMuonDialog(JFrame frame, boolean check, PhieuNhapHang pn, Pair<String, String> ten,
			List<Pair<ChiTietPhieuNhap, String>> listChiTiet) {
		super(frame, check);
		init();
		ThongTinPhieuMuonController control = new ThongTinPhieuMuonController(jtfMaPM, jtfMaDG, jtfMaNV, jtfTenDG,
				jtfTenNV, jtfNgayMuon, jlbTongSTT, jlbTongMuon, jbtnThoat, this, jpnView);
		control.setViewForPN(pn, ten, listChiTiet);
		control.setEvent();
	}

	public void init() {
		setBounds(100, 100, 1059, 775);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE));

		JPanel panel_1 = new JPanel();

		jpnView = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
				.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)));

		lblMPm = new JLabel("Mã PM:");
		lblMPm.setBounds(39, 20, 66, 25);
		lblMPm.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblMaDG = new JLabel("Mã ĐG:");
		lblMaDG.setBounds(39, 67, 120, 25);
		lblMaDG.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblTenDG = new JLabel("Tên ĐG:");
		lblTenDG.setBounds(39, 115, 120, 25);
		lblTenDG.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblMNv_1 = new JLabel("Mã NV:");
		lblMNv_1.setBounds(39, 157, 120, 25);
		lblMNv_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblMNv_1_1 = new JLabel("Tên NV:");
		lblMNv_1_1.setBounds(39, 202, 120, 25);
		lblMNv_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jlbNgayNhap = new JLabel("Ngày Mượn:");
		jlbNgayNhap.setBounds(39, 245, 120, 25);
		jlbNgayNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jlbHanTra = new JLabel("Hạn Trả:");
		jlbHanTra.setBounds(39, 290, 120, 25);
		jlbHanTra.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jlbSachNhap = new JLabel("Sách Mượn:");
		jlbSachNhap.setBounds(39, 348, 120, 25);
		jlbSachNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblStt = new JLabel("STT");
		lblStt.setBounds(177, 350, 53, 22);
		lblStt.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblTenSach = new JLabel("Tên Sách");
		lblTenSach.setBounds(237, 350, 147, 22);
		lblTenSach.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jlbSoLuong = new JLabel("Số Lượng Mượn");
		jlbSoLuong.setBounds(394, 350, 129, 22);
		jlbSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jlbGiaTien = new JLabel("Số Lượng Trả");
		jlbGiaTien.setBounds(541, 350, 109, 22);
		jlbGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblNgyTr = new JLabel("Ngày Trả");
		lblNgyTr.setBounds(667, 350, 109, 22);
		lblNgyTr.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblTnhTrngTr = new JLabel("Tình Trạng Trả");
		lblTnhTrngTr.setBounds(786, 350, 239, 22);
		lblTnhTrngTr.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jlbTongSTT = new JLabel("");
		jlbTongSTT.setBounds(177, 517, 53, 22);
		jlbTongSTT.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jlbTongMuon = new JLabel("");
		jlbTongMuon.setBounds(394, 517, 53, 22);
		jlbTongMuon.setFont(new Font("Tahoma", Font.PLAIN, 18));

		jlbTongTra = new JLabel("");
		jlbTongTra.setBounds(541, 515, 53, 22);
		jlbTongTra.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblHoanTat = new JLabel("Hoàn Tất :");
		lblHoanTat.setBounds(39, 558, 120, 25);
		lblHoanTat.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jbtnThoat = new JButton("Thoát");
		jbtnThoat.setBounds(384, 601, 208, 57);
		jbtnThoat.setFont(new Font("Tahoma", Font.PLAIN, 22));

		jtfMaPM = new JTextField();
		jtfMaPM.setBounds(177, 20, 346, 31);
		jtfMaPM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfMaPM.setColumns(10);
		jpnView.setLayout(null);
		jpnView.add(lblHoanTat);
		jpnView.add(jlbHanTra);
		jpnView.add(jlbTongSTT);
		jpnView.add(jlbTongMuon);
		jpnView.add(jbtnThoat);
		jpnView.add(jlbTongTra);
		jpnView.add(jlbSachNhap);
		jpnView.add(jlbNgayNhap);
		jpnView.add(lblMNv_1_1);
		jpnView.add(lblMNv_1);
		jpnView.add(lblTenDG);
		jpnView.add(lblMaDG);
		jpnView.add(lblMPm);
		jpnView.add(lblStt);
		jpnView.add(lblTenSach);
		jpnView.add(jlbSoLuong);
		jpnView.add(jtfMaPM);
		jpnView.add(jlbGiaTien);
		jpnView.add(lblNgyTr);
		jpnView.add(lblTnhTrngTr);

		jtfMaDG = new JTextField();
		jtfMaDG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfMaDG.setColumns(10);
		jtfMaDG.setBounds(177, 65, 346, 31);
		jpnView.add(jtfMaDG);

		jtfTenDG = new JTextField();
		jtfTenDG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfTenDG.setColumns(10);
		jtfTenDG.setBounds(177, 110, 346, 31);
		jpnView.add(jtfTenDG);

		jtfMaNV = new JTextField();
		jtfMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfMaNV.setColumns(10);
		jtfMaNV.setBounds(177, 155, 346, 31);
		jpnView.add(jtfMaNV);

		jtfTenNV = new JTextField();
		jtfTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfTenNV.setColumns(10);
		jtfTenNV.setBounds(177, 200, 346, 31);
		jpnView.add(jtfTenNV);

		jtfNgayMuon = new JTextField();
		jtfNgayMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfNgayMuon.setColumns(10);
		jtfNgayMuon.setBounds(177, 245, 346, 31);
		jpnView.add(jtfNgayMuon);

		jtfHanTra = new JTextField();
		jtfHanTra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfHanTra.setColumns(10);
		jtfHanTra.setBounds(177, 290, 346, 31);
		jpnView.add(jtfHanTra);

		jlbHoanTat = new JLabel("Chưa Trả");
		jlbHoanTat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jlbHoanTat.setBounds(177, 558, 120, 25);
		jpnView.add(jlbHoanTat);

		JLabel lblThngTinPhiu = new JLabel("THÔNG TIN PHIẾU MƯỢN");
		lblThngTinPhiu.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinPhiu.setFont(new Font("Tahoma", Font.PLAIN, 26));

		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(100)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE).addGap(100))
				.addComponent(lblThngTinPhiu, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblThngTinPhiu).addGap(10)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(27, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);

	}

	public void setViewForPN() {
		jlbNgayNhap.setText("Ngày Nhập");
		jlbGiaTien.setText("Giá Tiền");
		jlbSachNhap.setText("Sách Nhập");
		jlbSoLuong.setText("Số Lượng");
		lblMPm.setText("Mã PN");
		lblMaDG.setText("Mã NCC");
		lblTenDG.setText("Tên NCC");

		lblNgyTr.setText("");
		lblTnhTrngTr.setText("");
		lblHoanTat.setText("");
		jlbHanTra.setVisible(false);
		jtfHanTra.setVisible(false);
		jlbHoanTat.setText("");

	}
}
