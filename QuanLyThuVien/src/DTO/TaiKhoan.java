package DTO;

import java.util.Date;

import BUS.ClassSupport;

public class TaiKhoan {
	private int ma_Tai_Khoan;
	private String ten_Dang_Nhap = "", mat_Khau, ma_Nhan_Vien;
	private boolean tinh_Trang, admin;
	private Date ngay_dang_nhap;
	private static int sId = 1000;
	private final static String ma = "TK";

	public TaiKhoan(int ma_Tai_Khoan, String ten_Dang_Nhap, String mat_Khau, boolean tinh_Trang, Date ngay_dang_nhap,
			boolean admin, String ma_Nhan_Vien) {
		super();
		this.ma_Tai_Khoan = ma_Tai_Khoan;
		this.ten_Dang_Nhap = ten_Dang_Nhap;
		this.mat_Khau = mat_Khau;
		this.tinh_Trang = tinh_Trang;
		this.ngay_dang_nhap = ngay_dang_nhap;
		this.admin = admin;
		this.ma_Nhan_Vien = ma_Nhan_Vien;
	}

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
		ma_Tai_Khoan = sId++;
	}

	public TaiKhoan(String maTaiKhoan) {
		super();
		setMa_Tai_Khoan(maTaiKhoan);
		// TODO Auto-generated constructor stub
	}

	public String getMa_Nhan_Vien() {
		return ma_Nhan_Vien;
	}

	public void setMa_Nhan_Vien(String ma_Nhan_Vien) {
		this.ma_Nhan_Vien = ma_Nhan_Vien;
	}

	public void setMa_Tai_Khoan(int ma_Tai_Khoan) {
		this.ma_Tai_Khoan = ma_Tai_Khoan;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		TaiKhoan.sId = sId;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Date getNgay_dang_nhap() {
		return ngay_dang_nhap;
	}

	public void setNgay_dang_nhap(Date ngay_dang_nhap) {
		this.ngay_dang_nhap = ngay_dang_nhap;
	}

	public String getMa_Tai_Khoan() {
		return ma + ma_Tai_Khoan;
	}

	public void setMa_Tai_Khoan(String ma_Tai_Khoan) {

		this.ma_Tai_Khoan = Integer.parseInt(ClassSupport.findString(ma_Tai_Khoan, "(\\d+)"));
	}

	public String getTen_Dang_Nhap() {
		return ten_Dang_Nhap;
	}

	public void setTen_Dang_Nhap(String ten_Dang_Nhap) {
		this.ten_Dang_Nhap = ten_Dang_Nhap;
	}

	public String getMat_Khau() {
		return mat_Khau;
	}

	public void setMat_Khau(String mat_Khau) {
		this.mat_Khau = mat_Khau;
	}

	public boolean isTinh_Trang() {
		return tinh_Trang;
	}

	public void setTinh_Trang(boolean tinh_Trang) {
		this.tinh_Trang = tinh_Trang;
	}

}
