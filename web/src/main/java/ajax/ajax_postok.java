package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ajax_postok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * CORS 를 해결하기 위해서 사용하는 방식의 코드이며, 해당 Origin, Credentials
		 * 를 사요하여 ㄷ도메인이 다르게 접근하더라도 Ajax 통신이 되도록 허락을 하는 명령어
		 * 보안상 "*" -> "특정 허용 IP"
		 */
		response.addHeader("Access-Control-Allow-Origin", "*"); //* : 모든IP
		response.addHeader("Access-Control-Allow-Credentials", "true");
		
		String userid = request.getParameter("userid");
		String usermail = request.getParameter("usermail");
		String msg = ""; //ok : 정상 아이디, no : 아이디 오류, error : 백앤드 오류
		
		//System.out.println(userid);
		//System.out.println(usermail);
		
		this.pw = response.getWriter();
		
		if(userid.equals("hong") && usermail.equals("hong@nate.com")) {
			msg = "no";
		}
		else {
			msg = "ok";
		}
		
		this.pw.print(msg);  //프론트앤드에 보내는 값
	}

}
