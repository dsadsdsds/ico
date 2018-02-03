package com.io.smart.model;

import java.io.Serializable;

public class Createpoolrequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String poolName;
	private String deadline;	
	private String adminWallet;
	private String typeOfCoin;
	private double percentage;
	private String password;
	private double expectedBonus;
	private double expectedBonusPercent;
	private double expectedDiscount;
	private double expectedCoinPrice;
	private double minimum;
	private double maximum;
	
	
	
	
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
	public String getAdminWallet() {
		return adminWallet;
	}
	public void setAdminWallet(String adminWallet) {
		this.adminWallet = adminWallet;
	}
	public double getExpectedDiscount() {
		return expectedDiscount;
	}
	public void setExpectedDiscount(double expectedDiscount) {
		this.expectedDiscount = expectedDiscount;
	}
	public double getExpectedCoinPrice() {
		return expectedCoinPrice;
	}
	public void setExpectedCoinPrice(double expectedCoinPrice) {
		this.expectedCoinPrice = expectedCoinPrice;
	}
	public double getExpectedBonus() {
		return expectedBonus;
	}
	public void setExpectedBonus(double expectedBonus) {
		this.expectedBonus = expectedBonus;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	
	
	
}
