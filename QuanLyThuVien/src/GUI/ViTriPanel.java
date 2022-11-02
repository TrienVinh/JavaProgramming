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

import BUS.QuanLyViTriController;

public class ViTriPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField jtfSoKhu;
	private JTextField jtfMaViTri;
	private JTextField jtfSearch;
	private JTextField jtfSoKe;
	private JTextField jtfSoNgan;

	/**
	 * Create the panel.
	 */
	public ViTriPanel() {

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
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(jpbInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup().addGap(5)
						.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(407, Short.MAX_VALUE))
				.addComponent(jpnView, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup()
						.addComponent(jpbInfo, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnView, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JLabel lblThngTinTi = new JLabel("THÔNG TIN VI TRI");
		lblThngTinTi.setForeground(new Color(255, 255, 255));
		lblThngTinTi.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblThngTinTi.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblTnngNhp = new JLabel("Mã Vi Tri:");
		lblTnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnngNhp.setForeground(new Color(255, 255, 255));

		JLabel lblMtKhu = new JLabel("So Khu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhu.setForeground(new Color(255, 255, 255));

		jtfSoKhu = new JTextField();
		jtfSoKhu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfSoKhu.setColumns(10);

		jtfMaViTri = new JTextField();
		jtfMaViTri.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfMaViTri.setColumns(10);

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

		JLabel jlbMsg = new JLabel("");
		jlbMsg.setForeground(new Color(255, 51, 0));
		jlbMsg.setFont(new Font("Tahoma", Font.ITALIC, 14));

		JLabel lblNhapThongTin = new JLabel("");
		lblNhapThongTin.setForeground(new Color(255, 51, 51));
		lblNhapThongTin.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		JLabel lblSoKe = new JLabel("So Ke :");
		lblSoKe.setForeground(Color.WHITE);
		lblSoKe.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblSoNgan = new JLabel("So Ngan:");
		lblSoNgan.setForeground(Color.WHITE);
		lblSoNgan.setFont(new Font("Tahoma", Font.PLAIN, 15));

		jtfSoKe = new JTextField();
		jtfSoKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfSoKe.setColumns(10);

		jtfSoNgan = new JTextField();
		jtfSoNgan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfSoNgan.setColumns(10);
		GroupLayout gl_jpbInfo = new GroupLayout(jpbInfo);
		gl_jpbInfo.setHorizontalGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpbInfo.createSequentialGroup().addGap(10).addComponent(lblThngTinTi,
						GroupLayout.PREFERRED_SIZE, 928, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jpbInfo.createSequentialGroup().addGap(56)
						.addComponent(lblTnngNhp, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE).addGap(26)
						.addComponent(jtfMaViTri, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
						.addGap(31).addComponent(lblMtKhu, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(jtfSoKhu, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jpbInfo.createSequentialGroup().addGap(56).addComponent(lblNhapThongTin))
				.addGroup(gl_jpbInfo.createSequentialGroup().addGap(56)
						.addComponent(lblSoKe, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE).addGap(26)
						.addComponent(jtfSoKe, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE).addGap(31)
						.addComponent(lblSoNgan, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(jtfSoNgan, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jpbInfo.createSequentialGroup().addGap(56).addComponent(jlbMsg))
				.addGroup(gl_jpbInfo.createSequentialGroup().addGap(10)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE).addGap(73)
						.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE).addGap(67)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE).addGap(88)
						.addComponent(btnInBaoCao, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)));
		gl_jpbInfo
				.setVerticalGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpbInfo.createSequentialGroup().addGap(10).addComponent(lblThngTinTi).addGap(18)
								.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_jpbInfo.createSequentialGroup().addGap(4).addComponent(lblTnngNhp))
										.addComponent(jtfMaViTri, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_jpbInfo.createSequentialGroup().addGap(4).addComponent(lblMtKhu))
										.addComponent(jtfSoKhu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18).addComponent(lblNhapThongTin).addGap(7)
								.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING).addComponent(lblSoKe)
										.addGroup(gl_jpbInfo.createSequentialGroup().addGap(2).addComponent(jtfSoKe,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_jpbInfo.createSequentialGroup().addGap(5).addComponent(lblSoNgan))
										.addGroup(gl_jpbInfo.createSequentialGroup().addGap(2).addComponent(jtfSoNgan,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(21)
								.addComponent(jlbMsg, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGap(17)
								.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
										.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnInBaoCao, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE))));
		jpbInfo.setLayout(gl_jpbInfo);

		QuanLyViTriController control = new QuanLyViTriController(jtfMaViTri, jtfSoKe, jtfSoKhu, jtfSoNgan, jtfSearch,
				btnThem, btnSua, btnXoa, btnInBaoCao, jlbMsg, jmiLamMoi, jpnView);
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
