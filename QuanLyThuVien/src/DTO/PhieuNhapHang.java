package DTO;

import java.util.Date;

import BUS.ClassSupport;

public class PhieuNhapHang {
	private int maPN, so_Luong, tong_Tien;
	private String maNCC, maNV;
	private Date ngay_Nhap;

	private static int sId = 1000;
	private static final String ma = "PN";

	public PhieuNhapHang(int ma_PN, int so_Luong, int tong_Tien, String maNCC, String maNV, Date ngay_Nhap) {
		super();
		this.maPN = ma_PN;
		this.so_Luong = so_Luong;
		this.tong_Tien = tong_Tien;
		this.maNCC = maNCC;
		this.maNV = maNV;
		this.ngay_Nhap = ngay_Nhap;
	}

	public PhieuNhapHang(String ma_PN, int so_Luong, int tong_Tien, String maNCC, String maNV, Date ngay_Nhap) {
		super();
		setMaPN(ma_PN);
		this.so_Luong = so_Luong;
		this.tong_Tien = tong_Tien;
		this.maNCC = maNCC;
		this.maNV = maNV;
		this.ngay_Nhap = ngay_Nhap;

	}

	public PhieuNhapHang() {
		super();
		// TODO Auto-generated constructor stub
		maPN = sId++;
	}

	public PhieuNhapHang(String maPN) {
		super();
		// TODO Auto-generated constructor stub
		setMaPN(maPN);
	}

	public String getMaPN() {
		return ma + maPN;
	}

	public void setMaPN(int maPN) {
		this.maPN = maPN;
	}

	public void setMaPN(String maPN) {
		this.maPN = Integer.parseInt(ClassSupport.findString(maPN, "(\\d+)"));
	}

	public int getSo_Luong() {
		return so_Luong;
	}

	public void setSo_Luong(int so_Luong) {
		this.so_Luong = so_Luong;
	}

	public int getTong_Tien() {
		return tong_Tien;
	}

	public void setTong_Tien(int tong_Tien) {
		this.tong_Tien = tong_Tien;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public Date getNgay_Nhap() {
		return ngay_Nhap;
	}

	public void setNgay_Nhap(Date ngay_Nhap) {
		this.ngay_Nhap = ngay_Nhap;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		PhieuNhapHang.sId = sId;
	}

	public static void setsId(String sId) {
		PhieuNhapHang.sId = Integer.parseInt(ClassSupport.findString(sId, "(\\d+)")) + 1;
	}

}
