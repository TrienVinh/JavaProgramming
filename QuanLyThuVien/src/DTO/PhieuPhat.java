package DTO;

public class PhieuPhat {
	private String ma_Phieu_Muon, ma_Sach, ly_Do = "";
	private int tien_Phat;

	public PhieuPhat(String ma_Phieu_Muon, String ma_Sach, String ly_Do, int tien_Phat) {
		super();
		this.ma_Phieu_Muon = ma_Phieu_Muon;
		this.ma_Sach = ma_Sach;
		this.ly_Do = ly_Do;
		this.tien_Phat = tien_Phat;
	}

	public PhieuPhat() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getLy_Do() {
		return ly_Do;
	}

	public void setLy_Do(String ly_Do) {
		this.ly_Do = ly_Do;
	}

	public int getTien_Phat() {
		return tien_Phat;
	}

	public void setTien_Phat(int tien_Phat) {
		this.tien_Phat = tien_Phat;
	}

}
