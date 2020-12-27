package com.anti.controller;

import java.io.File;
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
import com.anti.mail.Mail;
import com.anti.methods.Create_User_Group;
import com.anti.methods.DESAlgorithms;
import com.anti.methods.RevokeFromGroups;
import com.anti.methods.file_revoke_methods;

/**
 * Servlet implementation class GetAllocatedGroupToMemberController
 */
@WebServlet("/GetAllocatedGroupToMemberController")
public class GetAllocatedGroupToMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR="ANTI_COLLUSION" ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllocatedGroupToMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// object 
		
	   String tableIdValue=null,userOldGroup=null,userNewGroup=null,userGetNewKey=null,userGetUpdateKey=null,Newfolder="C:"+File.separator+SAVE_DIR+File.separator,NewfolderPath,NewFilePath=null,userEmail=null,user_status="Allocated";
	   
	   int tableId=0,up=1,userId=0,result=0,result1=0;
	   
	   Dao dao=DaoFactory.getInstance();
	   
	   ResultSet rs=null,rs1=null,rs2=null;
	   
	   Mail mail=new Mail();
	   
	   DESAlgorithms desAlgorithmsObject=new DESAlgorithms();
	   
	   Create_User_Group createObject=new Create_User_Group();
	   
	   File f1,f2=null;
	   
	   file_revoke_methods filerevokeObject=new file_revoke_methods();
	   
	   RevokeFromGroups revokeGroupsObject=new RevokeFromGroups();
	   
	   String fileName=null;
	   
		
		// logice
		
	    tableIdValue=request.getParameter("tableIdValue");
		
		System.out.println("table id is "+tableIdValue);
		
		tableId=Integer.parseInt(tableIdValue);
		
		System.out.println("table id is "+tableId);
		
		rs=dao.groupMemberGetViewDetailsGroupMemberRevokeRequest(tableId);
		
		try {
			while(rs.next()){
				
				//id, user_id, user_email, user_name, user_old_group, user_new_group, user_status
				
				userOldGroup=rs.getString(5);
				
				userNewGroup=rs.getString(6);
				
				userId=rs.getInt(2);
				
				userEmail=rs.getString(3);
				
				
				
			}
			
			System.out.println("userOldGroup is =="+userOldGroup);
			
			rs1=dao.groupMemberCheckotherMemberGroup(userOldGroup);
			
			while(rs1.next()){
				
				// have other member to same group
				
				//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status
				
				System.out.println("User Name is "+rs1.getString(4));

				userGetNewKey=rs1.getString(11);
				
				System.out.println("Old Key =="+userGetNewKey);
				
				userGetUpdateKey=desAlgorithmsObject.DESAlgorithmsUpdateKey(userGetNewKey);
				
				System.out.println("userGetUpdateKey New Key  == "+userGetUpdateKey);
				
				up=dao.groupMemberUpdateKeyAfterRevokeUser(rs1.getInt(2), rs1.getString(3),rs1.getString(5), rs1.getString(6), rs1.getString(10), rs1.getString(11), userGetUpdateKey);
				
				System.out.println("Value of up is"+up);
				
				mail.mailSendToUpdateKeyGroupMember(rs1.getString(3), rs1.getString(6), userGetUpdateKey);
				
				System.out.println("mail sends ");
				
				
				
				
				
			} // end of rs1 loops 
			
			
			// switch the group old to new groups 
			
			NewfolderPath=Newfolder+userNewGroup;
			
			result=createObject.checkUserGroups(NewfolderPath);
			
			System.out.println("result is "+result);
			
			rs2=dao.groupMangerGetGroupMemberDetails(userId, userEmail);
			
			while(rs2.next()){
				
				//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status
				
				NewFilePath=NewfolderPath+File.separator+rs2.getString(6)+".aes";
				
				System.out.println("New File Path is "+NewFilePath);
				
				System.out.println("Copy Part are "+rs2.getString(9));
				
				
				fileName=rs2.getString(6);
				
				f2=new File(NewFilePath);
				
				f1=new File(rs2.getString(9));
				
				filerevokeObject.dataRevokeFromGroup(f1, f2);
				
				System.out.println("Copy hua ");
				
				result1=revokeGroupsObject.revokeFromGroupMethods(rs2.getString(9));
				
				System.out.println("Result 111 is "+result1);
							
				
				int up1=dao.groupMangerUpdateGroupUserReg(userId, userEmail, userOldGroup, userNewGroup);
				
				int up2=dao.groupMangerUpdateGroupuser_upload_table(userId, userEmail, userOldGroup, userNewGroup);
				
				int up3=dao.groupMangerUpdateGroupcsp_encrption_table(userId, userEmail, userOldGroup, userNewGroup);
				
				int up4=dao.groupMangerUpdateGroupadmin_encrption_table(userId, userEmail, userOldGroup, userNewGroup);
				
				int up5=dao.groupMangerUpdatePathFromRevoke(userId, userEmail, fileName,NewFilePath);
				
				System.out.println("Value of up1 "+up1+" value of up2"+up2+"value of up3"+up3+"value of up4 "+up4 +"and revoke Upadte is "+up5 );
				
				int update=dao.groupMangerUpdateGroupUser_revoke_group_request(userId, tableId, userEmail, user_status);
				
				System.out.println("update the value is "+update);
				
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

}
