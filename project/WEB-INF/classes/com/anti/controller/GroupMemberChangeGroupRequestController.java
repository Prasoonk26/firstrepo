package com.anti.controller;

import java.io.IOException;
import java.sql.ResultSet;

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
 * Servlet implementation class GroupMangerChangeGroupRequestController
 */
@WebServlet("/GroupMemberChangeGroupRequestController")
public class GroupMemberChangeGroupRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMemberChangeGroupRequestController() {
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
		
		// object 
		
		HttpSession session=request.getSession(),session1=request.getSession();
		
		UserBeans userBeans=new UserBeans();
		
		Dao dao=DaoFactory.getInstance();
		
		String userGroupStatus="Not Allocated ";
		
		ResultSet rs=null;
		
		
		
		// logic
		
		// user Session 
		
		userBeans=(UserBeans)session.getAttribute("userSessionInfomation");
		
		userBeans.setUser_new_group(request.getParameter("userGroup"));
		
		if(userBeans.getUser_new_group().equalsIgnoreCase(userBeans.getUser_group()))
		{
			System.out.println("user group and revoke group is same ");
			
			request.setAttribute("errorMsg"," Opps !Revoke Group and exiting group is same !!");
			
			RequestDispatcher rd=request.getRequestDispatcher("groupMemberRevokeGroup.jsp");
			rd.forward(request, response);
		}
		
		else
		{
			int n=dao.userInsertRevokeGroup(userBeans, userGroupStatus);
			
			if(n==1){
				
			     rs=dao.userViewStatusGroupRevoke(userBeans,userGroupStatus);
			     
			     session1.setAttribute("groupMemberStatusRevokeRequest", rs);
				
				RequestDispatcher rd=request.getRequestDispatcher("groupMemberRequestSend.jsp");
				rd.forward(request, response);
			}
		}
		
		
		
		
		
		
		
		
	}

}
