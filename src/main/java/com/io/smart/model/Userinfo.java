package com.io.smart.model;

import java.io.Serializable;

public class Userinfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private double amount;
	private double amountusd;
	private String username;
	private String txid;
	private double percentageofpool;
	private int numofparticipants;
	private String note;
	private String userwallet;
	private double expectedbonus;
	private double expectedbonuspercent;
	private double expecteddiscount;
	private String poolname;
	private String timestamputc;

	

	public double getPercentageofpool() {
		return percentageofpool;
	}
	public void setPercentageofpool(double percentageofpool) {
		this.percentageofpool = percentageofpool;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public double getAmountusd() {
		return amountusd;
	}
	public void setAmountusd(double amountusd) {
		this.amountusd = amountusd;
	}
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}

	public int getNumofparticipants() {
		return numofparticipants;
	}
	public void setNumofparticipants(int numofparticipants) {
		this.numofparticipants = numofparticipants;
	}
	public String getUserwallet() {
		return userwallet;
	}
	public void setUserwallet(String userwallet) {
		this.userwallet = userwallet;
	}
	public double getExpectedbonus() {
		return expectedbonus;
	}
	public void setExpectedbonus(double expectedbonus) {
		this.expectedbonus = expectedbonus;
	}
	public double getExpectedbonuspercent() {
		return expectedbonuspercent;
	}
	public void setExpectedbonuspercent(double expectedbonuspercent) {
		this.expectedbonuspercent = expectedbonuspercent;
	}
	public double getExpecteddiscount() {
		return expecteddiscount;
	}
	public void setExpecteddiscount(double expecteddiscount) {
		this.expecteddiscount = expecteddiscount;
	}
	public String getPoolname() {
		return poolname;
	}
	public void setPoolname(String poolname) {
		this.poolname = poolname;
	}
	public String getTimestamputc() {
		return timestamputc;
	}
	public void setTimestamputc(String timestamputc) {
		this.timestamputc = timestamputc;
	}

	
	
	
}
