package DTO;

import java.util.Date;

import BUS.ClassSupport;

public class PhieuMuon {

	private int ma_Phieu_Muon, tong_So_Sach_Muon;
	private String ma_Doc_Gia, ma_Nhan_Vien;
	private Date ngay_Muon, ngay_Phai_Tra;
	private boolean hoan_Tra;

	private static int sId = 1000;
	private final static String ma = "PM";

	public PhieuMuon(int ma_Phieu_Muon, int tong_So_Sach_Muon, String ma_Doc_Gia, String ma_Nhan_Vien, Date ngay_Muon,
			Date ngay_Phai_Tra, boolean hoan_Tra) {
		super();
		this.ma_Phieu_Muon = ma_Phieu_Muon;
		this.tong_So_Sach_Muon = tong_So_Sach_Muon;
		this.ma_Doc_Gia = ma_Doc_Gia;
		this.ma_Nhan_Vien = ma_Nhan_Vien;
		this.ngay_Muon = ngay_Muon;
		this.ngay_Phai_Tra = ngay_Phai_Tra;
		this.hoan_Tra = hoan_Tra;
	}

	public PhieuMuon(String ma_Phieu_Muon, int tong_So_Sach_Muon, String ma_Doc_Gia, String ma_Nhan_Vien,
			Date ngay_Muon, Date ngay_Phai_Tra, boolean hoan_Tra) {
		super();
		setMa_Phieu_Muon(ma_Phieu_Muon);
		this.tong_So_Sach_Muon = tong_So_Sach_Muon;
		this.ma_Doc_Gia = ma_Doc_Gia;
		this.ma_Nhan_Vien = ma_Nhan_Vien;
		this.ngay_Muon = ngay_Muon;
		this.ngay_Phai_Tra = ngay_Phai_Tra;
		this.hoan_Tra = hoan_Tra;
	}

	public PhieuMuon() {
		super();
		// TODO Auto-generated constructor stub
		this.ma_Phieu_Muon = sId++;
	}

	public PhieuMuon(String phieu_Muon) {
		super();
		// TODO Auto-generated constructor stub
		setMa_Phieu_Muon(phieu_Muon);
	}

	public String getMa_Phieu_Muon() {
		return ma + ma_Phieu_Muon;
	}

	public void setMa_Phieu_Muon(int ma_Phieu_Muon) {
		this.ma_Phieu_Muon = ma_Phieu_Muon;
	}

	public void setMa_Phieu_Muon(String ma_Phieu_Muon) {
		this.ma_Phieu_Muon = Integer.parseInt(ClassSupport.findString(ma_Phieu_Muon, "(\\d+)"));
	}

	public int getTong_So_Sach_Muon() {
		return tong_So_Sach_Muon;
	}

	public void setTong_So_Sach_Muon(int tong_So_Sach_Muon) {
		this.tong_So_Sach_Muon = tong_So_Sach_Muon;
	}

	public String getMa_Doc_Gia() {
		return ma_Doc_Gia;
	}

	public void setMa_Doc_Gia(String ma_Doc_Gia) {
		this.ma_Doc_Gia = ma_Doc_Gia;
	}

	public String getMa_Nhan_Vien() {
		return ma_Nhan_Vien;
	}

	public void setMa_Nhan_Vien(String ma_Nhan_Vien) {
		this.ma_Nhan_Vien = ma_Nhan_Vien;
	}

	public Date getNgay_Muon() {
		return ngay_Muon;
	}

	public void setNgay_Muon(Date ngay_Muon) {
		this.ngay_Muon = ngay_Muon;
	}

	public Date getNgay_Phai_Tra() {
		return ngay_Phai_Tra;
	}

	public void setNgay_Phai_Tra(Date ngay_Phai_Tra) {
		this.ngay_Phai_Tra = ngay_Phai_Tra;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		PhieuMuon.sId = sId;
	}

	public boolean isHoan_Tra() {
		return hoan_Tra;
	}

	public void setHoan_Tra(boolean hoan_Tra) {
		this.hoan_Tra = hoan_Tra;
	}

}
