package BUS;

import java.util.List;

import DTO.DocGia;


public interface DocGiaService {
	List<DocGia> getListDocGia();

	String getLastDocGia();

	boolean addDocGia(DocGia dg);

	boolean insertDocGia(DocGia dg);
	
	boolean removeDocGia(String dg);
}
