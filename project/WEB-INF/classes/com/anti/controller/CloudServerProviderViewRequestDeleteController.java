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
 * Servlet implementation class CloudServerProviderViewRequestDeleteController
 */
@WebServlet("/CloudServerProviderViewRequestDeleteController")
public class CloudServerProviderViewRequestDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloudServerProviderViewRequestDeleteController() {
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
		
		String userStatus="NotActivated!";
		
		ResultSet rs=null;
		
		rs=dao.cloudServerProviderGetFileDelete(userStatus);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("SessionDeletRequest", rs);
		
		RequestDispatcher rd=request.getRequestDispatcher("CloudServerProviderViewFileDeletRequest.jsp");
		rd.forward(request, response);
		
	}

}
