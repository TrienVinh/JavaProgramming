package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import BUS.PhieuMuonPanelController;

public class PhieuMuonPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField jtfSearch;

	/**
	 * Create the panel.
	 */
	public PhieuMuonPanel(JFrame frame, String maNV) {

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addComponent(panel, GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
						.addContainerGap()));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JPanel jpnView = new JPanel();
		jpnView.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		jtfSearch = new JTextField();
		jtfSearch.setBorder(new LineBorder(new Color(51, 51, 51), 2, true));
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfSearch.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 526, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(398, Short.MAX_VALUE))
				.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE).addGap(0)));

		JLabel lblThngTinPhiu = new JLabel("THÔNG TIN PHIẾU MƯỢN");
		lblThngTinPhiu.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinPhiu.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JButton btnThem = new JButton("Thêm Phiếu Mượn");
		btnThem.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setIcon(new ImageIcon(PhieuMuonPanel.class.getResource("/image/CRUD/Add_black_24dp.png")));

		JButton btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnCapNhat.setIcon(new ImageIcon(PhieuMuonPanel.class.getResource("/image/CRUD/edit2_black_24dp.png")));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup().addGap(114)
								.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
								.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
								.addGap(150))
						.addComponent(lblThngTinPhiu, GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addComponent(lblThngTinPhiu).addGap(18)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))));
		panel_1.setLayout(gl_panel_1);

		PhieuMuonPanelController control = new PhieuMuonPanelController(btnThem, btnCapNhat, jtfSearch, jpnView, maNV,
				frame);
		control.setView();
		control.setEvent();
	}
}
