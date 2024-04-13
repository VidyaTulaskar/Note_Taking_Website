package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Bean.NoteBean;
import DataBase.DBConnection;

public class DeleteNoteDAO 
{
	public int k = 0;
	public int delete(NoteBean nb)
	{
		Connection con = null;
        PreparedStatement ps = null;
		try
		{
			con = DBConnection.getCon();
			ps = con.prepareStatement("delete from NoteTable where id=?");
			ps.setInt(1, nb.getId());
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
