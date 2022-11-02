package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import BUS.ThongKeController;

public class ThongKePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ThongKePanel(JFrame frame) {

		JPanel jpnRoot = new JPanel();

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(new Color(0, 204, 255));

		JPanel jpnView = new JPanel();

		JPanel jpnThongKe = new JPanel();

		JPanel jpnTitle = new JPanel();
		GroupLayout gl_jpnRoot = new GroupLayout(jpnRoot);
		gl_jpnRoot.setHorizontalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING).addGroup(gl_jpnRoot
				.createSequentialGroup()
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_jpnRoot.createParallelGroup(Alignment.TRAILING)
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
						.addComponent(jpnTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
						.addComponent(jpnThongKe, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 823, Short.MAX_VALUE))
				.addContainerGap()));
		gl_jpnRoot.setVerticalGroup(gl_jpnRoot.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jpnRoot.createSequentialGroup().addGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpnRoot.createSequentialGroup()
								.addComponent(jpnTitle, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jpnView, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(jpnThongKe,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 715, GroupLayout.PREFERRED_SIZE)).addGap(3)));
		jpnTitle.setLayout(null);
		jpnThongKe.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));

		JLabel lblThngKTheo = new JLabel("Thống Kê Theo :");
		lblThngKTheo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblThngKTheo.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(10)
						.addComponent(lblThngKTheo, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE).addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblThngKTheo)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)));

		JList<String> jlThongKe = new JList<String>();
		jlThongKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlThongKe.setModel(new AbstractListModel<String>() {

			private static final long serialVersionUID = 1L;
			String[] values = new String[] { "+ Tỉ lệ sách được mượn", "+ Thống kê sách được mượn nhiều nhất",
					"+ Thống kê sách được mượn ít nhất", "+ Thống kê khách hàng thường xuyên mượn sách",
					"+ Các phiếu mượn chưa trả", "+ Các phiếu mượn đã trễ hạn", "+ Thống kê phiếu mượn theo ngày",
					"+ Thống kê sách đang mượn", "+ Thống kê khách hàng bị phạt nhiều nhất" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});

		scrollPane.setViewportView(jlThongKe);
		panel.setLayout(gl_panel);
		jpnRoot.setLayout(gl_jpnRoot);

		GroupLayout gl_jpnView = new GroupLayout(jpnView);
		gl_jpnView
				.setHorizontalGroup(gl_jpnView.createParallelGroup(Alignment.LEADING).addGap(0, 823, Short.MAX_VALUE));
		gl_jpnView.setVerticalGroup(gl_jpnView.createParallelGroup(Alignment.LEADING).addGap(0, 354, Short.MAX_VALUE));
		jpnView.setLayout(gl_jpnView);

		ThongKeController control = new ThongKeController(jpnView, jpnThongKe, jlThongKe, frame, jpnTitle);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(jpnRoot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(jpnRoot, GroupLayout.PREFERRED_SIZE, 718, Short.MAX_VALUE).addContainerGap()));
		setLayout(groupLayout);
		control.setView();
		control.setEvent();
	}
}
