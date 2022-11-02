package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.NgonNgu;

public class NgonNguDAOImp implements NgonNguDAO {

	private MySQLConnect DBConnect;

	public NgonNguDAOImp() {
		super();

		DBConnect = new MySQLConnect();
	}

	@Override
	public List<NgonNgu> getListNgonNgu() {

		List<NgonNgu> listItem = new ArrayList<NgonNgu>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select * from ngon_ngu";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NgonNgu nn = new NgonNgu(rs.getString("ma_ngon_ngu"));
				nn.setTen_Ngon_Ngu(rs.getString("ten_ngon_ngu"));
				listItem.add(nn);
			}
			conn.close();
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addNgonNgu(NgonNgu nn) {

		try {
			String sql = "insert into ngon_ngu values(";
			sql += "'" + nn.getMa_Ngon_Ngu() + "',";
			sql += "N'" + nn.getTen_Ngon_Ngu() + "')";

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editNgonNgu(NgonNgu nn) {

		try {

			String sql = "";

			sql += "update ngon_ngu set ";
			sql += "ten_ngon_ngu = N'" + nn.getTen_Ngon_Ngu() + "' where ";
			sql += "ma_ngon_ngu = '" + nn.getMa_Ngon_Ngu() + "'";

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeNgonNgu(NgonNgu nn) {

		try {
			String sql = "delete from ngon_ngu where ma_ngon_ngu = '" + nn.getMa_Ngon_Ngu() + "'";
			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getLastId() {

		try {
			String s = "";
			Connection conn = DBConnect.getConnect();
			String sql = "select max(ma_ngon_ngu) as max_nn from ngon_ngu";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = rs.getString("max_nn");
			}
			conn.close();
			return s;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
