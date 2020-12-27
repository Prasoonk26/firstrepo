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
 * Servlet implementation class GroupMemberLoginController
 */
@WebServlet("/GroupMemberLoginController")
public class GroupMemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMemberLoginController() {
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
		// TODO Auto-generated metod stub
		
		// object and vaarible 
		
		 
		UserBeans userBeans=new UserBeans();
		
		Dao dao=DaoFactory.getInstance();
		
		ResultSet rs=null,rs1=null,rs2=null;
		
		int userTime=0,n=0,userTokenTime=0;
		
		HttpSession session1=request.getSession();
		
		// graph code 
		
		
		long startingUploadingTime1=System.currentTimeMillis();
		
		System.out.println("Starting Time For Uploading is "+startingUploadingTime1);
		
		session1.setAttribute("startUploadingTimeSession", startingUploadingTime1);
		
		
		
		
		// logice
		
		userBeans.setUser_email(request.getParameter("userEmail"));
		
		userBeans.setUser_password(request.getParameter("userPassword"));
		
		rs=dao.groupMemberLogin(userBeans);
		
		try {
			if(rs.next()){
				
				//id, user_name, user_email, user_password, user_contact, user_group, user_otp, user_time
				
				System.out.println("Value are present ");
				
				userTime=rs.getInt(8);
				
				userBeans.setUser_email(rs.getString(3));
				
				System.out.println("userTime is "+userTime);
				
				System.out.println("userBean value is "+userBeans.getUser_email());
				
				
				
			if(userTime==0)
				{
					n=dao.userUpdateUserTime(userBeans);
					
					System.out.println("Value of n is"+n);
					
					RequestDispatcher rd=request.getRequestDispatcher("groupMemberLoginWithOtp.jsp");
					
					rd.forward(request, response);
				}
				
				else
				{
					System.out.println("In else parts ");
					
					userBeans.setId(rs.getInt(1));
					
					userBeans.setUser_email(rs.getString(3));
					
					userBeans.setUser_name(rs.getString(2));
					
					userBeans.setUser_password(rs.getString(4));
					
					userBeans.setUser_contact(rs.getString(5));
					
					userBeans.setUser_group(rs.getString(6));
					
					
					rs1=dao.userCheckUserStatus(userBeans);
					
					if(rs1.next()){
						
												
						HttpSession session = request.getSession();

						session.setAttribute("userSessionInfomation", userBeans);

						System.out.println("result set have a value ");
						
						
						rs2=dao.userCheckTokenTime(userBeans);
						
						while(rs2.next()){
							
							//id, user_id, user_email, user_name, user_token, user_time
							
							userTokenTime=rs2.getInt(6);
							
						}
						
						if(userTokenTime==1){
							
							System.out.println("UserTokenTime is 111 "+userTokenTime);
							
							int m=dao.userUpdateTokenTime(userBeans);
							
							System.out.println("Value of m is "+m);
							
							
							RequestDispatcher rd = request
									.getRequestDispatcher("groupMemberTokenPage.jsp");
							rd.forward(request, response);
							
						}
						
						else
						{
							
						
					
							
							RequestDispatcher rd=request.getRequestDispatcher("welcomeToMember.jsp");
							  rd.forward(request, response);
						}

						
						
					}
					
					else
					{
						System.out.println("Group Manger did Not Activated");
						
						RequestDispatcher rd = request
								.getRequestDispatcher("userAgainLoginpage.jsp");
						rd.forward(request, response);
						
					}
					
					
					
				    
					
				}
		}
			
			else
			{
				System.out.println("value are not present  ");
				
				request.setAttribute("errorCallMsg","Your Email id are not present !!!!");
				
				RequestDispatcher rd = request
						.getRequestDispatcher("groupMemberLogin.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
