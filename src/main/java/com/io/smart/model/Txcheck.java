package com.io.smart.model;

import java.io.Serializable;

public class Txcheck implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double actualAmount;
	private boolean status;
	private boolean invalidPin;
	
	
	
	
	public boolean isInvalidPin() {
		return invalidPin;
	}
	public void setInvalidPin(boolean invalidPin) {
		this.invalidPin = invalidPin;
	}
	public double getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(double actualAmount) {
		this.actualAmount = actualAmount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
