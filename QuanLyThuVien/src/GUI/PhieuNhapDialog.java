package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

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

import BUS.PhieuNhapDialogController;

import javax.swing.JComboBox;

public class PhieuNhapDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField jtfMaPN;
	private JTextField jtfSearchTL;
	private JTextField tfSearchSach;
	private JTextField jtfMaNV;
	private JTextField jtfSoSachMuon;

	/**
	 * Create the dialog.
	 */

	public PhieuNhapDialog(JFrame owner, boolean modal, String maNV) {
		super(owner, modal);
		setBounds(100, 100, 1084, 768);
		setLocationRelativeTo(null);
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
		jpnThongTIn.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		JPanel jpnSachDcChon = new JPanel();
		jpnSachDcChon.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		JPanel jpnTheLoai = new JPanel();
		jpnTheLoai.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		JPanel jpnSach = new JPanel();
		jpnSach.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		JButton jbtnThem = new JButton(">>");
		jbtnThem.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		jbtnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		jbtnThem.setIcon(new ImageIcon(PhieuTraDialog.class.getResource("/image/CRUD/Add_black_24dp.png")));
		JButton jbtnBo = new JButton("<<");
		jbtnBo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		jbtnBo.setIcon(new ImageIcon(PhieuTraDialog.class.getResource("/image/CRUD/Remove_black_24dp.png")));
		jbtnBo.setFont(new Font("Tahoma", Font.BOLD, 20));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(jpnThongTIn, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
						.addComponent(jpnTheLoai, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(jbtnThem, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jbtnBo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 175,
										Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnSachDcChon, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
						.addComponent(jpnSach, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(jpnSachDcChon, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup().addGap(80).addComponent(jbtnThem).addGap(18)
								.addComponent(jbtnBo, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
						.addComponent(jpnThongTIn, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(jpnSach, 0, 0, Short.MAX_VALUE)
								.addComponent(jpnTheLoai, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))));

		JLabel lblSSchMn = new JLabel("Số Sách Nhập:");
		lblSSchMn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSSchMn.setHorizontalAlignment(SwingConstants.CENTER);

		jtfSoSachMuon = new JTextField();
		jtfSoSachMuon.setHorizontalAlignment(SwingConstants.CENTER);
		jtfSoSachMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfSoSachMuon.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(jtfSoSachMuon, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(lblSSchMn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
				.addContainerGap()));
		gl_panel_1
				.setVerticalGroup(
						gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblSSchMn)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jtfSoSachMuon,
												GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(43, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JLabel lblSach = new JLabel("SÁCH");
		lblSach.setOpaque(true);
		lblSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblSach.setForeground(Color.WHITE);
		lblSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSach.setBackground(new Color(0, 204, 255));

		JPanel jpnViewSach = new JPanel();

		tfSearchSach = new JTextField();
		tfSearchSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfSearchSach.setColumns(10);

		JButton jbtnThemSach = new JButton("Thêm Sách");
		jbtnThemSach.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		jbtnThemSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_jpnSach = new GroupLayout(jpnSach);
		gl_jpnSach.setHorizontalGroup(gl_jpnSach.createParallelGroup(Alignment.LEADING)
				.addComponent(lblSach, GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
				.addComponent(jpnViewSach, GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE).addGroup(Alignment.TRAILING,
						gl_jpnSach.createSequentialGroup().addGap(5)
								.addComponent(tfSearchSach, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE).addGap(18)
								.addComponent(jbtnThemSach, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_jpnSach.setVerticalGroup(gl_jpnSach.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnSach.createSequentialGroup()
						.addComponent(lblSach, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_jpnSach.createParallelGroup(Alignment.LEADING).addComponent(tfSearchSach)
								.addComponent(jbtnThemSach, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnViewSach, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE).addGap(0)));
		jpnSach.setLayout(gl_jpnSach);

		JLabel lblTheLoai = new JLabel("THỂ LOẠI");
		lblTheLoai.setOpaque(true);
		lblTheLoai.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheLoai.setForeground(Color.WHITE);
		lblTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTheLoai.setBackground(new Color(0, 204, 255));

		JPanel jpnViewTheLoai = new JPanel();

		jtfSearchTL = new JTextField();
		jtfSearchTL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfSearchTL.setColumns(10);
		GroupLayout gl_jpnTheLoai = new GroupLayout(jpnTheLoai);
		gl_jpnTheLoai.setHorizontalGroup(gl_jpnTheLoai.createParallelGroup(Alignment.LEADING)
				.addComponent(jpnViewTheLoai, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
				.addGroup(gl_jpnTheLoai.createSequentialGroup().addGap(5)
						.addComponent(jtfSearchTL, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE).addContainerGap())
				.addComponent(lblTheLoai, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE));
		gl_jpnTheLoai.setVerticalGroup(gl_jpnTheLoai.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnTheLoai.createSequentialGroup()
						.addComponent(lblTheLoai, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(5)
						.addComponent(jtfSearchTL, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnViewTheLoai, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)));
		jpnTheLoai.setLayout(gl_jpnTheLoai);

		JLabel lblSachMuon = new JLabel("SÁCH NHẬP");
		lblSachMuon.setOpaque(true);
		lblSachMuon.setHorizontalAlignment(SwingConstants.CENTER);
		lblSachMuon.setForeground(Color.WHITE);
		lblSachMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSachMuon.setBackground(new Color(0, 204, 255));

		JPanel jpnViewSachMuon = new JPanel();
		GroupLayout gl_jpnSachDcChon = new GroupLayout(jpnSachDcChon);
		gl_jpnSachDcChon.setHorizontalGroup(gl_jpnSachDcChon.createParallelGroup(Alignment.LEADING)
				.addComponent(jpnViewSachMuon, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
				.addComponent(lblSachMuon, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE));
		gl_jpnSachDcChon.setVerticalGroup(gl_jpnSachDcChon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnSachDcChon.createSequentialGroup()
						.addComponent(lblSachMuon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnViewSachMuon, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_jpnViewSachMuon = new GroupLayout(jpnViewSachMuon);
		gl_jpnViewSachMuon.setHorizontalGroup(gl_jpnViewSachMuon.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE));
		gl_jpnViewSachMuon.setVerticalGroup(gl_jpnViewSachMuon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnViewSachMuon.createSequentialGroup().addGap(2).addComponent(scrollPane,
						GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)));

		JList<String> jlSachMuon = new JList<String>();
		jlSachMuon.setFont(new Font("Tahoma", Font.PLAIN, 22));
		scrollPane.setViewportView(jlSachMuon);
		jpnViewSachMuon.setLayout(gl_jpnViewSachMuon);
		jpnSachDcChon.setLayout(gl_jpnSachDcChon);

		JLabel lblTtPhieuMuon = new JLabel("TT PHIẾU NHẬP");
		lblTtPhieuMuon.setOpaque(true);
		lblTtPhieuMuon.setBackground(new Color(0, 204, 255));
		lblTtPhieuMuon.setForeground(Color.WHITE);
		lblTtPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTtPhieuMuon.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel jpnViewPM = new JPanel();
		GroupLayout gl_jpnThongTIn = new GroupLayout(jpnThongTIn);
		gl_jpnThongTIn.setHorizontalGroup(gl_jpnThongTIn.createParallelGroup(Alignment.LEADING)
				.addComponent(jpnViewPM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(lblTtPhieuMuon, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE));
		gl_jpnThongTIn.setVerticalGroup(gl_jpnThongTIn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnThongTIn.createSequentialGroup()
						.addComponent(lblTtPhieuMuon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnViewPM, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)));

		JLabel lblMPm = new JLabel("Mã PN:");
		lblMPm.setBounds(10, 12, 62, 17);
		lblMPm.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblTng = new JLabel("Mã NCC :");
		lblTng.setBounds(10, 41, 62, 17);
		lblTng.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNgyMn = new JLabel("Ngày Nhập:");
		lblNgyMn.setBounds(10, 103, 78, 17);
		lblNgyMn.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtfMaPN = new JTextField();
		jtfMaPN.setBounds(92, 10, 156, 22);
		jtfMaPN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jtfMaPN.setColumns(10);
		jtfMaPN.setEditable(false);

		JDateChooser jdcNgayNhap = new JDateChooser();
		jdcNgayNhap.setBounds(92, 101, 156, 19);
		jdcNgayNhap.setFont(new Font("tahoma", Font.BOLD, 13));
		jdcNgayNhap.setDateFormatString("dd/MM/yyyy");

		JButton jbtnLapPhieu = new JButton("Lập Phiếu Nhập");
		jbtnLapPhieu.setBounds(85, 166, 163, 51);
		jbtnLapPhieu.setFont(new Font("Tahoma", Font.BOLD, 16));
		jpnThongTIn.setLayout(gl_jpnThongTIn);
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);

		JLabel lblMNv = new JLabel("Mã NV:");
		lblMNv.setBounds(10, 70, 62, 17);
		lblMNv.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtfMaNV = new JTextField();
		jtfMaNV.setBounds(92, 72, 156, 22);
		jtfMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jtfMaNV.setColumns(10);

		JLabel jlbMsg = new JLabel("");
		jlbMsg.setBounds(10, 130, 238, 0);
		jlbMsg.setForeground(new Color(255, 0, 0));
		jlbMsg.setFont(new Font("Tahoma", Font.ITALIC, 14));
		jpnViewPM.setLayout(null);
		jpnViewPM.add(lblMPm);
		jpnViewPM.add(jtfMaPN);
		jpnViewPM.add(lblTng);
		jpnViewPM.add(lblMNv);
		jpnViewPM.add(jtfMaNV);
		jpnViewPM.add(lblNgyMn);
		jpnViewPM.add(jdcNgayNhap);
		jpnViewPM.add(jbtnLapPhieu);
		jpnViewPM.add(jlbMsg);

		JComboBox<String> jcbMaNCC = new JComboBox<String>();
		jcbMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jcbMaNCC.setBounds(92, 42, 156, 21);
		jpnViewPM.add(jcbMaNCC);

		PhieuNhapDialogController control = new PhieuNhapDialogController(jtfSoSachMuon, tfSearchSach, jtfSearchTL,
				jtfMaPN, jtfMaNV, jcbMaNCC, jdcNgayNhap, jlSachMuon, jpnViewTheLoai, jpnViewSach, jbtnThem, jbtnBo,
				jbtnThemSach, jbtnLapPhieu, jlbMsg, maNV, owner, this);
		control.setView();
		control.setEvent();
	}
}
