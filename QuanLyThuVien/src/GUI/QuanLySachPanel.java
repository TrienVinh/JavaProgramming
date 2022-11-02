package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import BUS.QuanLySachController;

public class QuanLySachPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public QuanLySachPanel() {

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.setBackground(new Color(240, 240, 240));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE));

		JPanel jpnSach = new JPanel();
		tabbedPane.addTab("Sach", null, jpnSach, null);

		JPanel jpnTacGia = new JPanel();
		tabbedPane.addTab("Tac Gia", null, jpnTacGia, null);

		JPanel jpnTheLoai = new JPanel();
		tabbedPane.addTab("The Loai", null, jpnTheLoai, null);

		JPanel jpnTimKiemSach = new JPanel();
		tabbedPane.addTab("Tim Kiem Sach", null, jpnTimKiemSach, null);

		JPanel jpnNXB = new JPanel();
		tabbedPane.addTab("Nha Xuat Ban", null, jpnNXB, null);

		JPanel jpnVT = new JPanel();
		tabbedPane.addTab("Vi Tri", null, jpnVT, null);

		JPanel jpnNN = new JPanel();
		tabbedPane.addTab("Ngôn Ngữ", null, jpnNN, null);
		JPanel jpnNCC = new JPanel();
		tabbedPane.addTab("Nha Cung Cap", null, jpnNCC, null);

		setLayout(groupLayout);
		QuanLySachController control = new QuanLySachController(jpnSach, jpnTacGia, jpnTheLoai, jpnTimKiemSach, jpnNXB,
				jpnVT, jpnNN, jpnNCC);

		control.setView();
	}
}
