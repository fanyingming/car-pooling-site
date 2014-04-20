package com.project.service;

import java.sql.SQLException;
import java.util.List;

import com.project.dao.UserDao;
import com.project.javabean.User;

public class UserService {
	UserDao dao = new UserDao();

	public boolean addUser(User u) throws Exception {
	
		return dao.addUser(u);

	}

	public boolean isExist(User u) throws Exception {
		
		return dao.isExist(u);
	}

	public boolean deleteUserByUid(int userName) throws Exception {
		
		return dao.deleteUserByUid(userName);
	}

	public boolean modifyUser(User u) throws Exception {
		
		return dao.modifyUser(u);
	}

	public List<User> listAllUsers() throws Exception {
		return dao.listAllUsers();
	}

	public User getUserByUserId(int user_id) throws Exception {
		return dao.getUserByUserId(user_id);
	}

	public int getUserIdByUserName(String user_name) throws SQLException {
		return dao.getUserIdByUserName(user_name);
	}

	public String getUserNameByUserId(int user_id) throws Exception {
		return dao.getUserNameByUserId(user_id);
	}
	public int getUserTotalNum() throws Exception {
		return dao.getUserTotalNum();
	}
	public List<User> listAllUserOrderByUserId(int begin, int offset) throws Exception{
		return dao.listAllUserOrderByUserId(begin, offset);
	}
}
