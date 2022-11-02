package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import BUS.ThongTinPersonController;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;

public class ThongTinPersonDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField jtfEmail;
	private JTextField jtfMa;
	private JTextField jtfTen;
	private JTextField jtfCMND;
	private JTextField jtfSDT;
	private JTextField jtfNgheNghiep;
	private JTextField jtfNgaySinh;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the dialog.
	 * 
	 * @param <E>
	 */
	public <E> ThongTinPersonDialog(JFrame owner, boolean check, E item) {
		setBounds(100, 100, 1024, 351);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.PREFERRED_SIZE, 426, Short.MAX_VALUE));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(73, Short.MAX_VALUE)));

		JPanel jpnThongTin = new JPanel();
		jpnThongTin.setBackground(new Color(51, 51, 51));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(jpnThongTin,
				GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addComponent(jpnThongTin, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE).addGap(4)));

		JLabel jlbNgheNghiep = new JLabel("Chức Vụ :");
		jlbNgheNghiep.setBounds(63, 194, 109, 21);
		jlbNgheNghiep.setForeground(Color.WHITE);
		jlbNgheNghiep.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblEmail = new JLabel("email :");
		lblEmail.setBounds(63, 161, 78, 21);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblGiiTnh = new JLabel("Giới Tính :");
		lblGiiTnh.setBounds(63, 130, 78, 21);
		lblGiiTnh.setForeground(Color.WHITE);
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JRadioButton jrbNam = new JRadioButton("Nam");
		buttonGroup.add(jrbNam);
		jrbNam.setBounds(195, 131, 88, 25);
		jrbNam.setSelected(true);
		jrbNam.setForeground(Color.WHITE);
		jrbNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jrbNam.setBackground(new Color(51, 51, 51));

		JRadioButton jrbNu = new JRadioButton("Nữ");
		buttonGroup.add(jrbNu);
		jrbNu.setBounds(301, 131, 77, 25);
		jrbNu.setForeground(Color.WHITE);
		jrbNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jrbNu.setBackground(new Color(51, 51, 51));

		jtfEmail = new JTextField();
		jtfEmail.setBounds(195, 161, 237, 23);
		jtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfEmail.setColumns(10);

		JLabel lblHTn = new JLabel("Họ Tên :");
		lblHTn.setBounds(63, 99, 65, 21);
		lblHTn.setForeground(Color.WHITE);
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel jlbMa = new JLabel("Mã Nhân Viên:");
		jlbMa.setBounds(63, 66, 110, 21);
		jlbMa.setForeground(Color.WHITE);
		jlbMa.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfMa = new JTextField();
		jtfMa.setEditable(false);
		jtfMa.setBounds(195, 66, 237, 23);
		jtfMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfMa.setColumns(10);

		jtfTen = new JTextField();
		jtfTen.setBounds(195, 101, 237, 23);
		jtfTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfTen.setColumns(10);

		JLabel lblNgySinh = new JLabel("Ngày Sinh :");
		lblNgySinh.setBounds(535, 71, 91, 20);
		lblNgySinh.setForeground(Color.WHITE);
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblCmnd = new JLabel("CMND :");
		lblCmnd.setBounds(535, 192, 57, 21);
		lblCmnd.setForeground(Color.WHITE);
		lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfCMND = new JTextField();
		jtfCMND.setBounds(661, 192, 226, 23);
		jtfCMND.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfCMND.setColumns(10);

		JLabel lblaCh = new JLabel("Địa Chỉ :");
		lblaCh.setBounds(535, 100, 66, 21);
		lblaCh.setForeground(Color.WHITE);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(661, 99, 226, 48);

		JLabel lblSinThoi = new JLabel("Số Điện Thoại :");
		lblSinThoi.setBounds(535, 158, 116, 21);
		lblSinThoi.setForeground(Color.WHITE);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfSDT = new JTextField();
		jtfSDT.setBounds(661, 157, 226, 25);
		jtfSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfSDT.setColumns(10);

		JLabel jlbTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		jlbTitle.setBounds(63, 19, 824, 29);
		jlbTitle.setForeground(new Color(255, 255, 255));
		jlbTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jlbTitle.setHorizontalAlignment(SwingConstants.CENTER);

		JButton jbtnThoat = new JButton("Thoát");
		jbtnThoat.setBounds(434, 242, 208, 57);
		jbtnThoat.setIcon(new ImageIcon(ThongTinPersonDialog.class.getResource("/image/CRUD/Remove_black_24dp.png")));
		jbtnThoat.setFont(new Font("Tahoma", Font.PLAIN, 22));

		jtfNgheNghiep = new JTextField();
		jtfNgheNghiep.setBounds(195, 194, 237, 23);
		jtfNgheNghiep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfNgheNghiep.setColumns(10);

		jtfNgaySinh = new JTextField();
		jtfNgaySinh.setBounds(661, 66, 226, 25);
		jtfNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfNgaySinh.setColumns(10);

		JTextArea jtaDiaChi = new JTextArea();
		jtaDiaChi.setFont(new Font("tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(jtaDiaChi);
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);
		jpnThongTin.setLayout(null);

		jpnThongTin.add(jlbTitle);
		jpnThongTin.add(lblEmail);
		jpnThongTin.add(jlbNgheNghiep);
		jpnThongTin.add(jtfNgheNghiep);
		jpnThongTin.add(lblCmnd);
		jpnThongTin.add(jtfCMND);
		jpnThongTin.add(jtfEmail);
		jpnThongTin.add(lblSinThoi);
		jpnThongTin.add(jtfSDT);
		jpnThongTin.add(lblHTn);
		jpnThongTin.add(lblGiiTnh);
		jpnThongTin.add(jtfTen);
		jpnThongTin.add(jrbNam);
		jpnThongTin.add(jrbNu);
		jpnThongTin.add(lblaCh);
		jpnThongTin.add(jlbMa);
		jpnThongTin.add(jtfMa);
		jpnThongTin.add(lblNgySinh);
		jpnThongTin.add(jtfNgaySinh);
		jpnThongTin.add(scrollPane);
		jpnThongTin.add(jbtnThoat);

		ThongTinPersonController control = new ThongTinPersonController(jtfMa, jtfTen, jtfCMND, jtfNgaySinh,
				jtfNgheNghiep, jtfSDT, jtaDiaChi, jlbTitle, jlbMa, jlbNgheNghiep, jrbNu, jbtnThoat, this, jtfEmail);
		control.setView(item);
		control.setEvent();
	}
}
