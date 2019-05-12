package bs.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bs.pojo.Customers;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter pw = response.getWriter()) {
			HttpSession hs = request.getSession();
			Customers c = (Customers)hs.getAttribute("cust_details");
			response.setContentType("text/html");
			String html="<h5>Thank you "+c.getName()+"</h5>"
					+ "<h5>For Continue press <a href='index.html'>Continue</a></h5><br/>";
			pw.println(html);			
		}catch (Exception e) {
			throw new ServletException("Error in do get logout",e);
		}
	}

}
