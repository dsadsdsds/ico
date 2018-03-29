package com.io.smart.model;

import java.io.Serializable;

public class RegisterWalletModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String walletaddress;

	public String getWalletaddress() {
		return walletaddress;
	}

	public void setWalletaddress(String walletaddress) {
		this.walletaddress = walletaddress;
	}
	
	
}
