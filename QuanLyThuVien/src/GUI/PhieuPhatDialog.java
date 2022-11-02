package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;

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
import javax.swing.border.MatteBorder;

import BUS.PhieuPhatController;
import DTO.Pair;
import DTO.PhieuPhat;

public class PhieuPhatDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField jtfMaPM;
	private JTextField jtfTenDG;
	private JTextField jtfMaSach;
	private JTextField jtfTenSach;
	private JTextField jtfLyDo;
	private JTextField jtfTienPhat;
	private JButton jbtnPhat, jbtnThoat;

//	private

	/**
	 * Create the dialog.
	 * 
	 * @wbp.parser.constructor
	 */
	public PhieuPhatDialog(JDialog owner, boolean check, PhieuPhat pp, Pair<String, String> pair, Pair<Date, Date> date,
			Pair<Integer, Integer> sach) {
		super(owner, check);
		init(pp, pair);
		PhieuPhatController control = new PhieuPhatController(jtfMaPM, jtfMaSach, jtfTenDG, jtfTenSach, jtfLyDo,
				jtfTienPhat, jbtnPhat, jbtnThoat, this);
		control.setData(sach, date);
		control.setEditable(false);
		control.setView(pp, pair);
		control.setEvent();
	}

	public PhieuPhatDialog(JFrame owner, boolean modal, PhieuPhat pp, Pair<String, String> pair) {
		super(owner, modal);
		// TODO Auto-generated constructor stub
		init(pp, pair);
		PhieuPhatController control = new PhieuPhatController(jtfMaPM, jtfMaSach, jtfTenDG, jtfTenSach, jtfLyDo,
				jtfTienPhat, jbtnPhat, jbtnThoat, this);
		control.setView(pp, pair);
		control.setEditable(true);
		control.setEvent();
	}

	public void init(PhieuPhat pp, Pair<String, String> pair) {
		setBounds(100, 100, 1032, 720);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel jpnRoot = new JPanel();
		jpnRoot.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(jpnRoot,
				GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(jpnRoot,
				GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE));

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();
		GroupLayout gl_jpnRoot = new GroupLayout(jpnRoot);
		gl_jpnRoot.setHorizontalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE));
		gl_jpnRoot.setVerticalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnRoot.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)));

		JLabel lblThngTinPhiu = new JLabel("THÔNG TIN PHIẾU PHẠT");
		lblThngTinPhiu.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinPhiu.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JLabel lblMPm = new JLabel("Mã PM :");
		lblMPm.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblTng = new JLabel("Tên ĐG:");
		lblTng.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblMSch = new JLabel("Mã Sách:");
		lblMSch.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblTnSch = new JLabel("Tên Sách:");
		lblTnSch.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblLDoPht = new JLabel("Lý Do Phạt:");
		lblLDoPht.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblTinPht = new JLabel("Tiền Phạt :");
		lblTinPht.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jtfMaPM = new JTextField();
		jtfMaPM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfMaPM.setColumns(10);

		jtfTenDG = new JTextField();
		jtfTenDG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfTenDG.setColumns(10);

		jtfMaSach = new JTextField();
		jtfMaSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfMaSach.setColumns(10);

		jtfTenSach = new JTextField();
		jtfTenSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfTenSach.setColumns(10);

		jtfLyDo = new JTextField();
		jtfLyDo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfLyDo.setColumns(10);

		jtfTienPhat = new JTextField();
		jtfTienPhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfTienPhat.setColumns(10);

		jbtnPhat = new JButton("Phạt");
		jbtnPhat.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		jbtnPhat.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jbtnThoat = new JButton("Thoát");
		jbtnThoat.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		jbtnThoat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblThngTinPhiu, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(85)
								.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE).addGap(85))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(205).addGroup(gl_panel_1
								.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
										.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
												.createSequentialGroup()
												.addComponent(lblLDoPht, GroupLayout.PREFERRED_SIZE, 105,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(jtfLyDo, GroupLayout.PREFERRED_SIZE, 426,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1
												.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblMPm, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblTng, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblMSch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblTnSch, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
														105, GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addComponent(jtfMaPM, GroupLayout.PREFERRED_SIZE, 426,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jtfTenDG, GroupLayout.PREFERRED_SIZE, 426,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jtfMaSach, GroupLayout.PREFERRED_SIZE, 426,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jtfTenSach, GroupLayout.PREFERRED_SIZE, 426,
																GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(
												lblTinPht, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(jbtnPhat, GroupLayout.PREFERRED_SIZE, 138,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jbtnThoat, GroupLayout.PREFERRED_SIZE, 138,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(jtfTienPhat, GroupLayout.PREFERRED_SIZE, 426,
														GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(254, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addComponent(lblThngTinPhiu).addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(
						separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(48)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblMPm).addComponent(jtfMaPM,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTng, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfTenDG, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMSch, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfMaSach, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTnSch, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfTenSach, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblLDoPht, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfLyDo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTinPht, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfTienPhat, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addGap(56)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(jbtnPhat, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbtnThoat, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(109, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JLabel lblQuynhChu = new JLabel("QUY ĐỊNH CHỊU PHẠT");
		lblQuynhChu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblQuynhChu.setHorizontalAlignment(SwingConstants.CENTER);

		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JLabel lblMtSch = new JLabel("Hư Hại Sách");
		lblMtSch.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblMtSch.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblMtSch_1 = new JLabel("1/");
		lblMtSch_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblMtSch_1_1 = new JLabel(
				":   Phạt theo giá tiền của cuốn sách đã mượn  x  số lượng sách hư hại cùng loại.");
		lblMtSch_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblMtSch_1_2 = new JLabel("2/");
		lblMtSch_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblTrHan = new JLabel("Trễ Hạn");
		lblTrHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrHan.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));

		JLabel lblMtSch_1_1_1 = new JLabel(":   Phạt 1,000đ/1 cuốn/1 ngày.");
		lblMtSch_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblQuynhChu, GroupLayout.PREFERRED_SIZE, 1008, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel.createSequentialGroup().addGap(90)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE).addGap(90))
				.addGroup(gl_panel.createSequentialGroup().addGap(63).addComponent(lblMtSch_1).addGap(10)
						.addComponent(lblMtSch, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE).addGap(1)
						.addComponent(lblMtSch_1_1, GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE).addGap(62))
				.addGroup(gl_panel.createSequentialGroup().addGap(63).addComponent(lblMtSch_1_2).addGap(10)
						.addComponent(lblTrHan).addGap(50)
						.addComponent(lblMtSch_1_1_1, GroupLayout.PREFERRED_SIZE, 708, GroupLayout.PREFERRED_SIZE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addComponent(lblQuynhChu).addGap(18)
				.addComponent(
						separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(32)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMtSch_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup().addGap(1).addComponent(lblMtSch,
								GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblMtSch_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addGap(11)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMtSch_1_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup().addGap(1).addComponent(lblTrHan,
								GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblMtSch_1_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))));
		panel.setLayout(gl_panel);
		jpnRoot.setLayout(gl_jpnRoot);
		contentPanel.setLayout(gl_contentPanel);

	}

	public void setEnableForButtonPhat(boolean isEnable) {
		jbtnPhat.setEnabled(isEnable);
	}
}
