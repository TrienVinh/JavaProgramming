package BUS;

import java.util.List;

import DAO.PhieuNhapDAO;
import DAO.PhieuNhapDAOImp;
import DTO.ChiTietPhieuNhap;
import DTO.Pair;
import DTO.PhieuNhapHang;

public class PhieuNhapServiceImp implements PhieuNhapService {

	private PhieuNhapDAO pnDAO;

	public PhieuNhapServiceImp() {
		super();

		pnDAO = new PhieuNhapDAOImp();
	}

	@Override
	public List<PhieuNhapHang> getListPhieuNhap() {

		return pnDAO.getListPhieuNhap();
	}

	@Override
	public List<Pair<ChiTietPhieuNhap, String>> getListChiTiet(String maPN) {

		return pnDAO.getListChiTiet(maPN);
	}

	@Override
	public String getLastId() {

		return pnDAO.getLastId();
	}

	@Override
	public boolean addPhieuNhap(PhieuNhapHang pn, List<Pair<String, String>> listChiTiet) {

		return pnDAO.addPhieuNhap(pn, listChiTiet);
	}

	@Override
	public Object getSomeThing(String sql) {
		return pnDAO.getSomeThing(sql);
	}

}
