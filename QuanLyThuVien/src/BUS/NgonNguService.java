package BUS;

import java.util.List;

import DTO.NgonNgu;

public interface NgonNguService {
	List<NgonNgu> getListNgonNgu();

	boolean addNgonNgu(NgonNgu nn);

	boolean editNgonNgu(NgonNgu nn);

	boolean removeNgonNgu(NgonNgu nn);

	String getLastId();
}
