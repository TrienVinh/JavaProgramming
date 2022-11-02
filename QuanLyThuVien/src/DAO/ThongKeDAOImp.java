package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.ChiTietPhieuMuon;
import DTO.DocGia;
import DTO.Pair;
import DTO.PhieuMuon;
import DTO.PhieuPhat;
import DTO.Sach;

public class ThongKeDAOImp implements ThongKeDAO {

	private MySQLConnect DBConnect;
	private PhieuMuonDAO pmDAO;
	private SachDAO sDAO;
	private PhieuPhatDAO ppDAO;

	public ThongKeDAOImp() {
		super();

		DBConnect = new MySQLConnect();
		pmDAO = new PhieuMuonDAOImp();
		sDAO = new SachDAOImp();
		ppDAO = new PhieuPhatDAOImp();
	}

	@Override
	public List<Pair<String, Double>> get3LoaiSach(String sql) {

		List<Pair<String, Double>> listPair = new ArrayList<Pair<String, Double>>();
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pair<String, Double> pair = new Pair<String, Double>();
				pair.setK(rs.getString(1));
				pair.setV(rs.getDouble(2));
				listPair.add(pair);
			}
			conn.close();
			return listPair;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<PhieuMuon> getPhieuMuon(String sql) {
		return pmDAO.getListPhieuMuon(sql);
	}

	public List<Pair<ChiTietPhieuMuon, String>> getListChiTiet(String maPM) {
		return pmDAO.getListChiTiet(maPM);
	}

	@Override
	public List<Sach> getListSach(String sql) {

		return sDAO.getList(sql);
	}

	public Pair<String, String> getTen(String sql) {
		return pmDAO.getTenDGAndTenNV(sql);
	}

	@Override
	public List<Pair<DocGia, Double>> getListDocGia(String sql) {
		List<Pair<DocGia, Double>> listItem = new ArrayList<Pair<DocGia, Double>>();
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DocGia dg = new DocGia();

				dg.setMa_Doi_Tuong(rs.getString("ma_doc_gia"));
				dg.setChuc_Vu(rs.getString("nghe_nghiep"));
				dg.setCMND(rs.getString("cmnd"));
				dg.setDia_Chi(rs.getString("dia_chi"));
				dg.setEmail(rs.getString("email"));
				dg.setGioi_Tinh(rs.getBoolean("gioi_tinh"));
				dg.setHo(rs.getString("ho"));
				dg.setTen(rs.getString("ten"));
				dg.setNgay_Sinh(rs.getDate("ngay_sinh"));
				dg.setSo_Dien_Thoai(rs.getString("so_dien_thoai"));

				double soLuongMuon = rs.getDouble("so_luong_muon");
				Pair<DocGia, Double> pair = new Pair<DocGia, Double>(dg, soLuongMuon);
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
	public List<Pair<String, Pair<String, Double>>> getListTwoPair(String sql) {
		List<Pair<String, Pair<String, Double>>> listItem = new ArrayList<Pair<String, Pair<String, Double>>>();
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String s = rs.getString(1);
				Pair<String, Double> pair = new Pair<String, Double>(rs.getString(2), rs.getDouble(3));
				Pair<String, Pair<String, Double>> pairItem = new Pair<String, Pair<String, Double>>(s, pair);
				listItem.add(pairItem);
			}
			conn.close();
			return listItem;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PhieuPhat> getListPhieuPhat(String sql) {
		return ppDAO.getListPhieuPhat(sql);
	}
}
