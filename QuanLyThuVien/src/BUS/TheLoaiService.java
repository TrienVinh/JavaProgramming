package BUS;

import java.util.List;

import DTO.TheLoai;

public interface TheLoaiService {
	List<TheLoai> getListTheLoai();

	boolean addTheLoai(TheLoai tl);

	boolean editTheLoai(TheLoai tl);

	boolean removeTheLoai(String tl);

	String getLastid();
}
