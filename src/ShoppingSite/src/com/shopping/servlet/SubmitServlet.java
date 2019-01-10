package com.shopping.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubmitServlet
 */
@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
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
	
	
	String totalPrize = request.getParameter("totalPrize");
	String accountID= request.getParameter("accountID");
	
	System.out.println("In Submit Servlet Prize is: "+totalPrize+ "Account No :"+accountID);
	
	if (accountID !=null && totalPrize != null)
	{	
	HttpSession ss= request.getSession();
	ss.setAttribute("totalPrize", totalPrize);
	ss.setAttribute("accountID", accountID);
	response.sendRedirect("confirmPayment.jsp?msg= Now Please Confirm The Payment");
	}
	else 
	{
		response.sendRedirect("addCart.jsp?msg =Please  Fill The Account Details");
		
	}
	
	}

}
