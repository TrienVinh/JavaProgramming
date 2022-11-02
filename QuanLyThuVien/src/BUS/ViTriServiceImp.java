package BUS;

import java.util.List;

import DAO.ViTriDAO;
import DAO.ViTriDAOImp;
import DTO.ViTri;

public class ViTriServiceImp implements ViTtriService {

	private ViTriDAO vtDAO;

	public ViTriServiceImp() {
		super();

		vtDAO = new ViTriDAOImp();
	}

	@Override
	public List<ViTri> getListViTri() {

		return vtDAO.getListViTri();
	}

	@Override
	public boolean addViTri(ViTri vt) {

		return vtDAO.addViTri(vt);
	}

	@Override
	public boolean editViTri(ViTri vt) {

		return vtDAO.editViTri(vt);
	}

	@Override
	public boolean removeViTri(String vt) {

		return vtDAO.removeViTri(vt);
	}

	@Override
	public String getLastId() {

		return vtDAO.getLastId();
	}

	@Override
	public boolean searchViTri(ViTri vt) {

		return vtDAO.searchViTri(vt);
	}

}
