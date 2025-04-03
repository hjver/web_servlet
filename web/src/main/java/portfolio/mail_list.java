package portfolio;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Database Table의 데이터를 출력하는
public class mail_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	mail_select ms = new mail_select();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ArrayList<String>> alldata = this.ms.maillist();
		request.setAttribute("alldata", alldata);
		RequestDispatcher rd = request.getRequestDispatcher("/mail_list.jsp");
		rd.forward(request, response);
	}

}
