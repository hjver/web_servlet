package portfolio;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mailok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	mail_insert mi = new mail_insert();
	
	PrintWriter pw = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //Front-end에서 한글이 전송될 경우
		response.setContentType("text/html;charset=utf-8");  //javascript 사용할 경우
		
		String to_name = request.getParameter("to_name");
		String to_mail = request.getParameter("to_mail");
		String subject = request.getParameter("subject");
		String context = request.getParameter("context");
		
		int result = this.mi.mail_in(to_name,to_mail,subject,context);
		
		this.pw = response.getWriter();
		if(result > 0) {
			this.pw.write("<script>"
					+ "alert('정상적으로 제휴 문의가 등록되었습니다.');"
					+ "location.href='./mail_list.do';"
					+ "</script>");
		}
		else {
			this.pw.write("<script>"
					+ "alert('서비스 장애로 인하여 문의 실패');"
					+ "history.go(-1);"
					+ "</script>");			
		}
	}

}
