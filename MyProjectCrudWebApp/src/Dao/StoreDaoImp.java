package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.AllStores;
import Controller.ServiceController;
import Model.Store;

public class StoreDaoImp {

	String sql;

	public String add(Store store) {

		sql = "INSERT INTO storeInfo VALUES('" + store.getStoreId() + "','" + store.getStoreName() + "','"
				+ store.getZipCode() + "','" + store.getDistance() + "')";
		return sql;
	}

	public String edit(String storeId, Store store) {

		sql = "UPDATE storeInfo SET StoreName='" + store.getStoreName() + "',ZipCode='" + store.getZipCode()
				+ "',Distance='" + store.getDistance() + "' WHERE StoreId='" + storeId + "'";
		return sql;

	}

	public String delete(String storeId) {

		sql = "DELETE FROM storeInfo WHERE StoreId='" + storeId + "'";
		return sql;

	}
	
	public String findStore(String zipcode,String range)
	{
		int Range=Integer.parseInt(range);
		sql= "SELECT * from storeInfo WHERE ZipCode='"+zipcode+"' AND Distance<'" +Range+ "'";
		return sql;
	}

	public String getStore(String storeId) {
		

		sql="SELECT * from storeInfo WHERE StoreId='" +storeId+ "'";
		return sql;
		
	}

	public String getAllStores() {
		String sql = "SELECT * FROM storeInfo";
		return sql;

	}


}
