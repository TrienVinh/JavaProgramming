package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.ChiTietPhieuMuon;
import DTO.DocGia;
import DTO.NhanVien;
import DTO.Pair;
import DTO.PhieuMuon;

public class PhieuMuonDAOImp implements PhieuMuonDAO {

	private MySQLConnect DBConnect;
	private ChiTietPhieuMuonDAO ctpmDAO;

	public PhieuMuonDAOImp() {
		super();

		DBConnect = new MySQLConnect();
		this.ctpmDAO = new ChiTietPhieuMuonDAOImp();
	}

	@Override
	public List<PhieuMuon> getListPhieuMuon() {

		List<PhieuMuon> listItem = new ArrayList<PhieuMuon>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select * from phieu_muon";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PhieuMuon pm = new PhieuMuon();
				pm.setMa_Phieu_Muon(rs.getString("ma_phieu_muon"));
				pm.setMa_Doc_Gia(rs.getString("ma_doc_gia"));
				pm.setMa_Nhan_Vien(rs.getString("ma_nhan_vien"));
				pm.setNgay_Muon(rs.getDate("ngay_muon"));
				pm.setNgay_Phai_Tra(rs.getDate("ngay_phai_tra"));
				pm.setTong_So_Sach_Muon(rs.getInt("tong_so_sach_muon"));
				pm.setHoan_Tra(rs.getBoolean("hoan_tra"));

				listItem.add(pm);
			}

			conn.close();
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addPhieuMuon(PhieuMuon pm, List<Pair<String, Integer>> listSp, Pair<String, String> CMNDAndTen) {

		try {
			String sql = "insert into phieu_muon values(";
			sql += "'" + pm.getMa_Phieu_Muon() + "',";
			sql += "'" + getMaDGFromCMNDAndTen(CMNDAndTen.getK(), CMNDAndTen.getV()) + "',";
			sql += "'" + pm.getMa_Nhan_Vien() + "',";
			sql += "'" + new Date(pm.getNgay_Muon().getTime()) + "',";
			sql += "'" + new Date(pm.getNgay_Phai_Tra().getTime()) + "',";
			sql += "" + pm.getTong_So_Sach_Muon() + ",";
			sql += 0 + ")"; // hoan tra

			DBConnect.executeUpdate(sql);

			ctpmDAO.addChiTietPhieuMuon(pm.getMa_Phieu_Muon(), listSp);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getListId() {

		String s = "";
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select max(ma_phieu_muon) as max_pm from phieu_muon";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				s = rs.getString("max_pm");
			}
			conn.close();
			return s;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return s;
	}

	public String getMaDGFromCMNDAndTen(String cmnd, String ten) {
		String s = "";
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select doc_gia.ma_doc_gia from doc_gia where doc_gia.cmnd = ? and doc_gia.ho like ? and doc_gia.ten like ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			int indexKT = ten.lastIndexOf(' ');
			ps.setString(1, cmnd);
			ps.setString(2, ten.substring(0, indexKT).trim());
			ps.setString(3, ten.substring(indexKT).trim());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = rs.getString("ma_doc_gia");
			}
			conn.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Pair<ChiTietPhieuMuon, String>> getListChiTiet(String maPM) {

		return ctpmDAO.getListChiTiet(maPM);
	}

	@Override
	public DocGia getDocGiaFromPhieuMuon(String maPM) {

		DocGia dg = new DocGia();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select doc_gia.* from doc_gia , phieu_muon where phieu_muon.ma_phieu_muon = ? and phieu_muon.ma_doc_gia = doc_gia.ma_doc_gia";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maPM);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

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

			}
			conn.close();
			return dg;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public NhanVien getNhanVienFromPhieuMuon(String maPM) {

		NhanVien nv = new NhanVien();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select nhan_vien.* from nhan_vien , phieu_muon where phieu_muon.ma_phieu_muon = ? and phieu_muon.ma_nhan_vien = nhan_vien.ma_nhan_vien";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maPM);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				nv.setMa_Doi_Tuong(rs.getString("ma_nhan_vien"));
				nv.setChuc_Vu(rs.getString("chuc_vu"));
				nv.setCMND(rs.getString("cmnd"));
				nv.setDia_Chi(rs.getString("dia_chi"));
				nv.setEmail(rs.getString("email"));
				nv.setGioi_Tinh(rs.getBoolean("gioi_tinh"));
				nv.setHo(rs.getString("ho"));
				nv.setTen(rs.getString("ten"));
				nv.setNgay_Sinh(rs.getDate("ngay_sinh"));
				nv.setSo_Dien_Thoai(rs.getString("so_dien_thoai"));

			}
			conn.close();
			return nv;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean editPhieuTra(List<ChiTietPhieuMuon> listChiTiet) {
		return ctpmDAO.editChiTietPhieuMuon(listChiTiet);
	}

	@Override
	public void updateSoLuongForSach(Pair<String, Integer> pair) {

		ctpmDAO.updateSoLuongForSach(pair);
	}

	@Override
	public void updateHoanTraForPhieuMuon(String maPM) {

		try {
			String sql = "update phieu_muon set hoan_tra = 1 where ma_phieu_muon = '" + maPM + "'";
			DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public PhieuMuon getPhieuMuonFromMa(String maPM) {
		PhieuMuon pm = new PhieuMuon();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select phieu_muon.* from phieu_muon where ma_phieu_muon = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				pm.setMa_Phieu_Muon(rs.getString("ma_phieu_muon"));
				pm.setMa_Doc_Gia(rs.getString("ma_doc_gia"));
				pm.setMa_Nhan_Vien(rs.getString("ma_nhan_vien"));
				pm.setNgay_Muon(rs.getDate("ngay_muon"));
				pm.setNgay_Phai_Tra(rs.getDate("ngay_phai_tra"));
				pm.setTong_So_Sach_Muon(rs.getInt("tong_so_sach_muon"));
				pm.setHoan_Tra(rs.getBoolean("hoan_tra"));

			}
			conn.close();
			return pm;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PhieuMuon> getListPhieuMuon(String sql) {
		List<PhieuMuon> listItem = new ArrayList<PhieuMuon>();
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PhieuMuon pm = new PhieuMuon();
				pm.setMa_Phieu_Muon(rs.getString("ma_phieu_muon"));
				pm.setMa_Doc_Gia(rs.getString("ma_doc_gia"));
				pm.setMa_Nhan_Vien(rs.getString("ma_nhan_vien"));
				pm.setNgay_Muon(rs.getDate("ngay_muon"));
				pm.setNgay_Phai_Tra(rs.getDate("ngay_phai_tra"));
				pm.setTong_So_Sach_Muon(rs.getInt("tong_so_sach_muon"));
				pm.setHoan_Tra(rs.getBoolean("hoan_tra"));

				listItem.add(pm);
			}

			conn.close();
			return listItem;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Pair<String, String> getTenDGAndTenNV(String sql) {
		Pair<String, String> pair = new Pair<String, String>();
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String tenDG = "", tenNV = "";
			while (rs.next()) {
				tenDG = rs.getString(1);
				tenNV = rs.getString(2);
			}
			pair.setK(tenDG);
			pair.setV(tenNV);
			conn.close();
			return pair;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
