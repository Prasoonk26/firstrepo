package com.anti.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

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
import com.anti.sms.smsSending;

/**
 * Servlet implementation class GroupMemberRegisterController
 */
@WebServlet("/GroupMemberRegisterController")
public class GroupMemberRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMemberRegisterController() {
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
		
		Dao dao=DaoFactory.getInstance();
		
		String userOtp=null;
		
		int userTime=0;
		
		Mail mail=new Mail();
		
		ResultSet rs=null;
		
		String user_status="Deactivate";
		
		int n=0;
		
		smsSending sms=new smsSending();
		
		// random number 
		
		Random r = new Random();
		int ii = r.nextInt(10000000 - 500000) + 500000;
		userOtp = ii + "";
		String l = "1";
		
	
		
		
		userBeans.setUser_name(request.getParameter("userName"));
		
		userBeans.setUser_email(request.getParameter("userEmail"));
		
		userBeans.setUser_password(request.getParameter("userPassword"));
		
		userBeans.setUser_contact(request.getParameter("userPhoneNumber"));
		
		userBeans.setUser_group(request.getParameter("userGroup"));
		
		userBeans.setUser_otp(userOtp);
		
		userBeans.setId(userTime);
		
		userBeans.setUser_status(user_status);
		
		
		rs=dao.groupMemberPresentOrNot(userBeans);
		
		try {
			if(rs.next()){
				
				request.setAttribute("errorMsg","Email is Allready Register !");
				
				System.out.println("Hello i am check the condition ");
				
				RequestDispatcher rd=request.getRequestDispatcher("groupMemberRegistration.jsp");
				
				rd.forward(request, response);
				
			}
			
			else{
			
		
			
			n=dao.groupMemberRegistion(userBeans);
			
			if(n>0){
				
				mail.mailSendOTP(userBeans.getUser_email(), userOtp);
				
				sms.Sms_user(userBeans.getUser_contact(), userOtp);
				
				
				
				request.setAttribute("succesMsg","Your Registeration is Successfuly  !");
				
				RequestDispatcher rd=request.getRequestDispatcher("groupMemberLogin.jsp");
				
				rd.forward(request, response);
				
				
				
				
			}
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
