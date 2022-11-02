package BUS;

import java.util.List;

import DTO.NhaCungCap;

public interface NhaCungCapService {
	List<NhaCungCap> getListNhaCungCap();

	boolean addNhaCungCap(NhaCungCap tl);

	boolean editNhaCungCap(NhaCungCap tl);

	boolean removeNhaCungCap(String maTl);

	String getLastid();
}
