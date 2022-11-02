package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DTO.Pair;
import DTO.TaiKhoan;

public class TaiKhoanDAOIpm implements TaiKhoanDAO {

	private MySQLConnect DBConnect;

	public TaiKhoanDAOIpm() {
		super();

		DBConnect = new MySQLConnect();
	}

	@Override
	public Pair<TaiKhoan, String> login(String tdn, String mk) {

		try {
			String nameNhanVien = "";
			TaiKhoan tk = new TaiKhoan();
			Connection conn = DBConnect.getConnect();
			String sql = "select tai_khoan.* , nhan_vien.ho,nhan_vien.ten from tai_khoan , nhan_vien where ten_dang_nhap = ? and mat_khau =? AND nhan_vien.ma_nhan_vien = tai_khoan.ma_nhan_vien";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tdn);
			ps.setString(2, mk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tk.setMa_Tai_Khoan(rs.getString("ma_tai_khoan"));
				tk.setTen_Dang_Nhap(rs.getString("ten_dang_nhap"));
				tk.setMat_Khau(rs.getString("mat_khau"));
				tk.setTinh_Trang(rs.getBoolean("tinh_trang"));
				tk.setNgay_dang_nhap(rs.getDate("ngay_dang_nhap"));
				tk.setAdmin(rs.getBoolean("quyen"));
				tk.setMa_Nhan_Vien(rs.getString("ma_nhan_vien"));

				nameNhanVien = rs.getString("ho") + " " + rs.getString("ten");
			}

			conn.close();
			return new Pair<TaiKhoan, String>(tk, nameNhanVien);
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Loi He Thong", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TaiKhoan getLastUser() {

		TaiKhoan tk = null;
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "SELECT * FROM tai_khoan WHERE ma_tai_khoan = (SELECT MAX(ma_tai_khoan) FROM tai_khoan) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tk = new TaiKhoan(rs.getString("ma_tai_khoan"));
				tk.setTen_Dang_Nhap(rs.getString("ten_dang_nhap"));
				tk.setMat_Khau(rs.getString("mat_khau"));
				tk.setTinh_Trang(rs.getBoolean("tinh_trang"));
				tk.setNgay_dang_nhap(rs.getDate("ngay_dang_nhap"));
				tk.setAdmin(rs.getBoolean("quyen"));
				tk.setMa_Nhan_Vien(rs.getString("ma_nhan_vien"));
			}
			conn.close();
			return tk;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void editTime(TaiKhoan tk) {

		try {
			String sql = "";
			sql += "update tai_khoan set ";
			sql += "ngay_dang_nhap = '" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tk.getNgay_dang_nhap())
					+ "' where ";
			sql += "ma_tai_khoan = '" + tk.getMa_Tai_Khoan() + "'";
			DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public boolean editPass(TaiKhoan tk) {

		try {
			String sql = "";
			sql += "update tai_khoan set ";
			sql += "mat_khau = '" + tk.getMat_Khau() + "' where ";
			sql += "ma_tai_khoan = '" + tk.getMa_Tai_Khoan() + "'";

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public TaiKhoan checkPass(String cmnd, String tdn) {

		TaiKhoan tk = null;
		try {
			Connection con = DBConnect.getConnect();

//			 %0454 : là phía trước 0454 có thể có 1 hoắc nhiều kí tự , Do ten_dang _nhap la unique nên ko cần thêm đk nhan_vien.ma_tai_khoan = tai_khoan.ma_tai_khoan;
			String sql = "SELECT tai_khoan.* FROM tai_khoan , nhan_vien WHERE nhan_vien.cmnd LIKE ? and tai_khoan.ten_dang_nhap = ? and nhan_vien.ma_nhan_vien = tai_khoan.ma_nhan_vien";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + cmnd);
			ps.setString(2, tdn);
			tk = new TaiKhoan();
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				tk = new TaiKhoan(rs.getString("ma_tai_khoan"));
				tk.setTen_Dang_Nhap(rs.getString("ten_dang_nhap"));
				tk.setMat_Khau(rs.getString("mat_khau"));
				tk.setTinh_Trang(rs.getBoolean("tinh_trang"));
				tk.setNgay_dang_nhap(rs.getDate("ngay_dang_nhap"));
				tk.setAdmin(rs.getBoolean("quyen"));
				tk.setMa_Nhan_Vien(rs.getString("ma_nhan_vien"));
			}
			con.close();
			return tk;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TaiKhoan> getListTaiKhoan() {

		List<TaiKhoan> listItem = new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "SELECT * FROM tai_khoan ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TaiKhoan tk = new TaiKhoan(rs.getString("ma_tai_khoan"));
				tk.setTen_Dang_Nhap(rs.getString("ten_dang_nhap"));
				tk.setMat_Khau(rs.getString("mat_khau"));
				tk.setTinh_Trang(rs.getBoolean("tinh_trang"));
				tk.setNgay_dang_nhap(rs.getDate("ngay_dang_nhap"));
				tk.setAdmin(rs.getBoolean("quyen"));
				tk.setMa_Nhan_Vien(rs.getString("ma_nhan_vien"));
				listItem.add(tk);
			}
			conn.close();
			return listItem;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public String[] getListMaNhanVien() {

		NhanVienDAO nvDAO = new NhanVienDAOImp();
		String maNV = nvDAO.getLastNhanVien();
		String[] maNhanViens = new String[Integer.parseInt(maNV.charAt(maNV.length() - 1) + "") + 1];
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "SELECT ma_nhan_vien , concat(ho , ' ' , ten) as ho_ten FROM nhan_vien WHERE ma_nhan_vien NOT IN (SELECT nhan_vien.ma_nhan_vien FROM nhan_vien , tai_khoan WHERE tai_khoan.ma_nhan_vien = nhan_vien.ma_nhan_vien) ";
//			String sql = "select ma_nhan_vien , ho_ten from nhan_vien";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while (rs.next()) {
				String s = rs.getString("ma_nhan_vien") + " - " + rs.getString("ho_ten");
				maNhanViens[i++] = s;
			}
			conn.close();
			return maNhanViens;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addTaiKhoan(TaiKhoan tk) {

		try {
			String sql = "insert into tai_khoan values(";
			sql += "'" + tk.getMa_Tai_Khoan() + "',";
			sql += "'" + tk.getTen_Dang_Nhap() + "',";
			sql += "'" + tk.getMat_Khau() + "',";
			sql += tk.isTinh_Trang() + ",";
			sql += tk.isAdmin() + ",";
			sql += "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tk.getNgay_dang_nhap()) + " ',";
			sql += "'" + tk.getMa_Nhan_Vien() + "')";
			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean edtTaiKhoan(TaiKhoan tk) {

		try {
			String sql = "";
			sql += "update tai_khoan set ";
			sql += "ten_dang_nhap = '" + tk.getTen_Dang_Nhap() + "', quyen = ";
			sql += tk.isAdmin() + ", tinh_trang = ";
			sql += tk.isTinh_Trang() + ", ";
			sql += "ma_nhan_vien = '" + tk.getMa_Nhan_Vien() + "' where ";
			sql += "ma_tai_khoan = '" + tk.getMa_Tai_Khoan() + "'";
			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeTaiKhoa(String tk) {

		try {
			String sql = "delete from tai_khoan where ma_tai_khoan = '" + tk + "'";
			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

}
