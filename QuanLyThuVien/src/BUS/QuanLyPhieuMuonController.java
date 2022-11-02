package BUS;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.PhieuMuonPanel;
import GUI.PhieuPhatPanel;

public class QuanLyPhieuMuonController {
	private JPanel jpnPhieuMuon, jpnPhieuPhat;
	private JFrame frame;
	private String maNV;

	public QuanLyPhieuMuonController(JPanel jpnPhieuMuon, JPanel jpnPhieuPhat, JFrame frame, String maNV) {
		super();
		this.jpnPhieuMuon = jpnPhieuMuon;
		this.jpnPhieuPhat = jpnPhieuPhat;
		this.frame = frame;
		this.maNV = maNV;
	}

	public void setView() {
		setViewForPanel(jpnPhieuMuon, new PhieuMuonPanel(frame, maNV));
		setViewForPanel(jpnPhieuPhat, new PhieuPhatPanel(frame));
	}

	public void setViewForPanel(JPanel jpnView, JPanel node) {
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(node);
		jpnView.validate();
		jpnView.repaint();
	}
}
