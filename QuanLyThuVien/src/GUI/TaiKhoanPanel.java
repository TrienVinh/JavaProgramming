package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import BUS.QuanLyTaiKhoanController;

public class TaiKhoanPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField jtfTenDangNhap;
	private JTextField jtfMaTaiKhoan;
	private JPasswordField jpfMatKhau;
	private JPasswordField jpfNhapLai;
	private JTextField jtfSearch;

	/**
	 * Create the panel.
	 */
	public TaiKhoanPanel() {

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		JPanel jpbInfo = new JPanel();
		jpbInfo.setBackground(new Color(51, 51, 51));

		JPanel jpnView = new JPanel();

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(panel, popupMenu);

		JMenuItem jmiLamMoi = new JMenuItem("Làm mới");
		popupMenu.add(jmiLamMoi);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(jpnView, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
				.addComponent(jpbInfo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(jpbInfo, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jpnView, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
		);

		JLabel lblThngTinTi = new JLabel("THÔNG TIN TÀI KHOẢN");
		lblThngTinTi.setForeground(new Color(255, 255, 255));
		lblThngTinTi.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblThngTinTi.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblTnngNhp = new JLabel("Mã Tài Khoản :");
		lblTnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnngNhp.setForeground(new Color(255, 255, 255));

		JLabel lblMtKhu = new JLabel("Tên Đăng Nhập :");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhu.setForeground(new Color(255, 255, 255));

		JLabel lblMtKhu_1 = new JLabel("Mật Khẩu :");
		lblMtKhu_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhu_1.setForeground(new Color(255, 255, 255));

		JLabel lblNhpLi = new JLabel("Nhập Lại :");
		lblNhpLi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhpLi.setForeground(new Color(255, 255, 255));

		JLabel lblMNhnVin = new JLabel("Mã Nhân Viên :");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMNhnVin.setForeground(new Color(255, 255, 255));

		jtfTenDangNhap = new JTextField();
		jtfTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfTenDangNhap.setColumns(10);

		jtfMaTaiKhoan = new JTextField();
		jtfMaTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfMaTaiKhoan.setColumns(10);

		jpfMatKhau = new JPasswordField();
		jpfMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jpfMatKhau.setEchoChar('*');

		jpfNhapLai = new JPasswordField();
		jpfNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jpfNhapLai.setEchoChar('*');

		JComboBox<String> jcbMaNhanVien = new JComboBox<String>();
		jcbMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(TaiKhoanPanel.class.getResource("/image/CRUD/Add_black_24dp.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(TaiKhoanPanel.class.getResource("/image/CRUD/edit2_black_24dp.png")));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnXoa = new JButton("Xoá");
		btnXoa.setIcon(new ImageIcon(TaiKhoanPanel.class.getResource("/image/CRUD/Remove_black_24dp.png")));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnInBaoCao = new JButton("In Báo cáo");
		btnInBaoCao.setIcon(new ImageIcon(TaiKhoanPanel.class.getResource("/image/CRUD/Printblack_24dp.png")));
		btnInBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblMtKhu_1_1 = new JLabel("Tình Trạng :");
		lblMtKhu_1_1.setForeground(Color.WHITE);
		lblMtKhu_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JCheckBox jcbTinhTrang = new JCheckBox("Kích Hoạt");
		jcbTinhTrang.setSelected(true);
		jcbTinhTrang.setForeground(new Color(255, 255, 255));
		jcbTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jcbTinhTrang.setBackground(new Color(51, 51, 51));

		jtfSearch = new JTextField();
		jtfSearch.setText("Nhập thông tin muốn tìm kiếm...");
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jtfSearch.setColumns(10);

		JLabel lblQuyn = new JLabel("Quyền :");
		lblQuyn.setForeground(Color.WHITE);
		lblQuyn.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JComboBox<String> jcobQuyen = new JComboBox<String>();
		jcobQuyen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jcobQuyen.setModel(new DefaultComboBoxModel<String>(new String[] { "Admin", "Nhan Vien" }));
		jcobQuyen.setSelectedIndex(0);

		JLabel jlbMsg = new JLabel("");
		jlbMsg.setForeground(new Color(255, 51, 0));
		jlbMsg.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GroupLayout gl_jpbInfo = new GroupLayout(jpbInfo);
		gl_jpbInfo.setHorizontalGroup(
			gl_jpbInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpbInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblThngTinTi, GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_jpbInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(297, Short.MAX_VALUE))
				.addGroup(gl_jpbInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
					.addGap(80)
					.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
					.addGap(80)
					.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
					.addGap(80)
					.addComponent(btnInBaoCao, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
					.addGap(37))
				.addGroup(gl_jpbInfo.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
						.addComponent(jlbMsg)
						.addGroup(gl_jpbInfo.createSequentialGroup()
							.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMtKhu)
								.addComponent(lblTnngNhp)
								.addComponent(lblMtKhu_1)
								.addComponent(lblMtKhu_1_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpbInfo.createSequentialGroup()
									.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING, false)
										.addComponent(jpfMatKhau, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
										.addComponent(jtfMaTaiKhoan, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
										.addComponent(jtfTenDangNhap, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
									.addGap(85)
									.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
										.addComponent(lblMNhnVin)
										.addComponent(lblQuyn, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNhpLi))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
										.addComponent(jpfNhapLai, 190, 190, 190)
										.addComponent(jcobQuyen, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addComponent(jcbMaNhanVien, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
								.addComponent(jcbTinhTrang, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))))
					.addGap(50))
		);
		gl_jpbInfo.setVerticalGroup(
			gl_jpbInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpbInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblThngTinTi)
					.addGap(18)
					.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpbInfo.createSequentialGroup()
							.addGroup(gl_jpbInfo.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTnngNhp)
								.addComponent(jtfMaTaiKhoan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMtKhu)
								.addGroup(gl_jpbInfo.createParallelGroup(Alignment.BASELINE)
									.addComponent(jtfTenDangNhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblQuyn, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_jpbInfo.createSequentialGroup()
							.addGroup(gl_jpbInfo.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMNhnVin)
								.addComponent(jcbMaNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(jcobQuyen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMtKhu_1)
						.addGroup(gl_jpbInfo.createParallelGroup(Alignment.BASELINE)
							.addComponent(jpfMatKhau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNhpLi)
							.addComponent(jpfNhapLai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_jpbInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMtKhu_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(jcbTinhTrang))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jlbMsg, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpbInfo.createSequentialGroup()
							.addGap(4)
							.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpbInfo.createSequentialGroup()
							.addGap(4)
							.addComponent(btnInBaoCao, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpbInfo.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jpbInfo.setLayout(gl_jpbInfo);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		QuanLyTaiKhoanController control = new QuanLyTaiKhoanController(jtfMaTaiKhoan, jtfTenDangNhap, jpfMatKhau,
				jpfNhapLai, jcbMaNhanVien, btnThem, btnXoa, btnSua, btnInBaoCao, jcbTinhTrang, jpnView, jtfSearch,
				jcobQuyen, jmiLamMoi, jlbMsg);
		control.setView();
		control.setEvent();
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
