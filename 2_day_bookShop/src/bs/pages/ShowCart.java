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

import bs.pojo.Books;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/showCart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter pw = response.getWriter()) {
			response.setContentType("text/html");
			HttpSession hs = request.getSession();
			List<Books> books = (List<Books>) hs.getAttribute("books_list");
			if (books != null) {
				String html = "";
				html+="<h3>Cart Details</h3><br/>"
						+ "<form action='category'>"
						+ "<table>"
						+ "<tr>"
						+ "<th>Title</th>"
						+ "<th>Author</th>"
						+ "<th>Price</th>"
						+ "<th>Qty</th>"
						+ "<th>Action</th>"
						+ "</tr>";
				
				for(Books b:books) {
					html+="<tr>"
							+"<td>"+b.getTitle()+"</td>"
							+"<td>"+b.getAuthor()+"</td>"
							+"<td>"+b.getPrice()+"</td>"
							+"<td>1</td>"
							+"<td><input type='submit' value='Add Qty +1' formaction='addQty'/></td>"
							+"<td><input type='submit' value='Delete' formaction='deleteQty'/></td>"
							+ "</tr>";
				}
				html+="<tr>"
						+ "<td></td>"
						+ "<td></td>"
						+ "<td colspan='2'>"
						+ "<input type='submit' value='Back To Cart'/>"
						+ "</td>"
						+ "</tr>"
						+ "</table>"
						+ "<form>";
				pw.println(html);

			}
		} catch (Exception e) {
			throw new ServletException("Error in do get showcart", e);
		}
	}

}
