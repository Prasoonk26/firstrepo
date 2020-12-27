package com.anti.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anti.beans.UserBeans;

/**
 * Servlet implementation class LogoutMemberController
 */
@WebServlet("/LogoutMemberController")
public class LogoutMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutMemberController() {
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
		
		UserBeans userBeans=new UserBeans();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("userSessionInfomation", null);
		
		System.out.println("value set null;");
		
		HttpSession session1=request.getSession();
		
		userBeans=(UserBeans)session1.getAttribute("userSessionInfomation");
		
		if(userBeans==null)
			
		{
			System.out.println("yes");
			
			 HttpSession session4=request.getSession(false);
		      session4.invalidate();
		      
		      response.sendRedirect("succes.jsp");
			
					}
		
		else
		{
			System.out.println("no ");
		}
	}

}
