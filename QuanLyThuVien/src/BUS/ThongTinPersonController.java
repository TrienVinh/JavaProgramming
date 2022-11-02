package BUS;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DTO.Person;

public class ThongTinPersonController {
	private JTextField jtfMa, jtfTen, jtfCMND, jtfNgaySinh, jtfNgheNghiep, jtfSDT, jtfEmail;
	private JTextArea jtaDiaChi;
	private JLabel jlbTitle, jlbMa, jlbNgheNghiep;
	private JRadioButton jrbNu;
	private JButton jbtnThoat;
	private JDialog dialog;

	public ThongTinPersonController(JTextField jtfMa, JTextField jtfTen, JTextField jtfCMND, JTextField jtfNgaySinh,
			JTextField jtfNgheNghiep, JTextField jtfSDT, JTextArea jtaDiaChi, JLabel jlbTitle, JLabel jlbMa,
			JLabel jlbNgheNghiep, JRadioButton jrbNu, JButton jbtnThoat, JDialog dialog, JTextField jtfEmail) {
		super();
		this.jtfMa = jtfMa;
		this.jtfTen = jtfTen;
		this.jtfCMND = jtfCMND;
		this.jtfNgaySinh = jtfNgaySinh;
		this.jtfNgheNghiep = jtfNgheNghiep;
		this.jtfSDT = jtfSDT;
		this.jtaDiaChi = jtaDiaChi;
		this.jlbTitle = jlbTitle;
		this.jlbMa = jlbMa;
		this.jlbNgheNghiep = jlbNgheNghiep;
		this.jrbNu = jrbNu;
		this.jbtnThoat = jbtnThoat;
		this.dialog = dialog;
		this.jtfEmail = jtfEmail;
	}

	public <E> void setView(E item) {
		Person dg = (Person) item;
		if (dg.getMa_Doi_Tuong().contains("NV")) {
			jlbTitle.setText("THÔNG TIN NHÂN VIÊN");
			jlbMa.setText("Mã NV:");
			jlbNgheNghiep.setText("Chức Vụ: ");

		} else {
			jlbTitle.setText("THÔNG TIN KHÁCH HÀNG");
			jlbMa.setText("Mã KH:");
			jlbNgheNghiep.setText("Nghề Nghiệp: ");

		}

		jtfMa.setText(dg.getMa_Doi_Tuong());
		jtfTen.setText(dg.getHo_Ten());
		jtfCMND.setText(dg.getCMND());
		jtfNgaySinh.setText(new SimpleDateFormat("dd/MM/yyyy").format(dg.getNgay_Sinh()));
		jtfNgheNghiep.setText(dg.getChuc_Vu());
		jtfSDT.setText(dg.getSo_Dien_Thoai());
		jtfEmail.setText(dg.getEmail());
		jtaDiaChi.setText(dg.getDia_Chi());
		jrbNu.setSelected(!dg.isGioi_Tinh());

		jtfMa.setEditable(false);
		jtfCMND.setEditable(false);
		jtfNgaySinh.setEditable(false);
		jtfNgheNghiep.setEditable(false);
		jtfSDT.setEditable(false);
		jtfTen.setEditable(false);
		jtfEmail.setEditable(false);
		jtaDiaChi.setEditable(false);
	}

	public void setEvent() {
		jbtnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				dialog.dispose();
			}
		});
	}
}
