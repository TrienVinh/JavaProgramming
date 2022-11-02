package BUS;

import java.util.List;

import DTO.Sach;
import DTO.SachTimKiem;

public interface SachService {
	List<Sach> getListSach();

	List<SachTimKiem> getListSachTimKiem();

	String getLastId();

	boolean addSach(Sach s, String idTL, String idNN);

	boolean editSach(Sach s, String idTL, String idNN);

	boolean removeSach(String s);

	String[] getComboBoxMaTG();

	String[] getComboBoxMaTL();

	String[] getComboBoxMaVT();

	String[] getComboBoxMaNXB();

	String[] getComboBoxMaNN();

	Object getSomeThingFromSach(String sql);
}
