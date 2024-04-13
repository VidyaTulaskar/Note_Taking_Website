package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Bean.UserBean;
import DataBase.DBConnection;

public class LoginDAO 
{
	public UserBean ub = null;
	public UserBean login(String uName, String pWord)
	{	
		try 
		{
			Connection con = DBConnection.getCon();
			//System.out.println(con);
			PreparedStatement ps = con.prepareStatement("Select * from NoteUser where uname=? and pword=?");
			
			ps.setString(1, uName);
			ps.setString(2, pWord);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				ub = new UserBean();
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setmId(rs.getString(6));
				ub.setPhNo(rs.getLong(7));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ub;
	}
}
