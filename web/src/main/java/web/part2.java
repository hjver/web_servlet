package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class part2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	
	//part1에서 get으로 전송하므로 doGet만 설정함
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			this.pw = response.getWriter();
			//getParameterValues => 배열
			String agree[] = request.getParameterValues("agree");
			if(!agree[0].equals("Y0") || !agree[1].equals("Y1") || !agree[2].equals("Y2")) {
				this.pw.write("<script>"
						+ "alert('올바른 접근 방식이 아닙니다. 약관에 필수 동의가 필요합니다.');"
						+ "locatio.href='http://172.30.1.95:8080/web/part1.jsp';"
						+ "</script>");
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("./part2.jsp");
				rd.forward(request, response);
			}
			
		}catch (Exception e) {
			this.pw.write("<script>"
					+ "alert('시스템 오류로 인하여 데이터 처리가 되지 않았습니다.');"
					+ "locatio.href='http://172.30.1.95:8080/web/part1.jsp';"
					+ "</script>");
		}finally {
			this.pw.close();
		}
	}

}
