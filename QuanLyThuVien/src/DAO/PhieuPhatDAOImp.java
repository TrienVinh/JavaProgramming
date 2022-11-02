package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.PhieuPhat;

public class PhieuPhatDAOImp implements PhieuPhatDAO {

	private MySQLConnect DBConnect;

	public PhieuPhatDAOImp() {
		super();

		DBConnect = new MySQLConnect();
	}

	@Override
	public List<PhieuPhat> getListPhieuPhat() {

		List<PhieuPhat> listItem = new ArrayList<PhieuPhat>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select * from giay_phat";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PhieuPhat pp = new PhieuPhat();
				pp.setMa_Phieu_Muon(rs.getString("ma_phieu_muon"));
				pp.setMa_Sach(rs.getString("ma_sach"));
				pp.setLy_Do(rs.getString("ly_do"));
				pp.setTien_Phat(rs.getInt("tien_phat"));
				listItem.add(pp);
			}
			conn.close();
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addPhieuPhat(PhieuPhat pp) {

		try {
			String sql = "insert into giay_phat(ma_phieu_muon , ma_sach , ly_do , tien_phat) values(";
			sql += "'" + pp.getMa_Phieu_Muon() + "',";
			sql += "'" + pp.getMa_Sach() + "',";
			sql += "N'" + pp.getLy_Do() + "',";
			sql += "" + pp.getTien_Phat() + ")";
			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Object getSomeThingFromSql(String sql) {

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
	public List<PhieuPhat> getListPhieuPhat(String sql) {
		List<PhieuPhat> listItem = new ArrayList<PhieuPhat>();
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PhieuPhat pp = new PhieuPhat();
				pp.setMa_Phieu_Muon(rs.getString("ma_phieu_muon"));
				pp.setMa_Sach(rs.getString("ma_sach"));
				pp.setLy_Do(rs.getString("ly_do"));
				pp.setTien_Phat(rs.getInt("tien_phat"));
				listItem.add(pp);
			}
			conn.close();
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
