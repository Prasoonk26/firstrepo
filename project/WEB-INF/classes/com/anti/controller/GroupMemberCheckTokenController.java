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
 * Servlet implementation class GroupMemberCheckTokenController
 */
@WebServlet("/GroupMemberCheckTokenController")
public class GroupMemberCheckTokenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMemberCheckTokenController() {
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
		
		// object and varible 
		
		System.out.println("In GroupMember Check Token Controller");
		
		UserBeans userBeans=new UserBeans();
		
		Dao dao=DaoFactory.getInstance();
		
		ResultSet rs=null;
		
		// logice
		
		userBeans.setUser_token(request.getParameter("userToken"));
		
		System.out.println("userToken is "+request.getParameter("userToken"));
		
		// get the user session 
		
		HttpSession session=request.getSession();
		
		userBeans=(UserBeans)session.getAttribute("userSessionInfomation");
	
		userBeans.setUser_token(request.getParameter("userToken"));
		
		
		rs=dao.userCheckUserToken(userBeans);
		
		try {
			if(rs.next()){
				System.out.println(" result set some value have value ");
				
              RequestDispatcher rd=request.getRequestDispatcher("welcomeToMember.jsp");
				
				rd.forward(request, response);
			}
			
			else
			{
				System.out.println("no value");
				
				request.setAttribute("errorMsg","sorry! your token is wrong");
				
				RequestDispatcher rd=request.getRequestDispatcher("groupMemberTokenPage.jsp");
				
				rd.forward(request, response);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
