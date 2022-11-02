package DTO;

import BUS.ClassSupport;

public class Sach {

	private int ma_Sach, gia_Tien, so_Luong, so_Trang, namXB;
	private String ten_Sach, ma_Tac_Gia, the_Loai, ma_NXB, ma_Vi_Tri, ngon_Ngu;

	private static int sId = 1000;
	private final static String ma = "S";

	public Sach(int ma_Sach, int gia_Tien, int so_Luong, int so_Trang, String ten_Sach, String ma_Tac_Gia,
			String ma_The_Loai, String ma_NXB, String ma_Vi_Tri, String ngon_Ngu, int namXB) {
		super();
		this.ma_Sach = ma_Sach;
		this.gia_Tien = gia_Tien;
		this.so_Luong = so_Luong;
		this.so_Trang = so_Trang;
		this.ten_Sach = ten_Sach;
		this.ma_Tac_Gia = ma_Tac_Gia;
		this.the_Loai = ma_The_Loai;
		this.ma_NXB = ma_NXB;
		this.ma_Vi_Tri = ma_Vi_Tri;
		this.ngon_Ngu = ngon_Ngu;
		this.namXB = namXB;
	}

	public Sach(String ma_Sach, int gia_Tien, int so_Luong, int so_Trang, String ten_Sach, String ma_Tac_Gia,
			String ma_The_Loai, String ma_NXB, String ma_Vi_Tri, String ngon_Ngu, int namXB) {
		super();
		setMa_Sach(ma_Sach);
		this.gia_Tien = gia_Tien;
		this.so_Luong = so_Luong;
		this.so_Trang = so_Trang;
		this.ten_Sach = ten_Sach;
		this.ma_Tac_Gia = ma_Tac_Gia;
		this.the_Loai = ma_The_Loai;
		this.ma_NXB = ma_NXB;
		this.ma_Vi_Tri = ma_Vi_Tri;
		this.ngon_Ngu = ngon_Ngu;
		this.namXB = namXB;
	}

	public Sach() {
		super();
		this.ma_Sach = sId++;
		// TODO Auto-generated constructor stub
	}

	public Sach(String maSach) {
		super();
		// TODO Auto-generated constructor stub
		setMa_Sach(maSach);
	}

	public String getMa_Sach() {
		return ma + ma_Sach;
	}

	public void setMa_Sach(String ma_Sach) {
		this.ma_Sach = Integer.parseInt(ClassSupport.findString(ma_Sach, "(\\d+)"));
	}

	public int getGia_Tien() {
		return gia_Tien;
	}

	public void setGia_Tien(int gia_Tien) {
		this.gia_Tien = gia_Tien;
	}

	public int getSo_Luong() {
		return so_Luong;
	}

	public void setSo_Luong(int so_Luong) {
		this.so_Luong = so_Luong;
	}

	public int getSo_Trang() {
		return so_Trang;
	}

	public void setSo_Trang(int so_Trang) {
		this.so_Trang = so_Trang;
	}

	public String getTen_Sach() {
		return ten_Sach;
	}

	public void setTen_Sach(String ten_Sach) {
		this.ten_Sach = ten_Sach;
	}

	public String getMa_Tac_Gia() {
		return ma_Tac_Gia;
	}

	public void setMa_Tac_Gia(String ma_Tac_Gia) {
		this.ma_Tac_Gia = ma_Tac_Gia;
	}

	public String getThe_Loai() {
		return the_Loai;
	}

	public void setThe_Loai(String ma_The_Loai) {
		this.the_Loai = ma_The_Loai;
	}

	public String getMa_NXB() {
		return ma_NXB;
	}

	public void setMa_NXB(String ma_NXB) {
		this.ma_NXB = ma_NXB;
	}

	public String getMa_Vi_Tri() {
		return ma_Vi_Tri;
	}

	public void setMa_Vi_Tri(String ma_Vi_Tri) {
		this.ma_Vi_Tri = ma_Vi_Tri;
	}

	public String getNgon_Ngu() {
		return ngon_Ngu;
	}

	public void setNgon_Ngu(String ngon_Ngu) {
		this.ngon_Ngu = ngon_Ngu;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		Sach.sId = sId;
	}

	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}

}
