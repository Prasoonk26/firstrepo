package com.anti.methods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class RSA_Algorithms {

	public void encrypt(String fname,String encrptionASEPath) throws Exception
	 {
		
		System.out.println("In methods 111"+fname);
		
		System.out.println("encrptionASEPath"+encrptionASEPath);
		
	  KeyGenerator keyGen = KeyGenerator.getInstance("AES");
	  keyGen.init(128);  //using AES-128
	  SecretKey key = keyGen.generateKey();  //generating key
	  System.out.println(key);
	  Cipher aesCipher = Cipher.getInstance("AES");  //getting cipher for AES
	  aesCipher.init(Cipher.ENCRYPT_MODE, key);  //initializing cipher for encryption with key
	   
	  //creating file output stream to write to file
	  try(FileOutputStream fos = new FileOutputStream(encrptionASEPath+".aes")){
	   //creating object output stream to write objects to file
	   ObjectOutputStream oos = new ObjectOutputStream(fos);
	   oos.writeObject(key);  //saving key to file for use during decryption
	 
	   //creating file input stream to read contents for encryption
	   try(FileInputStream fis = new FileInputStream(fname)){
	    //creating cipher output stream to write encrypted contents
	    try(CipherOutputStream cos = new CipherOutputStream(fos, aesCipher)){
	     int read;
	     byte buf[] = new byte[4096];
	     while((read = fis.read(buf)) != -1)  //reading from file
	      cos.write(buf, 0, read);  //encrypting and writing to file
	    }
	   }
	  }
	   
	 }
	
	public String genratedKey(String fileKey)
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
