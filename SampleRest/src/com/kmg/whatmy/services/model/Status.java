package com.kmg.whatmy.services.model;


public class Status {

 private int code;
 private String message;
 private String userId;
 private String token;

 public Status() {
 }

 public Status(int code, String message) {
  this.code = code;
  this.message = message;
 }

 public int getCode() {
  return code;
 }

 public void setCode(int code) {
  this.code = code;
 }

 public String getMessage() {
  return message;
 }

 public void setMessage(String message) {
  this.message = message;
 }

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}
 
}

