package BUS;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DTO.TaiKhoan;
import GUI.DangNhapDialog;



public class DoiMatKhauController {
	private JTextField jtfMaTaiKhoan, jtfTenDangNhap;
	private JPasswordField jpfMatKhau, jpfMatKhauMoi, jpfNhapLai;
	private JLabel jlbShowPw, jlbShowNewPw, jlbShowNhapLai, jlbMsgPw, jlbMsgNhapLai;
	private JButton jbtnDoiMatKhau, jbtnThoat;
	private JDialog dialog;

	private TaiKhoan tk = null;
	private TaiKhoanService tkService = null;

	public DoiMatKhauController(JTextField jtfMaTaiKhoan, JTextField jtfTenDangNhap, JPasswordField jpfMatKhau,
			JPasswordField jpfMatKhauMoi, JPasswordField jpfNhapLai, JLabel jlbShowPw, JLabel jlbShowNewPw,
			JLabel jlbShowNhapLai, JLabel jlbMsgPw, JLabel jlbMsgNhapLai, JButton jbtnDoiMatKhau, JButton jbtnThoat,
			JDialog dialog) {
		super();
		this.jtfMaTaiKhoan = jtfMaTaiKhoan;
		this.jtfTenDangNhap = jtfTenDangNhap;
		this.jpfMatKhau = jpfMatKhau;
		this.jpfMatKhauMoi = jpfMatKhauMoi;
		this.jpfNhapLai = jpfNhapLai;
		this.jlbShowPw = jlbShowPw;
		this.jlbShowNewPw = jlbShowNewPw;
		this.jlbShowNhapLai = jlbShowNhapLai;
		this.jbtnDoiMatKhau = jbtnDoiMatKhau;
		this.jbtnThoat = jbtnThoat;
		this.jlbMsgPw = jlbMsgPw;
		this.jlbMsgNhapLai = jlbMsgNhapLai;
		this.dialog = dialog;

		this.tkService = new TaiKhoanServiceImp();
	}

	public void setView(TaiKhoan tk) {
		this.tk = tk;

		jtfTenDangNhap.setText(tk.getTen_Dang_Nhap());
		jtfMaTaiKhoan.setText("#" + tk.getMa_Tai_Khoan());
		jtfMaTaiKhoan.setEnabled(false);
	}

	public void setEvent() {

//		Sét cursor cho các button và show passWord
		jbtnDoiMatKhau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnThoat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlbShowNewPw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlbShowPw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlbShowNhapLai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

//		Sét event cho cac button
		jbtnDoiMatKhau.addMouseListener(new ClassButtonMouseEvent("Doi", jbtnDoiMatKhau));
		jbtnThoat.addMouseListener(new ClassButtonMouseEvent("Thoat", jbtnThoat));

//		Sét event cho cac label show password
		jlbShowPw.addMouseListener(new ClassLabelMouseEvent(jlbShowPw, jpfMatKhau));
		jlbShowNewPw.addMouseListener(new ClassLabelMouseEvent(jlbShowNewPw, jpfMatKhauMoi));
		jlbShowNhapLai.addMouseListener(new ClassLabelMouseEvent(jlbShowNhapLai, jpfNhapLai));

	}

	public class ClassButtonMouseEvent extends MouseAdapter {
		private String type = "";
		private JButton jbtn;

		public ClassButtonMouseEvent(String type, JButton jbtn) {
			super();
			this.type = type;
			this.jbtn = jbtn;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			switch (type) {
			case "Doi":
				if (tk.getMat_Khau().compareTo(String.valueOf(jpfMatKhau.getPassword())) != 0) {
					jlbMsgPw.setText("Mật khẩu bạn nhập không đúng!");
					jpfMatKhau.setFocusable(true);
				} else {
					String pw = String.valueOf(jpfMatKhauMoi.getPassword());
					String pw2 = String.valueOf(jpfNhapLai.getPassword());
					if (pw.compareTo(pw2) != 0) {
						jlbMsgNhapLai.setText("Mật khẩu không trùng khớp!");
						jpfMatKhauMoi.setFocusable(true);
					} else {
						tk.setMat_Khau(pw);
						if (tkService.editPass(tk)) {
							JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!", null,
									JOptionPane.INFORMATION_MESSAGE);
							dialog.dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Đổi mật khẩu thất công!", null,
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				break;
			default:
				dialog.dispose();
				break;
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			jbtn.setBackground(new Color(51, 102, 0));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			jbtn.setBackground(new Color(0, 153, 0));
		}
	}

	public class ClassLabelMouseEvent extends MouseAdapter {
		private JLabel jlb;
		private JPasswordField jpf;

		public ClassLabelMouseEvent(JLabel jlb, JPasswordField jpf) {
			super();
			this.jlb = jlb;
			this.jpf = jpf;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (jpf.getEchoChar() == '*') {
				jlb.setToolTipText("Hiện mật khẩu");
				jpf.setEchoChar((char) 0);
				jlb.setIcon(
						new ImageIcon(DangNhapDialog.class.getResource("/image/dangNhap/unShowPass_white_18dp.png")));
			} else {
				jpf.setEchoChar('*');
				jlb.setToolTipText("Ẩn mật khẩu");
				jlb.setIcon(new ImageIcon(DangNhapDialog.class.getResource("/image/dangNhap/showPass_white_18dp.png")));
			}
		}
	}
}
