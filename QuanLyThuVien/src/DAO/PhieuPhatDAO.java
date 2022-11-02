package DAO;

import java.util.List;

import DTO.PhieuPhat;

public interface PhieuPhatDAO {
	List<PhieuPhat> getListPhieuPhat();

	List<PhieuPhat> getListPhieuPhat(String sql);

	boolean addPhieuPhat(PhieuPhat pp);

	Object getSomeThingFromSql(String sql);
}
