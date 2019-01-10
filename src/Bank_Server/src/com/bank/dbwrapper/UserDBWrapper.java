package com.bank.dbwrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bank.bean.AccountInfoBean;
import com.bank.bean.TransactionBean;
import com.bank.bean.UserBean;

public class UserDBWrapper {

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


	public String depositeAmount(int userid,int amount) {
		DBConnection dBConnection = new DBConnection();
		connection = dBConnection.connect();
		String finalString ="";
		String query = "update account_info set balance = (balance + " +amount+ ")  where account_user_id= "+userid;
		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			String mobile ="";
			int balance = 0;
			if(result !=0){
				String squery = "SELECT user_table.mob FROM user_table WHERE user_table.u_id = "+userid;
				ResultSet mobileResultSet = statement.executeQuery(squery);
				mobileResultSet.next();
				mobile = mobileResultSet.getString(1);

				String ssquery ="SELECT account_info.balance FROM account_info WHERE account_info.account_user_id ="+userid;
				ResultSet balanceResultSet = statement.executeQuery(ssquery);
				balanceResultSet.next();
				balance = balanceResultSet.getInt(1);

				finalString =mobile+","+balance;
				return finalString;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalString;
	}

	// INSERT
	public int insertUser(UserBean userBean) {
		DBConnection dBConnection = new DBConnection();
		connection = dBConnection.connect();
		String query = "insert into user_table(first_name, last_name,gender,enail_id,mob,username,password) values('"
				+ userBean.getFirstName()
				+ "','"
				+ userBean.getLastName()
				+ "','"
				+ userBean.getGender()
				+ "','"
				+ userBean.getEmailId()
				+ "','"
				+ userBean.getMobileNo()
				+ "','"
				+ userBean.getUserName()
				+ "','"
				+ userBean.getPassWord()
				+ "')";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			// find the max number from db....say id
			String squery = "SELECT *FROM user_table where u_id=(SELECT MAX(u_id) FROM user_table);";
			ResultSet resultSet = statement.executeQuery(squery);
			resultSet.next();
			int id = resultSet.getInt(1);
			userBean.setId(id);

			return id;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int insertAccountInfo(AccountInfoBean accountInfoBean) {
		DBConnection dBConnection = new DBConnection();
		connection = dBConnection.connect();
		PreparedStatement stmt;
		try {
			//System.out.println("Image lenth is "+accountInfoBean.getBank_share().read());
			stmt = connection.prepareStatement("insert into account_info(account_user_id,secret_pin,account_type,balance,bank_share) values (?,?,?,?,?)");
			stmt.setInt(1, accountInfoBean.getUserid());
			stmt.setString(2, accountInfoBean.getSecretPin());
			stmt.setString(3, accountInfoBean.getAccountType());
			stmt.setInt(4, accountInfoBean.getMinBalance());
			stmt.setBinaryStream(5, accountInfoBean.getBank_share());
			stmt.executeUpdate();
			String squery = "SELECT MAX(account_id) FROM account_info";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(squery);
			resultSet.next();
			int id = resultSet.getInt(1);
			return id;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return -1;
	}
	public int updateAccountInfo(int userid,int amount) {
		DBConnection dBConnection = new DBConnection();
		connection = dBConnection.connect();
		String query = "update account_info set balance = (balance + "+ amount+")  where account_user_id='"+ userid + "'";
		System.out.println(query);
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			// find the max number from db....say id
			String squery = "SELECT *FROM account_info where account_id=(SELECT MAX(account_id) FROM account_info);";
			ResultSet resultSet = statement.executeQuery(squery);
			resultSet.next();
			int id = resultSet.getInt(1);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int updateAccountInfoForWithdraw(int account_id,int amount) {
		DBConnection dBConnection = new DBConnection();
		connection = dBConnection.connect();
		String query = "update account_info set balance = (balance - "+ amount+")  where account_id="
				+ account_id + "";
		System.out.println(query);
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			// find the max number from db....say id
			String squery = "SELECT *FROM account_info where account_id=(SELECT MAX(account_id) FROM account_info);";
			ResultSet resultSet = statement.executeQuery(squery);
			resultSet.next();
			int id = resultSet.getInt(1);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public String userSName() 
	{
		DBConnection dBConnection = new DBConnection();
		connection = dBConnection.connect();
		Statement statement;
		String username = "";
		try {
			statement = connection.createStatement();
			//String query = "select * from user_table user inner join transactaion_table transaction on user.u_id=transaction.u_id";
			String query = "select u_id,first_name from user_table";
			ResultSet resultSet = statement.executeQuery(query);
			System.out.println("qusery..."+query);
			while(resultSet.next())

			{
				String allUserName=resultSet.getString("first_name");
				int userId=resultSet.getInt("u_id");
				System.out.println("id is.. "+userId);
				username +=userId+":" +allUserName + ",";
				//username += allUserName + ",";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return username;
	}

	public void transferMoney(int fromuser,int touser,int amount)
	{
		try {

			DBConnection dBConnection = new DBConnection();
			connection = dBConnection.connect();
			String query = "update account_info set balance = (balance - "+ amount+")  where account_user_id='"
					+ fromuser + "'";
			String query1 = "update account_info set balance = (balance + "+ amount+")  where account_user_id='"
					+ touser + "'";
			System.out.println(query);
			System.out.println(query1);

			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.executeUpdate(query1);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public int transferMoneyByAccount(int fromuser,int touser,int amount)
	{
		try {

			DBConnection dBConnection = new DBConnection();
			connection = dBConnection.connect();
			Statement statement = connection.createStatement();
			String query = "update account_info set balance = (balance - "+ amount+")  where secret_pin='"+ fromuser + "'";
			if(statement.executeUpdate(query) > 0) {
				query = "update account_info set balance = (balance + "+ amount+")  where secret_pin='"+ touser + "'";
				statement.executeUpdate(query);
				return 1;
			} else {
				return 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int insertAmount(int id,int amount, int otp)
	{
		try {

			DBConnection dBConnection = new DBConnection();
			connection = dBConnection.connect();
			String query="insert into transaction_table(user_id,amount,date,time, otp)values (" +id  + "," + amount+ "," + "now()" + "," + "now()" +", "+otp+")";
			System.out.println(query);
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			String squery = "SELECT *FROM transaction_table where transaction_id=(SELECT MAX(transaction_id) FROM transaction_table);";
			ResultSet resultSet = statement.executeQuery(squery);
			resultSet.next();
			int transactionId= resultSet.getInt(1);

			return transactionId;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int checkingOTP(TransactionBean bean)
	{
		DBConnection dBConnection = new DBConnection();
		connection = dBConnection.connect();
		Statement statement;
		int id = 0;
		try {
			statement = connection.createStatement();
			String query = "select * from transaction_table where otp="+bean.getOtp()+" and  transaction_table.amount="+bean.getAmount()+" and transaction_table.user_id="+bean.getUserId()+""; 
			ResultSet resultSet = statement.executeQuery(query);
			System.out.println("qusery..."+query);
			while(resultSet.next())
			{
				id =resultSet.getInt("transaction_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public ArrayList<UserBean> getAllUserdetails() throws SQLException
	{
		DBConnection dbconnect=new DBConnection();
		connection=dbconnect.connect();
		ArrayList<UserBean> al = new ArrayList<UserBean>();
		PreparedStatement stmt=connection.prepareStatement("select * from user_table");
		ResultSet rs=stmt.executeQuery();
		while(rs.next())
		{   

			UserBean bean = new UserBean();
			bean.setId(rs.getInt("u_id"));
			bean.setFirstName(rs.getString("first_name"));
			bean.setLastName(rs.getString("last_name"));
			bean.setGender(rs.getString("gender"));
			bean.setEmailId(rs.getString("enail_id"));
			bean.setMobileNo(rs.getString("mob"));	
			al.add(bean);
		}
		return al;	
	}


	public AccountInfoBean getAccountDetailsByAccID(int accountID, String secret_pin) 
	{
		System.out.println("in getAccountDetailsByAccID  accountID: "+accountID);
		DBConnection dbconnect=new DBConnection();
		connection=dbconnect.connect();
		AccountInfoBean bean = new AccountInfoBean();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("select * from account_info where account_id=? and secret_pin=?");
			stmt.setInt(1, accountID);
			stmt.setString(2, secret_pin);
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{   
				bean.setUserid(rs.getInt("account_user_id"));
				bean.setSecretPin(rs.getString("secret_pin"));
				bean.setAccountType(rs.getString("account_type"));
				bean.setMinBalance(rs.getInt("balance"));
				bean.setBank_share(rs.getBinaryStream("bank_share"));
				/*try {
					System.out.println("rs.getBinaryStream" + rs.getBinaryStream("bank_share").available());
				} catch (IOException e) {
					e.printStackTrace();
				}*/
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;	
	}


	public UserBean getUserDetailsByAccID(int accountID) 
	{
		System.out.println("in getUserDetailsByAccID  accountID: "+accountID);
		DBConnection dbconnect=new DBConnection();
		connection=dbconnect.connect();
		UserBean bean = new UserBean();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("select * FROM user_table where user_table.u_id IN (SELECT account_info.account_user_id FROM account_info where account_info.account_id="+accountID+");");
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{   
				bean.setId(rs.getInt("u_id"));
				bean.setFirstName(rs.getString("first_name"));
				bean.setLastName(rs.getString("last_name"));
				bean.setGender(rs.getString("gender"));
				bean.setEmailId(rs.getString("enail_id"));
				bean.setMobileNo(rs.getString("mob"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;	
	}

	public void deleteUser(int uid)  throws ClassNotFoundException, SQLException 
	{
		DBConnection dbconnect=new DBConnection();
		connection=dbconnect.connect();

		PreparedStatement stmt=connection.prepareStatement("delete from user_table where u_id=?");
		stmt.setInt(1,uid);
		stmt.execute();
	}

	public int checkUsername(String  username) 
	{
		DBConnection dbconnect=new DBConnection();
		connection=dbconnect.connect();
		int id = 0;
		try {
			PreparedStatement stmt=connection.prepareStatement("select u_id from user_table where username=?");
			stmt.setString(1,username);
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{   
				id =rs.getInt("u_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}