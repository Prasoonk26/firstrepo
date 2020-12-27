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

import com.anti.beans.adminBeans;
import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;

/**
 * Servlet implementation class GroupMangerLoginController
 */
@WebServlet("/GroupMangerLoginController")
public class GroupMangerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMangerLoginController() {
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
		
		adminBeans adminBeans=new adminBeans();
		
		Dao dao=DaoFactory.getInstance();
		
		ResultSet rs=null;
		
		// logic
		
		adminBeans.setAdmin_name(request.getParameter("adminName"));
		
		adminBeans.setAdmin_Password(request.getParameter("adminPassword"));
		
		rs=dao.groupMangerLogin(adminBeans);
		
		try {
			if(rs.next()){
				
			     System.out.println("rs value is not null");
			     
			     adminBeans.setAdmin_name(rs.getString(2));
			     
			     adminBeans.setAdmin_Password(rs.getString(3));
			     
			     HttpSession session= request.getSession();
			     
			     session.setAttribute("adminSessionInfomation", adminBeans);
			     
			     RequestDispatcher rd=request.getRequestDispatcher("WelcomeToManger.jsp");
					
				 rd.forward(request, response);

			     
			}
			
			else
			{                                                                                                  
				System.out.println("rs value is null");
				
				request.setAttribute("errorMsg", "Sorry! Admin name and password is Wrong ");
				
				RequestDispatcher rd=request.getRequestDispatcher("groupMangerLogin.jsp");
				
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
