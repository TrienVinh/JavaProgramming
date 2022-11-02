package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.NhaCungCap;

public class NhaCungCapDAOImp implements NhaCungCapDAO {

	private MySQLConnect DBConnect;

	public NhaCungCapDAOImp() {
		super();

		DBConnect = new MySQLConnect();
	}

	@Override
	public List<NhaCungCap> getListNhaCungCap() {

		List<NhaCungCap> listItem = new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select * from nha_cung_cap";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhaCungCap NCC = new NhaCungCap(rs.getString("ma_NCC"));
				NCC.setHo_Ten(rs.getString("ten_NCC"));
				NCC.setDia_Chi(rs.getString("dia_chi"));
				NCC.setEmail(rs.getString("email"));

				listItem.add(NCC);
			}
			conn.close();
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addNhaCungCap(NhaCungCap NCC) {

		try {
			String sql = "insert into nha_cung_cap values(";
			sql += "'" + NCC.getMa_NCC() + "',";
			sql += "N'" + NCC.getHo_Ten() + "',";
			sql += "N'" + NCC.getDia_Chi() + "',";
			sql += "'" + NCC.getEmail() + "')";

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editNhaCungCap(NhaCungCap NCC) {

		try {
			String sql = "";

			sql += "update nha_cung_cap set ";
			sql += "ten_NCC = N'" + NCC.getHo_Ten() + "',";
			sql += "dia_chi = N'" + NCC.getDia_Chi() + "',";
			sql += "email = '" + NCC.getEmail() + "' where ";
			sql += "ma_NCC = '" + NCC.getMa_NCC() + "'";

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeNhaCungCap(String matl) {

		try {
			String sql = "delete from nha_cung_cap where ma_NCC = '" + matl + "'";

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getLastid() {

		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select max(ma_NCC) as max_ncc from nha_cung_cap";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String s = "";
			while (rs.next()) {
				s = rs.getString("max_ncc");
			}
			conn.close();
			return s;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
