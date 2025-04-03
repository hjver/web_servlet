package portfolio;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mail_del extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
	String sql = null;
	int result = 0;
	m_dbinfo db = new m_dbinfo();
	PrintWriter pw = null;
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		try {
			String midx = request.getParameter("midx"); //Front-end GET 전송
			this.con = this.db.dbinfo();
			this.sql = "delete from hj_mail where midx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, midx);
			this.result = this.ps.executeUpdate();
			if(this.result > 0) {
				this.pw.print("<script>"
						+ "alert('해당 게시물을 정상적으로 삭제 하였습니다.');"
						+ "location.href='./mail_list.do';"
						+ "</script>");
			}
		}catch (Exception e) {
			this.pw.print("<script>"
					+ "alert('데이터 삭제 부분에 문제가 발생 하였습니다.');"
					+ "location.href='./mail_list.do';"
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
