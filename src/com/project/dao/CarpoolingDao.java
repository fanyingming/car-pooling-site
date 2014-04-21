package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.javabean.Carpooling;
import com.project.javabean.User;
import com.project.util.DBPoolUtil;

public class CarpoolingDao {
	
	public boolean addCarpooling(Carpooling c) throws Exception {
		Connection conn = DBPoolUtil.getConnection();
		String sql = "insert into tb_carpooling(user_id,source,destiny,date,car_type,intro,gasoline_fee,road_fee,total_passangers,joined_passangers,distance) values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, c.getUser_id());
		pstmt.setString(2, c.getSource());
		pstmt.setString(3, c.getDestiny());
		pstmt.setString(4, c.getDate());
		pstmt.setString(5, c.getCar_type());
		pstmt.setString(6, c.getIntro());
		pstmt.setInt(7, c.getGasoline_fee());
		pstmt.setInt(8, c.getRoad_fee());
		pstmt.setInt(9, c.getTotal_passangers());
		pstmt.setInt(10, 1);
		pstmt.setInt(11, c.getDistance());
	
		pstmt.executeUpdate();
		DBPoolUtil.closeConnection(conn);
		return true;
	}
	
	public boolean deleteCarpoolingByCarpoolingId(int carpoolingId) throws Exception {
		Connection conn = DBPoolUtil.getConnection();
		String sql = "delete from tb_carpooling where carpooling_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, carpoolingId);
		pstmt.executeUpdate();
		DBPoolUtil.closeConnection(conn);
		return true;
	}
	
	public List<Carpooling> listAllCarpoolingOrderByCarpoolingId(int begin, int offset) throws Exception{
		List<Carpooling> carpoolings = new ArrayList<Carpooling>();
		Connection conn = DBPoolUtil.getConnection();

		String sql = "select * from tb_carpooling order by carpooling_id desc limit "
				+ begin + "," + offset;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery(sql);

		while (result.next()) {
			Carpooling c = new Carpooling();
			c.setCar_type(result.getString("car_type"));
			c.setCarpooling_id(result.getInt("carpooling_id"));
			c.setDate(result.getString("date"));
			c.setDestiny(result.getString("destiny"));
			c.setDistance(result.getInt("distance"));
			c.setGasoline_fee(result.getInt("gasoline_fee"));
			c.setIntro(result.getString("intro"));
			c.setJoined_passangers(result.getInt("joined_passangers"));
			c.setRoad_fee(result.getInt("road_fee"));
			c.setSource(result.getString("source"));
			c.setTotal_passangers(result.getInt("total_passangers"));
			c.setUser_id(result.getInt("user_id"));
			carpoolings.add(c);
		}
		DBPoolUtil.closeConnection(conn);
		return carpoolings;
	}
	
	public int getCarpoolingTotalNum() throws Exception {
		int carpooling_num = 0;
		Connection conn = DBPoolUtil.getConnection();
		String sql = "select * from tb_carpooling ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery(sql);
		if (result.next()) {
			result.last();
			carpooling_num = result.getRow();
		} else {
			carpooling_num = 0;
		}
		DBPoolUtil.closeConnection(conn);
		return carpooling_num;
	}
	
	public Carpooling getCarpoolingByCarpoolingId(int carpooling_id) throws Exception {
		Carpooling c = new Carpooling();
		Connection conn = DBPoolUtil.getConnection();
		String sql = "select * from tb_carpooling where carpooling_id=" + carpooling_id;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery(sql);
		if (result.next()) {
			c.setCar_type(result.getString("car_type"));
			c.setCarpooling_id(result.getInt("carpooling_id"));
			c.setDate(result.getString("date"));
			c.setDestiny(result.getString("destiny"));
			c.setDistance(result.getInt("distance"));
			c.setGasoline_fee(result.getInt("gasoline_fee"));
			c.setIntro(result.getString("intro"));
			c.setJoined_passangers(result.getInt("joined_passangers"));
			c.setRoad_fee(result.getInt("road_fee"));
			c.setSource(result.getString("source"));
			c.setTotal_passangers(result.getInt("total_passangers"));
			c.setUser_id(result.getInt("user_id"));
		}
		DBPoolUtil.closeConnection(conn);
		return c;
	}

}
