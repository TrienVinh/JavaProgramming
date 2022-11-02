package BUS;

import java.util.List;

import DAO.PhieuPhatDAO;
import DAO.PhieuPhatDAOImp;
import DTO.PhieuPhat;

public class PhieuPhatServiceImp implements PhieuPhatService {

	private PhieuPhatDAO ppDAO;

	public PhieuPhatServiceImp() {
		super();

		ppDAO = new PhieuPhatDAOImp();
	}

	@Override
	public List<PhieuPhat> getListPhieuPhat() {

		return ppDAO.getListPhieuPhat();
	}

	@Override
	public boolean addPhieuPhat(PhieuPhat pp) {

		return ppDAO.addPhieuPhat(pp);
	}

	@Override
	public Object getSomeThingFromSql(String sql) {

		return ppDAO.getSomeThingFromSql(sql);
	}

}
