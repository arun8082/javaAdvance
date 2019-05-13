package vn.bean;

import java.sql.Date;
import java.util.List;

import vn.dao.IVendorsDao;
import vn.dao.VendorsDaoImpl;
import vn.pojo.Vendors;

public class VenOperationBean {
	private IVendorsDao dao;
	private int vid;
	private String name;
	private String email;
	private String password;
	private String city;
	private String cell_no;
	private double reg_amount;
	private Date reg_date;
	private String role;
	private String statusMsg;
	private Vendors logDetails;
	private String uri;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		System.out.println("set uri");
		this.uri = uri;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public VenOperationBean() throws Exception {
		System.out.println("bean def constr");
		dao = new VendorsDaoImpl();
	}

	public List<Vendors> getAllVendors() throws Exception {
		return dao.getAllvendorsList();
	}

	public String addNewVendor() throws Exception {
		Vendors vendor = new Vendors(name, email, password, city, cell_no, reg_amount,
				reg_date, role);
		boolean status = dao.insertVendor(vendor);
		if (status == true) {
			statusMsg = "1 vendor is sucessfully added...........";
			return "vendorsList";
		}
		statusMsg = "Failed to add vendor !!!!!!!!!!!!!!!!!";
		return "addvendor";
	}

	public String updateVendor() throws Exception {
		Vendors vendor = new Vendors(vid, city, cell_no);
		boolean status = dao.updateVendor(vendor);
		if (status == true) {
			statusMsg = "vendor data is sucessfully updated...........";
			return "vendorsList";
		}
		statusMsg = "Failed to update vendor data !!!!!!!!!!!!!!!!!";
		return "update";
	}

	public String deleteVendor() throws Exception {
		boolean status = dao.deleteVendor(vid);
		if (status == true) {
			statusMsg = "1 vendor is sucessfully deleted...........";
			// return "vendorsList";
		}
		statusMsg = "Failed to delete vendor !!!!!!!!!!!!!!!!!";
		return "vendorsList";
	}

	public String authenticateLogin() throws Exception {
		//System.out.println(email+" "+password);
		logDetails = dao.authenticateVendor(email, password);
		if (logDetails != null) {
			statusMsg = "Login successful...";
			return "vendorsList";
		}
		statusMsg = "invalid Logindetails !!!!!!!!!!";
		return "login";
	}

	public String authenticatePage() throws Exception {
		if (logDetails != null) {
			Vendors ven = null;
			ven = dao.authenticateVendor(logDetails.getEmail(), logDetails.getPassword());
			if (ven == null) {
				statusMsg = "Login first please !!!!!!!";
				return "login";
			}
			statusMsg = "";
			return (ven == null) ? "login" : "vendorsList";
		}
		return "login";
	}

	public Vendors vendorDetails() throws Exception {
		return dao.getVendorDetailsById(vid);
	}

	public void unset() {
		statusMsg = "";
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCell_no() {
		return cell_no;
	}

	public void setCell_no(String cell_no) {
		this.cell_no = cell_no;
	}

	public double getReg_amount() {
		return reg_amount;
	}

	public void setReg_amount(double reg_amount) {
		this.reg_amount = reg_amount;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Vendors getLogDetails() {
		return logDetails;
	}

}
