package DAO;

import java.util.List;

import DTO.ViTri;

public interface ViTriDAO {
	List<ViTri> getListViTri();

	boolean addViTri(ViTri vt);

	boolean editViTri(ViTri vt);

	boolean removeViTri(String vt);

	String getLastId();
	
	boolean searchViTri(ViTri vt);

}
