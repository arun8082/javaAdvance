package bs.jbean;

import java.util.ArrayList;
import java.util.List;

import bs.dao.BookShopDaoImpl;
import bs.dao.IBookShopDao;
import bs.pojo.Books;
import bs.pojo.Customers;

public class BookShopBean {
	private String email;
	private String password;
	private IBookShopDao dao;
	private Customers details;
	private String status;
	private String category;
	private int[] bookId;
	private List<Integer> cart;
	private List<Books> booksList;

	public int[] getBookId() {
		return bookId;
	}

	public void setBookId(int[] bookId) {
		System.out.println("set bookid");
		this.bookId = bookId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		System.out.println("set cate");
		this.category = category;
	}

	public BookShopBean() throws Exception {
		System.out.println("Bean def constr");
		dao = new BookShopDaoImpl();
	}

	public void setEmail(String email) {
		System.out.println("bean set email");
		this.email = email;
	}

	public void setPassword(String password) {
		System.out.println("Bean set pass");
		this.password = password;
	}

	public Customers getDetails() {
		System.out.println("Bean get deatails");
		return details;
	}

	public String validateCustomer() throws Exception {
		details = dao.authenticateCustomer(email, password);
		if (details != null) {
			status = "Sucessfully Login.......";
			cart = new ArrayList<>();
			return "category";
		}
		status = "invalid Login!!!!!!!!!!!";
		return "login";
	}

	public String getStatus() {
		return status;
	}

	public List<String> getAllCategories() throws Exception {
		return dao.getAllcategories();
	}

	public List<Books> getBooksListByCategory() throws Exception {
		return dao.getBooksListByCategory(category);
	}

	public List<Integer> getCartList() {
		System.out.println("in getCart list");
		for (int id : bookId) {
			cart.add(id);
		}
		return cart;
	}

	public List<Books> getCartListDetails() throws Exception{
		System.out.println("in cart list details");
		booksList = new ArrayList<>();
		if (cart != null) {
			for (int id : cart ) {
				booksList.add(dao.getBookDetailsByBookId(id));
			}
		}
		return booksList;
	}
	public double calculateTotal() throws Exception {
		System.out.println("calc total");
		return dao.calculateTotal(booksList);
	}
}
