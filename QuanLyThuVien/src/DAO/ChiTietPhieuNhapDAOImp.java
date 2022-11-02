package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.ChiTietPhieuNhap;
import DTO.Pair;

public class ChiTietPhieuNhapDAOImp implements ChiTietPhieuNhapDAO {

	private SachDAO sDAO;
	private MySQLConnect DBConnect;

	public ChiTietPhieuNhapDAOImp() {
		super();
		sDAO = new SachDAOImp();
		DBConnect = new MySQLConnect();
	}

	@Override
	public List<ChiTietPhieuNhap> getListChiTiet(String maPN) {

		List<ChiTietPhieuNhap> listChiTiet = new ArrayList<ChiTietPhieuNhap>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = " select * from chi_tiet_phieu_nhap where ma_phieu_nhap = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maPN);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
				ctpn.setMaPN(maPN);
				ctpn.setMaSach(rs.getString("ma_sach"));
				ctpn.setSo_Luong(rs.getInt("so_luong"));
				ctpn.setTong_Gia_Tien(rs.getInt("gia_tien"));
				listChiTiet.add(ctpn);
			}
			conn.close();
			return listChiTiet;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addChiTiet(List<Pair<String, String>> listChiTiet, String maPN) {

		try {
			String sql = "insert into chi_tiet_phieu_nhap values";

			for (Pair<String, String> pair : listChiTiet) {
				String[] temp = pair.getV().split(" - ");
				sql += "('" + maPN + "',";
				sql += "'" + pair.getK() + "',";
				sql += "" + temp[0] + ",";
				sql += "" + temp[1] + "),";

				sDAO.updateSoLuongForSach(new Pair<String, Integer>(pair.getK(), Integer.parseInt(temp[0]) * -1));
			}

			sql = sql.substring(0, sql.length() - 1);

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

}
