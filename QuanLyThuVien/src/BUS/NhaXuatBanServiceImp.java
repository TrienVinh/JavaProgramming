package BUS;

import java.util.List;

import DAO.NhaXuatBanDAO;
import DAO.NhaXuatBanDAOImp;
import DTO.NhaXuatBan;

public class NhaXuatBanServiceImp implements NhaXuatBanService {

	private NhaXuatBanDAO nxbDAO;

	public NhaXuatBanServiceImp() {
		super();
		// TODO Auto-generated constructor stub
		nxbDAO = new NhaXuatBanDAOImp();
	}

	@Override
	public List<NhaXuatBan> getListNhaXuatBan() {
		// TODO Auto-generated method stub
		return nxbDAO.getListNhaXuatBan();
	}

	@Override
	public boolean addNhaXuatBan(NhaXuatBan tl) {
		// TODO Auto-generated method stub
		return nxbDAO.addNhaXuatBan(tl);
	}

	@Override
	public boolean editNhaXuatBan(NhaXuatBan tl) {
		// TODO Auto-generated method stub
		return nxbDAO.editNhaXuatBan(tl);
	}

	@Override
	public boolean removeNhaXuatBan(String tl) {
		// TODO Auto-generated method stub
		return nxbDAO.removeNhaXuatBan(tl);
	}

	@Override
	public String getLastid() {
		// TODO Auto-generated method stub
		return nxbDAO.getLastid();
	}

}
