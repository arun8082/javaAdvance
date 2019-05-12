package bank.pojo;

public class BankUsers {
	private int id;
	private String name;
	private String password;
	private BankAccounts bankAccount;

	public BankUsers(int id, String name, String password, BankAccounts bankAccount) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.bankAccount = bankAccount;
	}
	
	

	public BankUsers(int id, String name, BankAccounts bankAccount) {
		super();
		this.id = id;
		this.name = name;
		this.bankAccount = bankAccount;
	}



	public BankUsers(String name, String password, BankAccounts bankAccount) {
		super();
		this.name = name;
		this.password = password;
		this.bankAccount = bankAccount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankUsers [id=" + id + ", name=" + name + ", password=" + password + ", bankAccount=" + bankAccount + "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the bankAccount
	 */
	public BankAccounts getBankAccount() {
		return bankAccount;
	}

	/**
	 * @param bankAccount the bankAccount to set
	 */
	public void setBankAccount(BankAccounts bankAccount) {
		this.bankAccount = bankAccount;
	}

}
