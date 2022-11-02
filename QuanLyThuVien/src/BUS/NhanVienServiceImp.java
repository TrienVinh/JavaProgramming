package BUS;

import java.util.List;

import DAO.NhanVienDAO;
import DAO.NhanVienDAOImp;
import DTO.NhanVien;

public class NhanVienServiceImp implements NhanVienService {

	private NhanVienDAO nvDAO = null;

	public NhanVienServiceImp() {
		super();
		
		nvDAO = new NhanVienDAOImp();
	}

	@Override
	public List<NhanVien> getListNhanVien() {
		
		return nvDAO.getListNhanVien();
	}

	@Override
	public String getLastNhanVien() {
		
		return nvDAO.getLastNhanVien();
	}

	@Override
	public boolean addNhanVien(NhanVien nv) {
		
		return nvDAO.addNhanVien(nv);
	}

	@Override
	public boolean insertNhanVien(NhanVien nv) {

		return nvDAO.insertNhanVien(nv);
	}

	@Override
	public boolean removeNhanVien(String nv) {
		
		return nvDAO.removeNhanVien(nv);
	}

}
