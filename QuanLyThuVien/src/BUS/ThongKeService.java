package BUS;

import java.util.List;

import DTO.ChiTietPhieuMuon;
import DTO.DocGia;
import DTO.Pair;
import DTO.PhieuMuon;
import DTO.PhieuPhat;
import DTO.Sach;

public interface ThongKeService {
	List<Pair<String, Double>> get3LoaiSach(String sql);

	List<PhieuMuon> getPhieuMuon(String sql);

	List<Pair<ChiTietPhieuMuon, String>> getListChiTiet(String maPM);

	List<Sach> getListSach(String sql);
	
	public Pair<String, String> getTen(String maPM);
	
	List<Pair<DocGia, Double>> getListDocGia(String sql);
	
	List<Pair<String, Pair<String, Double>>> getListTwoPair(String sql);
	
	List<PhieuPhat> getListPhieuPhat(String sql);
}
