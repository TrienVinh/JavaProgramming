package DAO;

import java.util.List;

import DTO.ChiTietPhieuNhap;
import DTO.Pair;

public interface ChiTietPhieuNhapDAO {
	List<ChiTietPhieuNhap> getListChiTiet(String maPN);

	boolean addChiTiet(List<Pair<String, String>> listChiTiet, String maPN);
}
