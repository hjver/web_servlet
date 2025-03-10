package review;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 5,
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 * 100
		)
public class io_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String url = "";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Part mfile = request.getPart("mfile");
			String filenm = mfile.getSubmittedFileName();
			
			//D:\web_servlet\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\web\
			this.url = request.getServletContext().getRealPath("/notice/");
			File f = new File(this.url);
			if(!f.exists()) {
				f.mkdir();
			}
			if(filenm != "") {
				mfile.write(this.url + filenm);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
