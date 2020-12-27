package com.anti.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.anti.beans.UserBeans;
import com.anti.beans.UserFileDataBeans;
import com.anti.dao.Dao;
import com.anti.daoFactory.DaoFactory;
import com.anti.methods.GetFileExtension;
import com.anti.methods.GetFileName;
import com.anti.methods.HideFolder;

/**
 * Servlet implementation class GroupMemberUploadDataController
 */
@MultipartConfig(maxFileSize=1024*1024*50)
@WebServlet("/GroupMemberUploadDataController")
public class GroupMemberUploadDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR="ANTI_COLLUSION" ;
	
	String filepath=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupMemberUploadDataController() {
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
		
		String fileName=null,savePath=null,original_file="original_file",filePath=null,uploadedFile=null,fileStatus="Send_To_Admin",fileExtension=null,newFileName=null,NewfileExtension=null,finalFileName=null;
		
		UserBeans userBeans=new UserBeans();
		
		HttpSession session=request.getSession(),session1=request.getSession(),session2=request.getSession();
		
		Dao dao=DaoFactory.getInstance();
		
		GetFileExtension getFileExtensionObjects=new GetFileExtension();
		
		UserFileDataBeans userFileDataBeans=new UserFileDataBeans();
		
		ResultSet rs=null,rs1=null;
		
		int userId=0;
		
		GetFileName getFileNameObject=new GetFileName();
		
		long EndUploadingTime2=0,startUploadingTime=0,totalUploadingTime=0;
		
		// make folder code
		
	     savePath="C:"+File.separator+SAVE_DIR+File.separator+original_file;
			
		 File orinignalPath=new File(savePath);
			
	      if(!orinignalPath.exists()){
				
		  boolean status = orinignalPath.mkdirs();
				
		  System.out.println("status is "+status);
		  
			}
	      
	    // hide the folder 
	      
	      HideFolder hideFolder=new HideFolder();
	      hideFolder.folderHide(savePath);
	      
	      System.out.println("Hide the ornignial folder");
	      
	      
	      
	      // user Session 
	      
	      userBeans=(UserBeans)session.getAttribute("userSessionInfomation");
	      
	      
			
			Part filePart = request.getPart("userFileData");
			
			System.out.println("filePart is "+filePart);
			
			fileName = extractFileName(filePart);
			
			System.out.println("FileName is .............."+fileName);
			
			
filepath=fileName;
			
			if(check()){
			
			rs1=dao.UserCheckFilePresentOrNot(fileName);
			
			try {
				if(rs1.next()){
					
					//id, user_id, user_email, user_name, user_group, file_name, file_path, file_status, file
				
					System.out.println("have data");

					System.out.println("fileName is " + rs1.getString(6));
					
					userId=rs1.getInt(1);
					
					fileExtension=getFileExtensionObjects.get_name_method(fileName);
					
					System.out.println("File Extension is "+fileExtension);
					
					newFileName=fileExtension+userBeans.getId();
					
					System.out.println("New File Name is "+newFileName);
					
					NewfileExtension=getFileNameObject.get_extension_method(fileName);
					
					finalFileName=newFileName+"."+NewfileExtension;
					
					System.out.println("Final File Name is "+finalFileName);
					
					 userFileDataBeans.setFileName(fileName);
					 
					 userFileDataBeans.setNewFileName(finalFileName);
				
					
					 File fileSaveDir = new File(savePath);
				        
				        filePath=fileSaveDir.getAbsolutePath() +File.separator +finalFileName;
				        
				        filePart.write(filePath);
				                
					    uploadedFile=fileSaveDir+File.separator+finalFileName;
					    
					    userFileDataBeans.setFilePath(uploadedFile);
				        
				        InputStream is = new FileInputStream(uploadedFile);
				        
				        
				        // user session 
				        
				        userBeans=(UserBeans)session.getAttribute("userSessionInfomation");
				        
				        userFileDataBeans.setFileStatus(fileStatus);
				        
				        rs=dao.userCheckFileDetails(userBeans, userFileDataBeans);
				        
				        try {
							if(rs.next()){
								
								System.out.println("Value of rs have some value");
								
								System.out.println("Not insert into Table ");
								
								request.setAttribute("errorMsg", "Sorry ! your File Aready uploaded into Cloud  !!! ");
								
								RequestDispatcher rd=request.getRequestDispatcher("groupMemberFileUpload.jsp");
					        	rd.forward(request, response);
								
								
							}
							
							else
							{
								 int m1=dao.userUploadDetails(userBeans, userFileDataBeans, is);
							        
							        System.out.println("Value of m1 is "+m1);
							        
							        if(m1>0){
							        	
							        	request.setAttribute("sucessMsg", "Thanks! your file sucessfuly Uploaded !!! ");
							        	
							        	// Get the Seconds Time for Uploading Time 
							        	
							        	 EndUploadingTime2=System.currentTimeMillis();
							        	
							        	System.out.println("end Uploading Time is "+EndUploadingTime2);
							        	
							        	session1.setAttribute("EndUploadingTimeSession", EndUploadingTime2);
							        	
							        	startUploadingTime=(Long)session2.getAttribute("startUploadingTimeSession");
							        	
							        	System.out.println("Start Uploading Time is "+startUploadingTime);
							        	
							        	totalUploadingTime=EndUploadingTime2-startUploadingTime;
							        	
							        	System.out.println("Total Uploading Time is "+totalUploadingTime);
							        	
							        	int graph=dao.userInsertUploadingGraph(userFileDataBeans.getFileName(), startUploadingTime, EndUploadingTime2, totalUploadingTime,userBeans.getUser_email());
							        	
							        	System.out.println("Value of graph code is "+graph);
							        	
							        	
							        
							        	
							        	RequestDispatcher rd=request.getRequestDispatcher("groupMemberFileUpload.jsp");
							        	rd.forward(request, response);
							        	
							        	
							        	
							        	
							        }
							}
				        } catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				        
				        
				}
				
				else
				{
					// No Records
					
					System.out.println("FirstPath==="+fileName);
				    
				    userFileDataBeans.setFileName(fileName);
				    
					 userFileDataBeans.setNewFileName(fileName);
				    
			        File fileSaveDir = new File(savePath);
			        
			        filePath=fileSaveDir.getAbsolutePath() +File.separator +fileName;
			        
			        filePart.write(filePath);
			                
				    uploadedFile=fileSaveDir+File.separator+fileName;
				    
				    userFileDataBeans.setFilePath(uploadedFile);
			        
			        InputStream is = new FileInputStream(uploadedFile);
			        
			        
			        // user session 
			        
			        
			        
			        userFileDataBeans.setFileStatus(fileStatus);
			        
			        rs=dao.userCheckFileDetails(userBeans, userFileDataBeans);
			        
			        try {
						if(rs.next()){
							
							System.out.println("Value of rs have some value");
							
							System.out.println("Not insert into Table ");
							
							request.setAttribute("errorMsg", "Sorry ! your File Aready uploaded into Cloud  !!! ");
							
							RequestDispatcher rd=request.getRequestDispatcher("groupMemberFileUpload.jsp");
				        	rd.forward(request, response);
							
							
						}
						
						else
						{
							 int m1=dao.userUploadDetails(userBeans, userFileDataBeans, is);
						        
						        System.out.println("Value of m1 is "+m1);
						        
						        if(m1>0){
						        	
						        	request.setAttribute("sucessMsg", "Thanks! your file sucessfuly Uploaded !!! ");
						        	
						        	// Get the Seconds Time for Uploading Time 
						        	
						        	 EndUploadingTime2=System.currentTimeMillis();
						        	
						        	System.out.println("end Uploading Time is "+EndUploadingTime2);
						        	
						        	session1.setAttribute("EndUploadingTimeSession", EndUploadingTime2);
						        	
						        	startUploadingTime=(Long)session2.getAttribute("startUploadingTimeSession");
						        	
						        	System.out.println("Start Uploading Time is "+startUploadingTime);
						        	
						        	totalUploadingTime=EndUploadingTime2-startUploadingTime;
						        	
						        	System.out.println("Total Uploading Time is "+totalUploadingTime);
						        /*	
						        	int graph=dao.userInsertUploadingGraph(userFileDataBeans.getFileName(), startUploadingTime, EndUploadingTime2, totalUploadingTime,userBeans.getUser_email());
						        	
						        	System.out.println("Value of graph code is "+graph);*/
						        	
						        
						        	
						        	RequestDispatcher rd=request.getRequestDispatcher("groupMemberFileUpload.jsp");
						        	rd.forward(request, response);
						        	
						        	
						        	
						        	
						        }
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        
		    
			}// end of If Methods
	       
			else
			{
				System.out.println("Result is false ");
				
				request.setAttribute("errorMsg1", "Pleases Select .txt and . pdf File and . docx  ");
        	
        	RequestDispatcher rd=request.getRequestDispatcher("groupMemberFileUpload.jsp");
        	rd.forward(request, response);
				
			}  
	}
	
	private String extractFileName(Part part) 
    {
           String contentDisp = part.getHeader("content-disposition");
           System.out.println("contentDisp:"+contentDisp);
           String[] items = contentDisp.split(";");
           for (String s : items) {
           if (s.trim().startsWith("filename")) 
           {
             return s.substring(s.indexOf("=") + 2, s.length()-1);
           }
     }
           
     return "";

}
	

	 public boolean check() 
    {
	  boolean flag=false;
	  
      if(filepath!=null&& filepath!="") 
      {
       if(filepath.endsWith(".txt")||filepath.endsWith(".pdf")||filepath.endsWith(".docx"))
        {
    	   flag= true;
        }
       
      }
       return flag;
    } 
}



