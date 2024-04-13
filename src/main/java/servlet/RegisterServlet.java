package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.UserBean;
import DAO.RegisterDAO;

@SuppressWarnings("serial")
@WebServlet("/userReg")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		UserBean ub = new UserBean();
		ub.setuName(req.getParameter("uname"));
		ub.setpWord(req.getParameter("pword"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setAddr(req.getParameter("addr"));
		ub.setmId(req.getParameter("mId"));
		ub.setPhNo(Long.parseLong(req.getParameter("phno")));
		int k = new RegisterDAO().register(ub);
		if(k>0)
		{
			req.setAttribute("msg", "User Registered Sucessfully...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
			
		}
	}
}
