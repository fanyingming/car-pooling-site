package com.project.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBPoolUtil {
	static ComboPooledDataSource dataSource;
	static {
		dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/PingCheWang");
		dataSource.setUser("root");
		dataSource.setPassword("123456");

		dataSource.setInitialPoolSize(2);
	
		dataSource.setMinPoolSize(1);
		
		dataSource.setMaxPoolSize(10);
	
		dataSource.setMaxStatements(50);
	
		dataSource.setMaxIdleTime(60);
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
