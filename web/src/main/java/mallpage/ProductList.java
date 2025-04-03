package mallpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Encriptor;


@WebServlet("/mallpage/product_list.do")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String midx = request.getParameter("midx");
		String pagename = "";
		
		if(midx == null) {
			ArrayList<ProductDto> products = new SelectProduct().selectProducts();
			request.setAttribute("products", products);
			
			pagename = "./product_list.jsp";
		}
		else{
			ProductDto product = new SelectProduct().selectOne(Integer.valueOf(midx));
			request.setAttribute("product", product);
			
			pagename = "./product_view.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(pagename);
		rd.forward(request, response);
	}

}
