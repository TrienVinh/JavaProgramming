package BUS;

import java.util.List;

import DTO.NhaXuatBan;

public interface NhaXuatBanService {
	List<NhaXuatBan> getListNhaXuatBan();

	boolean addNhaXuatBan(NhaXuatBan tl);

	boolean editNhaXuatBan(NhaXuatBan tl);

	boolean removeNhaXuatBan(String tl);

	String getLastid();
}
