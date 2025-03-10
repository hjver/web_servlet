package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class view_enroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String couponno[] = {"A1316B1004", "C4024A0096", "B1987C3136"};
	PrintWriter pw = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String mid = request.getParameter("mid");
		String mcouponno = request.getParameter("mcouponno");
		String magree = request.getParameter("magree");
		
		pw = response.getWriter();
		boolean exist_couponno = false;
		for(int i=0; i<couponno.length; i++) {
			if(mcouponno.equals(couponno[i])) {
				exist_couponno = true;
				break;
			}
		}
		
		if(exist_couponno) {
			request.setAttribute("mid", mid);
			request.setAttribute("mcouponno", mcouponno);
			request.setAttribute("magree", magree);
			
			RequestDispatcher rd = request.getRequestDispatcher("./view_enroll.jsp");
			rd.forward(request, response);
		}
		else {
			try {
				pw = response.getWriter();
				pw.write("<script>"
						+ "alert('해당 쿠폰번호를 확인하세요');"
						+ "history.go(-1);"
						+ "</script>");
			}catch (Exception e) {
				
			}finally {
				pw.close();
			}
		}	
	}
}
