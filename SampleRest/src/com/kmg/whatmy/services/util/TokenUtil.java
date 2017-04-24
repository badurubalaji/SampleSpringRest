package com.kmg.whatmy.services.util;

import java.util.Calendar;
import java.util.UUID;

public class TokenUtil {
	public String createToken(){
		Calendar cal=Calendar.getInstance();
		String token = UUID.randomUUID().toString().toUpperCase() + "|balaji|"+ cal.getTimeInMillis();
		
		return token;
	}
	public boolean validateToken(String token){
		return true;
	}

}
