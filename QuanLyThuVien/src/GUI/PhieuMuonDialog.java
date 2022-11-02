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

import BUS.PhieuMuonDialogController;

public class PhieuMuonDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField jtfMaPM;
	private JTextField jtfCMND;
	private JTextField jtfTenDG;
	private JTextField jtfSearchTL;
	private JTextField tfSearchSach;
	private JTextField jtfMaNV;
	private JTextField jtfSoSachMuon;

	/**
	 * Create the dialog.
	 */

	public PhieuMuonDialog(JFrame owner, boolean modal, String maNV) {
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

		JLabel lblSSchMn = new JLabel("Số Sách Mượn:");
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

		JLabel lblSach = new JLabel("SACH");
		lblSach.setOpaque(true);
		lblSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblSach.setForeground(Color.WHITE);
		lblSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSach.setBackground(new Color(0, 204, 255));

		JPanel jpnViewSach = new JPanel();

		tfSearchSach = new JTextField();
		tfSearchSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfSearchSach.setColumns(10);
		GroupLayout gl_jpnSach = new GroupLayout(jpnSach);
		gl_jpnSach.setHorizontalGroup(gl_jpnSach.createParallelGroup(Alignment.LEADING)
				.addComponent(lblSach, GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
				.addGroup(gl_jpnSach.createSequentialGroup().addGap(5)
						.addComponent(tfSearchSach, GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE).addContainerGap())
				.addComponent(jpnViewSach, GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE));
		gl_jpnSach.setVerticalGroup(gl_jpnSach.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnSach.createSequentialGroup()
						.addComponent(lblSach, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tfSearchSach, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnViewSach, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE).addGap(0)));
		jpnSach.setLayout(gl_jpnSach);

		JLabel lblTheLoai = new JLabel("THE LOAI");
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
				.addComponent(lblTheLoai, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_jpnTheLoai.createSequentialGroup().addGap(5)
						.addComponent(jtfSearchTL, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE).addContainerGap())
				.addComponent(jpnViewTheLoai, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE));
		gl_jpnTheLoai.setVerticalGroup(gl_jpnTheLoai.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnTheLoai.createSequentialGroup()
						.addComponent(lblTheLoai, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(5)
						.addComponent(jtfSearchTL, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnViewTheLoai, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)));
		jpnTheLoai.setLayout(gl_jpnTheLoai);

		JLabel lblSachMuon = new JLabel("SACH MUON");
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

		JLabel lblTtPhieuMuon = new JLabel("TT PHIEU MUON");
		lblTtPhieuMuon.setOpaque(true);
		lblTtPhieuMuon.setBackground(new Color(0, 204, 255));
		lblTtPhieuMuon.setForeground(Color.WHITE);
		lblTtPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTtPhieuMuon.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel jpnViewPM = new JPanel();
		GroupLayout gl_jpnThongTIn = new GroupLayout(jpnThongTIn);
		gl_jpnThongTIn.setHorizontalGroup(gl_jpnThongTIn.createParallelGroup(Alignment.LEADING)
				.addComponent(lblTtPhieuMuon, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
				.addComponent(jpnViewPM, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE));
		gl_jpnThongTIn.setVerticalGroup(gl_jpnThongTIn.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnThongTIn.createSequentialGroup()
						.addComponent(lblTtPhieuMuon, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnViewPM, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)));

		JLabel lblMPm = new JLabel("Mã PM:");
		lblMPm.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblMg = new JLabel("CMND:");
		lblMg.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblTng = new JLabel("Tên ĐG :");
		lblTng.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNgyMn = new JLabel("Ngày Mượn:");
		lblNgyMn.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtfMaPM = new JTextField();
		jtfMaPM.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jtfMaPM.setColumns(10);
		jtfMaPM.setEditable(false);

		jtfCMND = new JTextField();
		jtfCMND.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jtfCMND.setColumns(10);

		jtfTenDG = new JTextField();
		jtfTenDG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jtfTenDG.setColumns(10);

		JDateChooser jdcNgayMuon = new JDateChooser();
		jdcNgayMuon.setFont(new Font("tahoma", Font.BOLD, 13));
		jdcNgayMuon.setDateFormatString("dd/MM/yyyy");

		JButton jbtnLapPhieu = new JButton("Lập Phiếu Mượn");
		jbtnLapPhieu.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNgyTr = new JLabel("Ngày Trả:");
		lblNgyTr.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JDateChooser jdcNgayTra = new JDateChooser();
		jdcNgayTra.setFont(new Font("tahoma", Font.BOLD, 13));
		jdcNgayTra.setDateFormatString("dd/MM/yyyy");
		jdcNgayTra.setEnabled(false);
		jpnThongTIn.setLayout(gl_jpnThongTIn);
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);

		JLabel lblMNv = new JLabel("Mã NV:");
		lblMNv.setFont(new Font("Tahoma", Font.PLAIN, 14));

		jtfMaNV = new JTextField();
		jtfMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jtfMaNV.setColumns(10);

		JLabel jlbMsg = new JLabel("");
		jlbMsg.setForeground(new Color(255, 0, 0));
		jlbMsg.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GroupLayout gl_jpnViewPM = new GroupLayout(jpnViewPM);
		gl_jpnViewPM.setHorizontalGroup(gl_jpnViewPM.createParallelGroup(Alignment.LEADING).addGroup(gl_jpnViewPM
				.createSequentialGroup()
				.addGroup(gl_jpnViewPM.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(10)
								.addComponent(lblMPm, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(jtfMaPM, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(10)
								.addComponent(lblMg, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(jtfCMND, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(10)
								.addComponent(lblTng, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(jtfTenDG, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(10)
								.addComponent(lblMNv, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(jtfMaNV, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(10).addComponent(lblNgyMn).addGap(4)
								.addComponent(jdcNgayMuon, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(10)
								.addComponent(lblNgyTr, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGap(4)
								.addComponent(jdcNgayTra, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(85).addComponent(jbtnLapPhieu))
						.addGroup(gl_jpnViewPM.createSequentialGroup().addContainerGap().addComponent(jlbMsg,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addContainerGap(31, Short.MAX_VALUE)));
		gl_jpnViewPM.setVerticalGroup(gl_jpnViewPM.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(10)
						.addGroup(gl_jpnViewPM.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(2).addComponent(lblMPm))
								.addComponent(jtfMaPM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_jpnViewPM.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(2).addComponent(lblMg))
								.addComponent(jtfCMND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_jpnViewPM.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(2).addComponent(lblTng))
								.addComponent(jtfTenDG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(7)
						.addGroup(gl_jpnViewPM.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(2).addComponent(lblMNv))
								.addComponent(jtfMaNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(11)
						.addGroup(gl_jpnViewPM.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(2).addComponent(lblNgyMn))
								.addComponent(jdcNgayMuon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_jpnViewPM.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpnViewPM.createSequentialGroup().addGap(2).addComponent(lblNgyTr))
								.addComponent(jdcNgayTra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jlbMsg).addGap(21)
						.addComponent(jbtnLapPhieu, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)));
		jpnViewPM.setLayout(gl_jpnViewPM);

		PhieuMuonDialogController control = new PhieuMuonDialogController(jpnViewTheLoai, jpnViewSach, jlSachMuon, jtfMaPM,
				jtfTenDG, jtfMaNV, jtfCMND, jtfSearchTL, tfSearchSach, jdcNgayMuon, jdcNgayTra, jbtnThem, jbtnBo,
				jbtnLapPhieu, jtfSoSachMuon, maNV, this, jlbMsg);
		control.setView();
		control.setEvent();
	}

}
