package DTO;

import java.util.Date;

public class ChiTietPhieuMuon {

	private String ma_Phieu_Muon, ma_Sach;
	private int so_Luong_Muon;
	private Date ngay_tra;
	private int so_Luong_Tra;
	private String tinh_Trang_Tra;

	public ChiTietPhieuMuon(String ma_Phieu_Muon, String ma_Sach, int so_Luong_Muon, Date ngay_tra, int da_Tra,
			String tinh_Trang_Tra) {
		super();
		this.ma_Phieu_Muon = ma_Phieu_Muon;
		this.ma_Sach = ma_Sach;
		this.so_Luong_Muon = so_Luong_Muon;
		this.ngay_tra = ngay_tra;
		this.so_Luong_Tra = da_Tra;
		this.tinh_Trang_Tra = tinh_Trang_Tra;
	}

	public ChiTietPhieuMuon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTinh_Trang_Tra() {
		return tinh_Trang_Tra;
	}

	public void setTinh_Trang_Tra(String tinh_Trang_Tra) {
		this.tinh_Trang_Tra = tinh_Trang_Tra;
	}

	public String getMa_Phieu_Muon() {
		return ma_Phieu_Muon;
	}

	public void setMa_Phieu_Muon(String ma_Phieu_Muon) {
		this.ma_Phieu_Muon = ma_Phieu_Muon;
	}

	public String getMa_Sach() {
		return ma_Sach;
	}

	public void setMa_Sach(String ma_Sach) {
		this.ma_Sach = ma_Sach;
	}

	public int getSo_Luong_Muon() {
		return so_Luong_Muon;
	}

	public void setSo_Luong_Muon(int so_Luong_Muon) {
		this.so_Luong_Muon = so_Luong_Muon;
	}

	public Date getNgay_tra() {
		return ngay_tra;
	}

	public void setNgay_tra(Date ngay_tra) {
		this.ngay_tra = ngay_tra;
	}

	public int getSo_Luong_Tra() {
		return so_Luong_Tra;
	}

	public void setSo_Luong_Tra(int da_Tra) {
		this.so_Luong_Tra = da_Tra;
	}

}
