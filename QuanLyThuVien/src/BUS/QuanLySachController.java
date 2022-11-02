package BUS;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import GUI.NgonNguPanel;
import GUI.NhaCungCapPanel;
import GUI.NhaXuatBanPanel;
import GUI.SachPanel;
import GUI.TacGiaPanel;
import GUI.TheLoaiPanel;
import GUI.TimKiemSachPanel;
import GUI.ViTriPanel;

public class QuanLySachController {
	private JPanel jpnSach, jpnTacGia, jpnTheLoai, jpnTimKiem, jpnNXB, jpnVT, jpnNN, jpnNCC;

	public QuanLySachController(JPanel jpnSach, JPanel jpnTacGia, JPanel jpnTheLoai, JPanel jpnTimKiem, JPanel jpnNXB,
			JPanel jpnVT, JPanel jpnNN, JPanel jpnNCC) {
		super();
		this.jpnSach = jpnSach;
		this.jpnTacGia = jpnTacGia;
		this.jpnTheLoai = jpnTheLoai;
		this.jpnTimKiem = jpnTimKiem;
		this.jpnNXB = jpnNXB;
		this.jpnVT = jpnVT;
		this.jpnNN = jpnNN;
		this.jpnNCC = jpnNCC;
	}

	public void setView() {
		setViewPanel(jpnTheLoai, new TheLoaiPanel());
		setViewPanel(jpnTacGia, new TacGiaPanel());
		setViewPanel(jpnNXB, new NhaXuatBanPanel());
		setViewPanel(jpnVT, new ViTriPanel());
		setViewPanel(jpnNN, new NgonNguPanel());
		setViewPanel(jpnSach, new SachPanel());
		setViewPanel(jpnTimKiem, new TimKiemSachPanel());
		setViewPanel(jpnNCC, new NhaCungCapPanel());
	}

	public void setViewPanel(JPanel jpnView, JPanel jpnNode) {
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(jpnNode);
		jpnView.validate();
		jpnView.repaint();
	}
}
