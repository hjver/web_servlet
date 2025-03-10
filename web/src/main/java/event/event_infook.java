package event;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class event_infook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PrintWriter pw = null;
	Statement st = null; //SQL 문법을 실행시키는 클래스(기초)
	dbconfig db = new dbconfig();
	
	/*
	public event_infook() {
		try {
			this.con = new dbconfig().info();
			System.out.println("Database 연결성공!!");
		}catch (Exception e) {
			System.out.println("Database 연결실패!!");
		}
	}
	*/
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		String ename = req.getParameter("ename");
		String etel = req.getParameter("etel");
		String email = req.getParameter("email");
		String ememo = req.getParameter("ememo");
		String info1 = req.getParameter("info1");
		String info2 = req.getParameter("info2");

		//SQL Query문 (DDL) - select, insert, update, delete
		String sql = "insert into event (eidx,ename,etel,email,ememo,info1,info2,ejoin)"
				+ "values ('0','"+ename+"','"+etel+"','"+email+"','"+ememo+"','"+info1+"','"+info2+"',now())";
		this.pw = res.getWriter();
		try {
			this.con = this.db.info();
			this.st = this.con.createStatement();
			int result = st.executeUpdate(sql); //executeUpdate (insert, update, delete)
			if(result == 1) {
				this.pw.write("<script>"
						+ "alert('정상적으로 이벤트에 참여 되었습니다.');"
						+ "location.href='./event_info.html';"
						+ "</script>");
			}
		}catch (Exception e) {
			System.out.println(e);
			System.out.println("SQL 문법 오류!!");
		}finally { //정상적인 Database 모두 핸들링 후 역순으로 close를 순차적으로 적용해야 함
			try {
				this.pw.close();
				this.st.close();
				this.con.close();
			}catch (Exception e) {
				System.out.println("");
			}
		}
	}

}
