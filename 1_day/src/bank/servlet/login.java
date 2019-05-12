package bank.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.BankAccountDaoImpl;
import bank.pojo.BankUsers;
import sun.java2d.cmm.kcms.KcmsServiceProvider;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankAccountDaoImpl bankAccount;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init");
		try {
			bankAccount = new BankAccountDaoImpl();
		} catch (Exception e) {
			throw new ServletException("Connection Error", e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget start");
		try {
			
			response.setContentType("text/html");
			BankUsers bu = bankAccount.authenticateLogin(request.getParameter("name"),
				request.getParameter("password"));
			if (bu != null) {
				response.getWriter().print("<h3>Welcome " + bu.getName() + "<h3><br/>Accno: "
						+ bu.getBankAccount().getAccno() + "<br/>Type: " + bu.getBankAccount().getType());
			} else {
				response.getWriter().print("Invalid");
			}
			System.out.println("doget end");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
