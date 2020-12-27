package com.anti.methods;

import java.io.File;

public class Create_User_Group {

	
    public  int createGroups(String folderpath )
    {
    	 int n=1;
    	
    	 File files = new File(folderpath);
	        if (!files.exists()) {
	            if (files.mkdirs()) {
	                System.out.println("Multiple directories are created!");
	            } else {
	                System.out.println("Failed to create multiple directories!");
	            }
	        }
	         
    	
	   return n;
	
   } 
    
    public int checkUserGroups(String folderpath){
    	
    	 File files = new File(folderpath);
    	
    	 if (files.exists()) {
    	    
    		 int m=1;
    		 
    		 System.out.println("Already folder ");
    		 
    		 return m;
    		 
    	 }
    	 
    	 else
    	 {
    		 int m=0;
    		 
    		 files.mkdirs();
    		 
    		 System.out.println("Made new folder  ");
    		 
    		 return m;
    	 }
    	
		
    	
    	
    }
    
 /*   public static void main(String ags[]){
    	
    	String group="G1";
    	
    	String path="C:/Alka_Anti/";
    	
    	String res=path+group;
    	
    	System.out.println("path is "+res);
    	
    	Create_User_Group cr=new Create_User_Group();
    	cr.createGroups(group, res);
    	
    	
    }
	*/
}
