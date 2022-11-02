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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import BUS.SachController;

import javax.swing.JList;
import javax.swing.AbstractListModel;

public class SachPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField jtfMaSach;
	private JTextField jtfTenSach;
	private JTextField jtfSoTrang;
	private JTextField jtfSearch;
	private JTextField jtfGiaTien;
	private JTextField jtfSoLuong;
	private JTextField jtfNamXB;

	/**
	 * Create the panel.
	 */
	public SachPanel() {

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

		jtfSearch = new JTextField();
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfSearch.setColumns(10);
		GroupLayout gl_jpnRoot = new GroupLayout(jpnRoot);
		gl_jpnRoot.setHorizontalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
				.addComponent(jpnThongTin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_jpnRoot.createSequentialGroup().addGap(5)
						.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(368, Short.MAX_VALUE))
				.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE));
		gl_jpnRoot.setVerticalGroup(gl_jpnRoot.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jpnRoot.createSequentialGroup()
						.addComponent(jpnThongTin, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnView, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)));
		GroupLayout gl_jpnView = new GroupLayout(jpnView);
		gl_jpnView
				.setHorizontalGroup(gl_jpnView.createParallelGroup(Alignment.LEADING).addGap(0, 949, Short.MAX_VALUE));
		gl_jpnView.setVerticalGroup(gl_jpnView.createParallelGroup(Alignment.LEADING).addGap(0, 395, Short.MAX_VALUE));
		jpnView.setLayout(gl_jpnView);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		GroupLayout gl_jpnThongTin = new GroupLayout(jpnThongTin);
		gl_jpnThongTin.setHorizontalGroup(gl_jpnThongTin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnThongTin.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 454, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)));
		gl_jpnThongTin.setVerticalGroup(gl_jpnThongTin.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE));

		JLabel lblNgySinh = new JLabel("Mã TG:");
		lblNgySinh.setForeground(Color.WHITE);
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblaCh = new JLabel("Mã VT:");
		lblaCh.setForeground(Color.WHITE);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblSinThoi = new JLabel("Mã TL :");
		lblSinThoi.setForeground(Color.WHITE);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JButton btnXo = new JButton("Xoá");
		btnXo.setIcon(new ImageIcon(DocGiaPanel.class.getResource("/image/CRUD/Remove_black_24dp.png")));
		btnXo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnInBoCo = new JButton("In Báo cáo");
		btnInBoCo.setIcon(new ImageIcon(DocGiaPanel.class.getResource("/image/CRUD/Printblack_24dp.png")));
		btnInBoCo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JComboBox<String> jcobMaTG = new JComboBox<String>();
		jcobMaTG.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JComboBox<String> jcobMaVT = new JComboBox<String>();
		jcobMaVT.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane();

		JList<String> jlMaTL = new JList<String>();
		jlMaTL.setModel(new AbstractListModel<String>() {

			private static final long serialVersionUID = 1L;
			String[] values = new String[] {};

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
		jlMaTL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(jlMaTL);

		JLabel lblMNgnNg = new JLabel("Mã Ngôn Ngữ :");
		lblMNgnNg.setForeground(Color.WHITE);
		lblMNgnNg.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JScrollPane scrollPane_1 = new JScrollPane();

		JList<String> jlMaNN = new JList<String>();
		jlMaNN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_1.setViewportView(jlMaNN);

		JLabel lblMcGi = new JLabel("Mã Sách :");
		lblMcGi.setForeground(Color.WHITE);
		lblMcGi.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfMaSach = new JTextField();
		jtfMaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfMaSach.setColumns(10);

		JLabel lblHTn = new JLabel("Tên Sách:");
		lblHTn.setForeground(Color.WHITE);
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblGiiTnh = new JLabel("Số Lượng:");
		lblGiiTnh.setForeground(Color.WHITE);
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfTenSach = new JTextField();
		jtfTenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfTenSach.setColumns(10);

		JLabel lblEmail = new JLabel("Số Trang:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfSoTrang = new JTextField();
		jtfSoTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfSoTrang.setColumns(10);

		JLabel lblNghNghip = new JLabel("Giá Tiền: ");
		lblNghNghip.setForeground(Color.WHITE);
		lblNghNghip.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JButton btnThm = new JButton("Thêm");
		btnThm.setIcon(new ImageIcon(DocGiaPanel.class.getResource("/image/CRUD/Add_black_24dp.png")));
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnSa = new JButton("Sửa");
		btnSa.setIcon(new ImageIcon(DocGiaPanel.class.getResource("/image/CRUD/edit2_black_24dp.png")));
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jpnThongTin.setLayout(gl_jpnThongTin);
		jpnRoot.setLayout(gl_jpnRoot);
		setLayout(groupLayout);

		jtfGiaTien = new JTextField();
		jtfGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfGiaTien.setColumns(10);

		jtfSoLuong = new JTextField();
		jtfSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfSoLuong.setColumns(10);

		JLabel lblMNxb = new JLabel("Mã NXB:");
		lblMNxb.setForeground(Color.WHITE);
		lblMNxb.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JComboBox<String> jcobMaNXB = new JComboBox<String>();
		jcobMaNXB.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel jlbMsg = new JLabel("");
		jlbMsg.setForeground(new Color(255, 51, 51));
		jlbMsg.setFont(new Font("Tahoma", Font.ITALIC, 20));

		JLabel lblNmXb = new JLabel("Năm XB:");
		lblNmXb.setForeground(Color.WHITE);
		lblNmXb.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfNamXB = new JTextField();
		jtfNamXB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfNamXB.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(61)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblMcGi, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(35)
								.addComponent(jtfMaSach, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblHTn, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addGap(44)
								.addComponent(jtfTenSach, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblGiiTnh, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGap(54)
								.addComponent(jtfSoLuong, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGap(54)
								.addComponent(jtfSoTrang, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNghNghip, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addGap(23)
								.addComponent(jtfGiaTien, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblMNxb, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addGap(41)
								.addComponent(jcobMaNXB, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNmXb, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addGap(41)
								.addComponent(jtfNamXB, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addComponent(jlbMsg, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btnThm, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addGap(55)
								.addComponent(btnSa, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(23)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblMcGi).addComponent(jtfMaSach,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(5)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblHTn).addComponent(jtfTenSach,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblGiiTnh).addComponent(
						jtfSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblEmail).addComponent(
						jtfSoTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(8)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblNghNghip).addComponent(
						jtfGiaTien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMNxb, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup().addGap(3).addComponent(jcobMaNXB,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(9)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNmXb, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup().addGap(1).addComponent(jtfNamXB,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(13).addComponent(jlbMsg, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(6)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThm, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSa, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))));
		panel.setLayout(gl_panel);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(41)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblNgySinh, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addGap(35)
								.addComponent(jcobMaTG, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addGap(60).addComponent(jcobMaVT, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addGap(60).addComponent(scrollPane, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblMNgnNg, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addGap(12).addComponent(scrollPane_1, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(btnXo, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnInBoCo, GroupLayout.PREFERRED_SIZE, 168,
										GroupLayout.PREFERRED_SIZE)))));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(31).addComponent(lblNgySinh,
								GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(30).addComponent(jcobMaTG,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(16).addComponent(lblaCh))
								.addGroup(gl_panel_1.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jcobMaVT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(6)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblSinThoi)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblMNgnNg)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addGap(34)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnXo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnInBoCo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))));
		panel_1.setLayout(gl_panel_1);

		SachController control = new SachController(jtfMaSach, jtfTenSach, jtfSoLuong, jtfSoTrang, jtfGiaTien,
				jtfSearch, jcobMaTG, jcobMaNXB, jcobMaVT, jlbMsg, btnThm, btnSa, btnXo, btnInBoCo, jmiRefresh, jpnView,
				jlMaTL, jlMaNN, jtfNamXB);
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
