package com.anti.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

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
import com.anti.mail.Mail;
import com.anti.sms.smsSending;
import com.anti.testClass.myStringIntoNumber;

/**
 * Servlet implementation class GetActivatedMemberController
 */
@WebServlet("/GetActivatedMemberController")
public class GetActivatedMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetActivatedMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// varible and object
		
		Dao dao=DaoFactory.getInstance();
		
		ResultSet rs=null;
		
		String userStatus=null, userStatusAct="Activated";
		
		String userToken=null;
		
		Mail mail=new Mail();
		
		UserBeans userBeans=new UserBeans();
		
		int n=0,m=0;
		
		ArrayList<ResultSet> Arruser=new ArrayList<ResultSet>();
		
		myStringIntoNumber myobje=new myStringIntoNumber();
		
		int userId=0;
		
		String userValues=null;
		
		smsSending sms=new smsSending();
	
		
		// random Class Function 
		
		Random r = new Random();
		int ii = r.nextInt(10000000 - 500000) + 500000;
		userToken = ii + "";
		String l = "1";
		
		
		// logice
		
		 userValues=request.getParameter("userValue");
		
		System.out.println("userValues in String is "+userValues);
	
	    /*int userId=myobje.convertIntoNumber(userValues);
	    
	    System.out.println("In user Id is "+userId);*/
		
		userId=Integer.parseInt(userValues);
		
		System.out.println("userId values is "+userId);
		
		rs=dao.groupMangerActivateMemberParticulare(userId);
		
		try {
			while(rs.next()){
				
				userStatus=rs.getString(9);
				
				System.out.println("userStatus "+userStatus);
				
				if(userStatus.equals("Activated")){
				
					System.out.println(" user is Activate ");
					
					System.out.println("Same Page exitts ");
					
					 HttpSession session=request.getSession();
				   		
			   		  session.setAttribute("adminGetuserDetailsSession", rs);
			   		  
			   		  System.out.println("Same but user will activated Concepts ");
			   		  
			   		 /*RequestDispatcher rd=request.getRequestDispatcher("groupMangerUserDeatils.jsp");
			   		
			   		 rd.forward(request, response);*/
					
					
				}
				
				else {
					
					//id, user_name, user_email, user_password, user_contact, user_group, user_otp, user_time, user_status
					System.out.println("user is Deactivate user ");
					
					mail.mailSendUserToken(rs.getString(3), userToken);
					
					sms.Sms_user(rs.getString(5), userToken);
					
					userBeans.setId(rs.getInt(1));
					
					userBeans.setUser_email(rs.getString(3));
					
					userBeans.setUser_name(rs.getString(2));
					
					userBeans.setUser_token(userToken);
					
			       n=dao.groupMangerInsertTokenDetails(userBeans);
			       
			       if(n==1){
			    	   
			    	   System.out.println("value of n is "+n);
			    	   
			    	   userBeans.setUser_status(userStatusAct);
			    	   
			    	   m=dao.groupMangerUpdateUserStatus(userBeans);
			    	   
			    	   System.out.println("value is update from query "+m);

			    	   rs=dao.groupMangerActivateMember();
			   		
			    	  /* Arruser.add(rs);*/
						
			   		HttpSession session=request.getSession();
			   		
			   		session.setAttribute("adminGetuserDetailsSession", rs);
			   		
			   		/*RequestDispatcher rd=request.getRequestDispatcher("groupMangerUserDeatils.jsp");
			   		
			   		rd.forward(request, response);*/
			    	   
			       }
					
			       else
			       {
			    	   System.out.println("Value of n is "+n);
			       }
					
					
					
					
				}
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
