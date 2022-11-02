package DTO;

import BUS.ClassSupport;

public class NhaCungCap {
	private int ma_NCC;
	private String ho_Ten, dia_Chi, email;

	private static int sId = 1000;
	private final static String ma = "NCC";

	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
		ma_NCC = sId++;
	}

	public NhaCungCap(String ma_NCC) {
		super();
		// TODO Auto-generated constructor stub
		setMa_NCC(ma_NCC);
	}

	public NhaCungCap(int ma_NCC, String ho_Ten, String dia_Chi, String email) {
		super();
		this.ma_NCC = ma_NCC;
		this.ho_Ten = ho_Ten;
		this.dia_Chi = dia_Chi;
		this.email = email;
	}

	public NhaCungCap(String ma_NCC, String ho_Ten, String dia_Chi, String email) {
		super();
		setMa_NCC(ma_NCC);
		this.ho_Ten = ho_Ten;
		this.dia_Chi = dia_Chi;
		this.email = email;
	}

	public String getMa_NCC() {
		return ma + ma_NCC;
	}

	public void setMa_NCC(String ma_NCC) {
		this.ma_NCC = Integer.parseInt(ClassSupport.findString(ma_NCC, "(\\d+)"));
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
		NhaCungCap.sId = sId;
	}

}
