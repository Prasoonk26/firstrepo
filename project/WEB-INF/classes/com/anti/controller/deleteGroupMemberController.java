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

import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;
import com.anti.methods.RevokeFromGroups;

/**
 * Servlet implementation class deleteGroupMemberController
 */
@WebServlet("/deleteGroupMemberController")
public class deleteGroupMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteGroupMemberController() {
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
		
		RevokeFromGroups revokeFromGroups=new RevokeFromGroups();
		
        Dao dao=DaoFactory.getInstance();
		
		ResultSet rs=null,rs1=null,rs2=null;
		
		int n1=0,n2=0,n3=0;
		
		String status="Activated!",adminPath=null,cspPath=null,orPath=null;
				
        int userId=Integer.parseInt(request.getParameter("userId"));
		
		System.out.println("userId Id in controller "+userId);
		
		String fileName=request.getParameter("fileName");
		
		System.out.println("fileName is "+fileName);
		
		String userEmail=request.getParameter("userEmail");
		
		System.out.println("userEmail is"+userEmail);
		
		rs1=dao.cloudServerGetPathFromAdminEncrption(userId, userEmail, fileName);
		
		
		
		try {
			while(rs1.next()){
				
//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status, new_fileName				
				
				adminPath=rs1.getString(7);
				
				orPath=rs1.getString(6);
				
				System.out.println("Admin Path is .............................."+adminPath);
				
				System.out.println("Or  Path is "+orPath);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rs2=dao.cloudServerGetPathFromcsp_encrption_table(userId, userEmail, fileName);
		
		try {
			while(rs2.next()){
				
				//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status, new_fileName
				
				cspPath=rs2.getString(9);
				
				System.out.println("CSP  Path is......................... "+cspPath);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		revokeFromGroups.revokeFromGroupMethods(adminPath);
		
		revokeFromGroups.revokeFromGroupMethods(cspPath);
		
		revokeFromGroups.revokeFromGroupMethods(orPath);
		
		n1=dao.cloudServerProviderDeleteFromAdminEncrption(userId, userEmail, fileName);
		
	   	System.out.println("Value of n is"+n1);
	   	
	   	n2=dao.cloudServerProviderFromcsp_encrption_table(userId, userEmail, fileName);
	   	
	   	System.out.println("Value of n2 is "+n2);
   		
	    n3=dao.cloudServerProviderUpdatedeleteStatus(userId, userEmail, fileName, status);
	    
	    System.out.println("Value of n is "+n3);
	    
	    rs=dao.cloudServerproviderGetrecordsFromTable();
	    
	    HttpSession session=request.getSession();
	    
	    session.setAttribute("DeleteSessionRecords", rs);
	    
	    RequestDispatcher rd=request.getRequestDispatcher("cloudServerActivatedSuceffuly.jsp");
	    rd.forward(request, response);
	    
	    
		
		
	}

}
