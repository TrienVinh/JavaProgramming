package DTO;

import BUS.ClassSupport;

public class ViTri {

	private int ma_Vi_Tri;
	private int so_Ke, so_Khu, so_Ngan;

	private final static String ma = "VT";
	private static int sId = 1000;

	public ViTri() {
		super();
		// TODO Auto-generated constructor stub
		this.ma_Vi_Tri = sId++;
	}

	public ViTri(String ma_VT) {
		super();
		// TODO Auto-generated constructor stub
		setMa_Vi_Tri(ma_VT);
	}

	public ViTri(int ma_Vi_Tri, int so_Ke, int so_Khu, int so_Ngan) {
		super();
		this.ma_Vi_Tri = ma_Vi_Tri;
		this.so_Ke = so_Ke;
		this.so_Khu = so_Khu;
		this.so_Ngan = so_Ngan;
	}

	public ViTri(String ma_Vi_Tri, int so_Ke, int so_Khu, int so_Ngan) {
		super();
		setMa_Vi_Tri(ma_Vi_Tri);
		this.so_Ke = so_Ke;
		this.so_Khu = so_Khu;
		this.so_Ngan = so_Ngan;
	}

	public String getMa_Vi_Tri() {
		return ma + ma_Vi_Tri;
	}

	public void setMa_Vi_Tri(String ma_Vi_Tri) {
		this.ma_Vi_Tri = Integer.parseInt(ClassSupport.findString(ma_Vi_Tri, "(\\d+)"));
	}

	public int getSo_Ke() {
		return so_Ke;
	}

	public void setSo_Ke(int so_Ke) {
		this.so_Ke = so_Ke;
	}

	public int getSo_Khu() {
		return so_Khu;
	}

	public void setSo_Khu(int so_Khu) {
		this.so_Khu = so_Khu;
	}

	public int getSo_Ngan() {
		return so_Ngan;
	}

	public void setSo_Ngan(int so_Ngan) {
		this.so_Ngan = so_Ngan;
	}

	public static String getsId() {
		return ma + sId;
	}

	public static void setsId(int sId) {
		ViTri.sId = sId;
	}

}
