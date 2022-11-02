package DTO;

import java.util.Date;

public class Person {
	private String ma_Doi_Tuong;
	private String ho, ten, so_Dien_Thoai, dia_Chi, CMND, email, chuc_Vu;
	private Date ngay_Sinh;
	private boolean gioi_Tinh;

	public Person(String ma_Nhan_Vien, String ho, String so_Dien_Thoai, String dia_Chi, String cMND, String email,
			String chuc_Vu, Date ngay_Sinh, boolean gioi_Tinh, String ten) {
		super();
		this.ma_Doi_Tuong = ma_Nhan_Vien;
		this.ho = ho;
		this.so_Dien_Thoai = so_Dien_Thoai;
		this.dia_Chi = dia_Chi;
		this.CMND = cMND;
		this.email = email;
		this.chuc_Vu = chuc_Vu;
		this.ngay_Sinh = ngay_Sinh;
		this.gioi_Tinh = gioi_Tinh;
		this.ten = ten;
	}

	public Person(String ma_Doi_Tuong) {
		super();
		// TODO Auto-generated constructor stub
		this.ma_Doi_Tuong = ma_Doi_Tuong;
	}

	public String getMa_Doi_Tuong() {
		return ma_Doi_Tuong;
	}

	public void setMa_Doi_Tuong(String ma_Doi_Tuong) {
		this.ma_Doi_Tuong = ma_Doi_Tuong;
	}

	public String getChuc_Vu() {
		return chuc_Vu;
	}

	public void setChuc_Vu(String chuc_Vu) {
		this.chuc_Vu = chuc_Vu;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getSo_Dien_Thoai() {
		return so_Dien_Thoai;
	}

	public void setSo_Dien_Thoai(String so_Dien_Thoai) {
		this.so_Dien_Thoai = so_Dien_Thoai;
	}

	public String getDia_Chi() {
		return dia_Chi;
	}

	public void setDia_Chi(String dia_Chi) {
		this.dia_Chi = dia_Chi;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNgay_Sinh() {
		return ngay_Sinh;
	}

	public void setNgay_Sinh(Date ngay_Sinh) {
		this.ngay_Sinh = ngay_Sinh;
	}

	public boolean isGioi_Tinh() {
		return gioi_Tinh;
	}

	public void setGioi_Tinh(boolean gioi_Tinh) {
		this.gioi_Tinh = gioi_Tinh;
	}

	public String getHo_Ten() {
		return ho + " "+ ten;
	}
}
