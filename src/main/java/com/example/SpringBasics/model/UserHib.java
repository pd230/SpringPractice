package com.example.SpringBasics.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserHib {
		@Id
		private int uid;
		private String uname;
		
		public UserHib(){}
		
		
		public UserHib(int uid , String uname){
			this.uid = uid;
			this.uname = uname;
		}
		
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
		
		public String toString() {
			return "User [ id : "+uid+", uname : "+uname+" ]";
		}

}
