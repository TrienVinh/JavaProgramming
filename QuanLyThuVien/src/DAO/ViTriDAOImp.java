package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.ViTri;

public class ViTriDAOImp implements ViTriDAO {

	private MySQLConnect DBConnect;

	public ViTriDAOImp() {
		super();

		DBConnect = new MySQLConnect();
	}

	@Override
	public List<ViTri> getListViTri() {

		List<ViTri> listItem = new ArrayList<ViTri>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select * from vi_tri";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ViTri vt = new ViTri(rs.getString("ma_vi_tri"));
				vt.setSo_Ke(rs.getInt("so_ke"));
				vt.setSo_Khu(rs.getInt("so_khu"));
				vt.setSo_Ngan(rs.getInt("so_ngan"));

				listItem.add(vt);
			}
			conn.close();
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addViTri(ViTri vt) {

		try {
			String sql = "insert into vi_tri values(";
			sql += "'" + vt.getMa_Vi_Tri() + "',";
			sql += "" + vt.getSo_Ke() + ",";
			sql += "" + vt.getSo_Khu() + ",";
			sql += "" + vt.getSo_Ngan() + ",)";
			return DBConnect.executeUpdate(sql);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editViTri(ViTri vt) {

		try {
			String sql = "ma_khu = ? , ma_ke = ? , ma_ngan = ? where ma_vi_tri = ?";
			sql += "update vi_tri set ";
			sql += "ma_khu = " + vt.getSo_Khu() + ",";
			sql += "ma_ke = " + vt.getSo_Ke() + ",";
			sql += "ma_ngan = " + vt.getSo_Ngan() + " where ";
			sql += "ma_vi_tri = '" + vt.getMa_Vi_Tri() + "'";
			return DBConnect.executeUpdate(sql);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeViTri(String vt) {

		try {
			String sql = "delete from vi_tri where ma_vi_tri = '" + vt + "'";
			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getLastId() {

		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select max(ma_vi_tri) as max_vt from vi_tri";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String s = "";
			while (rs.next()) {
				s = rs.getString("max_vt");
			}
			return s;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean searchViTri(ViTri vt) {

		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select count(*) as so_luong from vi_tri where so_ke = ? and so_khu =? and so_ngan = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vt.getSo_Ke());
			ps.setInt(2, vt.getSo_Khu());
			ps.setInt(3, vt.getSo_Ngan());
			ResultSet rs = ps.executeQuery();
			int sl = 0;
			while (rs.next()) {
				sl = rs.getInt("so_luong");
			}
			return sl > 0;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

}
