package DTO;

import java.util.Date;

public class NhanVien extends Person {
	private final static String ma = "NV";
	private static int sId = 1000;

	public NhanVien(String ma_Nhan_Vien, String ho, String so_Dien_Thoai, String dia_Chi, String cMND, String email,
			String chuc_Vu, Date ngay_Sinh, boolean gioi_Tinh, String ten) {
		super(ma_Nhan_Vien, ho, so_Dien_Thoai, dia_Chi, cMND, email, chuc_Vu, ngay_Sinh, gioi_Tinh, ten);
		// TODO Auto-generated constructor stub
	}

	public NhanVien() {
		super(getMa_Nhan_Vien());
		// TODO Auto-generated constructor stub
		sId++;
	}

	public static String getMa_Nhan_Vien() {
		return ma + sId;
	}

	public static int getsId() {
		return sId;
	}

	public static void setsId(int sId) {
		NhanVien.sId = sId;
	}

}
