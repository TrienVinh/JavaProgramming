package DTO;

import BUS.ClassSupport;

public class NhaXuatBan {
	private int ma_NXB;
	private String ho_Ten, dia_Chi, email;

	private static int sId = 1000;
	private final static String ma = "NXB";

	public NhaXuatBan() {
		super();
		// TODO Auto-generated constructor stub
		ma_NXB = sId++;
	}

	public NhaXuatBan(String ma_NXB) {
		super();
		// TODO Auto-generated constructor stub
		setMa_NXB(ma_NXB);
	}

	public NhaXuatBan(int ma_NXB, String ho_Ten, String dia_Chi, String email) {
		super();
		this.ma_NXB = ma_NXB;
		this.ho_Ten = ho_Ten;
		this.dia_Chi = dia_Chi;
		this.email = email;
	}

	public NhaXuatBan(String ma_NXB, String ho_Ten, String dia_Chi, String email) {
		super();
		setMa_NXB(ma_NXB);
		this.ho_Ten = ho_Ten;
		this.dia_Chi = dia_Chi;
		this.email = email;
	}

	public String getMa_NXB() {
		return ma + ma_NXB;
	}

	public void setMa_NXB(String ma_NXB) {
		this.ma_NXB = Integer.parseInt(ClassSupport.findString(ma_NXB, "(\\d+)"));
	}

	public String getHo_Ten() {
		return ho_Ten;
	}

	public void setHo_Ten(String ho_Ten) {
		this.ho_Ten = ho_Ten;
	}

	public String getDia_Chi() {
		return dia_Chi;
	}

	public void setDia_Chi(String dia_Chi) {
		this.dia_Chi = dia_Chi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		NhaXuatBan.sId = sId;
	}

}
