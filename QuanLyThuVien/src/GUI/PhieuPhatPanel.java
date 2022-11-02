package GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import BUS.QuanLyPhieuPhatController;

import java.awt.Color;

public class PhieuPhatPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField jtfSearch;

	/**
	 * Create the panel.
	 */
	public PhieuPhatPanel(JFrame frame) {

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 972, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		JPanel jpnView = new JPanel();
		jpnView.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		jtfSearch = new JTextField();
		jtfSearch.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtfSearch.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(5)
						.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(401, Short.MAX_VALUE))
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
				.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)));

		JLabel lblThngTinPhiu = new JLabel("THÔNG TIN PHIẾU PHẠT");
		lblThngTinPhiu.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinPhiu.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JButton jbtnThem = new JButton("Thêm");
		jbtnThem.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		jbtnThem.setIcon(new ImageIcon(PhieuPhatPanel.class.getResource("/image/CRUD/Add_black_24dp.png")));
		jbtnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblThngTinPhiu, GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(317)
						.addComponent(jbtnThem, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(461, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblThngTinPhiu)
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addComponent(jbtnThem, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		QuanLyPhieuPhatController control = new QuanLyPhieuPhatController(jbtnThem, jtfSearch, jpnView, frame);
		control.setView();
		control.setEvent();
	}
}
