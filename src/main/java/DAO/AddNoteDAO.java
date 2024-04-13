package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Bean.NoteBean;
import DataBase.DBConnection;

public class AddNoteDAO 
{
	public int k=0;
	public int insert(NoteBean nb) 
	{
		Connection con = null;
        PreparedStatement ps = null;
		try
		{
			con = DBConnection.getCon();
			ps = con.prepareStatement("insert into NoteTable values(?,?,TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'),?,?)");
			ps.setInt(1, nb.getId());
			ps.setString(2, nb.getUname());
			ps.setString(3, nb.getDatetime());
			ps.setString(4, nb.getTitle());
			ps.setString(5, nb.getNote());
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
