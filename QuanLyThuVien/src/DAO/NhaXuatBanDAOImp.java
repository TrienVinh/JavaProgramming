package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.NhaXuatBan;

public class NhaXuatBanDAOImp implements NhaXuatBanDAO {

	private MySQLConnect DBConnect;

	public NhaXuatBanDAOImp() {
		super();

		DBConnect = new MySQLConnect();
	}

	@Override
	public List<NhaXuatBan> getListNhaXuatBan() {

		List<NhaXuatBan> listItem = new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select * from nha_xuat_ban";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhaXuatBan nxb = new NhaXuatBan(rs.getString("ma_NXB"));
				nxb.setHo_Ten(rs.getString("ho_ten"));
				nxb.setDia_Chi(rs.getString("dia_chi"));
				nxb.setEmail(rs.getString("email"));

				listItem.add(nxb);
			}
			conn.close();
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addNhaXuatBan(NhaXuatBan nxb) {

		try {

			String sql = "insert into nha_xuat_ban values(";
			sql += "'" + nxb.getMa_NXB() + "',";
			sql += "N'" + nxb.getHo_Ten() + "',";
			sql += "N'" + nxb.getDia_Chi() + "',";
			sql += "'" + nxb.getEmail() + "')";

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editNhaXuatBan(NhaXuatBan nxb) {

		try {
			String sql = "";
			sql += "update nha_xuat_ban set ";
			sql += "ho_ten = N'" + nxb.getHo_Ten() + "',";
			sql += "dia_chi = N'" + nxb.getDia_Chi() + "',";
			sql += "email = '" + nxb.getEmail() + "' where ";
			sql += "ma_NXB = '" + nxb.getMa_NXB() + "'";
			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeNhaXuatBan(String nxb) {

		try {
			String sql = "delete from nha_xuat_ban where ma_NXB = '" + nxb + "'";
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
			String sql = "select max(ma_NXB) as max_nxb from nha_xuat_ban";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String s = "";
			while (rs.next()) {
				s = rs.getString("max_nxb");
			}
			conn.close();
			return s;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
