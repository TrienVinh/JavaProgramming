package DTO;

import BUS.ClassSupport;

public class TacGia {

	private int ma_Tac_Gia;
	private String ho_Ten, dia_Chi, email;

	private static int sId = 1000;
	private final static String ma = "TG";

	public TacGia(int ma_Tac_Gia, String ho_Ten, String dia_Chi, String email) {
		super();
		this.ma_Tac_Gia = ma_Tac_Gia;
		this.ho_Ten = ho_Ten;
		this.dia_Chi = dia_Chi;
		this.email = email;
	}

	public TacGia(String ma_Tac_Gia, String ho_Ten, String dia_Chi, String email) {
		super();
		setMa_Tac_Gia(ma_Tac_Gia);
		this.ho_Ten = ho_Ten;
		this.dia_Chi = dia_Chi;
		this.email = email;
	}

	public TacGia() {
		super();
		// TODO Auto-generated constructor stub
		this.ma_Tac_Gia = sId++;
	}

	public TacGia(String maTG) {
		super();
		// TODO Auto-generated constructor stub
		setMa_Tac_Gia(maTG);
	}

	public String getMa_Tac_Gia() {
		return ma + ma_Tac_Gia;
	}

	public void setMa_Tac_Gia(String ma_Tac_Gia) {
		this.ma_Tac_Gia = Integer.parseInt(ClassSupport.findString(ma_Tac_Gia, "(\\d+)"));
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
		TacGia.sId = sId;
	}

}
