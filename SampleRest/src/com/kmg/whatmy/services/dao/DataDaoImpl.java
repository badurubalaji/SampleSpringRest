package com.kmg.whatmy.services.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.kmg.whatmy.services.model.Employee;
import com.kmg.whatmy.services.model.Login;
import com.kmg.whatmy.services.model.User;
import com.kmg.whatmy.services.model.UserProfile;

public class DataDaoImpl implements DataDao {

 @Autowired
 SessionFactory sessionFactory;
 
 @Autowired(required=false)
private HibernateTemplate hibernateTemplate;

 Session session = null;
 Transaction tx = null;

 @Override
 public boolean addEntity(Employee employee) throws Exception {

  session = sessionFactory.openSession();
  tx = session.beginTransaction();
  session.save(employee);
  tx.commit();
  session.close();

  return false;
 }

 @Override
 public Employee getEntityById(long id) throws Exception {
  session = sessionFactory.openSession();
  Employee employee = (Employee) session.load(Employee.class,new Long(id));
  tx = session.getTransaction();
  session.beginTransaction();
  tx.commit();
  return employee;
 }

 @Override
 public List<Employee> getEntityList() throws Exception {
  session = sessionFactory.openSession();
  tx = session.beginTransaction();
  //Get Criteria Builder
  CriteriaBuilder builder = session.getCriteriaBuilder();

  //Create Criteria
  CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
  Root<Employee> contactRoot = criteria.from(Employee.class);
  criteria.select(contactRoot);

  //Use criteria to query with session to fetch all employee list
  List<Employee> employeeList = session.createQuery(criteria).getResultList();
  tx.commit();
  session.close();
  return employeeList;
 }
 
 @Override
 public boolean deleteEntity(long id)
   throws Exception {
  session = sessionFactory.openSession();
  Object o = session.load(Employee.class, id);
  tx = session.getTransaction();
  session.beginTransaction();
  session.delete(o);
  tx.commit();
  return false;
 }

@Override
public boolean checkUserEntity(long user_number) throws Exception {
	// TODO Auto-generated method stub
	session = sessionFactory.openSession();
	//User user = (User) session.load(User.class,new Long(id));
	
	tx=session.beginTransaction();
	Criteria criteria = session.createCriteria(User.class);
    criteria.add(Restrictions.eq("user_Id", user_number));
    criteria.setProjection(Projections.rowCount());
    long count = (Long) criteria.uniqueResult();
    session.getTransaction().commit();
   if(count != 0){
	   return true;
   }
   else{
      return false;
   }
	  
}

@Override
public boolean createUserEntity(User user) throws Exception {
	// TODO Auto-generated method stub
	// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		//User user = (User) session.load(User.class,new Long(id));		
		tx=session.beginTransaction();
		session.save(user);
	    session.getTransaction().commit();
	    session.close();
	  
		   return true;
	  
	     
	   
	
}

@Override
public boolean createUserProfileEntity(UserProfile userProfile) throws Exception {
	// TODO Auto-generated method stub
	session = sessionFactory.openSession();
	//User user = (User) session.load(User.class,new Long(id));
	
	tx=session.beginTransaction();
	session.save(userProfile);
    session.getTransaction().commit();
    session.close();
  
	   return true;
}

@Override
public boolean checkLogin(Login login) throws Exception {
	// TODO Auto-generated method stub
	session = sessionFactory.openSession();
	//User user = (User) session.load(User.class,new Long(id));
	
	tx=session.beginTransaction();
	List<?> list = hibernateTemplate.find("FROM users WHERE User_Id=? and passcode=?",login.getUser_id(),login.getPasscode());
	session.getTransaction().commit();
    session.close();
	if(!list.isEmpty()) {
		return true;
	}
	else{
	return false;
	}
}


}