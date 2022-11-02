package BUS;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DTO.Pair;
import DTO.TaiKhoan;
import GUI.DangNhapDialog;
import GUI.DoiMatKhauDialog;
import GUI.MainFrame;
import GUI.TimKiemSachFrame;

public class TaiKhoanController {
	private JTextField jtfTenDangNhap;
	private JPasswordField jtfMatKhau;
	private JDialog dialog;
	private JButton jbtnDangNhap, jbtnThoat, jbtnTimKiem;
	private JLabel jlbMsg, jlbShow, jlbQuenMatKhau;

	private TaiKhoanService tkService = null;

	public TaiKhoanController(JTextField jtfTenDangNhap, JPasswordField jtfMatKhau, JDialog dialog,
			JButton jbtnDangNhap, JButton jbtnThoat, JButton jbtnTimKiem, JLabel jlbMsg, JLabel jlbShow,
			JLabel jlbQuenMatKhau) {
		super();
		this.jtfTenDangNhap = jtfTenDangNhap;
		this.jtfMatKhau = jtfMatKhau;
		this.dialog = dialog;
		this.jbtnDangNhap = jbtnDangNhap;
		this.jbtnThoat = jbtnThoat;
		this.jbtnTimKiem = jbtnTimKiem;
		this.jlbMsg = jlbMsg;
		this.jlbShow = jlbShow;
		this.jlbQuenMatKhau = jlbQuenMatKhau;

		this.tkService = new TaiKhoanServiceImp();
	}

	public TaiKhoanController() {
		super();

	}

	public JTextField getJtfTenDangNhap() {
		return jtfTenDangNhap;
	}

	public void setJtfTenDangNhap(JTextField jtfTenDangNhap) {
		this.jtfTenDangNhap = jtfTenDangNhap;
	}

	public JTextField getJtfMatKhau() {
		return jtfMatKhau;
	}

	public void setJtfMatKhau(JPasswordField jtfMatKhau) {
		this.jtfMatKhau = jtfMatKhau;
	}

	public JDialog getDialog() {
		return dialog;
	}

	public void setDialog(JDialog dialog) {
		this.dialog = dialog;
	}

	public JButton getJbtnDangNhap() {
		return jbtnDangNhap;
	}

	public void setJbtnDangNhap(JButton jbtnDangNhap) {
		this.jbtnDangNhap = jbtnDangNhap;
	}

	public JButton getJbtnThoat() {
		return jbtnThoat;
	}

	public void setJbtnThoat(JButton jbtnThoat) {
		this.jbtnThoat = jbtnThoat;
	}

	public JButton getJbtnTimKiem() {
		return jbtnTimKiem;
	}

	public void setJbtnTimKiem(JButton jbtnTimKiem) {
		this.jbtnTimKiem = jbtnTimKiem;
	}

	int loaiMatKhau = 1; // loaiMatKhau = 1 (* : vd : ***) , 0 (a : vd : abc1111)

	public void setEvent() {

//		Chuoi su kien khi click cac nut Button
		jbtnThoat.addMouseListener(new ClassEvent("Thoat", jbtnThoat));
		jbtnDangNhap.addMouseListener(new ClassEvent("Dang Nhap", jbtnDangNhap));
		jbtnTimKiem.addMouseListener(new ClassEvent("Tim Kiem", jbtnTimKiem));

//		Tao su kien khi enter tai Mat Khau de Dang Nhap
		jtfMatKhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});

//		Tao su kien click chuot khi click vao Label show PassWord
		jlbShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				loaiMatKhau = (loaiMatKhau == 0) ? 1 : 0;
				if (jtfMatKhau.getEchoChar() == '*') {
					jlbShow.setToolTipText("Hiện mật khẩu");
					jtfMatKhau.setEchoChar((char) 0);
					jlbShow.setIcon(new ImageIcon(
							DangNhapDialog.class.getResource("/image/dangNhap/unShowPass_white_18dp.png")));
				} else {
					jtfMatKhau.setEchoChar('*');
					jlbShow.setToolTipText("Ẩn mật khẩu");
					jlbShow.setIcon(
							new ImageIcon(DangNhapDialog.class.getResource("/image/dangNhap/showPass_white_18dp.png")));
				}
			}
		});

//		Tao su kien khi nhan nut X khi tat Dialog Dang Nhap
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}
		});

//		Tao su kien khi click Quen mat khau?
		jlbQuenMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String tdn = jtfTenDangNhap.getText();
				if (tdn.length() == 0) {
					JOptionPane.showMessageDialog(null, "Bạn phải nhập Tên đăng nhập để xác định tài khoản trước!");
				} else {
					String cmnd = JOptionPane.showInputDialog("Hãy nhập 4 số cuối CMND của bạn :");
					if (cmnd.length() > 0) {
						TaiKhoan tk = tkService.checkPass(cmnd, tdn);
						if (tk.getTen_Dang_Nhap().compareTo("") == 0) {
							JOptionPane.showMessageDialog(null, "CMND ko đúng hoặc Tên đăng nhập đã sai!", null,
									JOptionPane.ERROR_MESSAGE);
						} else {
							DoiMatKhauDialog dmk = new DoiMatKhauDialog(null, true, tk);
							dmk.setViewQuenMk();
							dmk.setVisible(true);
						}
					}
				}
			}
		});
		jlbQuenMatKhau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	public class ClassEvent extends MouseAdapter {

		private String type = "";
		private JButton jbtn;

		public ClassEvent(String type, JButton jbtn) {
			super();
			this.type = type;
			this.jbtn = jbtn;
		}

		@Override
		public void mouseClicked(MouseEvent e) {

			switch (type) {
			case "Dang Nhap":
				login();
				break;
			case "Thoat":
				System.exit(0);
				break;

			case "Tim Kiem":
				dialog.dispose();
				TimKiemSachFrame frame = new TimKiemSachFrame();
				frame.setView();
				frame.setVisible(true);
				break;

			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {

			jbtn.setBackground(new Color(0, 153, 0));
			jbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseExited(MouseEvent e) {

			jbtn.setBackground(new Color(51, 102, 0));
//			jbtn.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}

	public void login() {
		String tdn = jtfTenDangNhap.getText(), mk = String.valueOf(jtfMatKhau.getPassword());
		Pair<TaiKhoan, String> pair = tkService.login(tdn, mk);
		TaiKhoan tk = pair.getK();
		if (tk.getTen_Dang_Nhap().equals("")) {
			jlbMsg.setText("Tài khoản không tồn tại!");
		} else if (!tk.isTinh_Trang()) {
			jlbMsg.setText("Tài khoản tạm thời bị khoá!");
		} else {
			tk.setNgay_dang_nhap(Calendar.getInstance().getTime());
			tkService.editTime(tk);
			MainFrame frame = new MainFrame(tk, pair.getV());
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setVisible(true);
			dialog.dispose();
		}
	}
}
