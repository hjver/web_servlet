package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 페이비 번호ㄹ르 클릭시 해당 값을 받는 역할
		String pageno = request.getParameter("pageno");
		if(pageno == null || pageno.equals("1")) {  //최초 해당 게시판에 접속시 페이지 배열번호 0로 처리
			pageno = "0";
		}
		
		//list를 출력하기 위한 Database Table을 로드하는 Model
		m_noticelist nl = new m_noticelist(Integer.parseInt(pageno));
		
		ArrayList<ArrayList<String>> notice = nl.db_data();
		request.setAttribute("notice", notice);
		RequestDispatcher rd = request.getRequestDispatcher("./notice_list.jsp");
		rd.forward(request, response);
	}

}
