package com.bank.server;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


public class EncryptionAlgo {


	// AES encrypting
	 private static SecretKeySpec secretKey;
	    private static byte[] key;
	 
	    public static void setKey(String myKey) 
	    {
	        MessageDigest sha = null;
	        try {
	            key = myKey.getBytes("UTF-8");
	            sha = MessageDigest.getInstance("SHA-1");
	            key = sha.digest(key);
	            key = Arrays.copyOf(key, 16); 
	            secretKey = new SecretKeySpec(key, "AES");
	        } 
	        catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        } 
	        catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public static String encryptAES(String strToEncrypt, String secret) 
	    {
	        try
	        {
	            setKey(secret);
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	            return Base64.encodeBytes((cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Error while encrypting: " + e.toString());
	        }
	        return null;
	    }
	 
	    public static String decryptAES(String strToDecrypt, String secret) 
	    {
	        try
	        {
	            setKey(secret);
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	            cipher.init(Cipher.DECRYPT_MODE, secretKey);
	            return new String(cipher.doFinal(Base64.decode((strToDecrypt))));
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Error while decrypting: " + e.toString());
	        }
	        return null;
	    }
	    
	//md5 hashing
	public static String getMd5HashOf(String orgData) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance("MD5");
		StringBuffer SB = new StringBuffer();
		//convert String to md5
		String forMD5 = orgData;
		md.update(forMD5.getBytes());
		byte byteData[] = md.digest();
		for (int i = 0; i < byteData.length; i++) {
			SB.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		String resultMD5=SB.toString();
		return resultMD5;

	}
	//SHA256 hashing
	public static String getShaHashOf(String orgData)
	{
		String result = null;

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(orgData.getBytes("UTF-8"));
			return DatatypeConverter.printHexBinary(hash); // make it printable
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

}



















