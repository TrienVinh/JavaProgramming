package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.ChiTietPhieuNhap;
import DTO.Pair;
import DTO.PhieuNhapHang;

public class PhieuNhapDAOImp implements PhieuNhapDAO {

	private ChiTietPhieuNhapDAO ctpnDAO;
	private MySQLConnect DBConnect;

	public PhieuNhapDAOImp() {
		super();

		ctpnDAO = new ChiTietPhieuNhapDAOImp();
		DBConnect = new MySQLConnect();
	}

	@Override
	public List<PhieuNhapHang> getListPhieuNhap() {

		List<PhieuNhapHang> listItem = new ArrayList<PhieuNhapHang>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select * from phieu_nhap_hang";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PhieuNhapHang pn = new PhieuNhapHang(rs.getString("ma_phieu_nhap"));

				pn.setMaNCC(rs.getString("ma_NCC"));
				pn.setMaNV(rs.getString("ma_nhan_vien"));
				pn.setNgay_Nhap(rs.getDate("ngay_nhap_hang"));
				pn.setSo_Luong(rs.getInt("so_luong"));
				pn.setTong_Tien(rs.getInt("tong_tien"));

				listItem.add(pn);
			}
			conn.close();
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Pair<ChiTietPhieuNhap, String>> getListChiTiet(String maPN) {

		List<Pair<ChiTietPhieuNhap, String>> listChiTiet = new ArrayList<Pair<ChiTietPhieuNhap, String>>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select *, sach.ten_sach from chi_tiet_phieu_nhap inner join sach on chi_tiet_phieu_nhap.ma_sach = sach.ma_sach where ma_phieu_nhap = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maPN);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
				ctpn.setMaPN(maPN);
				ctpn.setMaSach(rs.getString("ma_sach"));
				ctpn.setSo_Luong(rs.getInt("so_luong"));
				ctpn.setTong_Gia_Tien(rs.getInt("gia_tien"));

				String tenSach = rs.getString("ten_sach");
				Pair<ChiTietPhieuNhap, String> pair = new Pair<ChiTietPhieuNhap, String>(ctpn, tenSach);
				listChiTiet.add(pair);
			}
			conn.close();
			return listChiTiet;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getLastId() {

		String id = "";
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select max(ma_phieu_nhap) as max_id from phieu_nhap_hang";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getString("max_id");
			}
			conn.close();
			return (id == null) ? "" : id;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean addPhieuNhap(PhieuNhapHang pn, List<Pair<String, String>> listChiTiet) {

		try {
			String sql = " insert into phieu_nhap_hang values(";
			sql += "'" + pn.getMaPN() + "',";
			sql += "'" + pn.getMaNV() + "',";
			sql += "'" + pn.getMaNCC() + "',";
			sql += "'" + new Date(pn.getNgay_Nhap().getTime()) + "',";
			sql += "" + pn.getSo_Luong() + ",";
			sql += "" + pn.getTong_Tien() + ")";

			DBConnect.executeUpdate(sql);
			ctpnDAO.addChiTiet(listChiTiet, pn.getMaPN());

			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Object getSomeThing(String sql) {
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Object obj = "";
			while (rs.next()) {
				obj = rs.getObject(1);
			}
			conn.close();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
