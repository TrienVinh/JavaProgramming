package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import BUS.TimKiemSachController;

import javax.swing.JList;

public class TimKiemSachPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField jtfGiaTien;
	private JTextField jtfTenSach;

	/**
	 * Create the panel.
	 */
	public TimKiemSachPanel() {

		JPanel jpnRoot = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(jpnRoot,
				GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(jpnRoot,
				GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));

		JPanel jpnThongTin = new JPanel();
		jpnThongTin.setBackground(new Color(51, 51, 51));

		JPanel jpnView = new JPanel();

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(jpnRoot, popupMenu);

		JMenuItem jmiRefresh = new JMenuItem("Lam Moi");
		popupMenu.add(jmiRefresh);
		GroupLayout gl_jpnRoot = new GroupLayout(jpnRoot);
		gl_jpnRoot.setHorizontalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
				.addComponent(jpnThongTin, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
				.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE));
		gl_jpnRoot.setVerticalGroup(gl_jpnRoot.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_jpnRoot.createSequentialGroup()
						.addComponent(jpnThongTin, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)));
		GroupLayout gl_jpnView = new GroupLayout(jpnView);
		gl_jpnView
				.setHorizontalGroup(gl_jpnView.createParallelGroup(Alignment.LEADING).addGap(0, 949, Short.MAX_VALUE));
		gl_jpnView.setVerticalGroup(gl_jpnView.createParallelGroup(Alignment.LEADING).addGap(0, 395, Short.MAX_VALUE));
		jpnView.setLayout(gl_jpnView);

		JLabel lblNghNghip = new JLabel("Giá Tiền: ");
		lblNghNghip.setForeground(Color.WHITE);
		lblNghNghip.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfGiaTien = new JTextField();
		jtfGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfGiaTien.setColumns(10);

		JLabel lblMNxb = new JLabel("Mã NXB:");
		lblMNxb.setForeground(Color.WHITE);
		lblMNxb.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JComboBox<String> jcobMaNXB = new JComboBox<String>();
		jcobMaNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblHTn = new JLabel("Tên Sách:");
		lblHTn.setForeground(Color.WHITE);
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfTenSach = new JTextField();
		jtfTenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfTenSach.setColumns(10);

		JButton btnTimKiem = new JButton("Tim Kiem");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblMNgnNg = new JLabel("Mã Ngôn Ngữ :");
		lblMNgnNg.setForeground(Color.WHITE);
		lblMNgnNg.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JScrollPane scrollPane_1 = new JScrollPane();

		JLabel lblSinThoi = new JLabel("Mã TL :");
		lblSinThoi.setForeground(Color.WHITE);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblaCh = new JLabel("Mã VT:");
		lblaCh.setForeground(Color.WHITE);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JComboBox<String> jcobMaVT = new JComboBox<String>();
		jcobMaVT.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNgySinh = new JLabel("Mã TG:");
		lblNgySinh.setForeground(Color.WHITE);
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JComboBox<String> jcobMaTG = new JComboBox<String>();
		jcobMaTG.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JList<String> jlNgonNgu = new JList<String>();
		scrollPane_1.setViewportView(jlNgonNgu);

		JList<String> jlTheLoai = new JList<String>();
		scrollPane.setViewportView(jlTheLoai);
		jpnRoot.setLayout(gl_jpnRoot);
		setLayout(groupLayout);

		TimKiemSachController control = new TimKiemSachController(jtfTenSach, jtfGiaTien, jcobMaTG, jcobMaNXB, jcobMaVT,
				btnTimKiem, jmiRefresh, jpnView, jlTheLoai, jlNgonNgu);
		GroupLayout gl_jpnThongTin = new GroupLayout(jpnThongTin);
		gl_jpnThongTin.setHorizontalGroup(gl_jpnThongTin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnThongTin.createSequentialGroup().addGap(49)
						.addGroup(gl_jpnThongTin.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHTn, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNghNghip, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMNxb, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGap(23)
						.addGroup(gl_jpnThongTin.createParallelGroup(Alignment.LEADING)
								.addComponent(jtfTenSach, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfGiaTien, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
								.addComponent(jcobMaNXB, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addGap(79).addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addGap(60)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jpnThongTin.createSequentialGroup().addGap(49)
						.addGroup(gl_jpnThongTin.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNgySinh, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
						.addGap(41)
						.addGroup(gl_jpnThongTin.createParallelGroup(Alignment.LEADING)
								.addComponent(jcobMaTG, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
								.addComponent(jcobMaVT, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addGap(79).addComponent(lblMNgnNg, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addGap(12)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_jpnThongTin.createSequentialGroup().addGap(388).addComponent(btnTimKiem,
						GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)));
		gl_jpnThongTin
				.setVerticalGroup(
						gl_jpnThongTin.createParallelGroup(Alignment.LEADING).addGroup(gl_jpnThongTin
								.createSequentialGroup().addGap(26).addGroup(gl_jpnThongTin
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_jpnThongTin.createSequentialGroup().addComponent(lblHTn).addGap(10)
												.addComponent(lblNghNghip).addGap(12).addComponent(lblMNxb,
														GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_jpnThongTin.createSequentialGroup()
														.addComponent(jtfTenSach, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(8)
														.addComponent(jtfGiaTien, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(9).addComponent(jcobMaNXB, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblSinThoi).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
												84, GroupLayout.PREFERRED_SIZE))
								.addGap(9)
								.addGroup(gl_jpnThongTin.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_jpnThongTin.createSequentialGroup()
												.addComponent(lblNgySinh, GroupLayout.PREFERRED_SIZE, 20,
														GroupLayout.PREFERRED_SIZE)
												.addGap(17).addComponent(lblaCh))
										.addGroup(gl_jpnThongTin.createSequentialGroup().addGap(1)
												.addComponent(jcobMaTG, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(10).addComponent(jcobMaVT, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblMNgnNg).addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE,
												76, GroupLayout.PREFERRED_SIZE))
								.addGap(41)
								.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)));
		jpnThongTin.setLayout(gl_jpnThongTin);
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
