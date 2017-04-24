package com.kmg.whatmy.services.util;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.kmg.whatmy.services.values.GetData;

public class EncryptDecryptImpl implements EncryptDecrypt {
@Override
public String encrypt(String data){

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
@Override
public String decrypt(String data){

	String decrypted=null;
	try{

	     // Create key and cipher
	     Key aesKey = new SecretKeySpec(GetData.KEY.getBytes(), "AES");
	     Cipher cipher = Cipher.getInstance("AES");
	
     //decrypt the text
      cipher.init(Cipher.DECRYPT_MODE, aesKey);
       decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(data)));
     
	}
	catch(Exception e){
		
	}
	return decrypted;

}
}
