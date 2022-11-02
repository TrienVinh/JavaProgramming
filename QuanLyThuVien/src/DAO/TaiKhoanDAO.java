package DAO;

import java.util.List;

import DTO.Pair;
import DTO.TaiKhoan;

public interface TaiKhoanDAO {
	Pair<TaiKhoan, String> login(String tdn, String mk);

	TaiKhoan getLastUser();

	void editTime(TaiKhoan tk);

	boolean editPass(TaiKhoan tk);

	TaiKhoan checkPass(String cmnd, String tdn);

	List<TaiKhoan> getListTaiKhoan();

	String[] getListMaNhanVien();

	boolean addTaiKhoan(TaiKhoan tk);

	boolean edtTaiKhoan(TaiKhoan tk);

	boolean removeTaiKhoa(String tk);

}
