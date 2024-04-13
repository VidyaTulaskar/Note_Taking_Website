package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Bean.NoteBean;
import DataBase.DBConnection;

public class UpdateNoteDAO
{
	public int k = 0;
	public int update(NoteBean nb)
	{
		Connection con = null;
        PreparedStatement ps = null;
		try
		{
			con = DBConnection.getCon();
			ps = con.prepareStatement("update NoteTable set datetime=TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ,title=? ,note=? where id=?");
			ps.setString(1, nb.getDatetime());
			ps.setString(2, nb.getTitle());
			ps.setString(3, nb.getNote());
			ps.setInt(4, nb.getId());
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
