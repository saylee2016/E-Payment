package com.bank.server;



import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONObject;

import com.bank.bean.AccountInfoBean;
import com.bank.bean.TransactionBean;
import com.bank.bean.UserBean;
import com.bank.dbwrapper.LoginDBWrapper;
import com.bank.dbwrapper.UserDBWrapper;
import com.java.SMSApi.SMSApi;

@Path("webService")
public class WebService {
	// private TakeAwayBean takeAwayBean = new TakeAwayBean();

	// The @Context annotation allows us to have certain contextual objects
	// injected into this class.
	// UriInfo object allows us to get URI information (no kidding).
	@Context
	UriInfo uriInfo;

	// Another "injected" object. This allows us to use the information that's
	// part of any incoming request.
	// We could, for example, get header information, or the requestor's
	// address.
	@Context
	// Request request;
	// Response response;
	HttpServletRequest request;
	HttpServletResponse response;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String respondAsReady() {
		return "Web service is ready!";
	}

	@POST
	@Path("/payamentRequest")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject registerUser(String data) {

		System.out.println("in payamentRequest");
		System.out.println(data);
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);
			System.out.println(jsonObject);

			String totalPrize = jsonObject.getString("TotalPrize");
			String accountID = jsonObject.getString("AccountID");
			String imageData = jsonObject.getString("ImageData");

			// half share from payment request
			byte [] image = Base64.decode(imageData);
			byte [] sData = new byte [10];
			// extracting the  secret pin from image
			System.arraycopy(image, image.length-10, sData, 0, 10);
			// converting secret pin into  MD5 to Check in DB 
			String secretData = new String(sData);
			System.out.println("secretData from Image:  "+secretData);
			String md5OfsecretData= EncryptionAlgo.getMd5HashOf(secretData);
			System.out.println("md5OfsecretData: "+md5OfsecretData);
			// Getting the all details from for requested AccID and SecretPin
			UserDBWrapper dbWrapper = new UserDBWrapper();
			UserBean userBean =dbWrapper.getUserDetailsByAccID(Integer.parseInt(accountID));
			AccountInfoBean accountInfoBean= dbWrapper.getAccountDetailsByAccID(Integer.parseInt(accountID),md5OfsecretData);

			if (accountInfoBean == null) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("request", "Credentials Not Matched");
				return jsonObj;
			}
			else {
			InputStream fromUser = new ByteArrayInputStream(image);
			BufferedImage bImageFromUser = ImageIO.read(fromUser);
			// half share from DB

			BufferedImage bImageFromDB = ImageIO.read(accountInfoBean.getBank_share());
			// both share passing to Decryption
			BufferedImage decryptedResult= ImageFunctions.Decrypt(bImageFromUser, bImageFromDB);
			// saving decryptedResult to Our Drive
			ByteArrayOutputStream bin=new ByteArrayOutputStream();
			ImageIO.write(decryptedResult, "png", bin );
			byte[] imageBytes=bin.toByteArray();
			File file1 = new File("D:/"+secretData+".png");
			FileOutputStream fout2= new FileOutputStream(file1);
			fout2.write(imageBytes);
			fout2.flush();
			fout2.close();
			int otp = (int)(Math.random()*9000)+1000;
			System.out.println("otp: "+otp);
			SMSApi.sendSMSMesage(userBean.getMobileNo(), "OTP is: "+otp);
			int transID=dbWrapper.insertAmount(accountInfoBean.getUserid(), Integer.parseInt(totalPrize), otp);
			// sending to 
			if (transID>0) {
				jsonObject = new JSONObject();
				jsonObject.put("request", "1");
				System.out.println(jsonObject);
			} else {
				jsonObject = new JSONObject();
				jsonObject.put("request", "Credentials Not Matched");
				System.out.println(jsonObject);
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				jsonObject = new JSONObject();
				jsonObject.put("request", "Credentials Not Matched");
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
		return jsonObject;
	}


	@POST
	@Path("/validateLogin")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject validateLogin(String data) {

		System.out.println("in validateLogin");
		System.out.println(data);

		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);
			System.out.println(jsonObject);
			String username = jsonObject.getString("userName");
			String password = jsonObject.getString("passWord");

			UserBean userBean = new UserBean();
			userBean.setUserName(username);
			userBean.setPassWord(password);

			LoginDBWrapper dbWrapper = new LoginDBWrapper();
			int result = dbWrapper.validateUser(userBean);

			if (result > 0) {
				jsonObject = new JSONObject();
				jsonObject.put("result", "Successfull");
				System.out.println(jsonObject);
			} else {
				jsonObject = new JSONObject();
				jsonObject.put("result", 0);
				System.out.println(jsonObject);
			}
		} catch (Exception e) {
			System.out.println(e);
			try {
				jsonObject = new JSONObject();
				jsonObject.put("result", -1);
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
		return jsonObject;
	}



	@POST
	@Path("/otpRequest")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject otpRequest(String data) {
		System.out.println("in otpRequest");
		System.out.println(data);
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);
			System.out.println(jsonObject);
			String otp = jsonObject.getString("OTP");
			String amount = jsonObject.getString("Amount");
			String accountID=jsonObject.getString("AccountID");
			UserDBWrapper dbWrapper = new UserDBWrapper();
			UserBean userBean= dbWrapper.getUserDetailsByAccID(Integer.parseInt(accountID));
			TransactionBean bean = new TransactionBean();
			bean.setAmount(Integer.parseInt(amount));
			bean.setOtp(Integer.parseInt(otp));
			bean.setUserId(userBean.getId());
			int trans_ID=dbWrapper.checkingOTP(bean);
			int accountiD = 0;
			if (trans_ID>0)
			{
				accountiD=dbWrapper.updateAccountInfoForWithdraw(Integer.parseInt(accountID), Integer.parseInt(amount));
			}
			else 
			{
				jsonObject = new JSONObject();
				jsonObject.put("otpRequest", "OTPDosentMatch");
				return jsonObject;
			}
			if (accountiD > 0) {
				jsonObject = new JSONObject();
				jsonObject.put("otpRequest", "Payment Successfull");
				System.out.println(jsonObject);
			} else {
				jsonObject = new JSONObject();
				jsonObject.put("otpRequest", "OTP Dosent Match");
				System.out.println(jsonObject);
			}
			
		} catch (Exception e) {
			System.out.println(e);
			try {
				jsonObject = new JSONObject();
				jsonObject.put("otpRequest", "OTP Dosent Match");
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
		return jsonObject;
	}
}
