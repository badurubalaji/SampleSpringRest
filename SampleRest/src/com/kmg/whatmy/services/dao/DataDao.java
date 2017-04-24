package com.kmg.whatmy.services.dao;

import java.util.List;

import com.kmg.whatmy.services.model.Employee;
import com.kmg.whatmy.services.model.Login;
import com.kmg.whatmy.services.model.User;
import com.kmg.whatmy.services.model.UserProfile;

public interface DataDao {
	
	 public boolean addEntity(Employee employee) throws Exception;
	 public Employee getEntityById(long id) throws Exception;
	 public List<Employee> getEntityList() throws Exception;
	 public boolean deleteEntity(long id) throws Exception;
	 public boolean checkUserEntity(long user_number)throws Exception;
	 public boolean createUserEntity(User user)throws Exception;
	 public boolean createUserProfileEntity(UserProfile userProfile)throws Exception;
	 public boolean checkLogin(Login login) throws Exception;
	}