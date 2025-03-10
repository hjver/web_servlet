package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class confirm_reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		String mname = req.getParameter("mname");
		String mtel = req.getParameter("mtel");
		String mmovie = req.getParameter("mmovie");
		String mdate = req.getParameter("mdate");

		req.setAttribute("mname", mname);
		req.setAttribute("mtel", mtel);
		req.setAttribute("mmovie", mmovie);
		req.setAttribute("mdate", mdate);
		
		RequestDispatcher rd = req.getRequestDispatcher("./confirm_reservation.jsp");
		rd.forward(req, res);
	}

}
