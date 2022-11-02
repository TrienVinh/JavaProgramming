package BUS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DTO.DanhMucBean;
import DTO.TaiKhoan;
import GUI.DangNhapDialog;
import GUI.DocGiaPanel;
import GUI.DoiMatKhauDialog;
import GUI.NhanVienPanel;
import GUI.QuanLyNhapHangPanel;
import GUI.QuanLyPhieuMuonPanel;
import GUI.QuanLySachPanel;
import GUI.TaiKhoanPanel;
import GUI.ThongKePanel;
import GUI.TimKiemSachPanel;

public class ChuyenManHinhController {
	private JPanel root;
	private String kindSelected = "";
	private JButton jbtnDoiMatKhau, jbtnDangXuat;
	private JFrame frame;

	private List<DanhMucBean> listItem = null;
	private String maNV;

	public ChuyenManHinhController(JPanel root, JButton jbtnDoiMatKhau, JButton jbtnDangXuat, JFrame frame,
			String maNV) {
		super();
		this.root = root;
		this.jbtnDoiMatKhau = jbtnDoiMatKhau;
		this.jbtnDangXuat = jbtnDangXuat;
		this.frame = frame;
		this.maNV = maNV;
	}

	public JPanel getRoot() {
		return root;
	}

	public void setRoot(JPanel root) {
		this.root = root;
	}

	public String getKindSelected() {
		return kindSelected;
	}

	public void setKindSelected(String kindSelected) {
		this.kindSelected = kindSelected;
	}

	public void setView(JButton jbtn) {
		jbtn.setBackground(new Color(0, 153, 0));
		kindSelected = "Tim Kiem";

		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(new TimKiemSachPanel());
		root.validate();
		root.repaint();
	}

	public void setEvent(List<DanhMucBean> listItem, TaiKhoan tk) {
		this.listItem = listItem;

		for (DanhMucBean dm : listItem) {
			dm.getJbtnDanhMuc().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			dm.getJbtnDanhMuc().addMouseListener(new ClassEvent(dm.getDanhMuc(), dm.getJbtnDanhMuc()));
		}

		jbtnDangXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frame.dispose();
				new DangNhapDialog().setVisible(true);
			}
		});

		jbtnDoiMatKhau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnDoiMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				new DoiMatKhauDialog(frame, true, tk).setVisible(true);
			}
		});
	}

	public class ClassEvent implements MouseListener {
		private String kind = "";
		private JButton jbtn;

		private JPanel node;

		public ClassEvent(String kind, JButton jbtn) {
			super();
			this.kind = kind;
			this.jbtn = jbtn;
		}

		@Override
		public void mouseClicked(MouseEvent e) {

			switch (kind) {
			case "Phieu Nhap":
				node = new QuanLyNhapHangPanel(frame, maNV);
				break;
			case "Doc Gia":
				node = new DocGiaPanel();
				break;
			case "Nhan Vien":
				node = new NhanVienPanel();
				break;
			case "Tai Khoan":
				node = new TaiKhoanPanel();
				break;
			case "Sach":
				node = new QuanLySachPanel();
				break;
			case "Phieu Muon":
				node = new QuanLyPhieuMuonPanel(frame, maNV);
				break;
			case "Tim Kiem":
				node = new TimKiemSachPanel();
				break;
			case "Thong Ke":
				node = new ThongKePanel(frame);
				break;
			default:

				break;
			}
			changeBackground(kindSelected);
			root.removeAll();
			root.setLayout(new BorderLayout());
			root.add(node);
			root.validate();
			root.repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {

			kindSelected = kind;
			jbtn.setBackground(new Color(0, 153, 0));
		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

			jbtn.setBackground(new Color(0, 153, 0));
		}

		@Override
		public void mouseExited(MouseEvent e) {

			if (!kind.equalsIgnoreCase(kindSelected)) {
				jbtn.setBackground(new Color(51, 102, 0));
			}
		}

	}

	public void changeBackground(String kind) {
		for (DanhMucBean dm : listItem) {
			if (dm.getDanhMuc().equalsIgnoreCase(kind)) {
				dm.getJbtnDanhMuc().setBackground(new Color(0, 153, 0));
			} else {
				dm.getJbtnDanhMuc().setBackground(new Color(51, 102, 0));
			}
		}
	}
}
