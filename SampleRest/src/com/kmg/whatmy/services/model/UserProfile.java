package com.kmg.whatmy.services.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user_profile")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserProfile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6326193663468110489L;
	@Id
	@Column(name="user_id",unique=true, nullable=false)
	private Long user_Id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="age")
	private Integer age;
	@Column(name="marital_status")
	private String maritalStatus;
	@Column(name="gender")
	private String gender;
	
	public Long getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	

}
