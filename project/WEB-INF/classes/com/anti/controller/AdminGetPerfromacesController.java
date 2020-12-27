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
 * Servlet implementation class AdminGetPerfromacesController
 */
@WebServlet("/AdminGetPerfromacesController")
public class AdminGetPerfromacesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetPerfromacesController() {
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
		
		String adminType=request.getParameter("adminType");
		
		System.out.println("adminType is "+adminType);
		
		if(adminType.equals("downloading"))
		{
			System.out.println("downloding ");
			
			rs=dao.groupMangerGetFileNameDownlaoding();
			
			session.setAttribute("adminDownloadingGraphResultSession", rs);
			
			RequestDispatcher rd=request.getRequestDispatcher("FileNameForGraphForDownloading.jsp");
			rd.forward(request, response);
			
			
			/*RequestDispatcher rd=request.getRequestDispatcher("groupMangerDownloadingGraph.jsp");
			rd.forward(request, response);
					*/
			
		}
		
		else
		{
			if(adminType.equals("uploading"))
			{
				
				System.out.println("uploading");
				
				
				
				
				
			     rs=dao.groupMangerGetFileNameUploading();
			


				session.setAttribute("adminUploadingGraphResultSession", rs);
				
				RequestDispatcher rd=request.getRequestDispatcher("FileNameForGraph.jsp");
				rd.forward(request, response);
				
			
						
				
				
			}
			
		}
		
		
		
	}

}
