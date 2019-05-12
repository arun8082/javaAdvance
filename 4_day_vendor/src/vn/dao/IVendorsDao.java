package vn.dao;

import java.util.List;

import vn.pojo.Vendors;

public interface IVendorsDao {
	List<Vendors> getAllvendorsList() throws Exception;

	Vendors getVendorDetailsById(int vid) throws Exception;

	boolean insertVendor(Vendors ven) throws Exception;

	boolean updateVendor(Vendors ven) throws Exception;

	boolean deleteVendor(int vid) throws Exception;
	
	Vendors authenticateVendor(String email,String password) throws Exception;
}
