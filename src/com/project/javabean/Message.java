package com.project.javabean;

public class Message {
	private int message_id;
	private int carpooling_id;
	private int user_id;
	private String message_content;
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public int getCarpooling_id() {
		return carpooling_id;
	}
	public void setCarpooling_id(int carpooling_id) {
		this.carpooling_id = carpooling_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	
	
	

}
