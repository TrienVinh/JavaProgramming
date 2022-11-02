package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

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
import javax.swing.border.MatteBorder;

import BUS.TaiKhoanController;

public class DangNhapDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField jtfTenDangNhap;
	private JPasswordField jtfMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DangNhapDialog dialog = new DangNhapDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DangNhapDialog() {
		setBounds(100, 100, 798, 515);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel jpnRoot = new JPanel();
		jpnRoot.setBackground(new Color(51, 51, 51));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(jpnRoot,
				GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(jpnRoot,
				GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE));

		JLabel lblNewLabel = new JLabel("HE THONG QUAN LY THU VIEN SACH");
		lblNewLabel.setBounds(10, 10, 754, 40);
		lblNewLabel.setBackground(new Color(51, 51, 51));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel jpnNhanVien = new JPanel();
		jpnNhanVien.setBounds(0, 60, 774, 276);
		jpnNhanVien.setBackground(new Color(51, 51, 51));

		JPanel jpnDocGia = new JPanel();
		jpnDocGia.setBackground(new Color(51, 51, 51));
		jpnDocGia.setBounds(0, 346, 774, 120);

		JLabel lblDnhChoNhn = new JLabel("Dành cho Nhân viên");
		lblDnhChoNhn.setForeground(new Color(255, 255, 204));
		lblDnhChoNhn.setFont(new Font("Tahoma", Font.ITALIC, 16));

		JSeparator separator = new JSeparator();
		jpnRoot.setLayout(null);
		jpnRoot.add(lblNewLabel);
		jpnRoot.add(jpnNhanVien);

		JLabel lblTnngNhp = new JLabel("Tên Đăng Nhập :");
		lblTnngNhp.setIcon(
				new ImageIcon(DangNhapDialog.class.getResource("/image/dangNhap/DangNhapUser_white_18dp.png")));
		lblTnngNhp.setForeground(new Color(255, 255, 204));
		lblTnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JLabel lblMtKhu = new JLabel("Mật Khẩu :");
		lblMtKhu.setIcon(
				new ImageIcon(DangNhapDialog.class.getResource("/image/dangNhap/DangNhapPass_white_18dp.png")));
		lblMtKhu.setForeground(new Color(255, 255, 204));
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 22));

		jtfTenDangNhap = new JTextField();
		jtfTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfTenDangNhap.setColumns(10);

		JButton jbtnDangNhap = new JButton("Đăng Nhập");
		jbtnDangNhap
				.setIcon(new ImageIcon(DangNhapDialog.class.getResource("/image/dangNhap/DangNhap_white_18dp.png")));
		jbtnDangNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnDangNhap.setBackground(new Color(51, 102, 0));
		jbtnDangNhap.setBorder(null);
		jbtnDangNhap.setForeground(new Color(255, 255, 204));
		jbtnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton jbtnThoat = new JButton("Thoát");
		jbtnThoat.setIcon(new ImageIcon(DangNhapDialog.class.getResource("/image/dangNhap/iconExit_white_18dp.png")));
		jbtnThoat.setForeground(new Color(255, 255, 204));
		jbtnThoat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jbtnThoat.setBorder(null);
		jbtnThoat.setBackground(new Color(51, 102, 0));

		JLabel jlbMsg = new JLabel("Hãy nhập đầy đủ thông tin!");
		jlbMsg.setForeground(new Color(255, 51, 51));
		jlbMsg.setFont(new Font("Tahoma", Font.ITALIC, 16));

		JLabel jlbShow = new JLabel("");
		jlbShow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlbShow.setToolTipText("Hiện Thị Mật Khẩu");
		jlbShow.setIcon(new ImageIcon(DangNhapDialog.class.getResource("/image/dangNhap/showPass_white_18dp.png")));
		;

		jtfMatKhau = new JPasswordField();
		jtfMatKhau.setEchoChar('*');
		jtfMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel jlbQuenMatKhau = new JLabel("Quên mật khẩu?");
		jlbQuenMatKhau.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		jlbQuenMatKhau.setForeground(new Color(0, 102, 255));
		jlbQuenMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_jpnNhanVien = new GroupLayout(jpnNhanVien);
		gl_jpnNhanVien.setHorizontalGroup(gl_jpnNhanVien.createParallelGroup(Alignment.TRAILING).addGroup(gl_jpnNhanVien
				.createSequentialGroup()
				.addGroup(gl_jpnNhanVien.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpnNhanVien.createSequentialGroup().addGap(16).addComponent(lblDnhChoNhn)
								.addGap(10).addComponent(separator, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
						.addGroup(gl_jpnNhanVien.createSequentialGroup().addGap(110)
								.addGroup(gl_jpnNhanVien.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblMtKhu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblTnngNhp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addGap(18)
								.addGroup(gl_jpnNhanVien.createParallelGroup(Alignment.LEADING)
										.addComponent(jtfTenDangNhap, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
										.addComponent(jtfMatKhau, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
										.addGroup(gl_jpnNhanVien.createSequentialGroup()
												.addComponent(jbtnDangNhap, GroupLayout.PREFERRED_SIZE, 160,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(jbtnThoat, GroupLayout.PREFERRED_SIZE, 160,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(jlbMsg, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(jlbShow, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE).addGap(52))
				.addGroup(gl_jpnNhanVien.createSequentialGroup().addContainerGap(440, Short.MAX_VALUE)
						.addComponent(jlbQuenMatKhau).addGap(229)));
		gl_jpnNhanVien.setVerticalGroup(gl_jpnNhanVien.createParallelGroup(Alignment.LEADING).addGroup(gl_jpnNhanVien
				.createSequentialGroup()
				.addGroup(gl_jpnNhanVien.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpnNhanVien.createSequentialGroup().addGap(10).addComponent(lblDnhChoNhn))
						.addGroup(gl_jpnNhanVien.createSequentialGroup().addGap(18).addComponent(separator,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(gl_jpnNhanVien
						.createParallelGroup(Alignment.BASELINE).addComponent(lblTnngNhp).addComponent(jtfTenDangNhap,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(23)
				.addGroup(gl_jpnNhanVien.createParallelGroup(Alignment.BASELINE).addComponent(lblMtKhu)
						.addComponent(jlbShow).addComponent(jtfMatKhau, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jlbMsg).addGap(18)
				.addGroup(gl_jpnNhanVien.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbtnDangNhap, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbtnThoat, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addGap(17).addComponent(jlbQuenMatKhau).addContainerGap()));
		jpnNhanVien.setLayout(gl_jpnNhanVien);
		jpnRoot.add(jpnDocGia);

		JLabel lblDnhChoc = new JLabel("Dành cho Độc giả");
		lblDnhChoc.setForeground(new Color(255, 255, 204));
		lblDnhChoc.setFont(new Font("Tahoma", Font.ITALIC, 16));

		JSeparator separator_1 = new JSeparator();

		JButton jbtnTimKiem = new JButton("Tìm Kiếm");
		jbtnTimKiem
				.setIcon(new ImageIcon(DangNhapDialog.class.getResource("/image/dangNhap/iconSearch_white_18dp.png")));
		jbtnTimKiem.setForeground(new Color(255, 255, 204));
		jbtnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jbtnTimKiem.setBorder(null);
		jbtnTimKiem.setBackground(new Color(51, 102, 0));
		GroupLayout gl_jpnDocGia = new GroupLayout(jpnDocGia);
		gl_jpnDocGia.setHorizontalGroup(gl_jpnDocGia.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jpnDocGia.createSequentialGroup().addGap(10)
						.addComponent(lblDnhChoc, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
						.addGap(108, 108, Short.MAX_VALUE))
				.addGroup(gl_jpnDocGia.createSequentialGroup().addContainerGap(337, Short.MAX_VALUE)
						.addComponent(jbtnTimKiem, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addGap(277)));
		gl_jpnDocGia.setVerticalGroup(gl_jpnDocGia.createParallelGroup(Alignment.LEADING).addGroup(gl_jpnDocGia
				.createSequentialGroup()
				.addGroup(gl_jpnDocGia.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpnDocGia.createSequentialGroup().addGap(10).addComponent(lblDnhChoc))
						.addGroup(gl_jpnDocGia.createSequentialGroup().addGap(22).addComponent(separator_1,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(22).addComponent(jbtnTimKiem, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(53, Short.MAX_VALUE)));
		jpnDocGia.setLayout(gl_jpnDocGia);
		contentPanel.setLayout(gl_contentPanel);
		TaiKhoanController control = new TaiKhoanController(jtfTenDangNhap, jtfMatKhau, this, jbtnDangNhap, jbtnThoat,
				jbtnTimKiem, jlbMsg, jlbShow, jlbQuenMatKhau);
		control.setEvent();
	}
}
