package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.NoteBean;
import DataBase.DBConnection;

public class ViewNoteDAO 
{
	public ArrayList<NoteBean> al=new ArrayList<NoteBean>();
	public ArrayList<NoteBean> retrieve(String uname)
	{
		try
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("SELECT ID,UNAME, TO_CHAR(DATETIME, 'YYYY-MM-DD HH24:MI:SS') AS DATETIME, TITLE, NOTE FROM NoteTable WHERE UNAME=? ORDER BY DATETIME DESC");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				NoteBean nb = new NoteBean();
				nb.setId(rs.getInt(1));
				nb.setUname(rs.getString(2));
				nb.setDatetime(rs.getString(3));
				nb.setTitle(rs.getString(4));
				nb.setNote(rs.getString(5));
				al.add(nb);
			}
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
		return al;
	}
}
