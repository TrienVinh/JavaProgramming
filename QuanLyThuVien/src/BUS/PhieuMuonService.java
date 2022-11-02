package BUS;

import java.util.List;

import DTO.ChiTietPhieuMuon;
import DTO.DocGia;
import DTO.NhanVien;
import DTO.Pair;
import DTO.PhieuMuon;

public interface PhieuMuonService {

	List<PhieuMuon> getListPhieuMuon();

	boolean addPhieuMuon(PhieuMuon pm, List<Pair<String, Integer>> listSp, Pair<String, String> CMNDAndTen);

	String getLastId();

	List<Pair<ChiTietPhieuMuon, String>> getListChiTiet(String maPM);

	DocGia getDocGiaFromPhieuMuon(String maPM);

	NhanVien getNhanVienFromPhieuMuon(String maPM);

	boolean editPhieuTra(List<ChiTietPhieuMuon> listChiTiet);

	void updateSoLuongForSach(Pair<String, Integer> pair);

	void updateHoanTraForPhieuMuon(String maPM);

	PhieuMuon getPhieuMuonFromMa(String maPM);

	Pair<String, String> getTenDGAndTenNV(String maPM);
}
