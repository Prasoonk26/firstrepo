package com.anti.methods;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class BlowfishAlgorithms {

	
	 private static void encrypt(String username, String password) throws Exception {
	        byte[] keyData = (username+password).getBytes();
	        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish"); // class used for Blowfish 
	        Cipher cipher = Cipher.getInstance("Blowfish");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec); // check the Varibles 
	        byte[] hasil = cipher.doFinal(password.getBytes());
	        System.out.println(new BASE64Encoder().encode(hasil));
	    }
	     
	    private static void decrypt(String string) throws Exception {
	        byte[] keyData = ("edwin"+"password").getBytes();
	        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
	        Cipher cipher = Cipher.getInstance("Blowfish");
	        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
	        byte[] hasil = cipher.doFinal(new BASE64Decoder().decodeBuffer(string)); // base 64 Decoder are used to decode the encrption varibles 
	        System.out.println(new String(hasil));
	    }
	    
	    
	    public static void encrypt(String key, InputStream is, OutputStream os) throws Throwable {
			encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
		}

		public static void decrypt(String key, InputStream is, OutputStream os) throws Throwable {
			encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
		}

	    
	    public static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os) throws Throwable {

			DESKeySpec dks = new DESKeySpec(key.getBytes());
			SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
			SecretKey desKey = skf.generateSecret(dks);
			Cipher cipher = Cipher.getInstance("DES"); // DES/ECB/PKCS5Padding for SunJCE

			if (mode == Cipher.ENCRYPT_MODE) {
				cipher.init(Cipher.ENCRYPT_MODE, desKey);
				CipherInputStream cis = new CipherInputStream(is, cipher);
				doCopy(cis, os);
			} else if (mode == Cipher.DECRYPT_MODE) {
				cipher.init(Cipher.DECRYPT_MODE, desKey);
				CipherOutputStream cos = new CipherOutputStream(os, cipher);
				doCopy(is, cos);
			}
		}
	    
	    
	    
	    

		public static void doCopy(InputStream is, OutputStream os) throws IOException {
			byte[] bytes = new byte[64];
			int numBytes;
			while ((numBytes = is.read(bytes)) != -1) {
				os.write(bytes, 0, numBytes);
			}
			os.flush();
			os.close();
			is.close();
		}
		
		public String blowFishKey(String fileName)
		{
			char[] characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
			int length=10;
			String filekey=null;
							
				 Random random1 = new SecureRandom();
				    char[] result = new char[length];
				    for (int i = 0; i < result.length; i++) {
				        // picks a random index out of character set > random character
				        int randomCharIndex = random1.nextInt(characterSet.length);
				        result[i] = characterSet[randomCharIndex];
				    }
				    filekey=new String(result);
				    System.out.println("resultttttttttttt"+ filekey);
					return filekey;

			
		}
	
}
