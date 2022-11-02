package DTO;

import javax.swing.JButton;

public class DanhMucBean {
	private String danhMuc;
	private JButton jbtnDanhMuc;

	public DanhMucBean(String danhMuc, JButton jbtnDanhMuc) {
		super();
		this.danhMuc = danhMuc;
		this.jbtnDanhMuc = jbtnDanhMuc;
	}

	public String getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(String danhMuc) {
		this.danhMuc = danhMuc;
	}

	public JButton getJbtnDanhMuc() {
		return jbtnDanhMuc;
	}

	public void setJbtnDanhMuc(JButton jbtnDanhMuc) {
		this.jbtnDanhMuc = jbtnDanhMuc;
	}

}
