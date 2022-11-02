package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import BUS.PhieuTraController;
import DTO.ChiTietPhieuMuon;
import DTO.Pair;
import DTO.PhieuMuon;

public class PhieuTraDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField jtfMaPM;
	private JTextField jtfMaDG;
	private JTextField jtfSearchSach;
	private JTextField jtfMaNV;
	private JTextField jtfSoSachMuon;
	private JTextField jtfTen;

	/**
	 * Create the dialog.
	 */
	public PhieuTraDialog(JFrame owner, boolean check, String maNV, List<Pair<ChiTietPhieuMuon, String>> listItem,
			PhieuMuon pm) {
		super(owner, check);
		setBounds(100, 100, 1084, 803);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE));
		JPanel jpnThongTIn = new JPanel();
		jpnThongTIn.setBounds(0, 0, 283, 454);
		jpnThongTIn.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		JPanel jpnSachDcChon = new JPanel();
		jpnSachDcChon.setBounds(289, 0, 781, 418);
		jpnSachDcChon.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		JPanel jpnTheLoai = new JPanel();
		jpnTheLoai.setBounds(289, 428, 781, 337);
		jpnTheLoai.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		JButton jbtnThem = new JButton("<<");
		jbtnThem.setBounds(102, 596, 181, 53);
		jbtnThem.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		jbtnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		jbtnThem.setIcon(new ImageIcon(PhieuMuonDialog.class.getResource("/image/CRUD/Add_black_24dp.png")));
		JButton jbtnBo = new JButton(">>");
		jbtnBo.setBounds(102, 667, 181, 57);
		jbtnBo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		jbtnBo.setIcon(new ImageIcon(PhieuMuonDialog.class.getResource("/image/CRUD/Remove_black_24dp.png")));
		jbtnBo.setFont(new Font("Tahoma", Font.BOLD, 20));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(104, 464, 179, 122);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JLabel lblSSchMn = new JLabel("Số Sách Trả:");
		lblSSchMn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSSchMn.setHorizontalAlignment(SwingConstants.CENTER);

		jtfSoSachMuon = new JTextField();
		jtfSoSachMuon.setHorizontalAlignment(SwingConstants.CENTER);
		jtfSoSachMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfSoSachMuon.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(jtfSoSachMuon, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155,
										Short.MAX_VALUE)
								.addComponent(lblSSchMn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel_1
				.setVerticalGroup(
						gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblSSchMn)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jtfSoSachMuon,
												GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(41, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JLabel lblTheLoai = new JLabel("SÁCH MƯỢN");
		lblTheLoai.setOpaque(true);
		lblTheLoai.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheLoai.setForeground(Color.WHITE);
		lblTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTheLoai.setBackground(new Color(0, 204, 255));

		JPanel jpnViewSachMuon = new JPanel();

		jtfSearchSach = new JTextField();
		jtfSearchSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfSearchSach.setColumns(10);
		GroupLayout gl_jpnTheLoai = new GroupLayout(jpnTheLoai);
		gl_jpnTheLoai.setHorizontalGroup(gl_jpnTheLoai.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnTheLoai.createSequentialGroup().addGap(5)
						.addComponent(jtfSearchSach, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE).addContainerGap())
				.addComponent(jpnViewSachMuon, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
				.addComponent(lblTheLoai, GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE));
		gl_jpnTheLoai.setVerticalGroup(gl_jpnTheLoai.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnTheLoai.createSequentialGroup()
						.addComponent(lblTheLoai, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(5)
						.addComponent(jtfSearchSach, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnViewSachMuon, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)));
		jpnTheLoai.setLayout(gl_jpnTheLoai);

		JLabel lblSachMuon = new JLabel("SÁCH MUỐN TRẢ");
		lblSachMuon.setOpaque(true);
		lblSachMuon.setHorizontalAlignment(SwingConstants.CENTER);
		lblSachMuon.setForeground(Color.WHITE);
		lblSachMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSachMuon.setBackground(new Color(0, 204, 255));

		JPanel jpnViewSachTra = new JPanel();
		GroupLayout gl_jpnSachDcChon = new GroupLayout(jpnSachDcChon);
		gl_jpnSachDcChon.setHorizontalGroup(gl_jpnSachDcChon.createParallelGroup(Alignment.LEADING)
				.addComponent(jpnViewSachTra, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
				.addComponent(lblSachMuon, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE));
		gl_jpnSachDcChon.setVerticalGroup(gl_jpnSachDcChon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnSachDcChon.createSequentialGroup()
						.addComponent(lblSachMuon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnViewSachTra, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_jpnViewSachTra = new GroupLayout(jpnViewSachTra);
		gl_jpnViewSachTra.setHorizontalGroup(gl_jpnViewSachTra.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE));
		gl_jpnViewSachTra.setVerticalGroup(gl_jpnViewSachTra.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnViewSachTra.createSequentialGroup().addGap(2).addComponent(scrollPane,
						GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)));

		JList<String> jlSachMuonTra = new JList<String>();
		jlSachMuonTra.setFont(new Font("Tahoma", Font.PLAIN, 22));
		scrollPane.setViewportView(jlSachMuonTra);
		jpnViewSachTra.setLayout(gl_jpnViewSachTra);
		jpnSachDcChon.setLayout(gl_jpnSachDcChon);

		JLabel lblTtPhieuMuon = new JLabel("TT PHIẾU MƯỢN");
		lblTtPhieuMuon.setOpaque(true);
		lblTtPhieuMuon.setBackground(new Color(0, 204, 255));
		lblTtPhieuMuon.setForeground(Color.WHITE);
		lblTtPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTtPhieuMuon.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel jpnViewPM = new JPanel();
		GroupLayout gl_jpnThongTIn = new GroupLayout(jpnThongTIn);
		gl_jpnThongTIn.setHorizontalGroup(gl_jpnThongTIn.createParallelGroup(Alignment.LEADING)
				.addComponent(jpnViewPM, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
				.addComponent(lblTtPhieuMuon, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE));
		gl_jpnThongTIn.setVerticalGroup(gl_jpnThongTIn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnThongTIn.createSequentialGroup()
						.addComponent(lblTtPhieuMuon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnViewPM, GroupLayout.PREFERRED_SIZE, 368, Short.MAX_VALUE)));

		JLabel lblMPm = new JLabel("Mã PM:");
		lblMPm.setBounds(17, 14, 62, 17);
		lblMPm.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblMg = new JLabel("Mã ĐG:");
		lblMg.setBounds(17, 51, 62, 17);
		lblMg.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNgyMn = new JLabel("Ngày Mượn:");
		lblNgyMn.setBounds(17, 151, 78, 17);
		lblNgyMn.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtfMaPM = new JTextField();
		jtfMaPM.setBounds(123, 12, 146, 22);
		jtfMaPM.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jtfMaPM.setColumns(10);
		jtfMaPM.setEditable(false);

		jtfMaDG = new JTextField();
		jtfMaDG.setBounds(123, 49, 146, 22);
		jtfMaDG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jtfMaDG.setColumns(10);

		JDateChooser jdcNgayMuon = new JDateChooser();
		jdcNgayMuon.setBounds(123, 149, 146, 19);
		jdcNgayMuon.setFont(new Font("tahoma", Font.BOLD, 13));
		jdcNgayMuon.setDateFormatString("dd/MM/yyyy");

		JButton jbtnCapNhat = new JButton("Cập nhật");
		jbtnCapNhat.setBounds(49, 347, 105, 51);
		jbtnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNgyTr = new JLabel("Ngày Phải Trả:");
		lblNgyTr.setBounds(17, 180, 94, 17);
		lblNgyTr.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JDateChooser jdcNgayPhaiTra = new JDateChooser();
		jdcNgayPhaiTra.setBounds(123, 178, 146, 19);
		jdcNgayPhaiTra.setFont(new Font("tahoma", Font.BOLD, 13));
		jdcNgayPhaiTra.setDateFormatString("dd/MM/yyyy");
		jdcNgayPhaiTra.setEnabled(false);
		jpnThongTIn.setLayout(gl_jpnThongTIn);
		contentPanel.setLayout(gl_contentPanel);
		panel.setLayout(null);

		JLabel lblMNv = new JLabel("Mã NV:");
		lblMNv.setBounds(17, 115, 62, 17);
		lblMNv.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtfMaNV = new JTextField();
		jtfMaNV.setBounds(123, 113, 146, 22);
		jtfMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jtfMaNV.setColumns(10);

		JLabel jlbMsg = new JLabel("");
		jlbMsg.setBounds(17, 236, 252, 0);
		jlbMsg.setForeground(new Color(255, 0, 0));
		jlbMsg.setFont(new Font("Tahoma", Font.ITALIC, 14));

		JLabel lblTng = new JLabel("Tên ĐG:");
		lblTng.setBounds(17, 83, 62, 17);
		lblTng.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtfTen = new JTextField();
		jtfTen.setBounds(123, 81, 146, 22);
		jtfTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jtfTen.setColumns(10);

		JLabel lblNgyMn_1 = new JLabel("Ngày Trả:");
		lblNgyMn_1.setBounds(17, 209, 78, 17);
		lblNgyMn_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JDateChooser jdcNgayTra = new JDateChooser();
		jdcNgayTra.setBounds(123, 207, 146, 19);
		jdcNgayTra.setFont(new Font("tahoma", Font.BOLD, 14));
		jdcNgayTra.setDateFormatString("dd/MM/yyyy");

		JLabel lblTnhTrngTr = new JLabel("Tình Trạng Trả:");
		lblTnhTrngTr.setBounds(17, 242, 100, 17);
		lblTnhTrngTr.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jpnViewPM.setLayout(null);
		jpnViewPM.add(lblNgyTr);
		jpnViewPM.add(jdcNgayPhaiTra);
		jpnViewPM.add(lblNgyMn);
		jpnViewPM.add(lblMNv);
		jpnViewPM.add(jdcNgayMuon);
		jpnViewPM.add(jtfMaNV);
		jpnViewPM.add(lblNgyMn_1);
		jpnViewPM.add(jdcNgayTra);
		jpnViewPM.add(lblMg);
		jpnViewPM.add(lblMPm);
		jpnViewPM.add(jtfMaPM);
		jpnViewPM.add(jtfMaDG);
		jpnViewPM.add(lblTng);
		jpnViewPM.add(jtfTen);
		jpnViewPM.add(jbtnCapNhat);
		jpnViewPM.add(lblTnhTrngTr);
		jpnViewPM.add(jlbMsg);

		JButton jbtnPhat = new JButton("Phạt");
		jbtnPhat.setFont(new Font("Tahoma", Font.BOLD, 16));
		jbtnPhat.setBounds(164, 347, 105, 51);
		jpnViewPM.add(jbtnPhat);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(123, 242, 146, 95);
		jpnViewPM.add(scrollPane_1);

		JList<String> jlTinhTrangTra = new JList<String>();
		jlTinhTrangTra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlTinhTrangTra.setSelectedIndex(0);
		scrollPane_1.setViewportView(jlTinhTrangTra);
		panel.add(jpnThongTIn);
		panel.add(jpnSachDcChon);
		panel.add(jbtnThem);
		panel.add(panel_1);
		panel.add(jbtnBo);
		panel.add(jpnTheLoai);

		PhieuTraController control = new PhieuTraController(jbtnThem, jbtnBo, jbtnCapNhat, jtfSoSachMuon, jtfMaPM,
				jtfMaDG, jtfTen, jtfMaNV, jtfSearchSach, jdcNgayMuon, jdcNgayPhaiTra, jdcNgayTra, jlSachMuonTra,
				jpnViewSachMuon, listItem, pm, maNV, jlbMsg, jlTinhTrangTra, jbtnPhat, this);
		control.setView();
		control.setEvent();
	}
}
