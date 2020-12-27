package com.anti.dao;

import java.io.InputStream;
import java.sql.ResultSet;

import org.apache.catalina.User;

import com.anti.beans.UserBeans;
import com.anti.beans.UserFileDataBeans;
import com.anti.beans.adminBeans;
import com.anti.beans.cloudBeans;
import com.sun.org.apache.regexp.internal.RESyntaxException;

public interface Dao {

	
	// GroupMember 
	
	int groupMemberRegistion(UserBeans userBeans);
	
	ResultSet groupMemberPresentOrNot(UserBeans userBeans);
	
	ResultSet groupMemberLogin(UserBeans userBeans);
	
	int userUpdateUserTime(UserBeans userBeans);
	
	ResultSet userCheckLoginWithOtp(UserBeans userBeans);
	
    int userContactMessage(UserBeans userBeans);
    
    ResultSet userCheckUserStatus(UserBeans userBeans);
    
    ResultSet userCheckUserToken(UserBeans userBeans);
    
    int userChangePassword(UserBeans userBeans);
    
    int userUploadDetails(UserBeans userBeans,UserFileDataBeans userFileDataBeans,InputStream io);
    
    ResultSet userCheckFileDetails(UserBeans userBeans,UserFileDataBeans userFileDataBeans);
    
    ResultSet userViewGroupMemberDetails(UserBeans userBeans);
    
    int userInsertRevokeGroup(UserBeans userBeans,String userGroupStatus);
    
    ResultSet userViewStatusGroupRevoke(UserBeans userBeans,String userGroupStatus);
    
    ResultSet userCheckTokenTime(UserBeans userBeans);
    
    int userUpdateTokenTime(UserBeans userBeans);
    
    ResultSet userGetDataFromGroup(UserBeans userBeans);
    
    ResultSet userGetDataFromGroupDownload(int userId,String userGroup,String fileName,String userEmail);
    
    int userInsertFakeTable(UserBeans userBeans,String  user_file_name, int user_count,String  user_group);
    
    ResultSet userCheckFakeCount(UserBeans userBeans,String  user_file_name,String  user_group);
    
	int userUpdateFakeCount(UserBeans userBeans,String  user_file_name,String  user_group,int count);
	
	int userInsertFakeInfomation(UserBeans userBeans,String userGroup,String fileName);
	
	ResultSet UserCheckFilePresentOrNot(String fileName);
	
	ResultSet userGetFileFromParticulareGroup(UserBeans userBeans);
	
	ResultSet userGetDeletefromTable(int tableId);
	
	int userInsertDeletRequest(int user_id, String user_email,String  user_name,String file_name,String  status);
	
    int userInsertUploadingGraph(String fileName,long startTime,long endTime,long totalTime,String userEmail);
    
    int userInsertDowloadingGraph(String fileName,long startTime,long endTime,long totalTime,String userEmail);
    
	// GroupManger
	
	ResultSet groupMangerLogin(adminBeans adminBeans);
	
    ResultSet groupMangerActivateMember();
    
    ResultSet groupMangerActivateMemberParticulare(int userId);
    
    int groupMangerInsertTokenDetails(UserBeans userBeans);
    
    int groupMangerUpdateUserStatus(UserBeans userBeans);
    
    ResultSet groupMangerGetUserDeatils();
    
    ResultSet groupMangerGetFileDetails(String status);
    
    ResultSet groupMangerGetFileParticulareDetails(int tableId);
    
    int groupMangerInsertFileEncption(UserBeans userBeans,UserFileDataBeans userFileDataBeans);
    
    int groupMangerUpdateMemberFileStatus(UserBeans userBeans,int tableId,String fileStatusNew);
    
    ResultSet groupMemberGetViewRevokeRequest(String userGroupStatus);
    
    ResultSet groupMemberGetViewDetailsGroupMemberRevokeRequest(int tableId);
    
    ResultSet groupMemberCheckotherMemberGroup(String userOldGroup);
    
    int groupMemberUpdateKeyAfterRevokeUser(int userId,String userEmail,String user_group, String file_name,String file_old_key,String  file_new_key,String userUpdateKey);
    
    ResultSet groupMangerGetGroupMemberDetails(int userId,String userEmail);
    
    int groupMangerUpdateGroupUserReg(int userId,String userEmail,String userOldGroup,String userNewGroup);
    
    int groupMangerUpdateGroupuser_upload_table(int userId,String userEmail,String userOldGroup,String userNewGroup);
    
    int groupMangerUpdateGroupcsp_encrption_table(int userId,String userEmail,String userOldGroup,String userNewGroup);
    
    int groupMangerUpdateGroupadmin_encrption_table(int userId,String userEmail,String userOldGroup,String userNewGroup); 
    
    int groupMangerUpdateGroupUser_revoke_group_request(int user_id,int tableId,String  user_email,String user_status);
    
    ResultSet groupMangerCheckFakeUser();
    
    ResultSet userGetFakeDetails(int id);
    
    int groupMangerGetDeleteFromUserReg(int userId);
    
    int groupMangerDeleleFromFaketable(int userId);
    
    ResultSet groupMangerGetFileNameUploading();
    
    ResultSet groupMangerGetFileNameDownlaoding();
    
    ResultSet groupMangerGetGraph(String fileName);
    
    ResultSet groupMangerGetGraphDownlding(String fileName);
    
    int groupMangerUpdatePathFromRevoke(int userId, String userEmail,String fileName,String NewFilePath);
    
    // cloud Service Provider 
    
    ResultSet cloudServiceProviderLogin(cloudBeans cloudBeans);
    
    ResultSet cloudServerProviderViewFileDetails();
    
    ResultSet cloudServerProviderViewFileParticulareDetails(int tableId);
     int cloudServerProviderInsertEncrptionFileDetails(UserBeans userBeans,UserFileDataBeans userFileDataBeans,String encrptionFinalPath,String finalStatus,String fileNewKey);
    
    int cloudServerProviderUpdateUserUploadStatus(UserBeans userBeans, UserFileDataBeans userFileDataBeans,String finalStatus);
    
    int cloudServerproviderUpdateAdminUploadStatus(UserBeans userBeans, UserFileDataBeans userFileDataBeans,String finalStatus);
    
    ResultSet cloudServerProviderGetFileDelete(String status);
    
    ResultSet cloudServerProviderGetUserDetails(int tableId);
    
    int cloudServerProviderDeleteFromAdminEncrption(int userId,String userEmail,String fileName);
    
    int cloudServerProviderFromcsp_encrption_table(int userId,String userEmail,String fileName);
    
    int cloudServerProviderUpdatedeleteStatus(int userId,String userEmail,String fileName,String status);
    
    ResultSet cloudServerproviderGetrecordsFromTable();
    
    ResultSet cloudServerGetPathFromAdminEncrption(int userId,String userEmail,String fileName);
    
    ResultSet cloudServerGetPathFromcsp_encrption_table(int userId,String userEmail,String fileName);
    
    
	
	
	
	
}
