package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.pojo.BankAccounts;
import bank.pojo.BankUsers;

import static bank.util.DBUtil.*;

public class BankAccountDaoImpl implements IBankAccountDao {
	private Connection con;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private PreparedStatement pst4;

	public BankAccountDaoImpl() throws Exception {
		con = getConnection();
		pst1 = con.prepareStatement("INSERT INTO bank_users"
				+ "(name,password) values"
				+ "(?,?)");
		pst2 = con.prepareStatement("INSERT INTO bank_accounts"
				+ "(id,type,bal) values"
				+ "(?,?,?)");
		pst3 = con.prepareStatement("SELECT bu.id,bu.name,ba.ac_no,ba.type"
				+ " FROM bank_users bu INNER JOIN"
				+ " bank_accounts ba ON"
				+ " bu.id=ba.id"
				+ " WHERE name=? AND password=?");
		pst4 = con.prepareStatement("SELECT id,name"
				+ " FROM bank_users"
				+ " WHERE name=? AND password=?");
	}

	@Override
	public boolean registerUser(BankUsers bankuser) throws Exception {
		pst1.setString(1, bankuser.getName());
		pst1.setString(2, bankuser.getPassword());
		int insertCount = pst1.executeUpdate();
		if (insertCount == 1) {
			pst4.setString(1, bankuser.getName());
			pst4.setString(2, bankuser.getPassword());
			ResultSet rst = pst4.executeQuery();
			if (rst.next()) {
				pst2.setInt(1, rst.getInt(1));
				pst2.setString(2, bankuser.getBankAccount().getType());
				pst2.setDouble(3, bankuser.getBankAccount().getBalance());
				insertCount = pst2.executeUpdate();
				if (insertCount == 1) {
					return true;
				}
			}

		}
		return false;
	}

	@Override
	public BankUsers authenticateLogin(String name, String password) throws Exception {
		pst3.setString(1, name);
		pst3.setString(2, password);
		System.out.println(pst3);
		ResultSet rst = pst3.executeQuery();
		if (rst.next()) {
			return new BankUsers(name,
				rst.getString(2),
				new BankAccounts(rst.getInt(3),
					rst.getString(4)));
		}
		return null;
	}

	@Override
	public void cleanUp() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				throw new RuntimeException("error in clean up", e);
			}
	}
}
