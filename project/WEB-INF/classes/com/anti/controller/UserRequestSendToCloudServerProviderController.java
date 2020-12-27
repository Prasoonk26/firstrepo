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
 * Servlet implementation class UserRequestSendToCloudServerProviderController
 */
@WebServlet("/UserRequestSendToCloudServerProviderController")
public class UserRequestSendToCloudServerProviderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRequestSendToCloudServerProviderController() {
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
		
		ResultSet rs=null;
		
		String userStatus="NotActivated!";
		
		int tableId=Integer.parseInt(request.getParameter("tableIdValue"));
		
		System.out.println("table Id "+tableId);
		
		rs=dao.userGetDeletefromTable(tableId);
		
		try {
			while(rs.next()){
				
				//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status, new_fileName
				
				int m=dao.userInsertDeletRequest(rs.getInt(2), rs.getString(3), rs.getString(3), rs.getString(6), userStatus);
				
				System.out.println("Value of m is "+m);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

		
		
		
	}

}
