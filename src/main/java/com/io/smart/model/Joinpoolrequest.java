package com.io.smart.model;

import java.io.Serializable;

public class Joinpoolrequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String txId;
	private String username;
	private double amount;
	private String note;
	private String userWallet;
	private String poolName;
	private String pin;
	
	

	
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPoolName() {
		return poolName;
	}
	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}
	public String getUserWallet() {
		return userWallet;
	}
	public void setUserWallet(String userWallet) {
		this.userWallet = userWallet;
	}

	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
	
	
}
