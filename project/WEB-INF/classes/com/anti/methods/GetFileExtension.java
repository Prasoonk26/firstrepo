package com.anti.methods;

import org.apache.commons.io.FilenameUtils;

public class GetFileExtension {

	public String get_name_method(String file_name){
		String fileNameWithOutExt = FilenameUtils.removeExtension(file_name);
		System.out.println("result is "+fileNameWithOutExt);
		return fileNameWithOutExt;
	}
	
}
