package BUS;

import java.util.List;

import DAO.DocGiaDAO;
import DAO.DocGiaDAOImp;
import DTO.DocGia;

public class DocGiaServiceImp implements DocGiaService {

	private DocGiaDAO dgDAO = null;

	public DocGiaServiceImp() {
		super();

		dgDAO = new DocGiaDAOImp();
	}

	@Override
	public List<DocGia> getListDocGia() {

		return dgDAO.getListDocGia();
	}

	@Override
	public String getLastDocGia() {

		return dgDAO.getLastDocGia();
	}

	@Override
	public boolean addDocGia(DocGia dg) {

		return dgDAO.addDocGia(dg);
	}

	@Override
	public boolean insertDocGia(DocGia dg) {

		return dgDAO.insertDocGia(dg);
	}

	@Override
	public boolean removeDocGia(String dg) {

		return dgDAO.removeDocGia(dg);
	}

}
