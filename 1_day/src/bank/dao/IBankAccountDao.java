package bank.dao;

import bank.pojo.BankUsers;

public interface IBankAccountDao {
	public boolean registerUser(BankUsers bankuser) throws Exception;

	public BankUsers authenticateLogin(String name, String password) throws Exception;

	public void cleanUp();
}
