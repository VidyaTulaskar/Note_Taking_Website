package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewNoteServlet extends HttpServlet 
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
			req.setAttribute("msg", "Your all notes are here...<br/>");
			req.getRequestDispatcher("ViewNote.jsp").forward(req, res);
		}
	}
}
