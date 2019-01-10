package com.bank.servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.bean.AccountInfoBean;
import com.bank.bean.UserBean;
import com.bank.dbwrapper.UserDBWrapper;
import com.bank.server.EncryptionAlgo;
import com.bank.server.ImageFunctions;
import com.bank.server.ImageGenerator;
import com.bank.server.SendingEmail;
import com.java.SMSApi.SMSApi;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		BufferedImage image1=null;
		BufferedImage image2=null;

		try {

			System.out.println("Inside  User Registration Servlet");
			UserBean userBean = new UserBean();
			AccountInfoBean accountInfoBean=new AccountInfoBean();
			userBean.setFirstName(request.getParameter("firstName"));
			userBean.setLastName(request.getParameter("lastName"));
			userBean.setGender(request.getParameter("gender"));
			userBean.setEmailId(request.getParameter("emailId"));
			userBean.setMobileNo(request.getParameter("mobileNo"));
			userBean.setUserName(request.getParameter("userName"));
			userBean.setPassWord(request.getParameter("passWord"));
			UserDBWrapper userDBWrapper = new UserDBWrapper();
			// checking username duplication
			int id =userDBWrapper.checkUsername(request.getParameter("userName"));
			System.out.println("id: "+id);
			if (id> 0)
			{
				response.sendRedirect("register.jsp?msg=Username Already Exists");
			}else{
				int userid = userDBWrapper.insertUser(userBean);
				String temp = request.getParameter("secret_pin");
				String value = temp.substring(0, 10);
				// converting Secret_Pin into MD5			
				String md5Secret_Pin= EncryptionAlgo.getMd5HashOf(value);
				accountInfoBean.setSecretPin(md5Secret_Pin);
				accountInfoBean.setAccountType(request.getParameter("accountType"));
				accountInfoBean.setMinBalance(Integer.parseInt(request.getParameter("minimumBalance")));
				accountInfoBean.setUserid(userid);

				// calling ImageGenerator to create image with Secret_Pin
				BufferedImage orImage =	ImageGenerator.mainFunction(
						value, 350, 100,
						"D:/abc.png", "" );

				// created image passing to ImageFunctions for Visual CryptoGraphy it will generate two shares
				ImageFunctions imagefunction= new ImageFunctions();
				imagefunction.generateVisualImages(orImage);

				image1=imagefunction.getImage1();
				image2=imagefunction.getImage2();
				// writing one image to drive to save into database and one will send to the users email

				ByteArrayOutputStream baos=new ByteArrayOutputStream();
				ImageIO.write(image1, "png", baos );
				byte[] imageBytes = baos.toByteArray();
				System.out.println("imageBytes Len:" + imageBytes.length);

				File file1 = new File("D:/image1.png");
				FileOutputStream fout= new FileOutputStream(file1);
				fout.write(imageBytes);
				fout.flush();
				fout.close();
				FileInputStream fin = new FileInputStream(file1);
				accountInfoBean.setBank_share(fin);

				file1 = new File("D:/abcd/image2.png");
				FileInputStream readFin = new FileInputStream(file1);
				int byteToRead = 0;
				byte [] bytetoEmail= new byte [(int)file1.length()];
				while(byteToRead < bytetoEmail.length)
				{
					byteToRead += readFin.read(bytetoEmail, byteToRead, bytetoEmail.length - byteToRead);					
				}
				readFin.close();

				System.out.println("value.getBytes().length:" + value.getBytes().length);
				System.arraycopy(value.getBytes(), 0, bytetoEmail, bytetoEmail.length - value.getBytes().length, value.getBytes().length);

				fout = new FileOutputStream(file1);
				fout.write(bytetoEmail);
				fout.flush();
				fout.close();

				SendingEmail.sendEmail(request.getParameter("emailId"));
				int accountid = userDBWrapper.insertAccountInfo(accountInfoBean);
				if (userid == -1 && accountid==-1) {
					response.sendRedirect("error.jsp");
				} 
				else 
				{
					response.sendRedirect("viewuser.jsp");
					SMSApi.sendSMSMesage(userBean.getMobileNo(),"Hello Your Account Succsessfully Created. Login Info \nUserName: "+userBean.getUserName() +"\nPassword: "+userBean.getPassWord()+"\nA/c ID:"+accountid+"\n for further details check your mail");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
