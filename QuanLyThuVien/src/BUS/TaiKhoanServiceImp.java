package BUS;

import java.util.List;

import DAO.TaiKhoanDAO;
import DAO.TaiKhoanDAOIpm;
import DTO.Pair;
import DTO.TaiKhoan;

public class TaiKhoanServiceImp implements TaiKhoanService {

	private TaiKhoanDAO tkDAO = null;

	public TaiKhoanServiceImp() {
		super();

		tkDAO = new TaiKhoanDAOIpm();
	}

	@Override
	public Pair<TaiKhoan, String> login(String tdn, String mk) {

		return tkDAO.login(tdn, mk);
	}

	@Override
	public TaiKhoan getLastUser() {

		return tkDAO.getLastUser();
	}

	@Override
	public void editTime(TaiKhoan tk) {

		tkDAO.editTime(tk);
	}

	@Override
	public boolean editPass(TaiKhoan tk) {

		return tkDAO.editPass(tk);
	}

	@Override
	public TaiKhoan checkPass(String cmnd, String tdn) {

		return tkDAO.checkPass(cmnd, tdn);
	}

	@Override
	public List<TaiKhoan> getListTaiKhoan() {

		return tkDAO.getListTaiKhoan();
	}

	@Override
	public String[] getListMaNhanVien() {

		return tkDAO.getListMaNhanVien();
	}

	@Override
	public boolean addTaiKhoan(TaiKhoan tk) {

		return tkDAO.addTaiKhoan(tk);
	}

	@Override
	public boolean edtTaiKhoan(TaiKhoan tk) {

		return tkDAO.edtTaiKhoan(tk);
	}

	@Override
	public boolean removeTaiKhoa(String tk) {

		return tkDAO.removeTaiKhoa(tk);
	}

}
