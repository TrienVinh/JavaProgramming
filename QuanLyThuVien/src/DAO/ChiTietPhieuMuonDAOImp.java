package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DTO.ChiTietPhieuMuon;
import DTO.Pair;

public class ChiTietPhieuMuonDAOImp implements ChiTietPhieuMuonDAO {

	private SachDAO sachDAO;
	private MySQLConnect DBConnect;

	public ChiTietPhieuMuonDAOImp() {
		super();
		sachDAO = new SachDAOImp();
		DBConnect = new MySQLConnect();
	}

	@Override
	public List<Pair<ChiTietPhieuMuon, String>> getListChiTiet(String maPM) {

		List<Pair<ChiTietPhieuMuon, String>> listItem = new ArrayList<Pair<ChiTietPhieuMuon, String>>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select chi_tiet_phieu_muon.* , sach.ten_sach from chi_tiet_phieu_muon , sach where chi_tiet_phieu_muon.ma_phieu_muon = ? and chi_tiet_phieu_muon.ma_sach = sach.ma_sach";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maPM);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();
				ctpm.setMa_Phieu_Muon(maPM);
				ctpm.setMa_Sach(rs.getString("ma_sach"));
				ctpm.setSo_Luong_Muon(rs.getInt("so_luong_muon"));
				ctpm.setNgay_tra(rs.getDate("ngay_tra"));
				ctpm.setSo_Luong_Tra(rs.getInt("so_luong_tra"));
				ctpm.setTinh_Trang_Tra(rs.getString("tinh_trang_tra"));
				String tenSach = rs.getString("ten_sach");

				Pair<ChiTietPhieuMuon, String> pair = new Pair<ChiTietPhieuMuon, String>(ctpm, tenSach);
				listItem.add(pair);

			}
			conn.close();
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addChiTietPhieuMuon(String maPM, List<Pair<String, Integer>> listSp) {

		try {

			String sql = "insert into chi_tiet_phieu_muon values";
			for (Pair<String, Integer> sachMuon : listSp) {

				sql += "('" + maPM + "',";
				sql += "'" + sachMuon.getK() + "',";
				sql += "" + sachMuon.getV() + ",";
				sql += "NULL,";
				sql += "" + 0 + ",";
				sql += "' '),";

				updateSoLuongForSach(sachMuon);
			}
			sql = sql.substring(0, sql.length() - 1);
			DBConnect.executeUpdate(sql);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editChiTietPhieuMuon(List<ChiTietPhieuMuon> listChiTiet) {

		try {
			for (ChiTietPhieuMuon ct : listChiTiet) {
				String sql = "";
				sql = "update chi_tiet_phieu_muon set ";
				sql += "so_luong_tra = so_luong_tra + " + ct.getSo_Luong_Tra() + ",";
				sql += "tinh_trang_tra = N'" + ct.getTinh_Trang_Tra() + "' ,";
				sql += "ngay_tra = '" + new SimpleDateFormat("yyyy/MM/dd").format(ct.getNgay_tra()) + "'";
				sql += " where ma_phieu_muon = '" + ct.getMa_Phieu_Muon() + "'";
				sql += " and ma_sach = '" + ct.getMa_Sach() + "'";

				DBConnect.executeUpdate(sql);

				updateSoLuongForSach(new Pair<String, Integer>(ct.getMa_Sach(), ct.getSo_Luong_Tra() * -1));
			}
			return true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeChiTietPhieuMuon(String maPM, List<Pair<String, Integer>> listSp) {

		return false;
	}

	@Override
	public void updateSoLuongForSach(Pair<String, Integer> pair) {
		sachDAO.updateSoLuongForSach(pair);
	}

}
