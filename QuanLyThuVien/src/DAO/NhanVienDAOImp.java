package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DTO.NhanVien;

public class NhanVienDAOImp implements NhanVienDAO {

	private MySQLConnect DBConnect;

	public NhanVienDAOImp() {
		super();
		DBConnect = new MySQLConnect();
	}

	@Override
	public List<NhanVien> getListNhanVien() {

		List<NhanVien> listItem = new ArrayList<NhanVien>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select nhan_vien.* from nhan_vien ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMa_Doi_Tuong(rs.getString("ma_nhan_vien"));
				nv.setChuc_Vu(rs.getString("chuc_vu"));
				nv.setCMND(rs.getString("cmnd"));
				nv.setDia_Chi(rs.getString("dia_chi"));
				nv.setEmail(rs.getString("email"));
				nv.setGioi_Tinh(rs.getBoolean("gioi_tinh"));
				nv.setHo(rs.getString("ho"));
				nv.setTen(rs.getString("ten"));
				nv.setNgay_Sinh(rs.getDate("ngay_sinh"));
				nv.setSo_Dien_Thoai(rs.getString("so_dien_thoai"));

				listItem.add(nv);
			}
			conn.close();
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getLastNhanVien() {

		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select max(ma_nhan_vien) as max from nhan_vien";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String ma = "";
			while (rs.next()) {
				ma = rs.getString("max");
			}
			return ma;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addNhanVien(NhanVien nv) {

		try {

			String sql = "insert into nhan_vien values";
			sql += "('" + nv.getMa_Doi_Tuong() + "',";
			sql += "N'" + nv.getHo() + "',";
			sql += "N'" + nv.getTen() + "',";
			sql += nv.isGioi_Tinh() + ",";
			sql += "'" + new SimpleDateFormat("yyyy-MM-dd").format(nv.getNgay_Sinh()) + "',";
			sql += "N'" + nv.getDia_Chi() + "',";
			sql += "'" + nv.getEmail() + "',";
			sql += "'" + nv.getSo_Dien_Thoai() + "',";
			sql += "N'" + nv.getChuc_Vu() + "',";
			sql += "'" + nv.getCMND() + "')";

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertNhanVien(NhanVien nv) {

		try {
			String sql = "";
			sql += "update nhan_vien set ";
			sql += "ho = N'" + nv.getHo() + "',";
			sql += "ten = N'" + nv.getTen() + "',gioi_tinh = ";
			sql += nv.isGioi_Tinh() + ",";
			sql += "dia_chi = N'" + nv.getDia_Chi() + "',";
			sql += "email = '" + nv.getEmail() + "',";
			sql += "chuc_vu = N'" + nv.getChuc_Vu() + "',";
			sql += "cmnd = '" + nv.getCMND() + "',";
			sql += "so_dien_thoai = '" + nv.getSo_Dien_Thoai() + "',";
			sql += "ngay_sinh = '" + new SimpleDateFormat("yyyy-MM-dd").format(nv.getNgay_Sinh()) + "'";
			sql += " where ma_nhan_vien = '" + nv.getMa_Doi_Tuong() + "'";
			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeNhanVien(String nv) {

		try {
			String sql = "delete from nhan_vien where ma_nhan_vien = '" + nv + "'";
			return DBConnect.executeUpdate(sql);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

}
