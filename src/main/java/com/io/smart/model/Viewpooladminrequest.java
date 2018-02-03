package com.io.smart.model;

import java.io.Serializable;

public class Viewpooladminrequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String poolName;
	private String password;
	public String getPoolName() {
		return poolName;
	}
	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
