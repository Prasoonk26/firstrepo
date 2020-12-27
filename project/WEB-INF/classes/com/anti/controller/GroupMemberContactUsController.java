package com.anti.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anti.beans.UserBeans;
import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;

/**
 * Servlet implementation class GroupMemberContactUsController
 */
@WebServlet("/GroupMemberContactUsController")
public class GroupMemberContactUsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMemberContactUsController() {
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
		
		// varible and object
		
		UserBeans userBeans=new UserBeans();
		
		Dao dao=DaoFactory.getInstance();
		
		int n=0;
		
		
		// logice
		
		userBeans.setUser_name(request.getParameter("fName"));
		
		userBeans.setUser_email(request.getParameter("userEmail"));
		
		userBeans.setUser_Message(request.getParameter("userMessage"));
		
		n=dao.userContactMessage(userBeans);
		
		if(n==1){
			
			System.out.println("Value of n is "+n);
			
			request.setAttribute("SuccesMsg", "Thanks ! your message succefully stored");
			
			RequestDispatcher rd=request.getRequestDispatcher("contactUs.jsp");
			
			rd.forward(request, response);
			
			
		}
		
		else
		{
			System.out.println("Vale is n "+n);
		}
		
	}

}
