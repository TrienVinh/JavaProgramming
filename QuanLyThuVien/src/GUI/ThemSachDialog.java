package GUI;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ThemSachDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel jpnView;

	public ThemSachDialog(JFrame frame, boolean check) {
		super(frame, check);
		setBounds(100, 100, 1091, 692);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		jpnView = new JPanel();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(jpnView,
				GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE));
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel.createSequentialGroup()
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE).addContainerGap()));
		contentPanel.setLayout(gl_contentPanel);
	}

	public void setView() {
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(new QuanLySachPanel());
		jpnView.validate();
		jpnView.repaint();
	}
}
