package com.anti.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anti.beans.UserBeans;
import com.anti.beans.UserFileDataBeans;
import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;
import com.anti.methods.BlowfishAlgorithms;

/**
 * Servlet implementation class GroupMangerGetFileDetailsEncrptionController
 */
@WebServlet("/GroupMangerGetFileDetailsEncrptionController")
public class GroupMangerGetFileDetailsEncrptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR="ANTI_COLLUSION" ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMangerGetFileDetailsEncrptionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// object
		
		Dao dao=DaoFactory.getInstance();
		
		ResultSet rs=null;
		
		String fileStatus=null,savePath=null,encrption_file="Encrption_file",fileKey=null,encrptionFilePath=null,fileStatusNew="Send-To-Cloud";
		
		UserFileDataBeans userFileDataBeans=new UserFileDataBeans();
		
		BlowfishAlgorithms blowFishAlgorithmsObject=new BlowfishAlgorithms();
		
        FileInputStream fin = null;
		
		FileOutputStream fos = null;
		
		UserBeans userBeans=new UserBeans();
		
		
		// Make folder 
		
		  
	     savePath="C:"+File.separator+SAVE_DIR+File.separator+encrption_file;
			
		 File encrptionPath=new File(savePath);
			
	      if(!encrptionPath.exists()){
				
		  boolean status = encrptionPath.mkdirs();
				
		  System.out.println("status is "+status);
		  
		}
		
		
		// logic parts 
				
		System.out.println("In GroupMangerGetFileDetailsEncrptionController page  ");
		
		int tableId=Integer.parseInt(request.getParameter("tableValue"));
		
		System.out.println("Table id is "+tableId);
		
		rs=dao.groupMangerGetFileParticulareDetails(tableId);
		
		try {
			while(rs.next()){
				
//id, user_id, user_email, user_name, user_group, file_name, file_path, file_status, file, new_file_name
				
				userBeans.setId(rs.getInt(2));
				
				userBeans.setUser_email(rs.getString(3));
				
				userBeans.setUser_name(rs.getString(4));
				
				userBeans.setUser_group(rs.getString(5));
				
				
				fileStatus=rs.getString(8);
				
				System.out.println("file Status is "+fileStatus);
				
				userFileDataBeans.setFileStatus(fileStatus);
				
				if(userFileDataBeans.getFileStatus().equals("Send_To_Admin"))
				{
					
					userFileDataBeans.setFileName(rs.getString(6));
					
					userFileDataBeans.setFilePath(rs.getString(7));
					
					userFileDataBeans.setNewFileName(rs.getString(10));
					
					fileKey=blowFishAlgorithmsObject.blowFishKey(userFileDataBeans.getNewFileName());
					
				       userFileDataBeans.setFileKey(fileKey);
					
					fin=new FileInputStream(userFileDataBeans.getFilePath());
					
					encrptionFilePath=savePath+File.separator+userFileDataBeans.getNewFileName();
					
					fos=new FileOutputStream(encrptionFilePath);
					
					userFileDataBeans.setFileEncrptionPath(encrptionFilePath);
					
					blowFishAlgorithmsObject.encrypt(userFileDataBeans.getFileKey(), fin, fos);
					
					System.out.println("Encrption done at one level ");
					
					userFileDataBeans.setFileStatus(fileStatusNew);
					
					int m=dao.groupMangerInsertFileEncption(userBeans, userFileDataBeans);
					
					System.out.println("Value of m is "+m);
					
					int m1=dao.groupMangerUpdateMemberFileStatus(userBeans, tableId, fileStatusNew);
					
					System.out.println("Value of m1 is "+m1);
					
					
					
					
				}
				
				else
				{
					System.out.println("In Controller");
					
					if(userFileDataBeans.getFileStatus().equals("UploadToCloud"))
					{

						System.out.println("Status is "+userFileDataBeans.getFileStatus());
					}
					
				}
				
				
				
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
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
