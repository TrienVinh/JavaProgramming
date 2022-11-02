package GUI;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Image;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class ManHinhChinhPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ManHinhChinhPanel() {

		JPanel jpnRoot = new JPanel();
		jpnRoot.setBackground(new Color(240, 240, 240));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(jpnRoot,
				GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(jpnRoot,
				GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);

		JLabel jlb2 = new JLabel("");
		jlb2.setBounds(0, 0, 294, 254);
		jlb2.setIcon(getImage("/image/imgSach/SherlockHolmes.png", jlb2));
		panel_1_1.add(jlb2);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));

		JLabel lblTnSch_1 = new JLabel("Tên Sách:");
		lblTnSch_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblMSch_1 = new JLabel("Mã Sách:");
		lblMSch_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblSLng_1 = new JLabel("Số Lượng:");
		lblSLng_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 294, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING).addComponent(lblTnSch_1)
								.addComponent(lblMSch_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSLng_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(231, Short.MAX_VALUE)));
		gl_panel_2_1.setVerticalGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING).addGap(0, 92, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1.createSequentialGroup().addContainerGap()
						.addComponent(lblMSch_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblTnSch_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSLng_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE)));
		panel_2_1.setLayout(gl_panel_2_1);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGap(0, 298, Short.MAX_VALUE)
				.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panel_2_1, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGap(0, 356, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
						.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2_1, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);

		JLabel jlb3 = new JLabel("");
		jlb3.setBounds(0, 0, 294, 254);
		jlb3.setIcon(getImage("/image/imgSach/Doraemon.jpg", jlb3));
		panel_1_2.add(jlb3);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));

		JLabel lblTnSch_2 = new JLabel("Tên Sách:");
		lblTnSch_2.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblMSch_2 = new JLabel("Mã Sách:");
		lblMSch_2.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblSLng_2 = new JLabel("Số Lượng:");
		lblSLng_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel_2_2 = new GroupLayout(panel_2_2);
		gl_panel_2_2.setHorizontalGroup(gl_panel_2_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 294, Short.MAX_VALUE)
				.addGroup(gl_panel_2_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2_2.createParallelGroup(Alignment.LEADING).addComponent(lblTnSch_2)
								.addComponent(lblMSch_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSLng_2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(231, Short.MAX_VALUE)));
		gl_panel_2_2.setVerticalGroup(gl_panel_2_2.createParallelGroup(Alignment.LEADING).addGap(0, 92, Short.MAX_VALUE)
				.addGroup(gl_panel_2_2.createSequentialGroup().addContainerGap()
						.addComponent(lblMSch_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblTnSch_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSLng_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE)));
		panel_2_2.setLayout(gl_panel_2_2);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGap(0, 298, Short.MAX_VALUE)
				.addComponent(panel_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panel_2_2, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGap(0, 356, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
						.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2_2, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);
		GroupLayout gl_jpnRoot = new GroupLayout(jpnRoot);
		gl_jpnRoot.setHorizontalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnRoot.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(51, Short.MAX_VALUE)));
		gl_jpnRoot.setVerticalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnRoot.createSequentialGroup().addContainerGap()
						.addGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(340, Short.MAX_VALUE)));

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)));
		panel_1.setLayout(null);

		JLabel jlb1 = new JLabel("");
		jlb1.setBounds(0, 0, 294, 254);
		jlb1.setIcon(getImage("/image/imgSach/Conan.png", jlb1));
		panel_1.add(jlb1);

		JLabel lblMSch = new JLabel("Mã Sách:");
		lblMSch.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblTnSch = new JLabel("Tên Sách:");
		lblTnSch.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblSLng = new JLabel("Số Lượng:");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(lblTnSch)
								.addComponent(lblMSch, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSLng, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(248, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(lblMSch, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblTnSch, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSLng, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(29, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
		jpnRoot.setLayout(gl_jpnRoot);
		setLayout(groupLayout);

	}

	public ImageIcon getImage(String pathName, JLabel jlb) {
		ImageIcon img = new ImageIcon(ManHinhChinhPanel.class.getResource(pathName));
		Image img1 = img.getImage();
		Image img2 = img1.getScaledInstance(jlb.getWidth(), jlb.getHeight(), Image.SCALE_SMOOTH);
		return new ImageIcon(img2);
	}
}
