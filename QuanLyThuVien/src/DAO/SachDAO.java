package DAO;

import java.util.List;

import DTO.Pair;
import DTO.Sach;
import DTO.SachTimKiem;

public interface SachDAO {
	List<Sach> getListSach();

	List<Sach> getList(String sql);

	List<SachTimKiem> getListSachTimKiem();

	String getLastId();

	boolean addSach(Sach s, String idTL, String idNN);

	boolean editSach(Sach s, String idTL, String idNN);

	boolean removeSach(String s);

	Object getSomeThingFromSach(String sql);

	public void updateSoLuongForSach(Pair<String, Integer> pair);

}
