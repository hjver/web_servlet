package email;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.m_dbinfo;

public class mailok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;
	PreparedStatement ps = null;
	m_dbinfo db = new m_dbinfo();
	
	String sql = "";
	int result;
	
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.con = this.db.getConnection();
			String to_name = request.getParameter("to_name");
			String to_mail = request.getParameter("to_mail");
			String subject = request.getParameter("subject");
			String context = request.getParameter("context");
		
			this.sql = "insert into mailto (eidx,to_name,to_mail,subject,context,edate) values ('0',?,?,?,?,now())";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, to_name);
			this.ps.setString(2, to_mail);
			this.ps.setString(3, subject);
			this.ps.setString(4, context);
			this.result = this.ps.executeUpdate();
			
			this.pw = response.getWriter();
			if(result > 0) {
				this.pw.write("<script>"
						+ "alert('데이터베이스에 정상 저장되었습니다.');"
						+ "</script>");
			}
			
		}catch (Exception e) {
			this.pw.write("<script>"
					+ "alert('데이터베이스에 오류가 있습니다.');"
					+ "</script>");			
		}finally {
			try {
				this.pw.close();
				this.ps.close();
				this.con.close();
			}catch (Exception e) {
				
			}
		}
		
		
	}

}
