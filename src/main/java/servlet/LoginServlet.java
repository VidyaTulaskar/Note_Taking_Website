package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.NoteBean;
import Bean.UserBean;
import DAO.LoginDAO;
import DAO.ViewNoteDAO;

@SuppressWarnings("serial")
@WebServlet("/userLog")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
	{
		UserBean ub = new LoginDAO().login(req.getParameter("uname"), req.getParameter("pword"));
		if(ub == null)
		{
			req.setAttribute("msg", "Invalid Login Process....<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs = req.getSession();	//create new session
			hs.setAttribute("ubean", ub);		//adding UserBean attribute into HttpSession.
			ArrayList<NoteBean> al = new ViewNoteDAO().retrieve(ub.getuName());
			hs.setAttribute("alist", al);		//adding arrayList attribute into HttpSession.
			req.setAttribute("msg", "Well done! You successfully Login...<br/>");
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		}
	}
}
