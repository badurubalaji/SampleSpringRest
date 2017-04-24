package com.kmg.whatmy.services.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6018032000709471254L;

	
	@Column(name="created_date", nullable=false)
	private Timestamp createdDate;

	@Column(length=40)
	private String device_Id;

	@Column(length=15)
	private String device_Type;

	@Column(nullable=false)
	private int passcode;
	@Id
	@Column(unique=true, nullable=false)
	private Long user_Id;

	public User() {
	}

	

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getDevice_Id() {
		return this.device_Id;
	}

	public void setDevice_Id(String device_Id) {
		this.device_Id = device_Id;
	}

	public String getDevice_Type() {
		return this.device_Type;
	}

	public void setDevice_Type(String device_Type) {
		this.device_Type = device_Type;
	}

	public int getPasscode() {
		return this.passcode;
	}

	public void setPasscode(int passcode) {
		this.passcode = passcode;
	}

	public Long getUser_Id() {
		return this.user_Id;
	}

	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}

}