package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.NoteBean;
import Bean.UserBean;
import DAO.AddNoteDAO;
import DAO.ViewNoteDAO;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddNoteServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);	//Accessing existing session
		if(hs == null)
		{
			req.setAttribute("msg", "Session expired.....");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			NoteBean nb = new NoteBean();
			UserBean ub = (UserBean) hs.getAttribute("ubean");
			
			nb.setId(new Random().nextInt(1000));	//setting random value for ID in database table.
			nb.setUname(ub.getuName());				//taking user name from UserBean for NoteBean
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        LocalDateTime now = LocalDateTime.now();	//taking current date and time from system.
	        
	        nb.setDatetime(dtf.format(now));			
	        nb.setTitle(req.getParameter("title"));
			nb.setNote(req.getParameter("note"));
						
			int k = new AddNoteDAO().insert(nb);
			if(k>0)
			{
				req.setAttribute("msg","Note added Successfully...<br/>");
			}
			ArrayList<NoteBean> al = new ViewNoteDAO().retrieve(ub.getuName());
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		}
	}
}
