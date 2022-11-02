package DAO;

import java.util.List;

import DTO.ChiTietPhieuNhap;
import DTO.Pair;
import DTO.PhieuNhapHang;

public interface PhieuNhapDAO {
	List<PhieuNhapHang> getListPhieuNhap();

	List<Pair<ChiTietPhieuNhap, String>> getListChiTiet(String maPN);

	String getLastId();

	boolean addPhieuNhap(PhieuNhapHang pn , List<Pair<String, String>> listChiTiet);
	
	Object getSomeThing(String sql);
}
