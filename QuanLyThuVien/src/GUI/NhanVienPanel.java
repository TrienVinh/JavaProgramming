package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.toedter.calendar.JDateChooser;

import BUS.QuanLyNhanVienController;
import javax.swing.ButtonGroup;

public class NhanVienPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfPhone;
	private JTextField jtfCMND;
	private JTextField jtfSearch;
	private JTextField jtfMaNV;
	private JTextField jtfHo;
	private JTextField jtfTen;
	private JTextField jtfEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public NhanVienPanel() {
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

		JMenuItem jmiRefresh = new JMenuItem("Refresh");
		popupMenu.add(jmiRefresh);

		jtfSearch = new JTextField();
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtfSearch.setColumns(10);
		GroupLayout gl_jpnRoot = new GroupLayout(jpnRoot);
		gl_jpnRoot.setHorizontalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
				.addComponent(jpnThongTin, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
				.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
				.addGroup(gl_jpnRoot.createSequentialGroup().addGap(5)
						.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(483, Short.MAX_VALUE)));
		gl_jpnRoot.setVerticalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnRoot.createSequentialGroup()
						.addComponent(jpnThongTin, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jpnView, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
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
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)));
		gl_jpnThongTin.setVerticalGroup(gl_jpnThongTin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnThongTin.createSequentialGroup()
						.addGroup(gl_jpnThongTin.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(56, Short.MAX_VALUE)));

		JLabel lblNgySinh = new JLabel("Ng??y Sinh :");
		lblNgySinh.setForeground(Color.WHITE);
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblaCh = new JLabel("?????a Ch??? :");
		lblaCh.setForeground(Color.WHITE);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblSinThoi = new JLabel("S??? ??i???n Tho???i :");
		lblSinThoi.setForeground(Color.WHITE);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfPhone = new JTextField();
		jtfPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfPhone.setColumns(10);

		JLabel lblCmnd = new JLabel("CMND :");
		lblCmnd.setForeground(Color.WHITE);
		lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfCMND = new JTextField();
		jtfCMND.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfCMND.setColumns(10);

		JButton btnXoa = new JButton("Xo??");
		btnXoa.setIcon(new ImageIcon(DocGiaPanel.class.getResource("/image/CRUD/Remove_black_24dp.png")));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnInBaoCao = new JButton("In B??o c??o");
		btnInBaoCao.setIcon(new ImageIcon(DocGiaPanel.class.getResource("/image/CRUD/Printblack_24dp.png")));
		btnInBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JDateChooser jdcNgaySinh = new JDateChooser();

		JTextArea jtaDiaChi = new JTextArea();
		jtaDiaChi.setWrapStyleWord(true);
		jtaDiaChi.setLineWrap(true);
		jtaDiaChi.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane.setViewportView(jtaDiaChi);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(41)
						.addComponent(lblNgySinh, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE).addGap(35)
						.addComponent(jdcNgaySinh, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup().addGap(41).addComponent(lblCmnd).addGap(69)
						.addComponent(jtfCMND, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup().addGap(51)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE).addGap(84)
						.addComponent(btnInBaoCao, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup().addGap(41).addGroup(gl_panel_1
						.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addGap(60).addComponent(scrollPane))
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
								.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addGap(10).addComponent(jtfPhone, GroupLayout.PREFERRED_SIZE, 289,
										GroupLayout.PREFERRED_SIZE)))));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(31)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNgySinh, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(jdcNgaySinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(10).addComponent(lblaCh))
								.addGroup(gl_panel_1.createSequentialGroup().addGap(9).addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
						.addGap(10)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(1).addComponent(lblSinThoi))
								.addComponent(jtfPhone, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblCmnd).addComponent(
								jtfCMND, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(14).addGroup(
								gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnInBaoCao, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE))));
		panel_1.setLayout(gl_panel_1);
		jpnThongTin.setLayout(gl_jpnThongTin);
		jpnRoot.setLayout(gl_jpnRoot);
		setLayout(groupLayout);

		JLabel lblMNhnVin = new JLabel("M?? NV :");
		lblMNhnVin.setForeground(Color.WHITE);
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfMaNV = new JTextField();
		jtfMaNV.setEditable(false);
		jtfMaNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfMaNV.setColumns(10);

		JLabel lblHTn = new JLabel("H??? :");
		lblHTn.setForeground(Color.WHITE);
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfHo = new JTextField();
		jtfHo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfHo.setColumns(10);

		JLabel lblTn = new JLabel("T??n: ");
		lblTn.setForeground(Color.WHITE);
		lblTn.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfTen = new JTextField();
		jtfTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfTen.setColumns(10);

		JLabel lblGiiTnh = new JLabel("Gi???i T??nh :");
		lblGiiTnh.setForeground(Color.WHITE);
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JRadioButton jrbNam = new JRadioButton("Nam");
		buttonGroup.add(jrbNam);
		jrbNam.setSelected(true);
		jrbNam.setForeground(Color.WHITE);
		jrbNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jrbNam.setBackground(new Color(51, 51, 51));

		JRadioButton jrbNu = new JRadioButton("N???");
		buttonGroup.add(jrbNu);
		jrbNu.setForeground(Color.WHITE);
		jrbNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jrbNu.setBackground(new Color(51, 51, 51));

		JLabel lblEmail = new JLabel("email :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jtfEmail = new JTextField();
		jtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfEmail.setColumns(10);

		JLabel lblChcV = new JLabel("Ch???c V??? :");
		lblChcV.setForeground(Color.WHITE);
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JComboBox<String> jcbChucVu = new JComboBox<String>();
		jcbChucVu.setModel(new DefaultComboBoxModel<String>(new String[] { "Nhan Vien", "Quan Ly" }));
		jcbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnThm = new JButton("Th??m");
		btnThm.setIcon(new ImageIcon(NhanVienPanel.class.getResource("/image/CRUD/Add_black_24dp.png")));
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnSa = new JButton("S???a");
		btnSa.setIcon(new ImageIcon(NhanVienPanel.class.getResource("/image/CRUD/edit2_black_24dp.png")));
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(33)
						.addComponent(lblMNhnVin, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE).addGap(35)
						.addComponent(jtfMaNV, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(33)
						.addComponent(lblHTn, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE).addGap(67)
						.addComponent(jtfHo, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE).addGap(10)
						.addComponent(lblTn).addGap(10)
						.addComponent(jtfTen, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(33)
						.addComponent(lblGiiTnh, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE).addGap(54)
						.addComponent(jrbNam, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(jrbNu, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(33)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE).addGap(54)
						.addComponent(jtfEmail, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(33)
						.addComponent(lblChcV, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE).addGap(23)
						.addComponent(jcbChucVu, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(72)
						.addComponent(btnThm, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE).addGap(94)
						.addComponent(btnSa, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(31)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblMNhnVin).addComponent(jtfMaNV,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(8)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblHTn)
						.addGroup(gl_panel.createSequentialGroup().addGap(2).addComponent(jtfHo,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addGap(2).addComponent(lblTn))
						.addGroup(gl_panel.createSequentialGroup().addGap(2).addComponent(jtfTen,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(6)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblGiiTnh).addComponent(jrbNam)
						.addComponent(jrbNu))
				.addGap(6)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblEmail).addComponent(jtfEmail,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(10)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblChcV).addComponent(jcbChucVu,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(10)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThm, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSa, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))));
		panel.setLayout(gl_panel);

		QuanLyNhanVienController control = new QuanLyNhanVienController(jtfMaNV, jtfPhone, jtfCMND, jtfHo, jtfEmail,
				jtaDiaChi, jcbChucVu, jrbNam, jrbNu, jdcNgaySinh, btnThm, btnSa, btnXoa, btnInBaoCao, jpnView,
				jmiRefresh, jtfSearch, jtfTen);
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
