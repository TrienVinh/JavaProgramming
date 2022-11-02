package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.TacGia;

public class TacGiaDAOImp implements TacGiaDAO {

	private MySQLConnect DBConnect;

	public TacGiaDAOImp() {
		super();

		DBConnect = new MySQLConnect();
	}

	@Override
	public List<TacGia> getListTacGia() {

		List<TacGia> listItem = new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select * from tac_gia";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TacGia tg = new TacGia(rs.getString("ma_tac_gia"));
				tg.setHo_Ten(rs.getString("ho_ten"));
				tg.setDia_Chi(rs.getString("dia_chi"));
				tg.setEmail(rs.getString("email"));

				listItem.add(tg);
			}
			conn.close();
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addTacGia(TacGia tg) {

		try {
			String sql = "insert into tac_gia values(";
			sql += "'" + tg.getMa_Tac_Gia() + "',";
			sql += "N'" + tg.getHo_Ten() + "',";
			sql += "N'" + tg.getDia_Chi() + "',";
			sql += "'" + tg.getEmail() + "')";

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editTacGia(TacGia tg) {

		try {
			String sql = "update tac_gia set ho_ten = ? , dia_chi = ? , email = ? where ma_tac_gia = ?";
			sql += "update tac_gia set ";
			sql += "ho_ten = N'" + tg.getHo_Ten() + "',";
			sql += "dia_chi = N'" + tg.getDia_Chi() + "',";
			sql += "email = '" + tg.getEmail() + "' where ";
			sql += "ma_tac_gia = '" + tg.getMa_Tac_Gia() + "'";
			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeTacGia(String tg) {

		try {
			String sql = "delete from tac_gia where ma_tac_gia = '" + tg + "'";
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
			String sql = "select max(ma_tac_gia) as max_tg from tac_gia";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String s = "";
			while (rs.next()) {
				s = rs.getString("max_tg");
			}
			conn.close();
			return s;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
