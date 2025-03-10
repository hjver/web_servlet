package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig( 
		fileSizeThreshold = 1024 * 1024 * 2,  
		maxFileSize = 1024 * 1024 * 5,  
		maxRequestSize = 1024 * 1024 * 100  
)
public class signupok extends HttpServlet {
	PrintWriter pw = null;
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		try {
			this.pw = response.getWriter();
			String mid = request.getParameter("mid");
			String mname = request.getParameter("mname");
			String mpass = request.getParameter("mpass");
			String memail = request.getParameter("memail");
			String mtelno = request.getParameter("mtelno");
			
			//휴대폰 번호 : 010****1004
			mtelno = mtelno.substring(0, 3) + "****" + mtelno.substring(7, 11);
			
			request.setAttribute("mid", mid);
			request.setAttribute("mname", mname);
			request.setAttribute("memail", memail);
			request.setAttribute("mtelno", mtelno);
			
			Part mfile = request.getPart("mfile");
			String filename = mfile.getSubmittedFileName();
			long filesize = mfile.getSize(); 
			if(filesize > 2097152) {
				this.pw.print("<script>"
							+ "alert('파일 첨부 용량은 최대 2MB까지 입니다.);"
							+ "history.go(-1);"
							+ "<script>"
							);
			}
			else {
				String url = request.getServletContext().getRealPath("/upload/");
				mfile.write(url + filename);
				request.setAttribute("filename", filename);
				this.pw.write("<script>"
							+ "alert('정상적으로 파일 업로드 되었습니다.');"
							+ "history.go(-1);"
							+ "<script>"
							);
			}	
			
			RequestDispatcher rd = request.getRequestDispatcher("/signupok.jsp");
			rd.forward(request, response);
			
		}catch (Exception e) {
			System.out.println(e);
			pw.write("<script>"
					+ "alert('올바른 값이 전달 되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>"
					);				
		}finally {
			this.pw.close();
		}
	}

}
