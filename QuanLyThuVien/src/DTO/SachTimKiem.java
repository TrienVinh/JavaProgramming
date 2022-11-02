package DTO;

public class SachTimKiem {

	private String ma_Sach, ten_Sach, tac_Gia, the_Loai, NXB, ngon_Ngu;
	private int gia_Tien, so_Luong, so_Trang, so_Ke, so_Ngan, so_Khu;

	public SachTimKiem(String ma_Sach, String ten_Sach, String tac_Gia, String the_Loai, String nXB, int so_Khu,
			int so_Ke, int so_Ngan, String ngon_Ngu, int gia_Tien, int so_Luong, int so_Trang) {
		super();
		this.ma_Sach = ma_Sach;
		this.ten_Sach = ten_Sach;
		this.tac_Gia = tac_Gia;
		this.the_Loai = the_Loai;
		this.NXB = nXB;
		this.so_Khu = so_Khu;
		this.so_Ke = so_Ke;
		this.so_Ngan = so_Ngan;
		this.ngon_Ngu = ngon_Ngu;
		this.gia_Tien = gia_Tien;
		this.so_Luong = so_Luong;
		this.so_Trang = so_Trang;
	}

	public SachTimKiem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SachTimKiem(Sach s) {
		super();
		this.ma_Sach = s.getMa_Sach();
		this.gia_Tien = s.getGia_Tien();
		this.ngon_Ngu = s.getNgon_Ngu();
		this.so_Trang = s.getSo_Trang();
		this.so_Luong = s.getSo_Luong();
		this.ten_Sach = s.getTen_Sach();
		this.the_Loai = s.getThe_Loai();
	}

	public String getMa_Sach() {
		return ma_Sach;
	}

	public void setMa_Sach(String ma_Sach) {
		this.ma_Sach = ma_Sach;
	}

	public String getTen_Sach() {
		return ten_Sach;
	}

	public void setTen_Sach(String ten_Sach) {
		this.ten_Sach = ten_Sach;
	}

	public String getTac_Gia() {
		return tac_Gia;
	}

	public void setTac_Gia(String tac_Gia) {
		this.tac_Gia = tac_Gia;
	}

	public String getThe_Loai() {
		return the_Loai;
	}

	public void setThe_Loai(String the_Loai) {
		this.the_Loai = the_Loai;
	}

	public String getNXB() {
		return NXB;
	}

	public void setNXB(String nXB) {
		NXB = nXB;
	}

	public int getSo_Khu() {
		return so_Khu;
	}

	public void setSo_Khu(int so_Khu) {
		this.so_Khu = so_Khu;
	}

	public int getSo_Ke() {
		return so_Ke;
	}

	public void setSo_Ke(int so_Ke) {
		this.so_Ke = so_Ke;
	}

	public int getSo_Ngan() {
		return so_Ngan;
	}

	public void setSo_Ngan(int so_Ngan) {
		this.so_Ngan = so_Ngan;
	}

	public String getNgon_Ngu() {
		return ngon_Ngu;
	}

	public void setNgon_Ngu(String ngon_Ngu) {
		this.ngon_Ngu = ngon_Ngu;
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

}
