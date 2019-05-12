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

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import bs.dao.IBookShopDao;
import bs.pojo.Books;
import bs.pojo.Customers;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookShopDao dao;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession hs = request.getSession();
		try (PrintWriter pw = response.getWriter()) {
			IBookShopDao dao = (IBookShopDao) hs.getAttribute("book_shop_dao");
			Customers c = (Customers) hs.getAttribute("cust_details");
			if (c != null) {
				String[] bookIds = null;
				List<Books> booksList = null;
				List<Books> pBooksList = null;
				List<Books> sBooksList = null;
				if (request.getParameterValues("cartItems") != null
						&& ((List<Books>) hs.getAttribute("cartItemsList")).size() != 0) {
					bookIds = request.getParameterValues("cartItems");
					// parameters books list
					pBooksList = dao.getBooksListsByBookIds(bookIds);
					// Old books list
					sBooksList = (List<Books>) hs.getAttribute("cartItemsList");
					// Adding inti old with new books list
					sBooksList.addAll(pBooksList);
					booksList = sBooksList;
					// set innto session eith all books list
					hs.setAttribute("cartItemsList", sBooksList);

				} else if (request.getParameterValues("cartItems") != null
						&& ((List<Books>) hs.getAttribute("cartItemsList")).size() == 0) {					System.err.println("2 if");
					bookIds = request.getParameterValues("cartItems");
					booksList = dao.getBooksListsByBookIds(bookIds);
				} else if (hs.getAttribute("cartItemsList") != null) {
					booksList = (List<Books>) hs.getAttribute("cartItemsList");
				}
				hs.setAttribute("cartItemsList", booksList);
				response.setContentType("text/html");

				// System.out.println(booksList);
				String html = "";
				if (booksList != null) {
					html += "<h3>Cart Details</h3><br/>" + "<form action='#'>" + "<table>" + "<tr>" + "<th>Title</th>"
							+ "<th>Author</th>" + "<th>Price</th>" + "<th>Qty</th>" + "<th>Action</th>" + "</tr>";

					for (Books b : booksList) {
						html += "<tr>" + "<td>" + b.getTitle() + "</td>" + "<td>" + b.getAuthor() + "</td>" + "<td>"
								+ b.getPrice() + "</td>" + "<td>1</td>" + "<td><a href='addQty?bid=" + b.getId()
								+ "'/>Add Qty +1</a></td>" + "<td><a href='deleteQty?bid=" + b.getId()
								+ "'/>Delete</a></td>" + "</tr>";
					}
					html += "<tr>" + "<td></td>" + "<td></td>" + "<td colspan='2'>"
							+ "<input type='submit' value='Pay Now' formaction='payNow'/>"
							+ "<input type='submit' value='Continue' formaction='category'/>" + "</td>" + "</tr>"
							+ "</table>" + "</form>";
					pw.println(html);
				} else {
					html += "<h3>Cart is empty........</h3>"
							+ "<h4>Click here to continue <a href='category'>Continue</a></h4>";
					pw.println(html);
				}
			}
		} catch (Exception e) {
			throw new ServletException("Error in do get add to cart", e);
		}
	}

}
