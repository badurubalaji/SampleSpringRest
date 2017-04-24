package com.kmg.whatmy.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmg.whatmy.services.dao.DataDao;
import com.kmg.whatmy.services.model.Employee;
import com.kmg.whatmy.services.model.Login;
import com.kmg.whatmy.services.model.User;
import com.kmg.whatmy.services.model.UserProfile;

public class DataServicesImpl implements DataServices {
	@Autowired  
	 DataDao dataDao;  

	@Override
	public boolean addEntity(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		return dataDao.addEntity(employee);  
	}

	@Override
	public Employee getEntityById(long id) throws Exception {
		// TODO Auto-generated method stub
		return dataDao.getEntityById(id);  
	}

	@Override
	public List<Employee> getEntityList() throws Exception {
		// TODO Auto-generated method stub
		 return dataDao.getEntityList();  
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		// TODO Auto-generated method stub
		return dataDao.deleteEntity(id);  
	}

	@Override
	public boolean checkUserEntity(long user_number) throws Exception {
		// TODO Auto-generated method stub
		return dataDao.checkUserEntity(user_number);
	}

	@Override
	public boolean createUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return dataDao.createUserEntity(user);
	}

	@Override
	public boolean createUserProfile(UserProfile userProfile) throws Exception {
		// TODO Auto-generated method stub
		return dataDao.createUserProfileEntity(userProfile);
	}

	@Override
	public boolean checkLogin(Login login) throws Exception {
		// TODO Auto-generated method stub
		return dataDao.checkLogin(login);
	}

	

}
