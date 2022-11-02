package BUS;

import java.util.List;

import DAO.PhieuMuonDAO;
import DAO.PhieuMuonDAOImp;
import DTO.ChiTietPhieuMuon;
import DTO.DocGia;
import DTO.NhanVien;
import DTO.Pair;
import DTO.PhieuMuon;

public class PhieuMuonServiceImp implements PhieuMuonService {

	private PhieuMuonDAO pmDAO;

	public PhieuMuonServiceImp() {
		super();

		pmDAO = new PhieuMuonDAOImp();
	}

	@Override
	public List<PhieuMuon> getListPhieuMuon() {

		return pmDAO.getListPhieuMuon();
	}

	@Override
	public boolean addPhieuMuon(PhieuMuon pm, List<Pair<String, Integer>> listSp, Pair<String, String> CMNDAndTen) {

		return pmDAO.addPhieuMuon(pm, listSp, CMNDAndTen);
	}

	@Override
	public String getLastId() {

		return pmDAO.getListId();
	}

	@Override
	public List<Pair<ChiTietPhieuMuon, String>> getListChiTiet(String maPM) {

		return pmDAO.getListChiTiet(maPM);
	}

	@Override
	public DocGia getDocGiaFromPhieuMuon(String maPM) {

		return pmDAO.getDocGiaFromPhieuMuon(maPM);
	}

	@Override
	public NhanVien getNhanVienFromPhieuMuon(String maPM) {

		return pmDAO.getNhanVienFromPhieuMuon(maPM);
	}

	@Override
	public boolean editPhieuTra(List<ChiTietPhieuMuon> listChiTiet) {

		return pmDAO.editPhieuTra(listChiTiet);
	}

	@Override
	public void updateSoLuongForSach(Pair<String, Integer> pair) {

		pmDAO.updateSoLuongForSach(pair);
	}

	@Override
	public void updateHoanTraForPhieuMuon(String maPM) {

		pmDAO.updateHoanTraForPhieuMuon(maPM);
	}

	@Override
	public PhieuMuon getPhieuMuonFromMa(String maPM) {

		return pmDAO.getPhieuMuonFromMa(maPM);
	}

	@Override
	public Pair<String, String> getTenDGAndTenNV(String maPM) {

		return pmDAO.getTenDGAndTenNV(maPM);
	}

}
