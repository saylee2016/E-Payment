package com.shopping.servlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import webservices.Base64;
import webservices.WebServiceParser;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
@MultipartConfig(maxFileSize = 16177215)
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageServlet() {
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
		InputStream inputStream = null;
		Part filePart =request.getPart("imagePassword");
		HttpSession ss= request.getSession();
		String prize =(String) ss.getAttribute("totalPrize");
		String accountID=(String)ss.getAttribute("accountID");
		if (filePart != null) 
		{
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			System.out.println(prize);
			inputStream = filePart.getInputStream();
		}

		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		int reads = inputStream.read();
		while(reads != -1)
		{ 
			baos.write(reads);
			reads = inputStream.read(); 
		}
		byte [] image=  baos.toByteArray();
		File file = new File("D:/abc1.jpeg");
		FileOutputStream fout= new FileOutputStream(file);
		fout.write(image);
		fout.flush();
		fout.close(); 

		String imagedata = Base64.encodeBytes(image);
		WebServiceParser webServiceParser = new WebServiceParser(
				"http://localhost:8080/Bank_Server/rest/webService/");

		Map<String, String> params = new HashMap<String, String>();
		params.put("TotalPrize",prize);
		params.put("AccountID", accountID);
		params.put("ImageData", imagedata);
		String result= webServiceParser.payamentRequest(params);
		if(result.equals(""))
		{
			response.sendRedirect("confirmPayment.jsp?msg=Error  ");
		}
		else if(result.equals("1")) 
		{
			response.sendRedirect("finalPayment.jsp?msg=Please Enter OTP here" );
		}
		else
		{
			response.sendRedirect("confirmPayment.jsp?msg="+result+"");
		}


	}

}
