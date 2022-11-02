package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DTO.DocGia;
import DTO.Person;

public class DocGiaDAOImp implements DocGiaDAO {

	private MySQLConnect DBConnect;

	public DocGiaDAOImp() {
		super();
		DBConnect = new MySQLConnect();
	}

	@Override
	public List<DocGia> getListDocGia() {

		List<DocGia> listItem = new ArrayList<>();
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select doc_gia.* from doc_gia ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Person dg = new DocGia();

				dg.setMa_Doi_Tuong(rs.getString("ma_doc_gia"));
				dg.setChuc_Vu(rs.getString("nghe_nghiep"));
				dg.setCMND(rs.getString("cmnd"));
				dg.setDia_Chi(rs.getString("dia_chi"));
				dg.setEmail(rs.getString("email"));
				dg.setGioi_Tinh(rs.getBoolean("gioi_tinh"));
				dg.setHo(rs.getString("ho"));
				dg.setTen(rs.getString("ten"));
				dg.setNgay_Sinh(rs.getDate("ngay_sinh"));
				dg.setSo_Dien_Thoai(rs.getString("so_dien_thoai"));

				listItem.add((DocGia) dg);
			}
			conn.close();
			return listItem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getLastDocGia() {

		String ma = "";
		try {
			Connection conn = DBConnect.getConnect();
			String sql = "select max(ma_doc_gia) as max_ma from doc_gia";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				ma = rs.getString("max_ma");
			}
			conn.close();
			return ma;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public boolean addDocGia(DocGia dg) {

		try {
			String sql = "insert into doc_gia values";
			sql += "('" + dg.getMa_Doi_Tuong() + "',";
			sql += "N'" + dg.getHo() + "',";
			sql += "N'" + dg.getTen() + "',";
			sql += dg.isGioi_Tinh() + ",";
			sql += "'" + new SimpleDateFormat("yyyy-MM-dd").format(dg.getNgay_Sinh()) + "',";
			sql += "N'" + dg.getDia_Chi() + "',";
			sql += "'" + dg.getEmail() + "',";
			sql += "N'" + dg.getChuc_Vu() + "',";
			sql += "'" + dg.getCMND() + "',";
			sql += "'" + dg.getSo_Dien_Thoai() + "')";

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertDocGia(DocGia dg) {

		try {
			String sql = "";

			sql += "update doc_gia set ";
			sql += "ho = N'" + dg.getHo() + "',";
			sql += "ten = N'" + dg.getTen() + "',gioi_tinh = ";
			sql += dg.isGioi_Tinh() + ",";
			sql += "dia_chi = N'" + dg.getDia_Chi() + "',";
			sql += "email = '" + dg.getEmail() + "',";
			sql += "nghe_nghiep = N'" + dg.getChuc_Vu() + "',";
			sql += "cmnd = '" + dg.getCMND() + "',";
			sql += "so_dien_thoai = '" + dg.getSo_Dien_Thoai() + "',";
			sql += "ngay_sinh = '" + new SimpleDateFormat("yyyy-MM-dd").format(dg.getNgay_Sinh()) + "'";
			sql += " where ma_doc_gia = '" + dg.getMa_Doi_Tuong() + "'";

			return DBConnect.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeDocGia(String dg) {

		try {
			String sql = "delete from doc_gia where ma_doc_gia = '" + dg + "'";
			return DBConnect.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
