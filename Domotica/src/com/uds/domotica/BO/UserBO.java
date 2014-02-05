package com.uds.domotica.BO;

import com.google.gson.annotations.SerializedName;

public class UserBO {
	private int id;
	
	@SerializedName("one")
	private String user;
	
	@SerializedName("key")
	private String city;
	public UserBO	(int id, String user, String city){
		this.id=id;
		this.city=city;
		this.user=user;
	}
	public UserBO(){
		
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
