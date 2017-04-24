package com.kmg.whatmy.services.util;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.UUID;

public class WhatMyUtil {
	
	public static String createToken(BigInteger userId){
		Calendar cal=Calendar.getInstance();
		String token = UUID.randomUUID().toString().toUpperCase() + "|" + "userid" + "|"+ cal.getTimeInMillis();
		return token;
	}
	public void main(String args[]){
		BigInteger num=new BigInteger("8686090907");
		
		System.out.println(createToken(num));
		
	}

}
