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
import com.anti.mail.Mail;

/**
 * Servlet implementation class GroupMemberChangePasswordController
 */
@WebServlet("/GroupMemberChangePasswordController")
public class GroupMemberChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMemberChangePasswordController() {
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
		
		// varible and Object
		
		UserBeans userBeans=new UserBeans();
		
		Dao dao=DaoFactory.getInstance();
		
		int n=0;
		
		Mail mail=new Mail();
		
		
		// logical part 
		
		userBeans.setUser_email(request.getParameter("userEmail"));
		
		userBeans.setUser_password(request.getParameter("userOldPassword"));
		
		userBeans.setUser_new_password(request.getParameter("userNewPassword"));
		
		n=dao.userChangePassword(userBeans);
		
		System.out.println("Values of n is "+n);
		
		if(n==1){
			System.out.println("N value is "+n);
			
			mail.mailSendChangePassword(userBeans.getUser_email(), userBeans.getUser_new_password());
			
			RequestDispatcher rd=request.getRequestDispatcher("groupMemberLogin.jsp");
			rd.forward(request, response);
			
		}
		
		else
		{
			request.setAttribute("errorMsg", "sorry! your email and password Not Exists");
			

			RequestDispatcher rd=request.getRequestDispatcher("groupMemberChangePassword.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
