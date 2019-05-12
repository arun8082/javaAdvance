package bs.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.security.sasl.SaslException;
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
 * Servlet implementation class CategoryDetails
 */
@WebServlet("/categoryDetails")
public class CategoryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		Customers c = (Customers) hs.getAttribute("cust_details");
		IBookShopDao dao = (BookShopDaoImpl) hs.getAttribute("book_shop_dao");
		String html = "";
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			if (c != null) {
				html += "<h3>Welcome " + c.getName() + "</h3><br/>" + "Choosed category "
						+ request.getParameter("category");
				List<Books> books = dao.getBooksListByCategory(request.getParameter("category"));
				if (books != null) {
					html += "<br/><form action='addToCart'>";
					for (Books b : books) {
						html += "<input type='checkbox' name='cartItems' value='" + b.getId() + "'/>" + b.getTitle() + " "
								+ b.getAuthor() + " " + b.getPrice() + "<br/>";
					}
					html += "<br/><br/><input type='submit' value='Add To Cart'/>"
							+ "<input type='submit' formaction='showCart' value='Show Cart'/>" + "</form>";
					pw.println(html);

				} else {
					pw.print("No books belongs to this category");
				}
			}
		} catch (Exception e) {
			throw new SaslException("Error in do get categoryDetails", e);
		}
	}

}
