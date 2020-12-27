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
 * Servlet implementation class GroupMangerDeleteFromCloudController
 */
@WebServlet("/GroupMangerDeleteFromCloudController")
public class GroupMangerDeleteFromCloudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMangerDeleteFromCloudController() {
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
		
		Dao dao=DaoFactory.getInstance();
		
		UserBeans userBeans=new UserBeans();
		
		ResultSet rs=null;
		
		HttpSession session=request.getSession(),session1=request.getSession();
		
		// user session 
		
				
		userBeans=(UserBeans)session.getAttribute("userSessionInfomation");
		
		rs=dao.userGetFileFromParticulareGroup(userBeans);
		
		session1.setAttribute("DeleteRequestSession", rs);
		
		RequestDispatcher rd=request.getRequestDispatcher("groupMangerViewFileFromDeleteRequest.jsp");
		rd.forward(request, response);
		
		
		
		
	}

}
