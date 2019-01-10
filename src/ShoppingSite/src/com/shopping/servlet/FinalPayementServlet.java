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
 * Servlet implementation class FinalPayementServlet
 */
@WebServlet("/FinalPayementServlet")
public class FinalPayementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalPayementServlet() {
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
		
		String otp = request.getParameter("otpass");
		
		HttpSession ss= request.getSession();
		String prize =(String) ss.getAttribute("totalPrize");
		String accountID=(String)ss.getAttribute("accountID");
	
		WebServiceParser webServiceParser = new WebServiceParser(
				"http://localhost:8080/Bank_Server/rest/webService/");
		Map<String, String> params = new HashMap<String, String>();
		params.put("OTP",otp);
		params.put("Amount",prize);
		params.put("AccountID",accountID);
		String result= webServiceParser.otpRequest(params);
		if (result.equals("Payment Successfull"))
		{
		response.sendRedirect("index.jsp?msg="+result+"");
		}
		else 
		{
		response.sendRedirect("finalPayment.jsp?msg="+result+"");
		}
	
	}

}
