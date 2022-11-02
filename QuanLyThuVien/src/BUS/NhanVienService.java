package BUS;

import java.util.List;

import DTO.NhanVien;


public interface NhanVienService {
	List<NhanVien> getListNhanVien();

	String getLastNhanVien();

	boolean addNhanVien(NhanVien nv);

	boolean insertNhanVien(NhanVien nv);

	boolean removeNhanVien(String nv);
}
