package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.project.javabean.Log;
import com.project.util.DBPoolUtil;

public class LogDao {
	
	public boolean addLog(Log log) throws Exception {

		Connection conn = DBPoolUtil.getConnection();
		String sql = "insert into tb_log(ip,date) values (?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, log.getIp());
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String nowTime = df.format(now);
		pstmt.setString(2, nowTime);
		pstmt.executeUpdate();
		DBPoolUtil.closeConnection(conn);
		return true;
	}
	
	public int getLogTotalNum() throws Exception {
		int log_num = 0;
		Connection conn = DBPoolUtil.getConnection();
		String sql = "select * from tb_log ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery(sql);
		if (result.next()) {
			result.last();
			log_num = result.getRow();
		} else {
			log_num = 0;
		}
		DBPoolUtil.closeConnection(conn);
		return log_num;
	}
}
