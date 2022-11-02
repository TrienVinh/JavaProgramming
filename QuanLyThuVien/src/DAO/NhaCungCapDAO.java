package DAO;

import java.util.List;

import DTO.NhaCungCap;

public interface NhaCungCapDAO {
	List<NhaCungCap> getListNhaCungCap();

	boolean addNhaCungCap(NhaCungCap tl);

	boolean editNhaCungCap(NhaCungCap tl);

	boolean removeNhaCungCap(String matl);

	String getLastid();
}
