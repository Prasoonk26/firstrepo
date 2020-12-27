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
 * Servlet implementation class GroupMemberDownloadGroupRequestController
 */
@WebServlet("/GroupMemberDownloadGroupRequestController")
public class GroupMemberDownloadGroupRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMemberDownloadGroupRequestController() {
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
		
		// objects 
		
		Dao dao=DaoFactory.getInstance();
		
		HttpSession session = request.getSession(), session1 = request
				.getSession();

		UserBeans userBeans = new UserBeans();
		
		ResultSet rs=null;
		
		// get the session 

		userBeans = (UserBeans) session.getAttribute("userSessionInfomation");

		userBeans.setUser_new_group(request.getParameter("userGroup"));
		
		if(userBeans.getUser_new_group().equalsIgnoreCase(userBeans.getUser_group()))
		{
			System.out.println("user group and revoke group is same ");
			
			rs=dao.userGetDataFromGroup(userBeans);
			
			session1.setAttribute("groupDataFileSession", rs);
	
			RequestDispatcher rd=request.getRequestDispatcher("userShowGroupsDataFile.jsp");
			rd.forward(request, response);
		}
		
		else
		{
		     System.out.println("No same group ");
			
            rs=dao.userGetDataFromGroup(userBeans);
			
			session1.setAttribute("groupDataFileSession", rs);
	
			RequestDispatcher rd=request.getRequestDispatcher("userShowFileFromDiffrentGroupsDataFile.jsp");
			rd.forward(request, response);
			
			
			
		}
		
		
	}

}
