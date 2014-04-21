package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.javabean.Message;
import com.project.util.DBPoolUtil;

public class MessageDao {
	public boolean addMessage(Message m) throws Exception {

		Connection conn = DBPoolUtil.getConnection();
		String sql = "insert into tb_message(carpooling_id,user_id,message_content,date) values (?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, m.getCarpooling_id());
		pstmt.setInt(2, m.getUser_id());
		pstmt.setString(3, m.getMessage_content());
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String nowTime = df.format(now);
		pstmt.setString(4, nowTime);
		pstmt.executeUpdate();
		DBPoolUtil.closeConnection(conn);
		return true;
	}
	
	public boolean deleteMessageByMessageId(int message_id) throws Exception {
		Connection conn = DBPoolUtil.getConnection();
		String sql = "delete from tb_message where message_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, message_id);
		pstmt.executeUpdate();
		DBPoolUtil.closeConnection(conn);
		return true;
	}
	
	public int getMessageTotalNum() throws Exception {
		int message_num = 0;
		Connection conn = DBPoolUtil.getConnection();
		String sql = "select * from tb_message ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery(sql);
		if (result.next()) {
			result.last();
			message_num = result.getRow();
		} else {
			message_num = 0;
		}
		DBPoolUtil.closeConnection(conn);
		return message_num;
	}
	public List<Message> listAllMessageOrderByMessageId(int begin, int offset) throws Exception{
		List<Message> messages = new ArrayList<Message>();
		Connection conn = DBPoolUtil.getConnection();

		String sql = "select * from tb_message order by message_id desc limit "
				+ begin + "," + offset;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery(sql);

		while (result.next()) {
			Message m = new Message();
			m.setCarpooling_id(result.getInt("carpooling_id"));
			m.setMessage_id(result.getInt("message_id"));
			m.setUser_id(result.getInt("user_id"));
			m.setMessage_content(result.getString("message_content"));
			m.setDate(result.getString("date"));
			messages.add(m);
		}
		DBPoolUtil.closeConnection(conn);
		return messages;
	}
}
