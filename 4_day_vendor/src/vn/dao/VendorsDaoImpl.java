package vn.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static vn.Utils.DBUtils.*;
import vn.pojo.Vendors;

public class VendorsDaoImpl implements IVendorsDao {
	private Connection con;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private PreparedStatement pst4;
	private PreparedStatement pst5;
	private PreparedStatement pst6;
	private ResultSet rst;

	public VendorsDaoImpl() throws Exception {
		con = getConnection();
		pst1 = con.prepareStatement(
				"SELECT id,name,email,password,city,cell_no,reg_amount,reg_date,role FROM vendors");
		pst2 = con.prepareStatement(
				"SELECT id,name,email,password,city,cell_no,reg_amount,reg_date,role FROM vendors WHERE id=?");
		pst3 = con.prepareStatement(
				"INSERT INTO vendors(name,email,password,city,cell_no,reg_amount,reg_date,role) VALUES(?,?,?,?,?,?,?,?)");
		pst4 = con.prepareStatement("UPDATE vendors SET city=?,cell_no=? WHERE id=?");
		pst5 = con.prepareStatement("DELETE FROM vendors WHERE id=?");
		pst6 = con.prepareStatement(
				"SELECT id,name,email,password,city,cell_no,reg_amount,reg_date,role FROM vendors WHERE email=? AND password=?");
	}

	@Override
	public List<Vendors> getAllvendorsList() throws Exception {
		List<Vendors> vendorsList = new ArrayList<>();
		rst = pst1.executeQuery();
		while (rst.next()) {
			vendorsList.add(new Vendors(rst.getInt("id"), rst.getString("name"),
					rst.getString("email"),rst.getString("password"), rst.getString("city"),
					rst.getString("cell_no"), rst.getDouble("reg_amount"),
					rst.getDate("reg_date"), rst.getString("role")));
		}
		return vendorsList;
	}

	@Override
	public Vendors getVendorDetailsById(int vid) throws Exception {
		pst2.setInt(1, vid);
		rst = pst2.executeQuery();
		Vendors vendor = null;
		if (rst.next()) {
			vendor = new Vendors(rst.getInt("id"), rst.getString("name"),
					rst.getString("email"),rst.getString("password"), rst.getString("city"),
					rst.getString("cell_no"), rst.getDouble("reg_amount"),
					rst.getDate("reg_date"), rst.getString("role"));
		}
		return vendor;
	}

	@Override
	public boolean insertVendor(Vendors ven) throws Exception {
		int insertStatus = 0;
		if (ven != null) {
			pst3.setString(1, ven.getName());
			pst3.setString(2, ven.getEmail());
			pst3.setString(3, ven.getPassword());
			pst3.setString(4, ven.getCity());
			pst3.setString(5, ven.getCell_no());
			pst3.setDouble(6, ven.getReg_amount());
			pst3.setDate(7, ven.getReg_date());
			pst3.setString(8, ven.getRole());
			insertStatus = pst3.executeUpdate();
		}
		return (insertStatus == 1) ? true : false;
	}

	@Override
	public boolean updateVendor(Vendors ven) throws Exception {
		pst4.setString(1, ven.getCity());
		pst4.setString(2, ven.getCell_no());
		pst4.setInt(3, ven.getId());
		int updateCount = 0;
		updateCount = pst4.executeUpdate();
		return (updateCount == 1) ? true : false;
	}

	@Override
	public boolean deleteVendor(int vid) throws Exception {
		pst5.setInt(1, vid);
		int deleteCount = 0;
		deleteCount = pst5.executeUpdate();
		return (deleteCount == 1) ? true : false;
	}

	@Override
	public Vendors authenticateVendor(String email, String password) throws Exception {
		Vendors vendor = null;
		pst6.setString(1, email);
		pst6.setString(2, password);
		//System.out.println(pst6);
		rst = pst6.executeQuery();
		if (rst.next()) {
			vendor = new Vendors(rst.getInt("id"), rst.getString("name"),
					rst.getString("email"),rst.getString("password"), rst.getString("city"),
					rst.getString("cell_no"), rst.getDouble("reg_amount"),
					rst.getDate("reg_date"), rst.getString("role"));
		}
		return vendor;
	}

}
