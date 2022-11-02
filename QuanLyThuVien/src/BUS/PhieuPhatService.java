package BUS;

import java.util.List;

import DTO.PhieuPhat;

public interface PhieuPhatService {
	List<PhieuPhat> getListPhieuPhat();

	boolean addPhieuPhat(PhieuPhat pp);

	Object getSomeThingFromSql(String sql);
}
