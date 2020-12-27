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

import com.anti.beans.UserBeans;
import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;
import com.anti.mail.Mail;

/**
 * Servlet implementation class GroupMemberForgotPasswordController
 */
@WebServlet("/GroupMemberForgotPasswordController")
public class GroupMemberForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMemberForgotPasswordController() {
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
		
		// varible and objects
		
		UserBeans userBeans=new UserBeans();
		
		Dao Dao=DaoFactory.getInstance();
		
		ResultSet rs=null;
		
		String userPassword=null;
		
		Mail mail=new Mail();
		
		// logice 
		
		userBeans.setUser_email(request.getParameter("userEmail"));
		
		rs=Dao.groupMemberPresentOrNot(userBeans);
		
		try {
			if(rs.next()){
				//id, user_name, user_email, user_password, user_contact, user_group, user_otp, user_time
				
				System.out.println("resultset is not null");
				
				userPassword=rs.getString(4);
				
				mail.mailSendForgotPassword(userBeans.getUser_email(), userPassword);
				
				request.setAttribute("msgSend","Your Password is send to Your Register mail id ");
				
				RequestDispatcher rd=request.getRequestDispatcher("groupMemberLogin.jsp");
				
				rd.forward(request, response);
				
				
				
			}
			
			else
			{
				System.out.println("resultset is  null");
				
				request.setAttribute("errorMsg", "sorry! your email is not Register ");
				
                RequestDispatcher rd=request.getRequestDispatcher("groupMemberLogin.jsp");
				
				rd.forward(request, response);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
