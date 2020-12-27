package com.anti.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anti.beans.UserBeans;
import com.anti.beans.userDataFileBeans;
import com.anti.mail.Mail;

/**
 * Servlet implementation class UserCheckKeyPageController
 */
@WebServlet("/UserCheckKeyPageController")
public class UserCheckKeyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCheckKeyPageController() {
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
		
		// graph Vaarible 
		
		long startDownloadingTime1=0;
		
		
		
		
		// user Session 
		
		HttpSession session=request.getSession(),session2=request.getSession();
		
		UserBeans userBeans=(UserBeans)session.getAttribute("userSessionInfomation");
		
		// objects
		
		Mail mail=new Mail();
		
		userDataFileBeans userDataFileBeans=new userDataFileBeans();
		
		HttpSession session1=request.getSession();
		
		userDataFileBeans=(userDataFileBeans)session1.getAttribute("UserDataFileBeansSession");
					
		String userKey=request.getParameter("userFileKey");
		
		System.out.println("userFileKey is "+userKey);
		
		if(userDataFileBeans.getFileKey().equals(userKey)){
			
			System.out.println("Key matched");
			
			// graph Code 
			
			 startDownloadingTime1=System.currentTimeMillis();
			
			System.out.println("start Downloading Time is "+startDownloadingTime1);
			
			
			session2.setAttribute("startingDownloadingTimeSession", startDownloadingTime1);
			
			
			RequestDispatcher rd=request.getRequestDispatcher("UserDownloadFileController");
			rd.forward(request, response);
			
		}
		
		else
		{
			System.out.println("key Not Matched..................");
			
			request.setAttribute("errorMsg", "Sorry! your Key is Wrong ");
			
			RequestDispatcher rd=request.getRequestDispatcher("userKeyPage.jsp");
			rd.forward(request, response);
			
			
		}
		
		
	}

}
