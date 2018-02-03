package com.io.smart.model;

import java.io.Serializable;

public class Viewpoolsuserrequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String poolName;
	private String username;
	public String getPoolName() {
		return poolName;
	}
	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

	
}
