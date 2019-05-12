package bank.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.BankAccountDaoImpl;
import bank.pojo.BankAccounts;
import bank.pojo.BankUsers;
import bank.util.DBUtil;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankAccountDaoImpl bankAccount;
	private Connection con;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init");
		try {
			con = DBUtil.getConnection();
			bankAccount = new BankAccountDaoImpl();
		} catch (Exception e) {
			throw new ServletException("Connection Error", e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy");
		try {
			if(con!=null)
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget start");
		try {
			boolean create= bankAccount.registerUser(new BankUsers(request.getParameter("name"),request.getParameter("password"), 
					new BankAccounts(request.getParameter("type"),Double.parseDouble(request.getParameter("bal")))));
			if(create==true) {
				response.getWriter().print("registered successfull");
				response.sendRedirect("login.html");
			}else {
				response.getWriter().print("registeration failed");
			}
			System.out.println("doget end");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
