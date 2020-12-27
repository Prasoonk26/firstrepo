package com.anti.controller;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anti.beans.UserBeans;
import com.anti.beans.UserFileDataBeans;
import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;
import com.anti.methods.RSA_Algorithms;
import com.anti.methods.Create_User_Group;
import com.anti.methods.RSA_Algorithms;

/**
 * Servlet implementation class CloudServerProviderFileSecondLevelEncrptionController
 */
@WebServlet("/CloudServerProviderFileSecondLevelEncrptionController")
public class CloudServerProviderFileSecondLevelEncrptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR="ANTI_COLLUSION" ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloudServerProviderFileSecondLevelEncrptionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//object 
		
		Dao dao=DaoFactory.getInstance();
		
		ResultSet rs=null;
		
		UserBeans userBeans=new UserBeans();
		
		UserFileDataBeans userFileDataBeans=new UserFileDataBeans();
		
		String folderPath="C:"+File.separator+SAVE_DIR+File.separator, finalPath=null,encrptionPath=null,fileKeyUpdate=null,finalStatus="UploadToCloud",encrptionFinalPath=null;
		
		Create_User_Group createObject=new Create_User_Group();
		
		RSA_Algorithms RSAObjects=new RSA_Algorithms();
		
		int n=1;
		
		// logic
		
		System.out.println("CloudServerProviderFileSecondLevelEncrptionController");
		
		
		
		
		int tableId=Integer.parseInt(request.getParameter("tableValue"));
		
		System.out.println("table Id is "+tableId);
		
		rs=dao.cloudServerProviderViewFileParticulareDetails(tableId);
		
		try {
			while(rs.next()){
				
				//id, user_id, user_email, user_name, file_name, file_path, file_encrption_path, file_key, file_status, user_group, new_fileName
				
				userBeans.setId(rs.getInt(2));
				
				userBeans.setUser_email(rs.getString(3));
				
				userBeans.setUser_name(rs.getString(4));
				
				userBeans.setUser_group(rs.getString(10));
				
				userFileDataBeans.setFileEncrptionPath(rs.getString(7));
				
				userFileDataBeans.setFileName(rs.getString(5));
				
				userFileDataBeans.setFilePath(rs.getString(6));
				
				finalPath=folderPath+userBeans.getUser_group();
				
				userFileDataBeans.setFileKey(rs.getString(8));
				
				userFileDataBeans.setFileStatus(rs.getString(9));
				
				userFileDataBeans.setNewFileName(rs.getString(11));
				
				if(userFileDataBeans.getFileStatus().equals("Send-To-Cloud"))
				{
				
				
				n=createObject.createGroups(finalPath);
				
				if(n==1){
					
					encrptionPath=finalPath+File.separator+userFileDataBeans.getNewFileName();
					
					System.out.println("encrption path is "+encrptionPath);
					
					System.out.println("user File Path is "+userFileDataBeans.getFileEncrptionPath());
					
					RSAObjects.encrypt(userFileDataBeans.getFileEncrptionPath(), encrptionPath);
					
					System.out.println("Done Encrption at seconds level ");
					
					System.out.println("YESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
					
					encrptionFinalPath=encrptionPath+".aes";
					
					System.out.println("Final encrption Final path =="+encrptionFinalPath);
					System.out.println("YESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS122222222222222222");			
										
					fileKeyUpdate=RSAObjects.genratedKey(userFileDataBeans.getFileKey());
					
					System.out.println("file key Update is "+fileKeyUpdate);
					
					System.out.println("first key is "+userFileDataBeans.getFileKey());
					
					//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status
					
					int n1=dao.cloudServerProviderInsertEncrptionFileDetails(userBeans, userFileDataBeans, encrptionFinalPath, finalStatus, fileKeyUpdate);
					
					System.out.println("Value of n is "+n1);
					
					int up1=dao.cloudServerProviderUpdateUserUploadStatus(userBeans, userFileDataBeans, finalStatus);
					
					System.out.println("Value of up1 is "+up1);
					
					int up2=dao.cloudServerproviderUpdateAdminUploadStatus(userBeans, userFileDataBeans, finalStatus);
					
					System.out.println("value of up2 is "+up2);
					
					
					
					
					
					
					
					
					
				}
				
				} // end of if frist condittions 
				
				
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
