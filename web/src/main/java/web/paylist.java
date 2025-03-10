package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class paylist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = response.getWriter();
			String[] ck = request.getParameterValues("ck");
			request.setAttribute("ck", ck);				
			RequestDispatcher rd = request.getRequestDispatcher("./paylist.jsp");
			rd.forward(request, response);
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.pw.close();
		}
	}

}
