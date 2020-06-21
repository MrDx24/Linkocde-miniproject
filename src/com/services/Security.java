package com.services;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Security {
	
	private static final String ALGO = "AES";
	private static final String keySecret = "stampy1234@stain";
	private byte[] keyValue;

	public Security() {
		// TODO Auto-generated constructor stub
		
	}
	
	public String encrypt(String data) throws Exception {
		
		Key key = generateKey();
		
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(data.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encVal);
		
		return encryptedValue;
			
	}
	
	public String decrypt(String data) throws Exception {
		
		Key key = generateKey();
		
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decryptedValue = new BASE64Decoder().decodeBuffer(data);
		byte[] decVal = c.doFinal(decryptedValue);
		String decryptedans = new String(decVal);
		
		return decryptedans;
			
	}

	private Key generateKey() throws Exception {
		keyValue = keySecret.getBytes();
		Key key = new SecretKeySpec(keyValue, ALGO);
		
		return key;
		
	}
	
}
