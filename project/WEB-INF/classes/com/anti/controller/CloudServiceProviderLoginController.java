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

import com.anti.beans.cloudBeans;
import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;

/**
 * Servlet implementation class CloudServiceProviderLoginController
 */
@WebServlet("/CloudServiceProviderLoginController")
public class CloudServiceProviderLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloudServiceProviderLoginController() {
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
		
		// object declaration and varibles 
		
		cloudBeans cloudBeans=new cloudBeans();
		
		Dao doa=DaoFactory.getInstance();
		
		ResultSet rs=null;
		
		// logice 
		
		cloudBeans.setCloud_name(request.getParameter("cloudName"));
		
		cloudBeans.setCloud_password(request.getParameter("cloudPassword"));
		
		rs=doa.cloudServiceProviderLogin(cloudBeans);
		
		try {
			if(rs.next()){
			
				System.out.println("have value");
				
				// make session
					
				cloudBeans.setCloud_name(rs.getString(2));
				
				cloudBeans.setCloud_password(rs.getString(3));
				
				HttpSession session=request.getSession();
				
				session.setAttribute("CloudServerSessionInfomation", cloudBeans);
				
				RequestDispatcher rd=request.getRequestDispatcher("welcomeToCloudServerProvider.jsp");
				
				rd.forward(request, response);
				
				

				
			}
			
			else
			{
				System.out.println("No values");
				
				request.setAttribute("erroMsg", "soory! Wrong Cloud Name and Password");
				
				RequestDispatcher rd=request.getRequestDispatcher("cloudServiceProviderLogin.jsp");
				rd.forward(request, response);
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
