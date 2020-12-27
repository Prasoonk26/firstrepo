package com.anti.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;

/**
 * Servlet implementation class DeleteFakeMemberController
 */
@WebServlet("/DeleteFakeMemberController")
public class DeleteFakeMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFakeMemberController() {
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
		
		int userId=0,n=0,n1=0;
		
		Dao dao=DaoFactory.getInstance();
		
		ResultSet rs=null;
		
		int userValue=Integer.parseInt(request.getParameter("userValue"));
		
		System.out.println("userValue is "+userValue);
		
		rs=dao.userGetFakeDetails(userValue);
		
		try {
			while(rs.next()){
				
				System.out.println("Value of id is "+rs.getInt(1));
				
				userId=rs.getInt(2);
				
				System.out.println("UserId is "+userId);
				
			
				
				
			}
			
			n=dao.groupMangerGetDeleteFromUserReg(userId);
			
			n1=dao.groupMangerDeleleFromFaketable(userId);
			
			System.out.println("Value of n is "+n);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// logic  
		
		
	}

}
