package com.anti.methods;

import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DESAlgorithms {

 public byte[] encrption_key_method(String user_key) throws Exception{
		 

		SecretKey secKey = getSecretEncryptionKey();

		// AES defaults to AES/ECB/PKCS5Padding in Java 7

		Cipher aesCipher = Cipher.getInstance("AES");

		aesCipher.init(Cipher.ENCRYPT_MODE, secKey);

		byte[] byteCipherText = aesCipher.doFinal(user_key.getBytes());

		return byteCipherText;
		 
	 }
	 
	 public static SecretKey getSecretEncryptionKey() throws Exception{
			
		KeyGenerator generator = KeyGenerator.getInstance("AES");

		generator.init(128); // The AES key size in number of bits

		SecretKey secKey = generator.generateKey();

		return secKey;
	
	    }
	 
	 public String DESAlgorithmsUpdateKey(String fileKey)
	 {
		 char[] characterSet = fileKey.toCharArray();
			int length=10;
			String filekeyupdate=null;
							
				 Random random1 = new SecureRandom();
				    char[] result = new char[length];
				    for (int i = 0; i < result.length; i++) {
				        // picks a random index out of character set > random character
				        int randomCharIndex = random1.nextInt(characterSet.length);
				        result[i] = characterSet[randomCharIndex];
				    }
				    filekeyupdate=new String(result);
				    System.out.println("resultttttttttttt"+ filekeyupdate);
					return filekeyupdate;
	 }
	
	
}
