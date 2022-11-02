package DTO;

public class ChiTietPhieuNhap {
	private String maPN, maSach;
	private int so_Luong, tong_Gia_Tien;

	public ChiTietPhieuNhap(String maPN, String maSach, int so_Luong, int tong_Gia_Tien) {
		super();
		this.maPN = maPN;
		this.maSach = maSach;
		this.so_Luong = so_Luong;
		this.tong_Gia_Tien = tong_Gia_Tien;
	}

	public ChiTietPhieuNhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaPN() {
		return maPN;
	}

	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public int getSo_Luong() {
		return so_Luong;
	}

	public void setSo_Luong(int so_Luong) {
		this.so_Luong = so_Luong;
	}

	public int getTong_Gia_Tien() {
		return tong_Gia_Tien;
	}

	public void setTong_Gia_Tien(int tong_Gia_Tien) {
		this.tong_Gia_Tien = tong_Gia_Tien;
	}

}
