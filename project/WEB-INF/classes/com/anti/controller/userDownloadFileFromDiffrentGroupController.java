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

import com.anti.beans.UserBeans;
import com.anti.beans.userDataFileBeans;
import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;
import com.anti.mail.Mail;

/**
 * Servlet implementation class userDownloadFileFromDiffrentGroupController
 */
@WebServlet("/userDownloadFileFromDiffrentGroupController")
public class userDownloadFileFromDiffrentGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userDownloadFileFromDiffrentGroupController() {
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
		
         Mail mail=new Mail();
         
         int n=1,user_count=1,userCountFinal=0,n1=0;
		
		HttpSession session=request.getSession(),session1=request.getSession();
		
		Dao dao=DaoFactory.getInstance();
		
		ResultSet rs=null,rs1=null;
		
		UserBeans userBeans=new UserBeans();
		
		int userId=Integer.parseInt(request.getParameter("userId"));
		
		String userEmail=request.getParameter("userEmail");
		
		String fileName=request.getParameter("userFileName");
		
		String userGroup=request.getParameter("userGroup");
		
		userBeans = (UserBeans) session.getAttribute("userSessionInfomation");
		
		// logic
		
		rs=dao.userCheckFakeCount(userBeans, fileName, userGroup);
		
		try {
			
			if(rs.next()){
				//id, user_id, user_email, user_name, user_file_name, user_count, user_group
				
				System.out.println("rs have same values");
				
				if(rs.getInt(6)==2){
					
					n1=dao.userInsertFakeInfomation(userBeans, userGroup, fileName);
					
					System.out.println("Value of n is"+n1);
					
					 rs1=dao.userGetDataFromGroup(userBeans);
						
					 session1.setAttribute("groupDataFileSession", rs1);
					
					RequestDispatcher rd=request.getRequestDispatcher("userShowFileFromDiffrentGroupsDataFile.jsp");
					rd.forward(request, response);
					
				}
				
				else
				{
				System.out.println("Table count value is "+rs.getInt(6));
				
				userCountFinal=rs.getInt(6)+1;
				
				System.out.println("userCountFinal is "+userCountFinal);
				
				int up=dao.userUpdateFakeCount(userBeans, fileName, userGroup, userCountFinal);
				
				System.out.println("Value of up is "+up);
				
				 rs1=dao.userGetDataFromGroup(userBeans);
					
				 session1.setAttribute("groupDataFileSession", rs1);
				
				RequestDispatcher rd=request.getRequestDispatcher("userShowFileFromDiffrentGroupsDataFile.jsp");
				rd.forward(request, response);
				
				
				}
				
				
				
				
			}
			
			else
			{
			
				
				
				n=dao.userInsertFakeTable(userBeans, fileName, user_count, userGroup);
				
				rs1=dao.userGetDataFromGroup(userBeans);
				
				 session1.setAttribute("groupDataFileSession", rs1);
				
				RequestDispatcher rd=request.getRequestDispatcher("userShowFileFromDiffrentGroupsDataFile.jsp");
				rd.forward(request, response);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
