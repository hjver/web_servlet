package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class idcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	//ajax 통신을 받는 메소드 (아이디 중복체크)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String msg = ""; //Front-end에게 결과값을 보내는 변수명
		
		//Back-end가 Front-end에게 결과값을 통보하는 역할
				this.pw = response.getWriter();
		
		//Ajax로 Front-end가 보낸 데이터를 받는 역할
		try {
			String id = request.getParameter("sid");
			if(id.equals("") || id.equals(null)) {
				msg = "error";
			}else {
				m_dbinfo db = new m_dbinfo();
				this.con = db.getConnection();
				/*
				 * sql query문 작성 방법
				 * 1. select => ResultSet, executeQuery
				 * 2. insert, update,delete => int, excuteUpdate
				 */
				//select count(*) from shop_member where sid = '변수명';
				String sql = "select count(*) as ctn from shop_member where sid='"+id+"'";
				//System.out.println(sql);
				
				//Statement : Database에 쿼리문을 작성할 수 있도록 사용하는 클래스
				//createStatement() : create, alter, drop
				this.st = this.con.createStatement();
				//ResultSet = executeQuery 결과값을 받는 역할
				this.rs = st.executeQuery(sql);
				
				if(this.rs.next() == true) { //정상적으로 Query문이 작동 했을 경우
					if(this.rs.getString("ctn").equals("0")) { //해당 데이터가 없을 때
						msg = "ok";
					}
					else { //검색한 데이터가 있을 경우
						msg ="no";
					}
				}
			}
			this.pw.write(msg); //ok : 사용가능 아이디, no : 사용불능 아이디, error : 데이터 오류
		}catch (NullPointerException ne) { //Front-end가 올바른 값을 전달하지 않을 경우
			msg = "error";
			this.pw.write(msg);
		}catch (Exception e) {
			msg = "CODE Error : 844 "; //임의의 에러 코드
			this.pw.write(msg);			
		}
		finally {
			this.pw.close();
			try {
				this.rs.close();
				this.st.close();
			}
			catch (Exception e) {
				
			}
		}
	}

}
