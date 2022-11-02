package BUS;

import java.util.List;

import DAO.NhaCungCapDAO;
import DAO.NhaCungCapDAOImp;
import DTO.NhaCungCap;

public class NhaCungCapServiceImp implements NhaCungCapService {

	private NhaCungCapDAO nccDAO;

	public NhaCungCapServiceImp() {
		super();

		nccDAO = new NhaCungCapDAOImp();
	}

	@Override
	public List<NhaCungCap> getListNhaCungCap() {

		return nccDAO.getListNhaCungCap();
	}

	@Override
	public boolean addNhaCungCap(NhaCungCap tl) {

		return nccDAO.addNhaCungCap(tl);
	}

	@Override
	public boolean editNhaCungCap(NhaCungCap tl) {

		return nccDAO.editNhaCungCap(tl);
	}

	@Override
	public boolean removeNhaCungCap(String tl) {

		return nccDAO.removeNhaCungCap(tl);
	}

	@Override
	public String getLastid() {

		return nccDAO.getLastid();
	}

}
