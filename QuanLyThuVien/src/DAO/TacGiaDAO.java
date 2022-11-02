package DAO;

import java.util.List;

import DTO.TacGia;

public interface TacGiaDAO {
	List<TacGia> getListTacGia();

	boolean addTacGia(TacGia tl);

	boolean editTacGia(TacGia tl);

	boolean removeTacGia(String tl);

	String getLastid();
}
