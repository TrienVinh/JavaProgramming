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

import BUS.QuanLyTheLoaiController;

public class TheLoaiPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField jtfTenTheLoai;
	private JTextField jtfMaTheLoai;
	private JTextField jtfSearch;

	/**
	 * Create the panel.
	 */
	public TheLoaiPanel() {

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
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(400, Short.MAX_VALUE))
				.addComponent(jpnView, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
				.addComponent(jpbInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(jpbInfo, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jpnView, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 0, Short.MAX_VALUE))
		);

		JLabel lblThngTinTi = new JLabel("THÔNG TIN THỂ LOẠI");
		lblThngTinTi.setForeground(new Color(255, 255, 255));
		lblThngTinTi.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblThngTinTi.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblTnngNhp = new JLabel("Mã Thể Loại :");
		lblTnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnngNhp.setForeground(new Color(255, 255, 255));

		JLabel lblMtKhu = new JLabel("Tên Thể Loại :");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhu.setForeground(new Color(255, 255, 255));

		jtfTenTheLoai = new JTextField();
		jtfTenTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfTenTheLoai.setColumns(10);

		jtfMaTheLoai = new JTextField();
		jtfMaTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfMaTheLoai.setColumns(10);

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
		GroupLayout gl_jpbInfo = new GroupLayout(jpbInfo);
		gl_jpbInfo.setHorizontalGroup(
			gl_jpbInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpbInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblThngTinTi, GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_jpbInfo.createSequentialGroup()
					.addGap(56)
					.addComponent(lblTnngNhp)
					.addGap(26)
					.addComponent(jtfMaTheLoai, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(lblMtKhu)
					.addGap(18)
					.addComponent(jtfTenTheLoai, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
					.addGap(82))
				.addGroup(gl_jpbInfo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpbInfo.createSequentialGroup()
							.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
							.addGap(73)
							.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
							.addGap(67)
							.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
							.addGap(88)
							.addComponent(btnInBaoCao, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
							.addGap(12))
						.addGroup(gl_jpbInfo.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
								.addComponent(jlbMsg)
								.addComponent(lblNhapThongTin))
							.addGap(749)))
					.addGap(37))
		);
		gl_jpbInfo.setVerticalGroup(
			gl_jpbInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpbInfo.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblThngTinTi)
					.addGap(18)
					.addGroup(gl_jpbInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTnngNhp)
						.addComponent(jtfMaTheLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMtKhu)
						.addComponent(jtfTenTheLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpbInfo.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNhapThongTin)
						.addComponent(jlbMsg, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_jpbInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInBaoCao, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jpbInfo.setLayout(gl_jpbInfo);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		QuanLyTheLoaiController control = new QuanLyTheLoaiController(jtfMaTheLoai, jtfTenTheLoai, jtfSearch, btnThem,
				btnSua, btnXoa, btnInBaoCao, jpnView, jmiLamMoi, jlbMsg);
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
