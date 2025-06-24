package com.example.SpringBasics.model;

public class User {
	private int uid;
	private String uname;
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int getUid() {
		return uid;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getUname() {
		return uname;
	}
	
	@Override
	public String toString() {
		return "User[ id : "+uid+", name : "+uname+" ]";
	}
}
