package com.kmg.whatmy.services.metamodel;

import java.sql.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.kmg.whatmy.services.model.User;

@StaticMetamodel(User.class)
public class User_ {
	 public static volatile SingularAttribute<User, Long> id;
	  public static volatile SingularAttribute<User, Long> user_id;
	  public static volatile SingularAttribute<User, String> passcode;
	  public static volatile SingularAttribute<User, String> deviceType;
	  public static volatile SingularAttribute<User, String> deviceId;
	  public static volatile SingularAttribute<User, Date> createdDate;

}
