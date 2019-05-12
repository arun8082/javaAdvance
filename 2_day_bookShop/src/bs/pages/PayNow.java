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

import bs.dao.IBookShopDao;
import bs.pojo.Books;

/**
 * Servlet implementation class PayNow
 */
@WebServlet("/payNow")
public class PayNow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookShopDao dao;
	private List<Books> booksList;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		response.setContentType("text/html");
		dao=(IBookShopDao) hs.getAttribute("book_shop_dao");
		booksList=(List<Books>) hs.getAttribute("cartItemsList");
		try(PrintWriter pw=response.getWriter()) {
			double total=dao.calculateTotal(booksList);
			pw.println("<h2>Paynow page<h2><br/>");
			pw.println("<h4>Total: "+total+"<h4>");
			pw.println("<h4><a href='category'>Continue</a><h4>");
		} catch (Exception e) {
			throw new ServletException("Error in do get paynow",e);
		}
	}

}
