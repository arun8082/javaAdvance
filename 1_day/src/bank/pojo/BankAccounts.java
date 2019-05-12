package bank.pojo;

public class BankAccounts {
	private int accno;
	private int id;
	private String type;
	private double balance;

	public BankAccounts(int accno, int id, String type, double balance) {
		super();
		this.accno = accno;
		this.id = id;
		this.type = type;
		this.balance = balance;
	}

	public BankAccounts(int accno, String type) {
		super();
		this.accno = accno;
		this.type = type;
	}
	

	public BankAccounts(String type, double balance) {
		super();
		this.type = type;
		this.balance = balance;
	}

	public BankAccounts(int id, String type, double balance) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
	}

	/**
	 * @return the accno
	 */
	public int getAccno() {
		return accno;
	}

	/**
	 * @param accno the accno to set
	 */
	public void setAccno(int accno) {
		this.accno = accno;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccounts [accno=" + accno + ", id=" + id + ", type=" + type + ", balance=" + balance + "]";
	}

}
