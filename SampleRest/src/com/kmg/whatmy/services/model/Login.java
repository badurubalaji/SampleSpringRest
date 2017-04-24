package com.kmg.whatmy.services.model;

import java.io.Serializable;

public class Login implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5494442262496654320L;
	private long user_id;
	private int passcode;
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public int getPasscode() {
		return passcode;
	}
	public void setPasscode(int passcode) {
		this.passcode = passcode;
	}
	

}
