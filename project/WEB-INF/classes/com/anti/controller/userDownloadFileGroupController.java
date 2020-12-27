package com.anti.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
import com.anti.mail.Mail;

/**
 * Servlet implementation class userDownloadFileGroupController
 */
@WebServlet("/userDownloadFileGroupController")
public class userDownloadFileGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userDownloadFileGroupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// objects 
		
		Mail mail=new Mail();
		
		HttpSession session=request.getSession(),session1=request.getSession();
		
		userDataFileBeans userDataFileBeans=new userDataFileBeans();
		
		Dao dao=DaoFactory.getInstance();
		
		UserBeans userBeans=new UserBeans();
		
		int userId=Integer.parseInt(request.getParameter("userId"));
		
		String userEmail=request.getParameter("userEmail");
		
		String fileName=request.getParameter("userFileName");
		
		String userGroup=request.getParameter("userGroup");
		
	System.out.println("userEmail is "+userEmail);
		
	System.out.println("fileName is "+fileName);
	
	System.out.println("userGroup is "+userGroup);
	
	System.out.println("UserId is "+userId);
		
		// userSession 
		
		userBeans = (UserBeans) session.getAttribute("userSessionInfomation");

		if(userGroup.equalsIgnoreCase(userBeans.getUser_group())){
			
			ResultSet rs=dao.userGetDataFromGroupDownload(userId, userGroup, fileName, userEmail);
			
			System.out.println("Result have Values");
			
			try {
				while(rs.next()){
					
					
					//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status, new_fileName
					
					userDataFileBeans.setFileKey(rs.getString(11));
					
					userDataFileBeans.setFileName(rs.getString(6));
					
					userDataFileBeans.setFilePath(rs.getString(7));
					
					userDataFileBeans.setNewFileName(rs.getString(13));
					
					System.out.println("In loops ");
					
					if(userDataFileBeans.getFileName().equals(userDataFileBeans.getNewFileName())){
						System.out.println("File Name ");
						
						session1.setAttribute("UserDataFileBeansSession", userDataFileBeans);
						
						mail.mailSendKeyFromUser(userBeans.getUser_email(), userDataFileBeans.getFileName(), rs.getString(11));
						
						System.out.println("Mail Sends!!!");
						
															
						RequestDispatcher rd=request.getRequestDispatcher("userKeyPage.jsp");
						rd.forward(request, response);
					}
					
					else
					{
						System.out.println("diffrent ");
						
						session1.setAttribute("UserDataFileBeansSession", userDataFileBeans);
						
						mail.mailSendKeyFromUser(userBeans.getUser_email(), userDataFileBeans.getFileName(), rs.getString(11));
						
						System.out.println("Mail Sends!!!");
						
															
						RequestDispatcher rd=request.getRequestDispatcher("userKeyPage.jsp");
						rd.forward(request, response);
					}
					
					
					
					
							
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
