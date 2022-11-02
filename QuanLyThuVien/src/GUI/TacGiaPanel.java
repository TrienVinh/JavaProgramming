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

import BUS.QuanLyTacGiaController;

public class TacGiaPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField jtfTenTacGia;
	private JTextField jtfMaTacGia;
	private JTextField jtfSearch;
	private JTextField jtfDiaChi;
	private JTextField jtfEmail;

	/**
	 * Create the panel.
	 */
	public TacGiaPanel() {

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
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(434, Short.MAX_VALUE))
				.addComponent(jpnView, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addComponent(jpbInfo, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
		);

		JLabel lblTnngNhp = new JLabel("Mã Tác Giả :");
		lblTnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnngNhp.setForeground(new Color(255, 255, 255));

		JLabel lblMtKhu = new JLabel("Tên Tác Giả :");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhu.setForeground(new Color(255, 255, 255));

		JLabel lblMNhnVin = new JLabel("Địa Chỉ:");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMNhnVin.setForeground(new Color(255, 255, 255));

		jtfTenTacGia = new JTextField();
		jtfTenTacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfTenTacGia.setColumns(10);

		jtfMaTacGia = new JTextField();
		jtfMaTacGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfMaTacGia.setColumns(10);

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
		
		JLabel lblThngTinTi = new JLabel("THÔNG TIN TÁC GIẢ");
		lblThngTinTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinTi.setForeground(Color.WHITE);
		lblThngTinTi.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		jtfDiaChi = new JTextField();
		jtfDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfDiaChi.setColumns(10);
		
		jtfEmail = new JTextField();
		jtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfEmail.setColumns(10);
		GroupLayout gl_jpbInfo = new GroupLayout(jpbInfo);
		gl_jpbInfo.setHorizontalGroup(
			gl_jpbInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpbInfo.createSequentialGroup()
					.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpbInfo.createSequentialGroup()
							.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpbInfo.createSequentialGroup()
									.addGap(56)
									.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
										.addComponent(jlbMsg)
										.addGroup(gl_jpbInfo.createSequentialGroup()
											.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
												.addComponent(lblMtKhu)
												.addComponent(lblTnngNhp))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING, false)
												.addComponent(jtfMaTacGia, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
												.addComponent(jtfTenTacGia, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
											.addGap(85)
											.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
												.addComponent(lblQuyn, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblMNhnVin))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING, false)
												.addComponent(jtfDiaChi)
												.addComponent(jtfEmail, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))))
								.addGroup(gl_jpbInfo.createSequentialGroup()
									.addContainerGap()
									.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
									.addGap(80)
									.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
									.addGap(99)
									.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
									.addGap(46)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnInBaoCao, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
						.addGroup(gl_jpbInfo.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblThngTinTi, GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_jpbInfo.setVerticalGroup(
			gl_jpbInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpbInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblThngTinTi, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpbInfo.createSequentialGroup()
							.addGroup(gl_jpbInfo.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTnngNhp)
								.addComponent(jtfMaTacGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMtKhu)
								.addGroup(gl_jpbInfo.createParallelGroup(Alignment.BASELINE)
									.addComponent(jtfTenTacGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblQuyn, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_jpbInfo.createSequentialGroup()
							.addGroup(gl_jpbInfo.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMNhnVin)
								.addComponent(jtfDiaChi, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(jtfEmail, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addComponent(jlbMsg, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpbInfo.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_jpbInfo.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnInBaoCao, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_jpbInfo.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		jpbInfo.setLayout(gl_jpbInfo);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		QuanLyTacGiaController control = new QuanLyTacGiaController(jtfMaTacGia, jtfTenTacGia, jtfDiaChi, jtfEmail, btnThem, btnSua, btnXoa, btnInBaoCao, jlbMsg, jpnView, jtfSearch);
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
