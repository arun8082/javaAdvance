package bs.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bs.dao.BookShopDaoImpl;
import bs.dao.IBookShopDao;
import bs.pojo.Customers;

/**
 * Servlet implementation class Category
 */
@WebServlet("/category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookShopDao dao;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter pw=response.getWriter()) {
			HttpSession hs = request.getSession();
			Customers c= (Customers)hs.getAttribute("cust_details");
			dao=(BookShopDaoImpl)hs.getAttribute("book_shop_dao");
			response.setContentType("text/html");
			if(c!=null) {
				String html="";
				html+="<h3>Welcome "+c.getName()+"</h3><br/>"
						+ "<string>Category</strong>"
						+ "<form action='categoryDetails'>"
						+ "<select name='category'>"
						+ "<option value=''>Select category</option>";
				List<String> categories = dao.getAllcategories();
				if(categories!=null) {
					for (String cat:categories) {
						html+="<option value='"+cat+"'>"+cat+"</option>";
					}
				}
				html+="</select>"
						+ "<input type='submit' value='Choose category'/>"
						+ "</form>"
						+ "<a href='logout'>Log Me Out</a>";
				pw.println(html);
			}else {
				response.sendRedirect("login.html?msg=requireLogin");
			}
		}catch (Exception e) {
			throw new ServletException("Error in do get category",e);
		}
	}

}
