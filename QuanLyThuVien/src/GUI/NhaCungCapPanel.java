package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import BUS.QuanLyNhaCungCapController;

public class NhaCungCapPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField jtfTenNCC;
	private JTextField jtfMaNCC;
	private JTextField jtfSearch;
	private JTextField jtfDiaChi;
	private JTextField jtfEmail;

	/**
	 * Create the panel.
	 */
	public NhaCungCapPanel() {

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

		jtfSearch = new JTextField();
		jtfSearch.setText("Nhập thông tin muốn tìm kiếm...");
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jtfSearch.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(jpbInfo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 975, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING,
								gl_panel.createSequentialGroup().addGap(5)
										.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 531,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(434, Short.MAX_VALUE))
						.addComponent(jpnView, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup()
						.addComponent(jpbInfo, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)));

		JLabel lblTnngNhp = new JLabel("Mã NCC:");
		lblTnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnngNhp.setForeground(new Color(255, 255, 255));

		JLabel lblMtKhu = new JLabel("Tên NCC:");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhu.setForeground(new Color(255, 255, 255));

		JLabel lblMNhnVin = new JLabel("Địa Chỉ:");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMNhnVin.setForeground(new Color(255, 255, 255));

		jtfTenNCC = new JTextField();
		jtfTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfTenNCC.setColumns(10);

		jtfMaNCC = new JTextField();
		jtfMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfMaNCC.setColumns(10);

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

		JLabel lblQuyn = new JLabel("Email :");
		lblQuyn.setForeground(Color.WHITE);
		lblQuyn.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel jlbMsg = new JLabel("");
		jlbMsg.setForeground(new Color(255, 51, 0));
		jlbMsg.setFont(new Font("Tahoma", Font.ITALIC, 14));

		JLabel lblThngTinTi = new JLabel("THÔNG TIN NHÀ CUNG CẤP");
		lblThngTinTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinTi.setForeground(Color.WHITE);
		lblThngTinTi.setFont(new Font("Tahoma", Font.PLAIN, 26));

		jtfDiaChi = new JTextField();
		jtfDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfDiaChi.setColumns(10);

		jtfEmail = new JTextField();
		jtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfEmail.setColumns(10);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		GroupLayout gl_jpbInfo = new GroupLayout(jpbInfo);
		gl_jpbInfo.setHorizontalGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpbInfo.createSequentialGroup().addGap(56).addComponent(lblTnngNhp).addGap(21)
						.addComponent(jtfMaNCC, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE).addGap(170)
						.addComponent(lblMNhnVin, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE).addGap(21)
						.addComponent(jtfDiaChi, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jpbInfo.createSequentialGroup().addGap(56)
						.addComponent(lblMtKhu, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE).addGap(10)
						.addComponent(jtfTenNCC, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
						.addGap(170).addComponent(lblQuyn, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addGap(4).addComponent(jtfEmail, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jpbInfo.createSequentialGroup().addGap(56).addComponent(jlbMsg))
				.addGroup(gl_jpbInfo.createSequentialGroup().addGap(10)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE).addGap(80)
						.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE).addGap(99)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE).addGap(46)
						.addComponent(btnInBaoCao, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jpbInfo.createSequentialGroup().addContainerGap()
						.addComponent(lblThngTinTi, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
						.addContainerGap()));
		gl_jpbInfo.setVerticalGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING).addGroup(gl_jpbInfo
				.createSequentialGroup().addContainerGap().addComponent(lblThngTinTi).addGap(18)
				.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpbInfo.createSequentialGroup().addGap(2).addComponent(lblTnngNhp))
						.addComponent(jtfMaNCC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_jpbInfo.createSequentialGroup().addGap(4).addComponent(lblMNhnVin))
						.addGroup(gl_jpbInfo.createSequentialGroup().addGap(2).addComponent(jtfDiaChi,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(16)
				.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING).addComponent(lblMtKhu)
						.addComponent(jtfTenNCC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_jpbInfo.createSequentialGroup().addGap(4).addComponent(lblQuyn))
						.addGroup(gl_jpbInfo.createSequentialGroup().addGap(2).addComponent(jtfEmail,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(13).addComponent(jlbMsg, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(11)
				.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_jpbInfo.createSequentialGroup().addGap(4).addComponent(btnXoa,
								GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpbInfo.createSequentialGroup().addGap(4).addComponent(btnInBaoCao,
								GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))));
		jpbInfo.setLayout(gl_jpbInfo);
		QuanLyNhaCungCapController control = new QuanLyNhaCungCapController(jtfMaNCC, jtfTenNCC, jtfDiaChi, jtfEmail,
				btnThem, btnSua, btnXoa, btnInBaoCao, jlbMsg, jpnView, jtfSearch);
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
