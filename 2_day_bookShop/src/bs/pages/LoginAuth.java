package bs.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bs.dao.BookShopDaoImpl;
import bs.dao.IBookShopDao;
import bs.pojo.Books;
import bs.pojo.Customers;

/**
 * Servlet implementation class Login
 */
@WebServlet("/loginAuth")
public class LoginAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookShopDao dao;
	private List<Books> cartItemsList;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter pw = response.getWriter()) {
			dao=new BookShopDaoImpl();
			response.setContentType("text/html");
			Customers c=dao.authenticateCustomer(request.getParameter("email"), request.getParameter("password"));
			HttpSession hs = request.getSession();
			hs.setAttribute("book_shop_dao", dao);
			if(c!=null) {
				hs.setAttribute("cust_details", c);
				cartItemsList= new ArrayList<>();
				hs.setAttribute("cartItemsList",cartItemsList);
				response.sendRedirect("category");
			}else {
				pw.println("Invalid Credentails.....<br/>");
				pw.print("<h4><a href='login.html'>Retry</a></h4>");
			}
		} catch (Exception e) {
			throw new ServletException("Error in login doget",e);
		}
	}

}
