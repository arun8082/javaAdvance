package bs.pages;

import java.io.IOException;
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
 * Servlet implementation class AddQty
 */
@WebServlet("/addQty")
public class AddQty extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookShopDao dao;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		dao = (IBookShopDao) hs.getAttribute("book_shop_dao");
		List<Books> cartItemsList = (List<Books>) hs.getAttribute("cartItemsList");
		try {
			Books book = dao.getBooksDetailsById(request.getParameter("bid"));
			cartItemsList.add(book);
			hs.setAttribute("cartItemsList", cartItemsList);
			response.sendRedirect("addToCart");
		} catch (Exception e) {
			throw new ServletException("Error in do get addQty", e);
		}
	}

}
