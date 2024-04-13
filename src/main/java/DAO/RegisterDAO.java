package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Bean.UserBean;
import DataBase.DBConnection;

public class RegisterDAO 
{
	public int k=0;
	public int register(UserBean ub)
	{
		Connection con = null;
        PreparedStatement ps = null;
		try
		{
			con = DBConnection.getCon();
			ps = con.prepareStatement("insert into NoteUser values(?,?,?,?,?,?,?)");
			
			ps.setString(1, ub.getuName());
			ps.setString(2, ub.getpWord());
			ps.setString(3, ub.getfName());
			ps.setString(4, ub.getlName());
			ps.setString(5, ub.getAddr());
			ps.setString(6, ub.getmId());
			ps.setLong(7, ub.getPhNo());
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}/*finally {
            // Close PreparedStatement
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Close Connection
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/
		return k;
	}
}
