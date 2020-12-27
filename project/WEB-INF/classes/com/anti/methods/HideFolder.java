package com.anti.methods;

import java.io.File;
import java.io.IOException;

public class HideFolder {

	 public static void main(String[] args) {
		 
	
		 String path="C:/Mona";
		 
		 HideFolder hideFolder=new HideFolder();
		 
		 hideFolder.folderHide(path);
		 
		/* System.out.println("Folder hidde");
		 
		 System.out.println("list of data");
		 
		
		 File f = new File("C:\\Abhi");
         int count = 0;
         for (File file : f.listFiles()) {
                 if (file.isFile()) {
                         count++;
                 }
         }
         System.out.println("Number of files: " + count);
		 */
     }
	 
public int folderHide(String path)
{
	int n=0;
	
	 
	 String cmd="attrib +h "+path;
	 
	 System.out.println("CMD is "+cmd);
	 try {
		Runtime.getRuntime().exec(cmd);
		n=1;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return n;
	
}
	 
	    }
	

