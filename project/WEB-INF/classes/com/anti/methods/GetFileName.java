package com.anti.methods;

import org.apache.commons.io.FilenameUtils;

public class GetFileName {


	public String get_extension_method(String file_name){
		
		String ext2 = FilenameUtils.getExtension(file_name);
		System.out.println("extension of file is"+ext2);
		return ext2;
		
	}
	
}
