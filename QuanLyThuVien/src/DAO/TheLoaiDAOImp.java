package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.TheLoai;

public class TheLoaiDAOImp implements TheLoaiDAO {

	private MySQLConnect DBConnect;

	public TheLoaiDAOImp() {
		super();

		DBConnect = new MySQLConnect();
	}

	@Override
	public List<TheLoai> getListTheLoai() {

		List<TheLoai> listItem = new ArrayList<TheLoai>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select  * from the_loai";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TheLoai tl = new TheLoai(rs.getString("ma_the_loai"));
				tl.setTen_The_Loai(rs.getString("ten_the_loai"));
				listItem.add(tl);
			}
			conn.close();
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addTheLoai(TheLoai tl) {

		try {
			String sql = "insert into the_loai values(";
			sql += "'" + tl.getMa_The_Loai() + "',";
			sql += "N'" + tl.getTen_The_Loai() + "')";

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editTheLoai(TheLoai tl) {

		try {
			String sql = "";
			sql += "update the_loai set ";
			sql += "ten_the_loai = N'" + tl.getTen_The_Loai() + "' where ";
			sql += "ma_the_loai = '" + tl.getMa_The_Loai() + "'";
			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeTheLoai(String tl) {

		try {
			String sql = "delete from the_loai where ma_the_loai = '" + tl + "'";
			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getLastid() {

		try {
			String s = "";
			Connection conn = DBConnect.getConnect();
			String sql = "select max(ma_the_loai) as max_tl from the_loai";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = rs.getString("max_tl");
			}
			return s;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
