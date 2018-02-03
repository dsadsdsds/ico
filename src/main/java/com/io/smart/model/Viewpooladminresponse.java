package com.io.smart.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Viewpooladminresponse implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private ArrayList<Userinfo> userinfo;

	public ArrayList<Userinfo> getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(ArrayList<Userinfo> userinfo) {
		this.userinfo = userinfo;
	}	
	
}
