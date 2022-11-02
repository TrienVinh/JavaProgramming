package DTO;

import BUS.ClassSupport;

public class NgonNgu {
	private int ma_Ngon_Ngu;
	private String ten_Ngon_Ngu;

	private static final String ma = "NN";
	private static int sId = 1000;

	public NgonNgu(int ma_Ngon_Ngu, String ten_Ngon_Ngu) {
		super();
		this.ma_Ngon_Ngu = ma_Ngon_Ngu;
		this.ten_Ngon_Ngu = ten_Ngon_Ngu;
	}

	public NgonNgu(String ma_Ngon_Ngu, String ten_Ngon_Ngu) {
		super();
		setMa_Ngon_Ngu(ma_Ngon_Ngu);
		this.ten_Ngon_Ngu = ten_Ngon_Ngu;
	}

	public NgonNgu() {
		super();
		// TODO Auto-generated constructor stub
		this.ma_Ngon_Ngu = sId++;
	}

	public NgonNgu(String ma_ngon_ngu) {
		super();
		// TODO Auto-generated constructor stub
		setMa_Ngon_Ngu(ma_ngon_ngu);
	}

	public String getMa_Ngon_Ngu() {
		return ma + ma_Ngon_Ngu;
	}

	public void setMa_Ngon_Ngu(int ma_Ngon_Ngu) {
		this.ma_Ngon_Ngu = ma_Ngon_Ngu;
	}

	public void setMa_Ngon_Ngu(String ma_Ngon_Ngu) {
		this.ma_Ngon_Ngu = Integer.parseInt(ClassSupport.findString(ma_Ngon_Ngu, "(\\d+)"));
	}

	public String getTen_Ngon_Ngu() {
		return ten_Ngon_Ngu;
	}

	public void setTen_Ngon_Ngu(String ten_Ngon_Ngu) {
		this.ten_Ngon_Ngu = ten_Ngon_Ngu;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		NgonNgu.sId = sId;
	}

}
