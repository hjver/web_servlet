package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deliveryok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter pw = null;
	
	//일반 메소드
	public void deliveryok(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("utf-8");
			res.setContentType("text/html;charset=utf-8");
			this.pw = res.getWriter();
		}catch (Exception e) {
			System.out.println("해당 URL 경로가 올바르지 않습니다.");
		}		
	}

	//매개변수명을 변경하여 request 또는 response를 다른 이름으로 변경 가능
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.deliveryok(req, res);
		String mname = req.getParameter("mname");
		String mtel = req.getParameter("mtel");
		String memail = req.getParameter("memail");
		String maddress = req.getParameter("maddress");
		
		ArrayList<String> data = new ArrayList<String>();
		data.add(mname);
		data.add(mtel);
		data.add(memail);
		data.add(maddress);
		req.setAttribute("data", data);
		
		RequestDispatcher rd = req.getRequestDispatcher("./deliveryok.jsp");
		rd.forward(req, res);
	}

}
