package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TimKiemSachFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel jpnView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemSachFrame frame = new TimKiemSachFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TimKiemSachFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		jpnView = new JPanel();

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new DangNhapDialog().setVisible(true);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(929, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(5)
						.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(10)
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
//		setView();
	}

	public void setView() {
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(new TimKiemSachPanel());
		jpnView.validate();
		jpnView.repaint();
	}
}
