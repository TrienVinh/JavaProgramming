package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import BUS.ChuyenManHinhController;
import DTO.DanhMucBean;
import DTO.TaiKhoan;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton jbtnQuanLyDocGia, jbtnQuanLyNhanVien;
	private JLabel jlbName;

	public static void main(String[] args) {
		new MainFrame(null, null).setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public MainFrame(TaiKhoan tk, String tdn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1363, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel jpnRoot = new JPanel();
		jpnRoot.setBackground(new Color(51, 51, 51));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(jpnRoot,
				GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(jpnRoot,
				GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));

		JPanel jpnHeader = new JPanel();
		jpnHeader.setBackground(new Color(51, 51, 51));

		JPanel jpnView = new JPanel();
		GroupLayout gl_jpnRoot = new GroupLayout(jpnRoot);
		gl_jpnRoot.setHorizontalGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
				.addComponent(jpnHeader, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_jpnRoot.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE).addGap(10)
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE).addContainerGap()));
		gl_jpnRoot.setVerticalGroup(gl_jpnRoot.createParallelGroup(Alignment.TRAILING).addGroup(gl_jpnRoot
				.createSequentialGroup().addComponent(jpnHeader, GroupLayout.PREFERRED_SIZE, 72, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_jpnRoot.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 715, Short.MAX_VALUE)
						.addComponent(jpnView, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
				.addContainerGap()));

		JLabel lblXinCho = new JLabel("Xin Chào  : ");
		lblXinCho.setForeground(new Color(255, 255, 255));
		lblXinCho.setFont(new Font("Tahoma", Font.PLAIN, 22));

		jlbName = new JLabel("abc");
		jlbName.setForeground(new Color(255, 255, 255));
		jlbName.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JButton jbtnDangXuat = new JButton("Đăng xuất");
		jbtnDangXuat.setIcon(new ImageIcon(MainFrame.class.getResource("/image/mainFrame/logout_white_24dp.png")));
		jbtnDangXuat.setBorder(null);
		jbtnDangXuat.setBackground(new Color(51, 51, 51));
		jbtnDangXuat.setForeground(new Color(255, 255, 255));
		jbtnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton jbtnDoiMatKhau = new JButton("Đổi mật khẩu");
		jbtnDoiMatKhau
				.setIcon(new ImageIcon(MainFrame.class.getResource("/image/mainFrame/DoiMatKhau_white_24dp.png")));
		jbtnDoiMatKhau.setForeground(Color.WHITE);
		jbtnDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jbtnDoiMatKhau.setBorder(null);
		jbtnDoiMatKhau.setBackground(new Color(51, 51, 51));
		GroupLayout gl_jpnHeader = new GroupLayout(jpnHeader);
		gl_jpnHeader.setHorizontalGroup(gl_jpnHeader.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpnHeader.createSequentialGroup().addContainerGap().addComponent(lblXinCho).addGap(37)
						.addComponent(jlbName, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 521, Short.MAX_VALUE)
						.addComponent(jbtnDoiMatKhau, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(jbtnDangXuat, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_jpnHeader.setVerticalGroup(gl_jpnHeader.createParallelGroup(Alignment.LEADING).addGroup(gl_jpnHeader
				.createSequentialGroup().addGap(10)
				.addGroup(gl_jpnHeader.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpnHeader.createParallelGroup(Alignment.BASELINE).addComponent(jlbName)
								.addComponent(lblXinCho, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpnHeader.createParallelGroup(Alignment.BASELINE)
								.addComponent(jbtnDangXuat, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE).addComponent(
										jbtnDoiMatKhau, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		jpnHeader.setLayout(gl_jpnHeader);

		jbtnQuanLyDocGia = new JButton("Quản lý Độc giả");
		jbtnQuanLyDocGia
				.setIcon(new ImageIcon(MainFrame.class.getResource("/image/mainFrame/QuanLyDocGia_white_24dp.png")));
		jbtnQuanLyDocGia.setForeground(Color.WHITE);
		jbtnQuanLyDocGia.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jbtnQuanLyDocGia.setBorder(null);
		jbtnQuanLyDocGia.setBackground(new Color(51, 102, 0));

		jbtnQuanLyNhanVien = new JButton("Quản lý Nhân viên");
		jbtnQuanLyNhanVien
				.setIcon(new ImageIcon(MainFrame.class.getResource("/image/mainFrame/QuanLyNhanVien_white_24dp.png")));
		jbtnQuanLyNhanVien.setForeground(Color.WHITE);
		jbtnQuanLyNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jbtnQuanLyNhanVien.setBorder(null);
		jbtnQuanLyNhanVien.setBackground(new Color(51, 102, 0));

		JButton jbtnQuanLySach = new JButton("Quản lý Sách");
		jbtnQuanLySach
				.setIcon(new ImageIcon(MainFrame.class.getResource("/image/mainFrame/QuanLySach_white_24dp.png")));
		jbtnQuanLySach.setForeground(Color.WHITE);
		jbtnQuanLySach.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jbtnQuanLySach.setBorder(null);
		jbtnQuanLySach.setBackground(new Color(51, 102, 0));

		JButton jbtnQuanLyPhieuMuon = new JButton("Quản lý Phiếu mượn");
		jbtnQuanLyPhieuMuon
				.setIcon(new ImageIcon(MainFrame.class.getResource("/image/mainFrame/QuanLyPhieuMuon_white_24dp.png")));
		jbtnQuanLyPhieuMuon.setForeground(Color.WHITE);
		jbtnQuanLyPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jbtnQuanLyPhieuMuon.setBorder(null);
		jbtnQuanLyPhieuMuon.setBackground(new Color(51, 102, 0));

		JButton jbtnThongKe = new JButton("Thống kê dữ liệu");
		jbtnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbtnThongKe.setIcon(new ImageIcon(MainFrame.class.getResource("/image/mainFrame/menuItem5_white_24dp.png")));
		jbtnThongKe.setForeground(Color.WHITE);
		jbtnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jbtnThongKe.setBorder(null);
		jbtnThongKe.setBackground(new Color(51, 102, 0));

		JButton jbtnTaiKhoan = new JButton("Quản Lý Tài Khoản");
		jbtnTaiKhoan.setIcon(new ImageIcon(MainFrame.class.getResource("/image/mainFrame/TaiKhoan_white_24dp.png")));
		jbtnTaiKhoan.setForeground(Color.WHITE);
		jbtnTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jbtnTaiKhoan.setBorder(null);
		jbtnTaiKhoan.setBackground(new Color(51, 102, 0));

		JButton jbtnTimKIem = new JButton("Tìm Kiếm Sách");
		jbtnTimKIem.setIcon(new ImageIcon(MainFrame.class.getResource("/image/dangNhap/iconSearch_white_18dp.png")));
		jbtnTimKIem.setForeground(Color.WHITE);
		jbtnTimKIem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jbtnTimKIem.setBorder(null);
		jbtnTimKIem.setBackground(new Color(51, 102, 0));

		JButton jbtnPhieuNhap = new JButton("Quản lý Phiếu nhập");
		jbtnPhieuNhap
				.setIcon(new ImageIcon(MainFrame.class.getResource("/image/mainFrame/QuanLyPhieuMuon_white_24dp.png")));
		jbtnPhieuNhap.setForeground(Color.WHITE);
		jbtnPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jbtnPhieuNhap.setBorder(null);
		jbtnPhieuNhap.setBackground(new Color(51, 102, 0));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(jbtnQuanLyDocGia, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
								.addComponent(jbtnQuanLyNhanVien, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(jbtnQuanLyPhieuMuon, GroupLayout.PREFERRED_SIZE, 275,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(jbtnThongKe, GroupLayout.PREFERRED_SIZE, 275,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(jbtnTaiKhoan, GroupLayout.PREFERRED_SIZE, 275,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(jbtnTimKIem, GroupLayout.PREFERRED_SIZE, 275,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(jbtnQuanLySach, GroupLayout.PREFERRED_SIZE, 275,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(jbtnPhieuNhap, GroupLayout.PREFERRED_SIZE, 275,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addComponent(jbtnQuanLySach, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE).addGap(15)
				.addComponent(jbtnQuanLyDocGia, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE).addGap(15)
				.addComponent(jbtnQuanLyNhanVien, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE).addGap(15)
				.addComponent(jbtnPhieuNhap, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE).addGap(15)
				.addComponent(jbtnQuanLyPhieuMuon, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
				.addGap(15).addComponent(jbtnThongKe, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
				.addGap(15).addComponent(jbtnTaiKhoan, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
				.addGap(15).addComponent(jbtnTimKIem, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		jpnRoot.setLayout(gl_jpnRoot);
		contentPane.setLayout(gl_contentPane);

		jlbName.setText(tdn);

		// Phan quyen cho nhan vien hoac admin
//		if (!tk.isAdmin()) {
//			jbtnQuanLyDocGia.setEnabled(false);
//			jbtnQuanLyNhanVien.setEnabled(false);
//		}
//		jlbName.setText("");

		List<DanhMucBean> listItem = new ArrayList<>();
		listItem.add(new DanhMucBean("Doc Gia", jbtnQuanLyDocGia));
		listItem.add(new DanhMucBean("Nhan Vien", jbtnQuanLyNhanVien));
		listItem.add(new DanhMucBean("Sach", jbtnQuanLySach));
		listItem.add(new DanhMucBean("Phieu Muon", jbtnQuanLyPhieuMuon));
		listItem.add(new DanhMucBean("Phieu Nhap", jbtnPhieuNhap));
		listItem.add(new DanhMucBean("Thong Ke", jbtnThongKe));
		listItem.add(new DanhMucBean("Tai Khoan", jbtnTaiKhoan));
		listItem.add(new DanhMucBean("Tim Kiem", jbtnTimKIem));

		ChuyenManHinhController control = new ChuyenManHinhController(jpnView, jbtnDoiMatKhau, jbtnDangXuat, this,
				tk.getMa_Nhan_Vien());
		control.setView(jbtnTimKIem);
		control.setEvent(listItem, tk);
	}
}
