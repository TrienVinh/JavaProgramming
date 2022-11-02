package GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import BUS.QuanLyPhieuMuonController;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class QuanLyPhieuMuonPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public QuanLyPhieuMuonPanel(JFrame frame, String maNV) {

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE));

		JPanel jpnPhieuMuon = new JPanel();
		tabbedPane.addTab("Phiếu Mượn", null, jpnPhieuMuon, null);

		JPanel jpnPhieuPhat = new JPanel();
		tabbedPane.addTab("Phiếu Phạt", null, jpnPhieuPhat, null);
		setLayout(groupLayout);

		QuanLyPhieuMuonController control = new QuanLyPhieuMuonController(jpnPhieuMuon, jpnPhieuPhat, frame, maNV);
		control.setView();
	}
}
