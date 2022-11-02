package DAO;

import java.util.List;

import DTO.NhanVien;

public interface NhanVienDAO {
	List<NhanVien> getListNhanVien();

	String getLastNhanVien();

	boolean addNhanVien(NhanVien nv);

	boolean insertNhanVien(NhanVien nv);

	boolean removeNhanVien(String nv);
}
