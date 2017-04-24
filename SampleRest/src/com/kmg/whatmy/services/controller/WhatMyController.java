package com.kmg.whatmy.services.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kmg.whatmy.services.model.Employee;
import com.kmg.whatmy.services.model.Login;
import com.kmg.whatmy.services.model.Status;
import com.kmg.whatmy.services.model.User;
import com.kmg.whatmy.services.model.UserProfile;
import com.kmg.whatmy.services.services.DataServices;
import com.kmg.whatmy.services.util.EncryptDecrypt;

@Controller
@CrossOrigin
@RequestMapping("/whatMy")
public class WhatMyController {

 @Autowired
 DataServices dataServices;
 @Autowired
 EncryptDecrypt encryptDecrypt;
 
 @Autowired
 Status status;

 static final Logger logger = LoggerFactory.getLogger(WhatMyController.class);

 /* login form in Spring Restful Services */
 @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
 public @ResponseBody
 Status login(@RequestBody Login login) {
  try {
	  logger.info("userId " +login.getUser_id());
   boolean check=dataServices.checkLogin(login);
   if(check){
	   //call wishlist
   return new Status(0, "Wish List");
   }
   else
	   return new Status(1, "Invalid PassCode" );
	   
  } catch (Exception e) {
   // e.printStackTrace();
	  logger.info(login.getUser_id() +e.toString());
   return new Status(1, "Invalid Credentials" +e.toString());
  }
 }
 
 /* Submit form in Spring Restful Services */
 @RequestMapping(value = "/checkUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
 public @ResponseBody
 Status checkUser(@RequestBody Map<String,Long> user_number) {
  try {
	  logger.info(user_number.get("user_number")+"");
   boolean check=dataServices.checkUserEntity(user_number.get("number"));
   System.out.println(user_number.get("number")+"");
   if(check)
   return new Status(0, "User Exist");
   else
	   return new Status(1, "New User" );
	   
  } catch (Exception e) {
   // e.printStackTrace();
	  logger.info(user_number.get("user_number") +e.toString());
   return new Status(1, "New User" +e.toString());
  }

 }
 @RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
 public @ResponseBody
 Status createUser(@RequestBody User user) {
	 
  try {
	  logger.info(user.getUser_Id().toString());
   boolean check=dataServices.createUser(user);
   if(check){
	   status.setCode(0);
	   status.setMessage("User Created");
	   status.setToken("");
	   status.setUserId(encryptDecrypt.encrypt(user.getUser_Id().toString()));
   }
   else{
	   status.setCode(1);
	   status.setMessage("user Creation failed");
	   status.setToken(null);
	   status.setUserId(null);
   }
   return status;
  } catch (Exception e) {
   // e.printStackTrace();
   return new Status(1, "SomeThing went wrong");
  }

 }
 @RequestMapping(value = "/createUserProfile", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
 public @ResponseBody
 Status createUserProfile(@RequestBody UserProfile userProfile) {
	 
  try {
   boolean check=dataServices.createUserProfile(userProfile);
   if(check){
	   status.setCode(0);
	   status.setMessage("User profile Created");
	   status.setToken("");
	   status.setUserId(encryptDecrypt.encrypt(userProfile.getUser_Id().toString()));
   }
   else{
	   status.setCode(1);
	   status.setMessage("user profile Creation failed");
	   status.setToken(null);
	   status.setUserId(null);
   }
   return status;
	  } catch (Exception e) {
   // e.printStackTrace();
   return new Status(1, "SomeThing went wrong");
  }

 }

 /* Ger a single objct in Json form in Spring Rest Services */
 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
 public @ResponseBody
 Employee getEmployee(@PathVariable("id") long id) {
  Employee employee = null;
  try {
   employee = dataServices.getEntityById(id);

  } catch (Exception e) {
   e.printStackTrace();
  }
  return employee;
 }

 /* Getting List of objects in Json format in Spring Restful Services */
 @RequestMapping(value = "/list", method = RequestMethod.GET)
 public @ResponseBody
 List<Employee> getEmployee() {

  List<Employee> employeeList = null;
  try {
   employeeList = dataServices.getEntityList();

  } catch (Exception e) {
   e.printStackTrace();
  }

  return employeeList;
 }

 /* Delete an object from DB in Spring Restful Services */
 @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
 public @ResponseBody
 Status deleteEmployee(@PathVariable("id") long id) {

  try {
   dataServices.deleteEntity(id);
   return new Status(1, "Employee deleted Successfully !");
  } catch (Exception e) {
   return new Status(0, e.toString());
  }

 }
}

