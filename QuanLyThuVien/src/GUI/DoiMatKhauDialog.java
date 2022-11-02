package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BUS.DoiMatKhauController;
import DTO.TaiKhoan;

public class DoiMatKhauDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField jtfDangNhap;
	private JPasswordField jpfMatKhau;
	private JPasswordField jpfMatKhauMoi;
	private JPasswordField jpfNhapLai;
	private JTextField jtfMaTaiKhoan;
	private TaiKhoan tk;

	public DoiMatKhauDialog(Frame owner, boolean modal, TaiKhoan tk) {
		super(owner, modal);
		// TODO Auto-generated constructor stub
		this.tk = tk;
		init(tk);
	}

	public void init(TaiKhoan tk) {
		setBounds(100, 100, 532, 559);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel jpnRoot = new JPanel();
		jpnRoot.setBackground(new Color(51, 51, 51));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING).addComponent(jpnRoot,
				Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING).addComponent(jpnRoot,
				Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE));

		JLabel lbliMtKhu = new JLabel("ĐỔI MẬT KHẨU");
		lbliMtKhu.setForeground(new Color(255, 255, 255));
		lbliMtKhu.setHorizontalAlignment(SwingConstants.CENTER);
		lbliMtKhu.setFont(new Font("Tahoma", Font.BOLD, 24));

		JSeparator separator = new JSeparator();

		JLabel lblTnngNhp = new JLabel("Tên Đăng Nhập :");
		lblTnngNhp.setForeground(new Color(255, 255, 204));
		lblTnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblMatKhu = new JLabel("Mật Khẩu : ");
		lblMatKhu.setForeground(new Color(255, 255, 204));
		lblMatKhu.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jtfDangNhap = new JTextField();
		jtfDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfDangNhap.setColumns(10);

		jpfMatKhau = new JPasswordField();
		jpfMatKhau.setEchoChar('*');
		jpfMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblMtKhuMi = new JLabel("Mật Khẩu Mới : ");
		lblMtKhuMi.setForeground(new Color(255, 255, 204));
		lblMtKhuMi.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jpfMatKhauMoi = new JPasswordField();
		jpfMatKhauMoi.setEchoChar('*');
		jpfMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblNhpLiMk = new JLabel("Nhập Lại MK : ");
		lblNhpLiMk.setForeground(new Color(255, 255, 204));
		lblNhpLiMk.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jpfNhapLai = new JPasswordField();
		jpfNhapLai.setEchoChar('*');
		jpfNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel jlbMatKhau = new JLabel("");
		jlbMatKhau.setFont(new Font("Tahoma", Font.ITALIC, 16));
		jlbMatKhau.setForeground(new Color(255, 51, 51));

		JLabel jlbNhapLai = new JLabel("");
		jlbNhapLai.setForeground(new Color(255, 51, 51));
		jlbNhapLai.setFont(new Font("Tahoma", Font.ITALIC, 16));

		JButton jbtnDoi = new JButton("Đổi Mật Khẩu");
		jbtnDoi.setBorder(null);
		jbtnDoi.setBackground(new Color(0, 102, 0));
		jbtnDoi.setIcon(
				new ImageIcon(DoiMatKhauDialog.class.getResource("/image/mainFrame/DoiMatKhau_white_24dp.png")));
		jbtnDoi.setForeground(new Color(255, 255, 255));
		jbtnDoi.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton jbtnThoat = new JButton("Thoát");
		jbtnThoat.setIcon(new ImageIcon(DoiMatKhauDialog.class.getResource("/image/dangNhap/iconExit_white_18dp.png")));
		jbtnThoat.setForeground(Color.WHITE);
		jbtnThoat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jbtnThoat.setBorder(null);
		jbtnThoat.setBackground(new Color(0, 102, 0));

		JLabel jlbShowPw = new JLabel("");
		jlbShowPw.setIcon(new ImageIcon(DoiMatKhauDialog.class.getResource("/image/dangNhap/showPass_white_18dp.png")));

		JLabel jlbShowNewPw = new JLabel("");
		jlbShowNewPw
				.setIcon(new ImageIcon(DoiMatKhauDialog.class.getResource("/image/dangNhap/showPass_white_18dp.png")));

		JLabel jlbShowNhapLai = new JLabel("");
		jlbShowNhapLai
				.setIcon(new ImageIcon(DoiMatKhauDialog.class.getResource("/image/dangNhap/showPass_white_18dp.png")));

		JLabel lblMTiKhon = new JLabel("Mã Tài Khoản :");
		lblMTiKhon.setForeground(new Color(255, 255, 204));
		lblMTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 20));

		jtfMaTaiKhoan = new JTextField();
		jtfMaTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfMaTaiKhoan.setColumns(10);
		GroupLayout gl_jpnRoot = new GroupLayout(jpnRoot);
		gl_jpnRoot.setHorizontalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnRoot.createSequentialGroup().addContainerGap()
						.addGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
								.addComponent(lbliMtKhu, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
								.addGroup(gl_jpnRoot.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
										.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10))
								.addGroup(gl_jpnRoot.createSequentialGroup().addGap(19).addGroup(gl_jpnRoot
										.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_jpnRoot.createSequentialGroup().addGap(27)
												.addComponent(jbtnDoi, GroupLayout.PREFERRED_SIZE, 180,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
												.addComponent(jbtnThoat, GroupLayout.PREFERRED_SIZE, 171,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_jpnRoot.createSequentialGroup()
												.addComponent(lblTnngNhp, GroupLayout.DEFAULT_SIZE, 167,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(jtfDangNhap,
														GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_jpnRoot.createSequentialGroup()
												.addGroup(gl_jpnRoot.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblNhpLiMk, GroupLayout.DEFAULT_SIZE, 153,
																Short.MAX_VALUE)
														.addComponent(lblMtKhuMi, GroupLayout.PREFERRED_SIZE, 153,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
														.addComponent(jpfNhapLai, GroupLayout.DEFAULT_SIZE, 248,
																Short.MAX_VALUE)
														.addComponent(jpfMatKhauMoi, GroupLayout.PREFERRED_SIZE, 248,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jlbNhapLai, GroupLayout.PREFERRED_SIZE, 250,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jlbMatKhau, GroupLayout.PREFERRED_SIZE, 248,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_jpnRoot.createSequentialGroup()
												.addComponent(lblMatKhu, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(jpfMatKhau,
														GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_jpnRoot.createSequentialGroup()
												.addComponent(lblMTiKhon, GroupLayout.PREFERRED_SIZE, 153,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
												.addComponent(jtfMaTaiKhoan, GroupLayout.PREFERRED_SIZE, 248,
														GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
												.addComponent(jlbShowNhapLai, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jlbShowNewPw, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jlbShowPw, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE))))
						.addContainerGap()));
		gl_jpnRoot.setVerticalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING).addGroup(gl_jpnRoot
				.createSequentialGroup().addContainerGap().addComponent(lbliMtKhu)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
				.addGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMTiKhon, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfMaTaiKhoan, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_jpnRoot.createParallelGroup(Alignment.BASELINE).addComponent(lblTnngNhp).addComponent(
						jtfDangNhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(15)
				.addGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING).addGroup(gl_jpnRoot.createSequentialGroup()
						.addGroup(gl_jpnRoot.createParallelGroup(Alignment.BASELINE).addComponent(lblMatKhu)
								.addComponent(jpfMatKhau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jlbMatKhau).addGap(9)
						.addGroup(gl_jpnRoot.createParallelGroup(Alignment.BASELINE)
								.addComponent(jpfMatKhauMoi, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMtKhuMi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_jpnRoot.createParallelGroup(Alignment.BASELINE)
								.addComponent(jpfNhapLai, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNhpLiMk, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(jlbNhapLai, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(38)
						.addGroup(gl_jpnRoot.createParallelGroup(Alignment.BASELINE)
								.addComponent(jbtnThoat, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(jbtnDoi, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_jpnRoot.createSequentialGroup().addComponent(jlbShowPw).addGap(10)
								.addComponent(jlbShowNewPw, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(jlbShowNhapLai, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(74)));
		jpnRoot.setLayout(gl_jpnRoot);
		contentPanel.setLayout(gl_contentPanel);

		DoiMatKhauController control = new DoiMatKhauController(jtfMaTaiKhoan, jtfDangNhap, jpfMatKhau, jpfMatKhauMoi,
				jpfNhapLai, jlbShowPw, jlbShowNewPw, jlbShowNhapLai, jlbMatKhau, jlbNhapLai, jbtnDoi, jbtnThoat, this);
		control.setView(tk);
		control.setEvent();
	}

	public void setViewQuenMk() {
		jpfMatKhau.setText(tk.getMat_Khau());
	}
}
