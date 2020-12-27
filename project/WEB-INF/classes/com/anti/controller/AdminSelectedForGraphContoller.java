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
 * Servlet implementation class AdminSelectedForGraphContoller
 */
@WebServlet("/AdminSelectedForGraphContoller")
public class AdminSelectedForGraphContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSelectedForGraphContoller() {
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
		
		ResultSet rs=null;
		
		HttpSession session=request.getSession();
		
		
		// logic
		
		
		String fileName=request.getParameter("fileName");
		
		System.out.println("File Name is ..."+fileName);
		
		rs=dao.groupMangerGetGraph(fileName);
		
		
		session.setAttribute("adminUploadingGraphResultSession", rs);
		
		RequestDispatcher rd=request.getRequestDispatcher("groupMangerUploadingGraph.jsp");
		rd.forward(request, response);
		
	}

}
