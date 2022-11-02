package BUS;

import java.util.List;

import DAO.ThongKeDAO;
import DAO.ThongKeDAOImp;
import DTO.ChiTietPhieuMuon;
import DTO.DocGia;
import DTO.Pair;
import DTO.PhieuMuon;
import DTO.PhieuPhat;
import DTO.Sach;

public class ThongKeServiceImp implements ThongKeService {

	private ThongKeDAO tkDAO;

	public ThongKeServiceImp() {
		super();

		tkDAO = new ThongKeDAOImp();
	}

	@Override
	public List<Pair<String, Double>> get3LoaiSach(String sql) {

		return tkDAO.get3LoaiSach(sql);
	}

	@Override
	public List<PhieuMuon> getPhieuMuon(String sql) {

		return tkDAO.getPhieuMuon(sql);
	}

	@Override
	public List<Pair<ChiTietPhieuMuon, String>> getListChiTiet(String maPM) {

		return tkDAO.getListChiTiet(maPM);
	}

	@Override
	public List<Sach> getListSach(String sql) {

		return tkDAO.getListSach(sql);
	}

	@Override
	public Pair<String, String> getTen(String maPM) {

		return tkDAO.getTen(maPM);
	}

	@Override
	public List<Pair<DocGia, Double>> getListDocGia(String sql) {

		return tkDAO.getListDocGia(sql);
	}

	@Override
	public List<Pair<String, Pair<String, Double>>> getListTwoPair(String sql) {

		return tkDAO.getListTwoPair(sql);
	}

	@Override
	public List<PhieuPhat> getListPhieuPhat(String sql) {

		return tkDAO.getListPhieuPhat(sql);
	}

}
