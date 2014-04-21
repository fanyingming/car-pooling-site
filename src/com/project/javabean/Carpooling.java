package com.project.javabean;

public class Carpooling {
	private int carpooling_id;
	private int user_id;
	private String source;
	private String destiny;
	private String date;
	private String car_type;
	private String intro;
	private int gasoline_fee;
	private int road_fee;
	private int total_passangers;
	private int joined_passangers;
	private int distance;
	
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getJoined_passangers() {
		return joined_passangers;
	}
	public void setJoined_passangers(int joined_passangers) {
		this.joined_passangers = joined_passangers;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getCarpooling_id() {
		return carpooling_id;
	}
	public void setCarpooling_id(int carpooling_id) {
		this.carpooling_id = carpooling_id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestiny() {
		return destiny;
	}
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public int getGasoline_fee() {
		return gasoline_fee;
	}
	public void setGasoline_fee(int gasoline_fee) {
		this.gasoline_fee = gasoline_fee;
	}
	public int getRoad_fee() {
		return road_fee;
	}
	public void setRoad_fee(int road_fee) {
		this.road_fee = road_fee;
	}
	public int getTotal_passangers() {
		return total_passangers;
	}
	public void setTotal_passangers(int total_passangers) {
		this.total_passangers = total_passangers;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	

}
