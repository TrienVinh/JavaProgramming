package BUS;

import java.util.List;

import DAO.TheLoaiDAO;
import DAO.TheLoaiDAOImp;
import DTO.TheLoai;

public class TheLoaiServiceImp implements TheLoaiService {

	private TheLoaiDAO tlDAO = null;

	public TheLoaiServiceImp() {
		super();

		tlDAO = new TheLoaiDAOImp();
	}

	@Override
	public List<TheLoai> getListTheLoai() {

		return tlDAO.getListTheLoai();
	}

	@Override
	public boolean addTheLoai(TheLoai tl) {

		return tlDAO.addTheLoai(tl);
	}

	@Override
	public boolean editTheLoai(TheLoai tl) {

		return tlDAO.editTheLoai(tl);
	}

	@Override
	public boolean removeTheLoai(String tl) {

		return tlDAO.removeTheLoai(tl);
	}

	@Override
	public String getLastid() {
		// TODO Auto-generated method stub
		return tlDAO.getLastid();
	}

}
