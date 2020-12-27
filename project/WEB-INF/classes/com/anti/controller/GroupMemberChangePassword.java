package com.anti.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anti.beans.UserBeans;
import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;

/**
 * Servlet implementation class GroupMemberChangePassword
 */
@WebServlet("/GroupMemberChangePassword")
public class GroupMemberChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMemberChangePassword() {
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
		
		UserBeans userBeans=new UserBeans();
		
		Dao doa=DaoFactory.getInstance();
		
		// logice 
		
		userBeans.setId(Integer.parseInt(request.getParameter("userId")));
		
		
		
		
	}

}
