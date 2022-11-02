package BUS;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import DTO.DocGia;
import DTO.NgonNgu;
import DTO.NhaCungCap;
import DTO.NhaXuatBan;
import DTO.NhanVien;
import DTO.PhieuMuon;
import DTO.PhieuNhapHang;
import DTO.PhieuPhat;
import DTO.Sach;
import DTO.SachTimKiem;
import DTO.TacGia;
import DTO.TaiKhoan;
import DTO.TheLoai;
import DTO.ViTri;

public class ClassModel {
	public <E> DefaultTableModel getModel(List<E> listItem, String[] columnName) {
		E e = (listItem.size() > 0) ? listItem.get(0) : null;

		DefaultTableModel model = new DefaultTableModel() {

			private static final long serialVersionUID = 287770168727503342L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {

				return (e instanceof TaiKhoan && columnIndex == 5) ? Boolean.class : String.class;

			}
		};
		int count = 1;
		model.setColumnIdentifiers(columnName);
		if (e instanceof DocGia) {
			for (E e2 : listItem) {
				DocGia dg = (DocGia) e2;
				model.addRow(new Object[] { count++ + "", dg.getMa_Doi_Tuong(), dg.getHo(), dg.getTen(),
						dg.isGioi_Tinh() ? "Nam" : "Nu", new SimpleDateFormat("dd/MM/yyyy").format(dg.getNgay_Sinh()),
						dg.getDia_Chi(), dg.getChuc_Vu(), dg.getCMND(), dg.getEmail(), dg.getSo_Dien_Thoai() });
			}
		} else if (e instanceof NhanVien) {
			for (E e2 : listItem) {
				NhanVien nv = (NhanVien) e2;
				model.addRow(new Object[] { count++ + "", nv.getMa_Doi_Tuong(), nv.getHo(), nv.getTen(),
						nv.isGioi_Tinh() ? "Nam" : "Nu", new SimpleDateFormat("dd/MM/yyyy").format(nv.getNgay_Sinh()),
						nv.getDia_Chi(), nv.getChuc_Vu(), nv.getCMND(), nv.getEmail(), nv.getSo_Dien_Thoai() });
			}
		} else if (e instanceof TaiKhoan) {
			for (E e2 : listItem) {
				TaiKhoan tk = (TaiKhoan) e2;
				model.addRow(new Object[] { count++ + "", tk.getMa_Tai_Khoan(), tk.getTen_Dang_Nhap(),
						tk.getMat_Khau().replaceAll(".", "*"), tk.isAdmin() ? "Admin" : "Nhan Vien", tk.isTinh_Trang(),
						tk.getMa_Nhan_Vien() });
			}
		} else if (e instanceof TheLoai) {
			for (E e2 : listItem) {
				TheLoai tl = (TheLoai) e2;
				model.addRow(new Object[] { count++ + "", tl.getMa_The_Loai(), tl.getTen_The_Loai() });
			}
		} else if (e instanceof TacGia) {
			for (E e2 : listItem) {
				TacGia tg = (TacGia) e2;
				model.addRow(new Object[] { count++ + "", tg.getMa_Tac_Gia(), tg.getHo_Ten(), tg.getDia_Chi(),
						tg.getEmail() });
			}
		} else if (e instanceof NhaXuatBan)
			for (E e2 : listItem) {
				NhaXuatBan nxb = (NhaXuatBan) e2;
				model.addRow(new Object[] { count++ + "", nxb.getMa_NXB(), nxb.getHo_Ten(), nxb.getDia_Chi(),
						nxb.getEmail() });
			}
		else if (e instanceof ViTri)
			for (E e2 : listItem) {
				ViTri vt = (ViTri) e2;
				model.addRow(new Object[] { count++ + "", vt.getMa_Vi_Tri(), vt.getSo_Khu(), vt.getSo_Ke(),
						vt.getSo_Ngan() });
			}
		else if (e instanceof NgonNgu)
			for (E e2 : listItem) {
				NgonNgu nn = (NgonNgu) e2;
				model.addRow(new Object[] { count++ + "", nn.getMa_Ngon_Ngu(), nn.getTen_Ngon_Ngu() });
			}
		else if (e instanceof Sach)
			for (E e2 : listItem) {
				Sach s = (Sach) e2;
				model.addRow(new Object[] { count++ + "", s.getMa_Sach(), s.getTen_Sach(), s.getMa_Tac_Gia(),
						s.getThe_Loai(), s.getMa_Vi_Tri(), s.getMa_NXB(), s.getSo_Luong(), s.getNgon_Ngu(),
						s.getSo_Trang(), s.getGia_Tien() });
			}
		else if (e instanceof SachTimKiem)
			for (E e2 : listItem) {
				SachTimKiem s = (SachTimKiem) e2;
				model.addRow(new Object[] { " ".repeat(5) + count++, " ".repeat(2) + s.getMa_Sach(), s.getTen_Sach(),
						s.getTac_Gia(), s.getThe_Loai(), s.getNXB(), " ".repeat(5) + s.getSo_Khu(),
						" ".repeat(5) + s.getSo_Ke(), " ".repeat(5) + s.getSo_Ngan(), " ".repeat(5) + s.getSo_Luong(),
						s.getNgon_Ngu(), " ".repeat(5) + s.getSo_Trang(), " ".repeat(8) + s.getGia_Tien() });
			}
		else if (e instanceof PhieuMuon)
			for (E e2 : listItem) {
				PhieuMuon pm = (PhieuMuon) e2;
				model.addRow(new Object[] { " ".repeat(5) + count++, " ".repeat(2) + pm.getMa_Phieu_Muon(),
						pm.getMa_Doc_Gia(), pm.getMa_Nhan_Vien(),
						new SimpleDateFormat("dd/MM/yyyy").format(pm.getNgay_Muon()),
						new SimpleDateFormat("dd/MM/yyyy").format(pm.getNgay_Phai_Tra()), pm.getTong_So_Sach_Muon(),
						pm.isHoan_Tra() ? "Hoàn Tất" : "Chưa Trả" });
			}
		else if (e instanceof PhieuPhat)
			for (E e2 : listItem) {
				PhieuPhat pp = (PhieuPhat) e2;
				model.addRow(new Object[] { " ".repeat(5) + count++, pp.getMa_Phieu_Muon(), pp.getMa_Sach(),
						pp.getLy_Do(), pp.getTien_Phat() + "" });
			}
		else if (e instanceof PhieuNhapHang)
			for (E e2 : listItem) {
				PhieuNhapHang pn = (PhieuNhapHang) e2;
				model.addRow(new Object[] { " ".repeat(5) + count++, pn.getMaPN(), pn.getMaNCC(), pn.getMaNV(),
						new SimpleDateFormat("dd/MM/yyyy").format(pn.getNgay_Nhap()), pn.getSo_Luong(),
						pn.getTong_Tien() });
			}
		else if (e instanceof NhaCungCap)
			for (E e2 : listItem) {
				NhaCungCap nxb = (NhaCungCap) e2;
				model.addRow(new Object[] { count++ + "", nxb.getMa_NCC(), nxb.getHo_Ten(), nxb.getDia_Chi(),
						nxb.getEmail() });
			}
		return model;
	}

}
