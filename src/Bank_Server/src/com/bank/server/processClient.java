package com.bank.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.bank.bean.AccountInfoBean;
import com.bank.bean.UserBean;
import com.bank.dbwrapper.LoginDBWrapper;
import com.bank.dbwrapper.UserDBWrapper;

class processClient implements Runnable {
	Socket clnt;
	Thread t;
	String files;

	processClient(Socket s) {
		clnt = s;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		try {
			process();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void process() throws IOException  {
		System.out.println("Client connected...");

		try{
		DataInputStream in = new DataInputStream(clnt.getInputStream());
		DataOutputStream out = new DataOutputStream(clnt.getOutputStream());
		int uid=-1;
		while (true) {
			
			
			System.out.println("waiting for client request...");
			// First of all always read the protocol first...
			int todo = in.readInt();
			switch (todo) {
			case 1: // user login

			{
				String Username = in.readUTF();
				String Password = in.readUTF();
				System.out.println(Username);
				System.out.println(Password);
				UserBean userBean = new UserBean();
				userBean.setUserName(Username);
				userBean.setPassWord(Password);
				LoginDBWrapper loginDBWrapper = new LoginDBWrapper();
				uid = loginDBWrapper.validateUser(userBean);
				if (uid == -1) {
					System.out.println("wrong username & password!");
					System.out.println(uid);
					out.writeInt(uid);
				} else {
					System.out.println("Inside user section");
					System.out.println(uid);
					out.writeInt(uid);
				}
			}
				break;
			
			case 2: // Deposit amount
			{
				
				int userId=in.read();
				int amount = in.readInt();
				AccountInfoBean accountInfoBean=new AccountInfoBean();
				accountInfoBean.setAmount(amount);
				System.out.println("in amount deposite section" + amount);

				
				UserDBWrapper userDBWrapper=new UserDBWrapper();
			//	int transactionId=userDBWrapper.insertAmount(userId,amount);
				
				
				userDBWrapper.updateAccountInfo(userId,amount);
				
			//	out.writeInt(transactionId);
//				fout.close();
//				in.close();
//				clnt.close();
				System.out.println("amount deposited suuccessfuly ");

			}
				break;
			case 3: // in withdraw section
			{
				int userId=in.read();
				int amount = in.readInt();
				//TransactionBean transactionBean=new TransactionBean();
				//transactionBean.setAmount(amount);
				System.out.println("in amount withdraw section" + amount);

				
				UserDBWrapper userDBWrapper=new UserDBWrapper();
		//		int transactionId=userDBWrapper.insertAmount(userId,amount);
				userDBWrapper.updateAccountInfoForWithdraw(userId,amount);
				//out.writeInt(transactionId);
//				fout.close();
//				in.close();
//				clnt.close();
				System.out.println("amount withdraw suuccessfuly ");
				
			}
			break;
			
			case 4: // users name Download
			{
				UserDBWrapper userDBWrapper=new UserDBWrapper();
				String username=userDBWrapper.userSName();
				System.out.println("username: "+username);
				out.writeUTF(username);
				out.flush();
				
			}
			break;
			
			case 5: // transfer section...
			{
				int userId = in.read();
				System.out.println("in amount transfer section" + userId);

				int userId2 = Integer.parseInt(in.readUTF());
				System.out.println("in amount transfer recever user" + userId2);
				
				int amount = in.readInt();
				System.out.println("Amount:" + amount);
				UserDBWrapper userDBWrapper=new UserDBWrapper();
			//	int transactionId=userDBWrapper.insertAmount(userId,amount);
			//	int transactionId2=userDBWrapper.insertAmount(userId2,amount);
				//UserDBWrapper userDBWrapper=new UserDBWrapper();
				userDBWrapper.transferMoney(userId,userId2,amount);
				
//				fout.close();
//				in.close();
//				clnt.close();
				System.out.println("amount transfer complete");
				
			}
			break;
			case 6: // transfer section...
			{
				int accountFrom = in.readInt();
				System.out.println("account from :" + accountFrom);

				int accountTo = in.readInt();
				System.out.println("account to :" + accountTo);
				
				int amount = in.readInt();
				System.out.println("Amount:" + amount);
				UserDBWrapper userDBWrapper=new UserDBWrapper();
				
				int result = userDBWrapper.transferMoneyByAccount(accountFrom,accountTo,amount);
				out.writeInt(result);
				out.flush();
//				fout.close();
//				in.close();
//				clnt.close();
				System.out.println("amount transfer complete");
				
			}
			break;
			
			default:
				System.out.println("invalid protocol...");
			} // Switch
			
			
		} // While (1);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
