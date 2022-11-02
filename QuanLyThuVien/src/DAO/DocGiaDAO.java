package DAO;

import java.util.List;

import DTO.DocGia;

public interface DocGiaDAO {

	List<DocGia> getListDocGia();
	
	String getLastDocGia();
	
	boolean addDocGia(DocGia dg);
	
	boolean insertDocGia(DocGia dg);
	
	boolean removeDocGia(String dg);
}
