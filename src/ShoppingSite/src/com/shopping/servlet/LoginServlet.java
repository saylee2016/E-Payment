package com.shopping.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webservices.WebServiceParser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			
		
		String username=request.getParameter("userName");
		String password=request.getParameter("passWord");
		HttpSession session = request.getSession(true);

		WebServiceParser webServiceParser = new WebServiceParser(
				"http://localhost:8080/Bank_Server/rest/webService/");

		Map<String, String> params = new HashMap<String, String>();
		params.put("userName",username);
		params.put("passWord", password);
		String name= webServiceParser.validateLogin(params);
		System.out.println("After The webParcer Called and getting result: "+name);
		if (name != null && name.equals("Successfull"))
		{
			session.setAttribute("role", "USER");
			response.sendRedirect("shop.jsp");
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
