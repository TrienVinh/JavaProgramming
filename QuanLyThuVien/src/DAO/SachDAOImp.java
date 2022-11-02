package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Pair;
import DTO.Sach;
import DTO.SachTimKiem;

public class SachDAOImp implements SachDAO {

	private MySQLConnect DBConnect;

	public SachDAOImp() {
		super();
		DBConnect = new MySQLConnect();
	}

	@Override
	public List<Sach> getListSach() {

		String sql = "select * from sach";

		return getList(sql);
	}

	public List<Sach> getList(String sql) {
		List<Sach> listItem = new ArrayList<Sach>();
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Sach s = new Sach(rs.getString("ma_sach"));
				s.setGia_Tien(rs.getInt("gia_tien"));
				s.setMa_NXB(rs.getString("ma_nxb"));
				s.setMa_Tac_Gia(rs.getString("ma_tac_gia"));
				s.setMa_Vi_Tri(rs.getString("ma_vi_tri"));
				s.setSo_Luong(rs.getInt("so_luong"));
				s.setSo_Trang(rs.getInt("so_trang"));
				s.setTen_Sach(rs.getString("ten_sach"));
				s.setNamXB(rs.getInt("nam_xuat_ban"));

				listItem.add(s);
			}

			for (int i = 0; i < listItem.size(); i++) {
				String theLoai = "";
				Sach s = listItem.get(i);
				sql = "select the_loai.ten_the_loai from sach, the_loai , sach_theLoai where sach_theLoai.ma_the_loai = the_loai.ma_the_loai and sach.ma_sach = sach_theLoai.ma_sach and sach.ma_sach = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, s.getMa_Sach());
				rs = ps.executeQuery();
				while (rs.next()) {
					theLoai += rs.getString("ten_the_loai") + ", ";
				}
				if (theLoai.length() > 2)
					theLoai = theLoai.substring(0, theLoai.length() - 2);
				s.setThe_Loai(theLoai);
				listItem.set(i, s);

			}

