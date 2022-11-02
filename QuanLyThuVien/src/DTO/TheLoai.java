package DTO;

import BUS.ClassSupport;

public class TheLoai {
	private int ma_The_Loai;
	private String ten_The_Loai;

	private final static String ma = "TL";
	private static int sId = 1000;

	public TheLoai(int ma_The_Loai, String ten_The_Loai) {
		super();
		this.ma_The_Loai = ma_The_Loai;
		this.ten_The_Loai = ten_The_Loai;
	}

	public TheLoai() {
		super();
		this.ma_The_Loai = sId++;
	}

	public TheLoai(String maTheLoai) {
		super();
		setMa_The_Loai(maTheLoai);
	}

	public String getMa_The_Loai() {
		return ma + ma_The_Loai;
	}

	public void setMa_The_Loai(String ma_The_Loai) {
		this.ma_The_Loai = Integer.parseInt(ClassSupport.findString(ma_The_Loai, "(\\d+)"));
	}

	public void setMa_The_Loai(int ma_The_Loai) {
		this.ma_The_Loai = ma_The_Loai;
	}

	public String getTen_The_Loai() {
		return ten_The_Loai;
	}

	public void setTen_The_Loai(String ten_The_Loai) {
		this.ten_The_Loai = ten_The_Loai;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		TheLoai.sId = sId;
	}

}
