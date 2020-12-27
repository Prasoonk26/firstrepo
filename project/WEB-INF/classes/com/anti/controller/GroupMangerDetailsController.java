package com.anti.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class GroupMangerDetailsController
 * @param <E>
 */
@WebServlet("/GroupMangerDetailsController")
public class GroupMangerDetailsController<E> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMangerDetailsController() {
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
		
		
		ArrayList<UserBeans> Arruser=new ArrayList<UserBeans>();
		
		ResultSet rs=null;
		
		Dao dao=DaoFactory.getInstance();
		
		UserBeans userBeans=new UserBeans();
		
		rs=dao.groupMangerActivateMember();
		
       /* try {
			while(rs.next()){
				
				//id, user_name, user_email, user_password, user_contact, user_group, user_otp, user_time, user_status
				
				userBeans.setId(rs.getInt(1));
				
				userBeans.setUser_email(rs.getString(3));
				
				userBeans.setUser_name(rs.getString(2));
				
				userBeans.setUser_group(rs.getString(6));
				
				userBeans.setUser_status(rs.getString(9));
				
				Arruser.add(userBeans);
				
				HttpSession session=request.getSession();
				
				session.setAttribute("adminGetuserDetailsSession", Arruser);
				 
			
			}*/
		
		    HttpSession session=request.getSession();
		
			
	  	    session.setAttribute("adminGetuserDetailsSession", rs);
			RequestDispatcher rd=request.getRequestDispatcher("groupMangerUserDeatils.jsp");
			
			rd.forward(request, response);

		/*} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
			
		
   	
	
		
		
		
	}

}
