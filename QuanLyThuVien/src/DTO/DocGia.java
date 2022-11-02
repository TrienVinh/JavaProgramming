package DTO;

import java.util.Date;

import BUS.ClassSupport;

public class DocGia extends Person {
	private final static String ma = "DG";
	private static int sId = 1000;

	public DocGia(String ma_Doc_Gia, String ho, String so_Dien_Thoai, String dia_Chi, String cMND, String email,
			String chuc_Vu, Date ngay_Sinh, boolean gioi_Tinh, String ten) {
		super(ma_Doc_Gia, ho, so_Dien_Thoai, dia_Chi, cMND, email, chuc_Vu, ngay_Sinh, gioi_Tinh, ten);
	}

	public DocGia() {
		super(getMa_Doc_Gia());
		// TODO Auto-generated constructor stub
		sId++;
	}

	public static String getMa_Doc_Gia() {
		return ma + sId;
	}

	public static int getsId() {
		return sId;
	}

	public static void setsId(int sId) {
		DocGia.sId = sId;
	}

	public static void setsId(String sId) {
		DocGia.sId = Integer.parseInt(ClassSupport.findString(sId, "(\\d+)")) + 1;
	}

	public String getMa() {
		return ma;
	}

}
