package com.anti.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.anti.beans.UserBeans;
import com.anti.beans.UserFileDataBeans;
import com.anti.beans.adminBeans;
import com.anti.beans.cloudBeans;
import com.anti.connectionManger.ConnectionManger;

public class DaoImpl implements Dao {
	
	Connection con=ConnectionManger.getConnection();

	@Override
	public int groupMemberRegistion(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		int n=1;
		
		///id, user_name, user_email, user_password, user_contact, user_group, user_status
		
		String sql="insert into user_reg value(?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setString(2, userBeans.getUser_name());
			
			ps.setString(3, userBeans.getUser_email());
			
			ps.setString(4, userBeans.getUser_password());
			
			ps.setString(5, userBeans.getUser_contact());
			
			ps.setString(6, userBeans.getUser_group());
			
			ps.setString(7, userBeans.getUser_otp());
			
			ps.setInt(8, userBeans.getId());
			
			ps.setString(9, userBeans.getUser_status());
			
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return n;
	}

	@Override
	public ResultSet groupMemberPresentOrNot(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		//id, user_name, user_email, user_password, user_contact, user_group, user_otp, user_time
		
		ResultSet rs=null;
		
		System.out.println("In Methods  ....");
		
		String sql="Select * from user_reg where user_email=?";
		
		System.out.println("userEmail is "+userBeans.getUser_email());
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, userBeans.getUser_email());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rs;
	}

	@Override
	public ResultSet groupMemberLogin(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		//id, user_name, user_email, user_password, user_contact, user_group, user_otp, user_time
		
		String sql="Select * from user_reg where user_name=? or  user_email=? and  user_password=?  ";
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, userBeans.getUser_email());
			
			ps.setString(2, userBeans.getUser_email());
			
			ps.setString(3, userBeans.getUser_password());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
	}

	@Override
	public int userUpdateUserTime(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		int n=1;
		
		String sql="update user_reg set user_time=1 where  user_email=? and  user_password=?  ";
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, userBeans.getUser_email());
			
			ps.setString(2, userBeans.getUser_password());
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
		return n;
	}

	@Override
	public ResultSet userCheckLoginWithOtp(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from user_reg where user_email=? and user_password=? and user_otp=?";
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, userBeans.getUser_email());
			
			ps.setString(2, userBeans.getUser_password());
			
			ps.setString(3, userBeans.getUser_otp());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public ResultSet groupMangerLogin(adminBeans adminBeans) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from admin_reg where admin_name=? and admin_password=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, adminBeans.getAdmin_name());
			
			ps.setString(2, adminBeans.getAdmin_Password());
			
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
	}

	@Override
	public int userContactMessage(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		int n=1;
		
		//id, user_fname, user_email, user_message
		
		String sql="insert into user_contact values(?,?,?,?)";
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setString(2, userBeans.getUser_name());

			ps.setString(3, userBeans.getUser_email());
			
			ps.setString(4, userBeans.getUser_Message());
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return n;
	}

	@Override
	public ResultSet groupMangerActivateMember() {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from user_reg";
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public ResultSet groupMangerActivateMemberParticulare(int userId) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from user_reg where id=?";
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
		   rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
	}

	@Override
	public int groupMangerInsertTokenDetails(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		int n=0;
		
		//id, user_id, user_email, user_name, user_token
		
		String sql="insert into admin_user_token values(?,?,?,?,?,?)";
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setInt(2, userBeans.getId());
			
			ps.setString(3, userBeans.getUser_email());
			
			ps.setString(4, userBeans.getUser_name());
			
			ps.setString(5, userBeans.getUser_token());
			
			ps.setInt(6, 1);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return n;
	}

	@Override
	public int groupMangerUpdateUserStatus(UserBeans userBeans) {
		// TODO Auto-generated method stub
		int n=1;
		
		//id, user_name, user_email, user_password, user_contact, user_group, user_otp, user_time, user_status
		
		String sql="update user_reg set user_status=? where  user_email=? and id=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userBeans.getUser_status());
			
			ps.setString(2, userBeans.getUser_email());
			
			ps.setInt(3, userBeans.getId());
			
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public ResultSet userCheckUserStatus(UserBeans userBeans) {
		// TODO Auto-generated method stub
		// id, user_name, user_email, user_password, user_contact, user_group, user_otp, user_time, user_status
		
		ResultSet rs=null;
		String sql="Select * from user_reg where user_status=? and user_email=? and id=?";
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, "Activated");
			
			ps.setString(2, userBeans.getUser_email());
			
			ps.setInt(3, userBeans.getId());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rs;
	}

	@Override
	public ResultSet userCheckUserToken(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from admin_user_token where user_id=? and user_email=? and user_name=? and user_token=?";
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			System.out.println("userId is "+userBeans.getId());
			
			System.out.println("userEmail is "+userBeans.getUser_email());
			
			System.out.println("userName is "+userBeans.getUser_name());
			
			System.out.println("userToken is "+userBeans.getUser_token());
			
			ps.setInt(1, userBeans.getId());
			
			ps.setString(2, userBeans.getUser_email());
			
			ps.setString(3, userBeans.getUser_name());
			
			ps.setString(4, userBeans.getUser_token());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public ResultSet cloudServiceProviderLogin(cloudBeans cloudBeans) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		//id, cloud_name, cloud_password
		
		String sql="Select * from cloud_service_reg  where  cloud_name=? and  cloud_password=?";
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, cloudBeans.getCloud_name());
			
			ps.setString(2, cloudBeans.getCloud_password());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public int userChangePassword(UserBeans userBeans) {
		// TODO Auto-generated method stub
		int n=1;
		//id, user_name, user_email, user_password, user_contact, user_group, user_otp, user_time, user_status
		
		String sql="update user_reg set  user_password=? where user_email=? and user_password=? ";
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, userBeans.getUser_new_password());
			
			ps.setString(2, userBeans.getUser_email());
			
			ps.setString(3, userBeans.getUser_password());
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return n;
	}

	@Override
	public int userUploadDetails(UserBeans userBeans,
			UserFileDataBeans userFileDataBeans, InputStream io) {	
		// TODO Auto-generated method stub
		
//id, user_id, user_email, user_name, user_group, file_name, file_path, file_status, file, new_file_name
		
		int n=1;
		
		String sql="insert into user_upload_table values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setInt(2, userBeans.getId());		
			
			ps.setString(3,userBeans.getUser_email() );
			
			ps.setString(4,userBeans.getUser_name() );
			
			ps.setString(5,userBeans.getUser_group() );
			
			ps.setString(6, userFileDataBeans.getFileName());
			
			ps.setString(7, userFileDataBeans.getFilePath());
			
			ps.setString(8, userFileDataBeans.getFileStatus());
			
			ps.setBlob(9, io);
			
			ps.setString(10, userFileDataBeans.getNewFileName());
			
			n=ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return n;
	}

	@Override
	public ResultSet groupMangerGetUserDeatils() {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="select * from user_reg";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return rs;
	}

	@Override
	public ResultSet userCheckFileDetails(UserBeans userBeans,
			UserFileDataBeans userFileDataBeans) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, user_group, file_name, file_path, file_status, file
		
		ResultSet rs=null;
		
		String sql="Select * from user_upload_table where user_id=? and  user_email=? and user_name=? and  user_group=?  and file_name=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userBeans.getId());
			
			ps.setString(2, userBeans.getUser_email());
			
			ps.setString(3, userBeans.getUser_name());
			
			ps.setString(4, userBeans.getUser_group());

			ps.setString(5, userFileDataBeans.getFileName());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public ResultSet groupMangerGetFileDetails(String status ) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, user_group, file_name, file_path, file_status, file
		
		ResultSet rs=null;
		
		String sql="select * from user_upload_table where  file_status=? ";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, status);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public ResultSet groupMangerGetFileParticulareDetails(int tableId) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, user_group, file_name, file_path, file_status, file
		
		ResultSet rs=null;
		
       String sql="select * from user_upload_table where id=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, tableId);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public int groupMangerInsertFileEncption(UserBeans userBeans,
			UserFileDataBeans userFileDataBeans) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, file_name, file_path, file_encrption_path, file_key, file_status, user_group
		
		int n=1;
		
		String sql="insert into admin_encrption_table values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setInt(2, userBeans.getId());
			
			ps.setString(3, userBeans.getUser_email());
			
			ps.setString(4, userBeans.getUser_name());
			
			ps.setString(5, userFileDataBeans.getFileName());
			
			ps.setString(6, userFileDataBeans.getFilePath());
			
			ps.setString(7, userFileDataBeans.getFileEncrptionPath());
			
			ps.setString(8, userFileDataBeans.getFileKey());
			
			ps.setString(9, userFileDataBeans.getFileStatus());
														
			ps.setString(10, userBeans.getUser_group());
			
			ps.setString(11, userFileDataBeans.getNewFileName());
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return n;
	}

	@Override
	public int groupMangerUpdateMemberFileStatus(UserBeans userBeans,
			int tableId,String fileStatusNew) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, user_group, file_name, file_path, file_status, file
		
		int n=1;
		
		String sql="update user_upload_table set file_status=? where id= ? and user_id=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, fileStatusNew);
			
			ps.setInt(2, tableId);
			
			ps.setInt(3, userBeans.getId());
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet cloudServerProviderViewFileDetails() {
		// TODO Auto-generated method stub
ResultSet rs=null;
		
		String sql="select * from admin_encrption_table";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public ResultSet cloudServerProviderViewFileParticulareDetails(int tableId) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from admin_encrption_table where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, tableId);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public int cloudServerProviderInsertEncrptionFileDetails(
			UserBeans userBeans, UserFileDataBeans userFileDataBeans,
			String encrptionFinalPath, String finalStatus,String fileNewKey) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status
		
		int n=1;
		
		String sql="insert into csp_encrption_table value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setInt(2, userBeans.getId());
			
			ps.setString(3, userBeans.getUser_email());
			
			ps.setString(4, userBeans.getUser_name());
			
			ps.setString(5, userBeans.getUser_group());
			
			ps.setString(6, userFileDataBeans.getFileName());
			
			ps.setString(7, userFileDataBeans.getFilePath());
			
			ps.setString(8, userFileDataBeans.getFileEncrptionPath());
			
			
			ps.setString(9, encrptionFinalPath);
			
			ps.setString(10, userFileDataBeans.getFileKey());
			
			ps.setString(11, fileNewKey);
			
			ps.setString(12, finalStatus);
			
			ps.setString(13, userFileDataBeans.getNewFileName());
			
			n=ps.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int cloudServerProviderUpdateUserUploadStatus(UserBeans userBeans,
			UserFileDataBeans userFileDataBeans, String finalStatus) {
		//id, user_id, user_email, user_name, user_group, file_name, file_path, file_status, file
		
	      int n=1;
		
		String sql="update user_upload_table set file_status=?  where user_id=? and user_email=?  and user_name=? and file_name=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, finalStatus);
			
			
			ps.setInt(2, userBeans.getId());
			
			ps.setString(3, userBeans.getUser_email());
			
			ps.setString(4, userBeans.getUser_name());
			
			ps.setString(5, userFileDataBeans.getFileName());
			
			n=ps.executeUpdate();
			
			
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int cloudServerproviderUpdateAdminUploadStatus(UserBeans userBeans,
			UserFileDataBeans userFileDataBeans, String finalStatus) {
		
		//id, user_id, user_email, user_name, file_name, file_path, file_encrption_path, file_key, file_status, user_group	
		
		 int n=1;
			
			String sql="update admin_encrption_table set file_status=? where  user_id=? and user_email=?  and user_name=? and file_name=? ";
			
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setString(1, finalStatus);
				
				
				ps.setInt(2, userBeans.getId());
				
				ps.setString(3, userBeans.getUser_email());
				
				ps.setString(4, userBeans.getUser_name());
				
				ps.setString(5, userFileDataBeans.getFileName());
				
				n=ps.executeUpdate();
				
				
				
				n=ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return n;
		
		
	}

	@Override
	public ResultSet userViewGroupMemberDetails(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		//id, user_name, user_email, user_password, user_contact, user_group, user_otp, user_time, user_status
		
	ResultSet rs=null;
	
	String sql="select * from user_reg where id!=?  ";
	
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, userBeans.getId());
		
		rs=ps.executeQuery();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		
		return rs;
	}

	@Override
	public int userInsertRevokeGroup(UserBeans userBeans, String userGroupStatus) {
		// TODO Auto-generated method stub
		
		int n=1;
		
		//id, user_id, user_email, user_name, user_old_group, user_new_group, user_status
		
		String sql="insert into user_revoke_group_request values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setInt(2, userBeans.getId());
			
			ps.setString(3, userBeans.getUser_email());
			
			ps.setString(4, userBeans.getUser_name());
			
			ps.setString(5, userBeans.getUser_group());
			
			ps.setString(6, userBeans.getUser_new_group());
			
			ps.setString(7, userGroupStatus);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet userViewStatusGroupRevoke(UserBeans userBeans,String userGroupStatus) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from user_revoke_group_request where user_id=? and  user_email=? and user_status=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userBeans.getId());
			
			ps.setString(2, userBeans.getUser_email());
			
			ps.setString(3, userGroupStatus);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public ResultSet groupMemberGetViewRevokeRequest(String userGroupStatus) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from user_revoke_group_request where user_status=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, userGroupStatus);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public ResultSet groupMemberGetViewDetailsGroupMemberRevokeRequest(
			int tableId) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="select * from user_revoke_group_request where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, tableId);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public ResultSet groupMemberCheckotherMemberGroup(String userOldGroup) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status
		
		ResultSet rs=null;
		
		String sql="select * from csp_encrption_table where user_group=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, userOldGroup);
			
			rs=ps.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public int groupMemberUpdateKeyAfterRevokeUser(int userId,
			String userEmail, String user_group, String file_name,
			String file_old_key, String file_new_key,String userUpdateKey) {
		// TODO Auto-generated method stub
		
		////id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status
		
		int n=1;
		
		String sql="update csp_encrption_table set file_new_key=? where user_id=? and  user_email=?  and  user_group=? and file_name =? and file_old_key=? and  file_new_key=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, userUpdateKey);
			
			ps.setInt(2, userId);
			
			ps.setString(3, userEmail);
						
			ps.setString(4, user_group);
			
			ps.setString(5, file_name);
			
			ps.setString(6, file_old_key);
			
			ps.setString(7, file_new_key);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet groupMangerGetGroupMemberDetails(int userId,
			String userEmail) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		////id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status
		
		String sql="Select * from csp_encrption_table where user_id=? and  user_email=?  ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			ps.setString(2, userEmail);
			
	        rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
	}

	@Override
	public int groupMangerUpdateGroupUserReg(int userId, String userEmail,String userOldGroup,String userNewGroup) {
		// TODO Auto-generated method stub
		
		int n=1;
		
		//id, user_name, user_email, user_password, user_contact, user_group, user_otp, user_time, user_status
		
		String sql="update user_reg set user_group=? where id=? and user_email=?  and user_group=?  ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, userNewGroup);
			
			ps.setInt(2, userId);
			
			ps.setString(3, userEmail);
			
			ps.setString(4, userOldGroup);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int groupMangerUpdateGroupuser_upload_table(int userId,
			String userEmail, String userOldGroup, String userNewGroup) {
          int n=1;
		
         // id, user_id, user_email, user_name, user_group, file_name, file_path, file_status, file
		
		String sql="update user_upload_table set user_group=? where user_id=? and user_email=?  and user_group=?  ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, userNewGroup);
			
			ps.setInt(2, userId);
			
			ps.setString(3, userEmail);
			
			ps.setString(4, userOldGroup);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int groupMangerUpdateGroupcsp_encrption_table(int userId,
			String userEmail, String userOldGroup, String userNewGroup) {

		int n=1;
		
		//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status
		
		String sql="update csp_encrption_table set user_group=? where user_id=? and user_email=?  and user_group=?  ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, userNewGroup);
			
			ps.setInt(2, userId);
			
			ps.setString(3, userEmail);
			
			ps.setString(4, userOldGroup);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int groupMangerUpdateGroupadmin_encrption_table(int userId,
			String userEmail, String userOldGroup, String userNewGroup) {
		
        int n=1;
		
		//id, user_id, user_email, user_name, file_name, file_path, file_encrption_path, file_key, file_status, user_group
       
		
		String sql="update admin_encrption_table set user_group=? where user_id=? and user_email=?  and user_group=?  ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, userNewGroup);
			
			ps.setInt(2, userId);
			
			ps.setString(3, userEmail);
			
			ps.setString(4, userOldGroup);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int groupMangerUpdateGroupUser_revoke_group_request(int user_id,int tableId,
			String user_email, String user_status) {
		// TODO Auto-generated method stub
		
		int n = 1;

		// id, user_id, user_email, user_name, user_old_group, user_new_group,
		// user_status

		String sql = "update user_revoke_group_request set  user_status=? where id=? and user_id=? and  user_email=? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user_status);

			ps.setInt(2, tableId);

			ps.setInt(3, user_id);

			ps.setString(4, user_email);

			n = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet userCheckTokenTime(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		//id, user_id, user_email, user_name, user_token, user_time
		
		String sql="select * from admin_user_token where user_id=? and  user_email=?  ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userBeans.getId());
			
			ps.setString(2, userBeans.getUser_email());
			
			rs=ps.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public int userUpdateTokenTime(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, user_token, user_time
		
		int n=1;
		
		String sql="update admin_user_token set user_time=?  where user_id=? and  user_email=? ";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, 10);
			
			ps.setInt(2, userBeans.getId());
			
			ps.setString(3, userBeans.getUser_email());
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet userGetDataFromGroup(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status
		
		String sql="Select * from csp_encrption_table where user_group=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, userBeans.getUser_new_group());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rs;
	}

	@Override
	public ResultSet userGetDataFromGroupDownload(int userId, String userGroup,
			String fileName,String userEmail) {
           ResultSet rs=null;
		
		//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status
		
		String sql="Select * from csp_encrption_table where id=? and  user_email=? and  file_name=? and  user_group=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			ps.setString(2, userEmail);
			
			ps.setString(3, fileName);
			
			ps.setString(4, userGroup);
			
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}

	@Override
	public int userInsertFakeTable(UserBeans userBeans, String user_file_name,
			int user_count, String user_group) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, user_file_name, user_count, user_group
		
		int n=1;
		
		String sql="Insert into user_fake_details values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setInt(2, userBeans.getId());
			
			ps.setString(3, userBeans.getUser_email());
			
			ps.setString(4, userBeans.getUser_name());
			
			ps.setString(5, user_file_name);
			
			ps.setInt(6, user_count);
			
			ps.setString(7, user_group);
			
			
			n=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet userCheckFakeCount(UserBeans userBeans,
			String user_file_name, String user_group) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from user_fake_details where user_id=? and user_email=? and  user_name=? and  user_file_name=? and    user_group=?  ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			
            ps.setInt(1, userBeans.getId());
			
			ps.setString(2, userBeans.getUser_email());
			
			ps.setString(3, userBeans.getUser_name());
			
			ps.setString(4, user_file_name);
			
			ps.setString(5, user_group);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public int userUpdateFakeCount(UserBeans userBeans, String user_file_name,
			String user_group, int count) {
		// TODO Auto-generated method stub
		
		int n=1;
		
		////id, user_id, user_email, user_name, user_file_name, user_count, user_group
		
		String sql="Update  user_fake_details set  user_count =? where  user_id=? and user_email=? and  user_name=? and  user_file_name=? and    user_group=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, count);
			
			 ps.setInt(2, userBeans.getId());
				
			ps.setString(3, userBeans.getUser_email());
				
			ps.setString(4, userBeans.getUser_name());
				
			ps.setString(5, user_file_name);
				
			ps.setString(6, user_group);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	        
		
		return n;
	}

	@Override
	public int userInsertFakeInfomation(UserBeans userBeans, String userGroup,String fileName) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, user_group, user_fake_group, user_file_name
		
		int n1=0;
		
		String sql="Insert into admin_view_fake values(?,?,?,?,?,?,?)";
		
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setInt(2, userBeans.getId());
			
			ps.setString(3, userBeans.getUser_email());
				
			ps.setString(4, userBeans.getUser_name());
			
			ps.setString(5, userBeans.getUser_group());
			
			ps.setString(6, userGroup);
			
			ps.setString(7, fileName);
			
			n1=ps.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return n1;
	}

	@Override
	public ResultSet groupMangerCheckFakeUser() {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from admin_view_fake";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public ResultSet userGetFakeDetails(int id) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, user_group, user_fake_group, user_file_name
		
		ResultSet rs=null;
		
		String sql="select * from admin_view_fake where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public int groupMangerGetDeleteFromUserReg(int userId) {
		// TODO Auto-generated method stub
		
		int n=0;
		
		String sql="delete from user_reg where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			n=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int groupMangerDeleleFromFaketable(int userId) {
int n=0;
		
		String sql="delete from admin_view_fake where user_id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			n=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet UserCheckFilePresentOrNot(String fileName) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, user_group, file_name, file_path, file_status, file
		
		ResultSet rs=null;
		
		String sql="Select * from user_upload_table where file_name=?";
		
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, fileName);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public ResultSet userGetFileFromParticulareGroup(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status, new_fileName
		
		
		ResultSet rs=null;
		
		String sql="select * from csp_encrption_table where user_id=? and  user_email=? and  user_name=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userBeans.getId());
			
			ps.setString(2, userBeans.getUser_email());
			
			ps.setString(3, userBeans.getUser_name());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rs;
	}

	@Override
	public ResultSet userGetDeletefromTable(int tableId) {
		// TODO Auto-generated method stub
		
		ResultSet  rs=null;
		
		String sql="Select * from  csp_encrption_table where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, tableId);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public int userInsertDeletRequest(int user_id, String user_email,
			String user_name, String file_name, String status) {
		// TODO Auto-generated method stub
		//id, user_id, user_email, user_name, file_name, status
		
		int n=1;
		
		String sql="Insert into delete_table_request values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
		ps.setInt(1, 0);
		
		ps.setInt(2, user_id);
		
		ps.setString(3, user_email);
		
		ps.setString(4, user_name);
		
		ps.setString(5, file_name);
		
		ps.setString(6, status);
		
		n=ps.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet cloudServerProviderGetFileDelete(String status) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from delete_table_request where status=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, status);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return rs;
	}

	@Override
	public ResultSet cloudServerProviderGetUserDetails(int tableId) {
		
		////id, user_id, user_email, user_name, file_name, status
	ResultSet rs=null;
		
		String sql="Select * from delete_table_request where id=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, tableId);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return rs;
	}

	@Override
	public int cloudServerProviderDeleteFromAdminEncrption(int userId,
			String userEmail, String fileName) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, file_name, file_path, file_encrption_path, file_key, file_status, user_group, new_fileName
		
		int n=1;
		
		String sql="delete from admin_encrption_table where  user_id=? and  user_email=? and  file_name=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			ps.setString(2, userEmail);
			
			ps.setString(3, fileName);
			
			System.out.println("userId is "+userId);
			
			System.out.println("userEmail is "+userEmail);
			
					
			System.out.println("file_name is "+fileName);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int cloudServerProviderFromcsp_encrption_table(int userId,
			String userEmail, String fileName) {
		
		//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status, new_fileName
         int n=1;
		
		String sql="delete from csp_encrption_table where  user_id=? and  user_email=? and  file_name=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			ps.setString(2, userEmail);
			
			ps.setString(3, fileName);
			
            System.out.println("userId is  CSP"+userId);
			
			System.out.println("userEmail is CSP  "+userEmail);
			
					
			System.out.println("file_name is CSP  "+fileName);
			
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int cloudServerProviderUpdatedeleteStatus(int userId,
			String userEmail, String fileName, String status) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, file_name, status
		
		int n=0;
		
		String sql="update delete_table_request set status=? where user_id=? and  user_email=? and  file_name=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, status);
			
           ps.setInt(2, userId);
			
			ps.setString(3, userEmail);
			
			ps.setString(4, fileName);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet cloudServerproviderGetrecordsFromTable() {
		
		
ResultSet rs=null;
		
		String sql="Select * from delete_table_request";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
								
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return rs;
	}

	@Override
	public ResultSet cloudServerGetPathFromAdminEncrption(int userId,
			String userEmail, String fileName) {
ResultSet rs=null;
		
		String sql="Select * from admin_encrption_table where user_id=? and  user_email=? and  file_name=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
           ps.setInt(1, userId);
			
			ps.setString(2, userEmail);
			
			ps.setString(3, fileName);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return rs;
	}

	@Override
	public ResultSet cloudServerGetPathFromcsp_encrption_table(int userId,
			String userEmail, String fileName) {
         ResultSet rs=null;
		
		String sql="Select * from csp_encrption_table where user_id=? and  user_email=? and  file_name=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
           ps.setInt(1, userId);
			
			ps.setString(2, userEmail);
			
			ps.setString(3, fileName);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return rs;
	}

	@Override
	public int userInsertUploadingGraph(String fileName, long startTime,
			long endTime, long totalTime,String userEmail) {
		// TODO Auto-generated method stub
		
		
		//id, fileName, startTime, endTime, totalTime
		
		int n=1;
		
		String sql="Insert into user_uploading_graph values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
		ps.setInt(1, 0);
		
		
		
		ps.setString(2, fileName);
		
		ps.setLong(3, startTime);
		
		ps.setLong(4, endTime);
		
		ps.setLong(5, totalTime);
		
		ps.setString(6, userEmail);
		
		
		
		
		
		n=ps.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet groupMangerGetFileNameUploading() {
		  ResultSet rs=null;
			
			String sql="Select * from user_uploading_graph";
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				
	          
				
				rs=ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
			return rs;
	}

	@Override
	public int userInsertDowloadingGraph(String fileName, long startTime,
			long endTime, long totalTime, String userEmail) {
		// TODO Auto-generated method stub
		
		//user_downloading_graph
		
		//id, fileName, startTime, endTime, totalTime
		
				int n=1;
				
				String sql="Insert into user_downloading_graph values(?,?,?,?,?,?)";
				
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					
				ps.setInt(1, 0);
				
				
				
				ps.setString(2, fileName);
				
				ps.setLong(3, startTime);
				
				ps.setLong(4, endTime);
				
				ps.setLong(5, totalTime);
				
				ps.setString(6, userEmail);
				
				
				
				
				
				n=ps.executeUpdate();	
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				return n;
		
	}

	@Override
	public ResultSet groupMangerGetFileNameDownlaoding() {
		 ResultSet rs=null;
			
			String sql="Select * from user_downloading_graph";
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				
	          
				
				rs=ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
			return rs;
	}

	@Override
	public ResultSet groupMangerGetGraph(String fileName) {
		 ResultSet rs=null;
		 
		 //id, fileName, startTime, endTime, totalTime, userEmail
			
			String sql="Select * from user_uploading_graph where fileName=?";
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				
	          ps.setString(1, fileName);
				
				rs=ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
			return rs;
	}

	@Override
	public ResultSet groupMangerGetGraphDownlding(String fileName) {
 ResultSet rs=null;
		 
		 //id, fileName, startTime, endTime, totalTime, userEmail
			
			String sql="Select * from user_downloading_graph where fileName=?";
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				
	          ps.setString(1, fileName);
				
				rs=ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
			return rs;
	}

	@Override
	public int groupMangerUpdatePathFromRevoke(int userId, String userEmail,
			String fileName, String NewFilePath) {
int n=0;
		
//id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status, new_fileName

		String sql="update csp_encrption_table set file_enc_final_path=? where user_id=? and  user_email=? and  file_name=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, NewFilePath);
			
           ps.setInt(2, userId);
			
			ps.setString(3, userEmail);
			
			ps.setString(4, fileName);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

}
