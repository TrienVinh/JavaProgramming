package DAO;

import java.util.List;

import DTO.NhaXuatBan;

public interface NhaXuatBanDAO {
	List<NhaXuatBan> getListNhaXuatBan();

	boolean addNhaXuatBan(NhaXuatBan tl);

	boolean editNhaXuatBan(NhaXuatBan tl);

	boolean removeNhaXuatBan(String tl);

	String getLastid();
}
