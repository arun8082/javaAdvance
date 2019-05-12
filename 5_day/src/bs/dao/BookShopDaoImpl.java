package bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bs.pojo.Books;
import bs.pojo.Customers;

import static bs.utils.DBUtils.*;

public class BookShopDaoImpl implements IBookShopDao {
	private Connection con;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private PreparedStatement pst4;

	public BookShopDaoImpl() throws Exception {
		con = getConnection();
		pst1 = con.prepareStatement(
				"SELECT id,email,name,password,reg_date,role FROM my_customers WHERE email=? and password=?");
	}

	@Override
	public Customers authenticateCustomer(String email, String password) throws Exception {
		pst1.setString(1, email);
		pst1.setString(2, password);
		// System.out.println(pst1);
		ResultSet rst = pst1.executeQuery();
		if (rst.next()) {
			Customers c = new Customers(rst.getInt("id"), rst.getString("email"), rst.getString("name"),
					rst.getString("password"), rst.getDate("reg_date"), rst.getString("role"));
			return c;
		}
		return null;
	}

	@Override
	public List<String> getAllcategories() throws Exception {
		ArrayList<String> categories = new ArrayList<>();
		pst2 = con.prepareStatement("SELECT category FROM dmc_books");
		ResultSet rst = pst2.executeQuery();
		while (rst.next()) {
			categories.add(rst.getString("category"));
		}
		return categories;
	}

	@Override
	public List<Books> getBooksListByCategory(String category) throws Exception {
		ArrayList<Books> books = new ArrayList<>();
		pst3 = con.prepareStatement("SELECT id,title,author,price FROM dmc_books WHERE category=?");
		pst3.setString(1, category);
		ResultSet rst = pst3.executeQuery();
		while (rst.next()) {
			books.add(new Books(rst.getInt("id"), rst.getString("title"), rst.getString("author"),
					rst.getDouble("price")));
		}
		return books;
	}

	@Override
	public Map<Integer, Integer> getBooksListWithCount(List<Books> booksList) throws Exception {
		Map<Integer, Integer> map = new HashMap<>();
		List<Books> list = booksList;
		Set<Books> unique = new HashSet<Books>(list);
		for (Books key : unique) {
			map.put(key.getId(), Collections.frequency(list, key));
		}
		return map;
	}

	@Override
	public double calculateTotal(List<Books> booksList) throws Exception {
		double total = 0;
		if (booksList != null) {
			for (Books b : booksList) {
				total += b.getPrice();
			}
		}
		return total;
	}

	@Override
	public Books getBookDetailsByBookId(int bookId) throws Exception {
		pst4 = con.prepareStatement("SELECT id,title,author,price FROM dmc_books WHERE id=" + bookId);
		// System.out.println(pst4);
		ResultSet rst = pst4.executeQuery();
		Books book=null;
		if (rst.next()) {
			book = new Books(rst.getInt("id"), rst.getString("title"), rst.getString("author"),
					rst.getDouble("price"));
		}
		return book;
	}

}
