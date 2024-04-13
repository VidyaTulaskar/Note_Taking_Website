package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.NoteBean;
import DAO.UpdateNoteDAO;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateNoteServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs == null)
		{
			req.setAttribute("msg", "Session Expired....");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			int id = Integer.parseInt(req.getParameter("id"));
			@SuppressWarnings("unchecked")
			ArrayList<NoteBean> al = (ArrayList<NoteBean>)hs.getAttribute("alist");
			NoteBean nb = null;
			Iterator<NoteBean> it = al.iterator();
			while(it.hasNext())
			{
				nb=it.next();
				if(id == nb.getId())
				{
					break;
				}
			}
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        LocalDateTime now = LocalDateTime.now();	//taking current date and time from system.
	        
	        nb.setDatetime(dtf.format(now));
			nb.setTitle(req.getParameter("title"));
			nb.setNote(req.getParameter("note"));
			
			int k = new UpdateNoteDAO().update(nb);
			if(k>0)
			{
				req.setAttribute("msg", "Note updated successfully....<br>");
				req.getRequestDispatcher("ViewNote.jsp").forward(req, res);
			}
		}
	}
}
