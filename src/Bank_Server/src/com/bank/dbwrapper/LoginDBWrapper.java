package com.bank.dbwrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.bean.UserBean;

public class LoginDBWrapper {
	Connection connection = null;
	PreparedStatement preparestatement = null;
	ResultSet rs = null;

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// User Login
	public int validateUser(UserBean userBean) {
		System.out.println("validate User");
		DBConnection dBConnection = new DBConnection();
		connection = dBConnection.connect();
		try {
			preparestatement = connection.prepareStatement("Select *from user_table where username=? and password=?");
			preparestatement.setString(1, userBean.getUserName());
			preparestatement.setString(2, userBean.getPassWord());
			ResultSet rs = preparestatement.executeQuery();
			if(rs != null)
			{
				rs.next();
				int id = rs.getInt(1);
				System.out.println("ID:"+id);
				return id;
			}
			else return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}