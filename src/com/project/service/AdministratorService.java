package com.project.service;

import java.util.List;

import com.project.dao.AdministratorDao;
import com.project.javabean.*;

public class AdministratorService {
	private AdministratorDao dao = new AdministratorDao();

	public boolean addAdministrator(Administrator u) throws Exception {
		return dao.addAdministrator(u);
	}

	public List<Administrator> listAllAdministrator() throws Exception {
		return dao.listAllAdministrator();
	}

	
	public List<Administrator> listAllAdministratorOrderByAdministratorId(int begin, int offset)
			throws Exception {
		return dao.listAllAdministratorOrderByAdministratorId(begin, offset);
	}

	public boolean isExist(Administrator u) throws Exception {
		return dao.isExist(u);
	}

	public boolean deleteAdministratorByAdministratorId(int administrator_id)
			throws Exception {
		return dao.deleteAdministratorByAdministratorId(administrator_id);
	}

	public boolean modifyAdministrator(Administrator u) throws Exception {
		return dao.modifyAdministrator(u);
	}

	public Administrator getAdministratorById(int administrator_id)
			throws Exception {
		return dao.getAdministratorById(administrator_id);
	}

	public int getAdministratorTotalNum() throws Exception {
		return dao.getAdministratorTotalNum();
	}
}
