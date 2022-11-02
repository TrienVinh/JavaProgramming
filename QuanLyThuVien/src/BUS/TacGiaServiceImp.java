package BUS;

import java.util.List;

import DAO.TacGiaDAO;
import DAO.TacGiaDAOImp;
import DTO.TacGia;

public class TacGiaServiceImp implements TacGiaService {

	private TacGiaDAO tgDAO;

	public TacGiaServiceImp() {
		super();
		this.tgDAO = new TacGiaDAOImp();
	}

	@Override
	public List<TacGia> getListTacGia() {

		return tgDAO.getListTacGia();
	}

	@Override
	public boolean addTacGia(TacGia tg) {

		return tgDAO.addTacGia(tg);
	}

	@Override
	public boolean editTacGia(TacGia tg) {

		return tgDAO.editTacGia(tg);
	}

	@Override
	public boolean removeTacGia(String tg) {

		return tgDAO.removeTacGia(tg);
	}

	@Override
	public String getLastid() {

		return tgDAO.getLastid();
	}

}
