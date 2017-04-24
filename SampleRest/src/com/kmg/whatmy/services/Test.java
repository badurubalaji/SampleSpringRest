package com.kmg.whatmy.services;

import java.math.BigInteger;
import java.security.Key;
import java.util.Base64;
import java.util.Calendar;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.kmg.whatmy.services.values.GetData;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BigInteger num=new BigInteger("8686090907");
		
String token=createToken(num);
		System.out.println(token);
		
		String encrypttext=encrypt(token);
		System.out.println(encrypttext);
		System.out.println(decrypt(encrypttext));

	}
	public static String createToken(BigInteger userId){
		
		Calendar cal=Calendar.getInstance();
		String token = UUID.randomUUID().toString().toUpperCase() + "|balaji|"+ cal.getTimeInMillis();
		
		return token;
	}
	
	public static String encrypt(String data){
		String encryptedKey=null;
		try{

		     // Create key and cipher
		     Key aesKey = new SecretKeySpec(GetData.KEY.getBytes(), "AES");
		     Cipher cipher = Cipher.getInstance("AES");

		     // encrypt the text
		    
		     
		     cipher.init(Cipher.ENCRYPT_MODE, aesKey);
		     byte[] encrypted = cipher.doFinal(data.getBytes());
		     encryptedKey=new String(Base64.getEncoder().encodeToString(encrypted));

		     
		    }catch(Exception e){
		      e.printStackTrace();
		    }
		return encryptedKey;
		
	}
	public static String decrypt(String decryptData){
		String decrypted=null;
		try{

		     // Create key and cipher
		     Key aesKey = new SecretKeySpec(GetData.KEY.getBytes(), "AES");
		     Cipher cipher = Cipher.getInstance("AES");
		
		  // decrypt the text
	      cipher.init(Cipher.DECRYPT_MODE, aesKey);
	       decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(decryptData)));
	      System.err.println("Decrypted: " + decrypted);
	     
		}
		catch(Exception e){
			
		}
		return decrypted;
	}

}
