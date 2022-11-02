package BUS;

import java.util.List;

import DAO.NgonNguDAO;
import DAO.NgonNguDAOImp;
import DTO.NgonNgu;

public class NgonNguServiceImp implements NgonNguService {

	private NgonNguDAO nnDAO;

	public NgonNguServiceImp() {
		super();
		// TODO Auto-generated constructor stub
		nnDAO = new NgonNguDAOImp();
	}

	@Override
	public List<NgonNgu> getListNgonNgu() {
		// TODO Auto-generated method stub
		return nnDAO.getListNgonNgu();
	}

	@Override
	public boolean addNgonNgu(NgonNgu nn) {
		// TODO Auto-generated method stub
		return nnDAO.addNgonNgu(nn);
	}

	@Override
	public boolean editNgonNgu(NgonNgu nn) {
		// TODO Auto-generated method stub
		return nnDAO.editNgonNgu(nn);
	}

	@Override
	public boolean removeNgonNgu(NgonNgu nn) {
		// TODO Auto-generated method stub
		return nnDAO.removeNgonNgu(nn);
	}

	@Override
	public String getLastId() {
		// TODO Auto-generated method stub
		return nnDAO.getLastId();
	}

}
