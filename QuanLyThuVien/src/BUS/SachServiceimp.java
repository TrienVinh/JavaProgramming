package BUS;

import java.util.List;

import DAO.NgonNguDAO;
import DAO.NgonNguDAOImp;
import DAO.NhaXuatBanDAO;
import DAO.NhaXuatBanDAOImp;
import DAO.SachDAO;
import DAO.SachDAOImp;
import DAO.TacGiaDAO;
import DAO.TacGiaDAOImp;
import DAO.TheLoaiDAO;
import DAO.TheLoaiDAOImp;
import DAO.ViTriDAO;
import DAO.ViTriDAOImp;
import DTO.NgonNgu;
import DTO.NhaXuatBan;
import DTO.Sach;
import DTO.SachTimKiem;
import DTO.TacGia;
import DTO.TheLoai;
import DTO.ViTri;

public class SachServiceimp implements SachService {

	private SachDAO sachDAO;
	private TacGiaDAO tgDAO;
	private TheLoaiDAO tlDAO;
	private NhaXuatBanDAO nxbDAO;
	private ViTriDAO vtDAO;
	private NgonNguDAO nnDAO;

	public SachServiceimp() {
		super();

		sachDAO = new SachDAOImp();
		tgDAO = new TacGiaDAOImp();
		tlDAO = new TheLoaiDAOImp();
		nxbDAO = new NhaXuatBanDAOImp();
		vtDAO = new ViTriDAOImp();
		nnDAO = new NgonNguDAOImp();
	}

	@Override
	public List<Sach> getListSach() {

		return sachDAO.getListSach();
	}

	@Override
	public String getLastId() {

		return sachDAO.getLastId();
	}

	@Override
	public boolean addSach(Sach s, String idTL, String idNN) {

		return sachDAO.addSach(s, idTL, idNN);
	}

	@Override
	public boolean editSach(Sach s, String idTL, String idNN) {

		return sachDAO.editSach(s, idTL, idNN);
	}

	@Override
	public boolean removeSach(String s) {

		return sachDAO.removeSach(s);
	}

	@Override
	public String[] getComboBoxMaTG() {

		List<TacGia> listTG = tgDAO.getListTacGia();
		int size = listTG.size();
		String[] comboTG = new String[size];
		if (size > 0)
			for (int i = 0; i < listTG.size(); i++) {
				String ma = listTG.get(i).getMa_Tac_Gia();
				String ten = listTG.get(i).getHo_Ten();
				comboTG[i] = ma + " - " + ten;
			}
		return comboTG;
	}

	@Override
	public String[] getComboBoxMaTL() {

		List<TheLoai> listTL = tlDAO.getListTheLoai();
		int size = listTL.size();
		String[] comboTL = new String[size];
		if (size > 0)
			for (int i = 0; i < listTL.size(); i++) {
				String ma = listTL.get(i).getMa_The_Loai();
				String ten = listTL.get(i).getTen_The_Loai();
				comboTL[i] = ma + " - " + ten;
			}
		return comboTL;
	}

	@Override
	public String[] getComboBoxMaVT() {

		List<ViTri> listVT = vtDAO.getListViTri();
		int size = listVT.size();
		String[] comboVT = new String[size];
		if (size > 0)
			for (int i = 0; i < listVT.size(); i++) {
				String ma = listVT.get(i).getMa_Vi_Tri();
				int khu = listVT.get(i).getSo_Khu();
				int ke = listVT.get(i).getSo_Ke();
				int ngan = listVT.get(i).getSo_Ngan();
				comboVT[i] = ma + " - Khu: " + khu + " - Ke: " + ke + " - Ngan: " + ngan;
			}
		return comboVT;
	}

	@Override
	public String[] getComboBoxMaNXB() {

		List<NhaXuatBan> listNXB = nxbDAO.getListNhaXuatBan();
		int size = listNXB.size();
		String[] comboNXB = new String[size];
		if (size > 0)
			for (int i = 0; i < listNXB.size(); i++) {
				String ma = listNXB.get(i).getMa_NXB();
				String ten = listNXB.get(i).getHo_Ten();
				comboNXB[i] = ma + " - " + ten;
			}
		return comboNXB;
	}

	@Override
	public String[] getComboBoxMaNN() {

		List<NgonNgu> listNN = nnDAO.getListNgonNgu();
		int size = listNN.size();
		String[] comboNN = new String[size];
		if (size > 0)
			for (int i = 0; i < listNN.size(); i++) {
				String ma = listNN.get(i).getMa_Ngon_Ngu();
				String ten = listNN.get(i).getTen_Ngon_Ngu();
				comboNN[i] = ma + " - " + ten;
			}
		return comboNN;
	}

	@Override
	public List<SachTimKiem> getListSachTimKiem() {

		return sachDAO.getListSachTimKiem();
	}

	@Override
	public Object getSomeThingFromSach(String sql) {

		return sachDAO.getSomeThingFromSach(sql);
	}

}
