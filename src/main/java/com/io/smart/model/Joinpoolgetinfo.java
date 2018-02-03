package com.io.smart.model;

import java.io.Serializable;

public class Joinpoolgetinfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String poolName;
	private String deadline;	
	private String adminWallet;
	private String typeOfCoin;
	private double percentage;
	private double expectedBonus;
	private double expectedCoinValue;
	private double expecteddiscount;
	private double expectedBonusPercent;
	private double minimum;
	private double maximum;
	
	
	public String getAdminWallet() {
		return adminWallet;
	}
	public void setAdminWallet(String adminWallet) {
		this.adminWallet = adminWallet;
	}
	public double getExpectedCoinValue() {
		return expectedCoinValue;
	}
	public void setExpectedCoinValue(double expectedCoinValue) {
		this.expectedCoinValue = expectedCoinValue;
	}
	public double getExpecteddiscount() {
		return expecteddiscount;
	}
	public void setExpecteddiscount(double expecteddiscount) {
		this.expecteddiscount = expecteddiscount;
	}
	public double getExpectedBonusPercent() {
		return expectedBonusPercent;
	}
	public void setExpectedBonusPercent(double expectedBonusPercent) {
		this.expectedBonusPercent = expectedBonusPercent;
	}
	public double getMinimum() {
		return minimum;
	}
	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}
	public double getMaximum() {
		return maximum;
	}
	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}
	public String getPoolName() {
		return poolName;
	}
	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getWallet() {
		return adminWallet;
	}
	public void setWallet(String wallet) {
		this.adminWallet = wallet;
	}
	public String getTypeOfCoin() {
		return typeOfCoin;
	}
	public void setTypeOfCoin(String typeOfCoin) {
		this.typeOfCoin = typeOfCoin;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public double getExpectedBonus() {
		return expectedBonus;
	}
	public void setExpectedBonus(double expectedBonus) {
		this.expectedBonus = expectedBonus;
	}

}
