package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.project.javabean.User;
import com.project.util.DBPoolUtil;

public class UserDao {

	public boolean addUser(User u) throws Exception {

		Connection conn = DBPoolUtil.getConnection();
		String sql = "insert into tb_user(user_name,user_pass,user_phone,user_mail) values (?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, u.getUser_name());
		pstmt.setString(2, u.getUser_pass());
		pstmt.setString(3, u.getUser_phone());
		pstmt.setString(4, u.getUser_mail());
		pstmt.executeUpdate();
		DBPoolUtil.closeConnection(conn);
		return true;
	}

	public boolean isExist(User u) throws Exception {

		boolean flag = false;
		Connection conn = DBPoolUtil.getConnection();
		String sql = "select * from tb_user where user_name='"
				+ u.getUser_name() + "' and user_pass='" + u.getUser_pass()
				+ "'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery(sql);
		if (result.next())
			flag = true;
		DBPoolUtil.closeConnection(conn);
		return flag;

	}

	public boolean deleteUserByUid(int user_id) throws Exception {
		Connection conn = DBPoolUtil.getConnection();
		String sql = "delete from tb_user where user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		pstmt.executeUpdate();
		DBPoolUtil.closeConnection(conn);
		return true;
	}

	public boolean modifyUser(User u) throws Exception {
		Connection conn = DBPoolUtil.getConnection();
		String sql = "update tb_user set user_name=?,user_pass=? ,user_phone=?, user_mail=? where user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, u.getUser_name());
		pstmt.setString(2, u.getUser_pass());
		pstmt.setString(3, u.getUser_phone());
		pstmt.setString(4, u.getUser_mail());
		pstmt.setInt(5, u.getUser_id());
		pstmt.executeUpdate();
		DBPoolUtil.closeConnection(conn);
		return true;
	}

	public List<User> listAllUsers() throws Exception {
		List<User> users = new ArrayList<User>();
		Connection conn = DBPoolUtil.getConnection();
		String sql = "select * from tb_user";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery(sql);

		while (result.next()) {
			User u = new User();
			u.setUser_id(result.getInt("user_id"));
			u.setUser_name(result.getString("user_name"));
			u.setUser_pass(result.getString("user_pass"));
			u.setUser_phone(result.getString("user_phone"));
			u.setUser_mail(result.getString("user_mail"));
			users.add(u);
		}
		DBPoolUtil.closeConnection(conn);
		return users;
	}

	public User getUserByUserId(int user_id) throws Exception {
		User u = new User();
		Connection conn = DBPoolUtil.getConnection();
		String sql = "select * from tb_user where user_id=" + user_id;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery(sql);
		if (result.next()) {
			u.setUser_id(user_id);
			u.setUser_name(result.getString("user_name"));
			u.setUser_pass(result.getString("user_pass"));
			u.setUser_phone(result.getString("user_phone"));
			u.setUser_mail(result.getString("user_mail"));
		}
		DBPoolUtil.closeConnection(conn);
		return u;
	}

	public int getUserIdByUserName(String user_name) throws SQLException {
		int value = 0;
		Connection conn = DBPoolUtil.getConnection();
		String sql = "select * from tb_user where user_name='" + user_name
				+ "'";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet result = pstmt.executeQuery(sql);
		if (result.next()) {
			value = result.getInt("user_id");
		}
		DBPoolUtil.closeConnection(conn);
		return value;

	}

	public String getUserNameByUserId(int user_id) throws Exception {
		String str = null;
		Connection conn = DBPoolUtil.getConnection();
		String sql = "select * from tb_user where user_id='" + user_id + "'";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet result = pstmt.executeQuery(sql);
		if (result.next()) {
			str = result.getString("user_name");
		}
		DBPoolUtil.closeConnection(conn);
		return str;
	}
	public int getUserTotalNum() throws Exception {
		int user_num = 0;
		Connection conn = DBPoolUtil.getConnection();
		String sql = "select * from tb_user ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery(sql);
		if (result.next()) {
			result.last();
			user_num = result.getRow();
		} else {
			user_num = 0;
		}
		DBPoolUtil.closeConnection(conn);
		return user_num;
	}
	public List<User> listAllUserOrderByUserId(int begin, int offset) throws Exception{
		List<User> users = new ArrayList<User>();
		Connection conn = DBPoolUtil.getConnection();

		String sql = "select * from tb_user order by user_id desc limit "
				+ begin + "," + offset;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery(sql);

		while (result.next()) {
			User u = new User();
			u.setUser_id(result.getInt("user_id"));
			u.setUser_name(result.getString("user_name"));
			u.setUser_pass(result.getString("user_pass"));
			u.setUser_phone(result.getString("user_phone"));
			u.setUser_mail(result.getString("user_mail"));
			users.add(u);
		}
		DBPoolUtil.closeConnection(conn);
		return users;
	}
}
