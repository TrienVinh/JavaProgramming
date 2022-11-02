package DAO;

import java.util.List;

import DTO.ChiTietPhieuMuon;
import DTO.Pair;

public interface ChiTietPhieuMuonDAO {
	List<Pair<ChiTietPhieuMuon, String>> getListChiTiet(String maPM);

	boolean addChiTietPhieuMuon(String maPM, List<Pair<String, Integer>> listSp);

	boolean editChiTietPhieuMuon(List<ChiTietPhieuMuon> listChiTiet);

	boolean removeChiTietPhieuMuon(String maPM, List<Pair<String, Integer>> listSp);
	
	void updateSoLuongForSach(Pair<String, Integer> pair);
}
