package DAO;

import java.util.List;

import DTO.ChiTietPhieuMuon;
import DTO.DocGia;
import DTO.NhanVien;
import DTO.Pair;
import DTO.PhieuMuon;

public interface PhieuMuonDAO {
	boolean addPhieuMuon(PhieuMuon pm, List<Pair<String, Integer>> listSp, Pair<String, String> CMNDAndTen);

	List<PhieuMuon> getListPhieuMuon();

	List<PhieuMuon> getListPhieuMuon(String sql);

	String getListId();

	List<Pair<ChiTietPhieuMuon, String>> getListChiTiet(String maPM);

	DocGia getDocGiaFromPhieuMuon(String maPM);

	NhanVien getNhanVienFromPhieuMuon(String maPM);
	
	Pair<String, String> getTenDGAndTenNV(String sql);

	boolean editPhieuTra(List<ChiTietPhieuMuon> listChiTiet);

	void updateSoLuongForSach(Pair<String, Integer> pair);

	void updateHoanTraForPhieuMuon(String maPM);

	PhieuMuon getPhieuMuonFromMa(String maPM);
}
