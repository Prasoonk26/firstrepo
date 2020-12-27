package com.anti.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anti.beans.UserBeans;
import com.anti.beans.userDataFileBeans;
import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;

/**
 * Servlet implementation class UserDownloadFileController
 */
@WebServlet("/UserDownloadFileController")
public class UserDownloadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDownloadFileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// graph Code 
		
		long startDownloadingTime1=0,endDownloadingTime=0,totalDownloadingTime=0;
		
		Dao dao=DaoFactory.getInstance();
		
	
		
		// objects 
		
		HttpSession session=request.getSession(),session2=request.getSession(),session3=request.getSession();
		
		userDataFileBeans userDataFileBeans=new userDataFileBeans();
		userDataFileBeans=(userDataFileBeans)session.getAttribute("UserDataFileBeansSession");
		
		
		UserBeans userBeans=(UserBeans)session3.getAttribute("userSessionInfomation");
		
		  File downloadFile = new File(userDataFileBeans.getFilePath());
	        FileInputStream inStream = new FileInputStream(downloadFile);
	         
	        // if you want to use a relative path to context root:
	        String relativePath = getServletContext().getRealPath("");
	        System.out.println("relativePath = " + relativePath);
	         
	    	
	        
	       ServletContext context=getServletContext();
	        
	        // gets MIME type of the file
	        String mimeType = context.getMimeType(userDataFileBeans.getFilePath());
	        if (mimeType == null) {        
	            // set to binary type if MIME mapping not found
	            mimeType = "application/octet-stream";
	        }
	        System.out.println("MIME type: " + mimeType);
	         
	        // modifies response
	        response.setContentType(mimeType);
	        response.setContentLength((int) downloadFile.length());
	         
	        // forces download
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
	        response.setHeader(headerKey, headerValue);
	         
	        // obtains response's output stream
	        OutputStream outStream = response.getOutputStream();
	         
	        byte[] buffer = new byte[4096];
	        int bytesRead = -1;
	         
	        while ((bytesRead = inStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }
	        

	      
	        // graph Code 
	        
	        
	        endDownloadingTime=System.currentTimeMillis();
			
			System.out.println("End Downloading Time is "+endDownloadingTime);
			
			startDownloadingTime1=(long)session2.getAttribute("startingDownloadingTimeSession");
			
			System.out.println("start Downloading Time is "+startDownloadingTime1);
	        
			totalDownloadingTime=endDownloadingTime-startDownloadingTime1;
			
			System.out.println("Total  Downloading Time is "+totalDownloadingTime);
			
			int m=dao.userInsertDowloadingGraph(userDataFileBeans.getFileName(), startDownloadingTime1, endDownloadingTime, totalDownloadingTime, userBeans.getUser_email());
			
			System.out.println("Value of mis "+m);
			
			
	        inStream.close();
	        outStream.close(); 
		
	}

}
