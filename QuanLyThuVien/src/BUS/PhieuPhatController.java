package BUS;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DTO.Pair;
import DTO.PhieuPhat;

public class PhieuPhatController {
	private JTextField jtfMaPM, jtfMaSach, jtfTenDG, jtfTenSach, jtfLyDo, jtfTienPhat;
	private JButton jbtnPhat, jbtnThoat;
	private JDialog dialog;
	private PhieuPhat phieuPhat;
	private Pair<String, String> pair; // chua ten DG va ten Sach;
	private Pair<Integer, Integer> sach; // sach<SoLuongPhat , GiaTienCuonSach>
	private Pair<Date, Date> date; // date<ngayTra , hanTra>

	private PhieuPhatService ppService;

	public PhieuPhatController(JTextField jtfMaPM, JTextField jtfMaSach, JTextField jtfTenDG, JTextField jtfTenSach,
			JTextField jtfLyDo, JTextField jtfTienPhat, JButton jbtnPhat, JButton jbtnThoat, JDialog dialog) {
		super();
		this.jtfMaPM = jtfMaPM;
		this.jtfMaSach = jtfMaSach;
		this.jtfTenDG = jtfTenDG;
		this.jtfTenSach = jtfTenSach;
		this.jtfLyDo = jtfLyDo;
		this.jtfTienPhat = jtfTienPhat;
		this.jbtnPhat = jbtnPhat;
		this.jbtnThoat = jbtnThoat;
		this.dialog = dialog;

		ppService = new PhieuPhatServiceImp();
	}

	public void setData(Pair<Integer, Integer> sach, Pair<Date, Date> date) {

		this.sach = sach;
		this.date = date;
	}

	public void setEditable(boolean check) {
		jtfMaPM.setEditable(check);
		jtfLyDo.setEditable(check);
		jtfMaSach.setEditable(check);
		jtfTenDG.setEditable(check);
		jtfTenSach.setEditable(check);

	}

	public void setView(PhieuPhat pp, Pair<String, String> pair) {
		this.phieuPhat = pp;
		this.pair = pair;

		jtfMaPM.setText(phieuPhat.getMa_Phieu_Muon());

		jtfMaSach.setText(phieuPhat.getMa_Sach());

		jtfLyDo.setText(phieuPhat.getLy_Do());

		jtfTenDG.setText(this.pair.getK());

		jtfTenSach.setText(this.pair.getV());

		if (pp.getTien_Phat() == 0) {
			int tienPhat = 0;
			String[] banned = phieuPhat.getLy_Do().split(", ");
			for (String string : banned) {
				switch (string) {
				case "Hư Hại Sách":
				case "Mất Sách":
					tienPhat += sach.getK() * sach.getV();
					break;
				case "Trễ Hạn":
					tienPhat += 1000 * getTreHan(date.getK(), date.getV());

				}
			}

			jtfTienPhat.setText(tienPhat + "");
		} else
			jtfTienPhat.setText(pp.getTien_Phat() + "");
	}

	public void setEvent() {
		jbtnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				dialog.dispose();
			}
		});

		jbtnPhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String tienTra = JOptionPane.showInputDialog("Nhập tiền phạt!");
				int tienPhat = Integer.parseInt(jtfTienPhat.getText());
				int tienDong = Integer.parseInt(tienTra);

				JOptionPane.showMessageDialog(null, "Số tiền trả lại: " + (tienDong - tienPhat));
				phieuPhat.setTien_Phat(tienPhat);
				if (ppService.addPhieuPhat(phieuPhat)) {
					dialog.dispose();
				}
			}
		});
	}

	public int getTreHan(Date ngayTra, Date hanTra) {

		Date date1 = null;
		Date date2 = null;
		try {

			date1 = ngayTra;
			date2 = hanTra;

			long getDiff = date1.getTime() - date2.getTime();

//			long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);

			// 24 hours = 1 day
			// 60 minutes = 1 hour
			// 60 seconds = 1 minute
			// 1000 milliseconds = 1 second
			long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);

			return (int) Math.abs(getDaysDiff);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	// Cach2

//	public  int getTime(String dateTra, String dateHan) {
//		int[] tra = getIntFromString(dateTra, "/");
//		int[] han = getIntFromString(dateHan, "/");
//		int time = 0;
//		if (tra[2] > han[2]) { // tra[2] = 2020 - 1900 = 120;
//			time = (isNamNhuan(tra[2])) ? 365 : 364;
//		}
//
////		dateTra.setMonth((tra[1]() == 12) ? 12 : tra[1]());
////		dateHan.setMonth((han[1] == 12) ? 12 : han[1]);
////		dateTra.setMonth(12);
//		int thangHan = han[1], thangTra = tra[1];
//		if (thangTra == thangHan) {
//			time -= tra[0] - han[0];
//		} else if (thangTra > thangHan) {
//			int dayHan = 0;
//
//			while (++thangHan < thangTra) {
//				dayHan += getDateFromMonth(thangHan, han[2]);
//
//			}
//			time += dayHan + (getDateFromMonth(han[1], han[2]) - han[0] + tra[0]);
//
//		} else {
//			int dayHan = 0;
//
//			while (++thangTra < thangHan) {
//				// Lay nam cua date nao cung dc vi luc nay ko xet theo year , den cuoi cung xet
//				// thang 2 cua nam lon nhat de + them 1;
//				dayHan += getDateFromMonth(thangTra, han[2]);
//
//			}
//			time -= dayHan + (getDateFromMonth(tra[1], tra[2]) - tra[0] + han[0]);
//		}
//		time = Math.abs(time);
//		return time;
//	}
//
//	public static int getDateFromMonth(int month, int year) {
//		switch (month) {
//		case 1:
//		case 3:
//		case 5:
//		case 7:
//		case 8:
//		case 10:
//		case 12:
//			return 31;
//		case 4:
//		case 6:
//		case 9:
//		case 11:
//			return 30;
//		case 2:
//			if (isNamNhuan(year)) {
//				return 29;
//			} else
//				return 28;
//		default:
//			break;
//		}
//		return 0;
//	}
//
//	public static boolean isNamNhuan(int year) {
//		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
//	}
//
//	public static int[] getIntFromString(String string, String split) {
//		String[] temp = string.split(split);
//		int[] so = new int[temp.length];
//		for (int i = 0; i < temp.length; i++) {
//			so[i] = Integer.parseInt(temp[i]);
//		}
//		return so;
//	}
}