			for (int i = 0; i < listItem.size(); i++) {
				String ngonNgu = "";
				Sach s = listItem.get(i);
				sql = "select ngon_ngu.ten_ngon_ngu from sach, ngon_ngu , sach_ngonNgu where sach_ngonNgu.ma_ngon_ngu = ngon_ngu.ma_ngon_ngu and sach.ma_sach = sach_ngonNgu.ma_sach and sach.ma_sach = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, s.getMa_Sach());
				rs = ps.executeQuery();
				while (rs.next()) {
					ngonNgu += rs.getString("ten_ngon_ngu") + ", ";
				}
				if (ngonNgu.length() > 2)
					ngonNgu = ngonNgu.substring(0, ngonNgu.length() - 2);
				s.setNgon_Ngu(ngonNgu);
				listItem.set(i, s);
			}
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return listItem;
	}

	@Override
	public String getLastId() {

		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select max(ma_sach) as max_s from sach";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String s = "";
			while (rs.next()) {
				s = rs.getString("max_s");
			}
			conn.close();
			return s;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addSach(Sach s, String idTl, String idNn) {

		try {
			String sql = "insert into sach values(";
			sql += "'" + s.getMa_Sach() + "',";
			sql += "N'" + s.getTen_Sach() + "',";
			sql += "'" + s.getMa_Tac_Gia() + "',";
			sql += "'" + s.getMa_NXB() + "',";
			sql += "" + s.getNamXB() + ",";
			sql += "'" + s.getMa_Vi_Tri() + "',";
			sql += "" + s.getGia_Tien() + ",";
			sql += "" + s.getSo_Luong() + ",";
			sql += "" + s.getSo_Trang() + ")";
			DBConnect.executeUpdate(sql);

			sql = "insert into sach_theLoai values";
			updateNgonNguAndTheLoai(sql, idTl, s.getMa_Sach());

			sql = "insert into sach_ngonNgu values";
			updateNgonNguAndTheLoai(sql, idNn, s.getMa_Sach());
			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	public void updateNgonNguAndTheLoai(String sql, String splitStr, String maSach) {
		String[] tempTl = splitStr.split(" - ");
		for (String str : tempTl) {
			sql += "('" + maSach + "',";
			sql += "'" + str + "'),";
		}
		sql = sql.substring(0, sql.length() - 1);
		DBConnect.executeUpdate(sql);
	}

	@Override
	public boolean editSach(Sach s, String idTL, String idNN) {

		try {
			String sql = "ten_sach = ?, ma_vi_tri = ? , gia_tien = ? , so_luong = ?  , so_trang = ? where ma_sach = ?";
			sql += "update sach set ";
			sql += "ten_sach = N'" + s.getTen_Sach() + "',";
			sql += "ma_vi_tri = '" + s.getMa_Vi_Tri() + "',";
			sql += "gia_tien = " + s.getGia_Tien() + ",";
			sql += "so_luong = " + s.getSo_Luong() + ",";
			sql += "so_trang = " + s.getSo_Trang() + " where ";
			sql += "ma_sach = '" + s.getMa_Sach() + "'";

			DBConnect.executeUpdate(sql);

			sql = "delete from sach_theLoai where ma_sach = ";
			removeTheLoaiOrNgonNgu(sql, s.getMa_Sach());

			sql = "insert into sach_theLoai values";
			updateNgonNguAndTheLoai(sql, idTL, s.getMa_Sach());

			sql = "delete from sach_ngonNgu where ma_sach = ";
			removeTheLoaiOrNgonNgu(sql, s.getMa_Sach());

			sql = "insert into sach_ngonNgu values";
			updateNgonNguAndTheLoai(sql, idNN, s.getMa_Sach());

			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeSach(String s) {

		try {

			String sql = "delete from sach_theLoai where ma_sach = ";
			removeTheLoaiOrNgonNgu(sql, s);

			sql = "delete from sach_ngonNgu where ma_sach = ";
			removeTheLoaiOrNgonNgu(sql, s);

			sql = "delete from sach where ma_sach = '" + s;

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	public void removeTheLoaiOrNgonNgu(String sql, String maSach) {
		sql += "'" + maSach + "'";
		DBConnect.executeUpdate(sql);
	}

	@Override
	public List<SachTimKiem> getListSachTimKiem() {

		List<SachTimKiem> listSachTK = new ArrayList<SachTimKiem>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "SELECT sach.ma_sach, sach.ten_sach , tac_gia.ho_ten as ten_tac_gia , nha_xuat_ban.ho_ten as ten_nxb , sach.so_luong, sach.gia_tien from sach , tac_gia , nha_xuat_ban where sach.ma_tac_gia = tac_gia.ma_tac_gia AND sach.ma_nxb = nha_xuat_ban.ma_NXB ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SachTimKiem s = new SachTimKiem();

				s.setMa_Sach(rs.getString("ma_sach"));
				s.setTen_Sach(rs.getString("ten_sach"));
				s.setTac_Gia(rs.getString("ten_tac_gia"));
				s.setNXB(rs.getString("ten_nxb"));
				s.setSo_Luong(rs.getInt("so_luong"));
				s.setGia_Tien(rs.getInt("gia_tien"));

				listSachTK.add(s);
			}

			for (SachTimKiem sachtk : listSachTK) {
				sql = "select the_loai.ten_the_loai from sach_theLoai , the_loai where sach_theLoai.ma_the_loai = the_loai.ma_the_loai and sach_theLoai.ma_sach = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, sachtk.getMa_Sach());
				rs = ps.executeQuery();
				String tl = "";
				while (rs.next()) {
					tl += rs.getString("ten_the_loai") + ", ";
				}
				if (tl.length() > 1)
					tl = tl.substring(0, tl.length() - 2);
				sachtk.setThe_Loai(tl);
			}
			conn.close();
			return listSachTK;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object getSomeThingFromSach(String sql) {
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Object obj = null;
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

	@Override
	public void updateSoLuongForSach(Pair<String, Integer> pair) {

		try {
			String sql = "";
			sql += "update sach set ";
			sql += "sach.so_luong = sach.so_luong - " + pair.getV() + " where ";
			sql += "sach.ma_sach = '" + pair.getK() + "'";

			DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
