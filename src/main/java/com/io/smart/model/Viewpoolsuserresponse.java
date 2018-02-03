package com.io.smart.model;

import java.io.Serializable;

public class Viewpoolsuserresponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private Userinfo userinfo;
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
}
