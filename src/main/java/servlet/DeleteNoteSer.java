package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.NoteBean;
import DAO.DeleteNoteDAO;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteNoteSer extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		if(hs == null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			int id = Integer.parseInt(req.getParameter("id"));
			@SuppressWarnings("unchecked")
			ArrayList<NoteBean> al = (ArrayList<NoteBean>)hs.getAttribute("alist");
			NoteBean nb=null;
			Iterator<NoteBean> it = al.iterator();
			while(it.hasNext())
			{
				nb = it.next();
				if(id == nb.getId())
				{
					break;
				}
			}
			int k = new DeleteNoteDAO().delete(nb);
			if(k>0)
			{
				req.setAttribute("msg", "Note deleted successfully...<br/>");
				req.getRequestDispatcher("ViewNote.jsp").forward(req,res);
			}
		}
	}
}
