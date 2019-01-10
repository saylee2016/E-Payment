package com.bank.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dbwrapper.UserDBWrapper;
import com.java.SMSApi.SMSApi;

public class DepositeServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			System.out.println("Inside Deposite Servlet");

			int amount =Integer.valueOf(request.getParameter("amount"));
			int userId =Integer.valueOf(request.getParameter("userid"));

			UserDBWrapper dbWrapper = new UserDBWrapper();
			String result = dbWrapper.depositeAmount(userId, amount);
			if(!result.equals(""))
			{	
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String [] mob_bal = result.split(",");
				String msg = "Rs. "+amount+" Depositeed to your A/c ************* \nYour Tot Bal: "+mob_bal[1]+" CR Avl Amt: "+mob_bal[1]+"("+dateFormat.format(date)+")";
				System.out.println("message:"+msg);
				response.sendRedirect("deposit.jsp?msg=Amount Deposite Successfull");
				try {
					SMSApi.sendSMSMesage(mob_bal[0], msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else 
			{
				response.sendRedirect("user_welcome.jsp?msg=Deposite Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
