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

import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;

/**
 * Servlet implementation class CloudServerViewMemberFileDeatilsController
 */
@WebServlet("/CloudServerViewMemberFileDeatilsController")
public class CloudServerViewMemberFileDeatilsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloudServerViewMemberFileDeatilsController() {
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
		
		Dao dao=DaoFactory.getInstance();
		
		ResultSet rs=null;
		
		HttpSession session=request.getSession();
		
		// logic
		
		rs=dao.cloudServerProviderViewFileDetails();
		
		session.setAttribute("cloudServerProviderFileDeatilsSession", rs);
		
		RequestDispatcher rd=request.getRequestDispatcher("cloudServerProviderViewFileDeatils.jsp");
		rd.forward(request, response);
		
		
		
		
	}

}
