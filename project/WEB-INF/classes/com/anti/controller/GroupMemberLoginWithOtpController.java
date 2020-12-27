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
import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;

/**
 * Servlet implementation class GroupMemberLoginWithOtpController
 */
@WebServlet("/GroupMemberLoginWithOtpController")
public class GroupMemberLoginWithOtpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMemberLoginWithOtpController() {
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
		
		Dao doa=DaoFactory.getInstance();
		
		ResultSet rs=null;
		
		ResultSet rs1=null;
		
		
		// logices 
		
		userBeans.setUser_email(request.getParameter("userEmail"));
		
		userBeans.setUser_password(request.getParameter("userPassword"));
		
		userBeans.setUser_otp(request.getParameter("userOtp"));
		
		rs=doa.userCheckLoginWithOtp(userBeans);
		
		try {
			if(rs.next()){
				System.out.println("rs have value ");
				
				//id, user_name, user_email, user_password, user_contact, user_group, user_otp, user_time
				
				userBeans.setId(rs.getInt(1));
				
				userBeans.setUser_name(rs.getString(2));
				
				userBeans.setUser_email(rs.getString(3));

				userBeans.setUser_password(rs.getString(4));
				
				userBeans.setUser_group(rs.getString(6));
				
				
				
				
				rs1=doa.userCheckUserStatus(userBeans);
				
				if(rs1.next()){
					
											
					HttpSession session = request.getSession();

					session.setAttribute("userSessionInfomation", userBeans);

					System.out.println("result set have a value ");

					RequestDispatcher rd = request
							.getRequestDispatcher("welcomeToMember.jsp");
					rd.forward(request, response);
					
				}
				
				else
				{
					System.out.println("Group Manger did Not Activated");
					
					RequestDispatcher rd = request
							.getRequestDispatcher("userAgainLoginpage.jsp");
					rd.forward(request, response);
					
				}
			    
			    
				
				
			}
			
			else
			{
				System.out.println("No value ");
				
				request.setAttribute("errorMsg", "Sorry! your Email Id and Password is Wrong ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
