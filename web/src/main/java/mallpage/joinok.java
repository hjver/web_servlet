package mallpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.m_md5;

@WebServlet("/mallpage/joinok.do")
public class joinok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//checkbox
		String event_mail = request.getParameter("event_mail");
		String event_sms = request.getParameter("event_sms");
		
		if(event_mail==null) {
			event_mail = "N";
		}
		if(event_sms==null) {
			event_sms = "N";
		}
		
		m_member dto = new m_member();
		dto.setMid(request.getParameter("mid"));
		dto.setMpass(new m_md5().md5_code(request.getParameter("mpass")));
		dto.setMname(request.getParameter("mname"));
		dto.setMemail(request.getParameter("memail"));
		dto.setMtel(request.getParameter("mtel"));
		dto.setEvent_mail(event_mail);
		dto.setEvent_sms(event_sms);
		
		//DTO값을 insert Model 전달함
		Integer result = new insert_join().insert_member(dto);

		this.pw = response.getWriter();
		if(result > 0 ) {
			this.pw.write("<script>"
					+ "alert('회원가입이 정상처리 되었습니다.');"
					+ "location.href='/login.do';"
					+ "</script>");
		}else {
			this.pw.write("<script>"
					+ "alert('시스템 점검으로 회원가입이 되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		this.pw.close();
	}

}
