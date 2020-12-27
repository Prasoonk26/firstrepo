package com.anti.methods;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;


public class file_revoke_methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int dataRevokeFromGroup(File f1,File f2){
		 int n=1;
		   
		   System.out.println(" in methods ");
		   try {
				FileUtils.copyFile(f1, f2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return n;
	}
	
	
}
