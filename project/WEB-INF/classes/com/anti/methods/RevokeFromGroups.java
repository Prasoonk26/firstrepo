package com.anti.methods;

import java.io.File;

public class RevokeFromGroups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

              try{
    		
    		File file = new File("C:/ABHISHEKHA/Group2/kishori.txt.aes");
        	
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	   
    	}catch(Exception e){
    		
    		e.printStackTrace();
    		
    	}
		
	}
		public int revokeFromGroupMethods(String groupPath){
		
		int n=0;
		  try{
	    		
	    		File file = new File(groupPath);
	        	
	    		if(file.delete()){
	    			System.out.println(file.getName() + " is deleted!");
	    			
	    			n=1;
	    		}else{
	    			System.out.println("Delete operation is failed.");
	    		}
	    	   
	    	}catch(Exception e){
	    		
	    		e.printStackTrace();
	    		
	    	}
		return n;
	}

}
