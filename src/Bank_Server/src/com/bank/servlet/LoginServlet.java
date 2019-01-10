package com.bank.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.bean.UserBean;
import com.bank.dbwrapper.LoginDBWrapper;

public class LoginServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			System.out.println("Inside  User Login Servlet");

			HttpSession session = request.getSession(true);
			String username=request.getParameter("userName");
			String password=request.getParameter("passWord");
			UserBean userBean = new UserBean();
			userBean.setUserName(username);
			userBean.setPassWord(password);

			if(username.equals("admin") && password.equals("111"))
			{
				session.setAttribute("role", "ADMIN");
				response.sendRedirect("admin_welcome.jsp");
			}
			else
			{
				LoginDBWrapper dbWrapper = new LoginDBWrapper();
				int result = dbWrapper.validateUser(userBean);
				if(result > 0)
				{
					session.setAttribute("USERID", result);
					session.setAttribute("role", "USER");
					response.sendRedirect("user_welcome.jsp");
				}
				else 
				{
					response.sendRedirect("login.jsp?msg=Invalid UserName and Password");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
