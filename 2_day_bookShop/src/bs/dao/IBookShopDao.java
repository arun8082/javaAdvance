package bs.dao;

import java.util.List;
import java.util.Map;

import bs.pojo.Books;
import bs.pojo.Customers;

public interface IBookShopDao {
	Customers authenticateCustomer(String email,String password) throws Exception;
	List<String> getAllcategories() throws Exception;
	List<Books> getBooksListByCategory(String catgory) throws Exception;
	Map<Integer,Integer>getBooksListWithCount(List<Books> booksList) throws Exception;
	double calculateTotal(List<Books> booksList) throws Exception;
	Books getBooksDetailsById(String bid) throws Exception;
	List<Books> addBooksInList(List<Books> oldList,Books book) throws Exception;
	List<Books> getBooksListsByBookIds(String[] ids) throws Exception;
	
	
}
