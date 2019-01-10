
package com.bank.server;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.imageio.ImageIO;

public class ImageFunctions {

	static final int BLACK = -16777216; // Constant to represent the RGB binary value of black. In binary - 1111111 00000000 00000000 00000000
	static final int WHITE = -1; // Constant to represent the RGB binary value of white. In binary - 1111111 1111111 1111111 1111111
	BufferedImage image1=null;
	BufferedImage image2=null;
	
	// Saves an image to disk at desired path
	public static void Save(BufferedImage img, File path){
		try {
			ImageIO.write( img, "png", path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Converts original image into a cipher image using the key
	public static BufferedImage Create_Cipher(BufferedImage original, BufferedImage key){

		BufferedImage cipher_image = new BufferedImage(
				original.getWidth(), original.getHeight(),
				BufferedImage.TYPE_BYTE_BINARY);

		// For every pixel in the original image, do the following:
		// 1. If the key pixel is black, flip the color of the original image and store in  cipher at identical location
		// 2. If the key pixel is white, set the cipher pixel to the same color as the original image
		for( int i = 0; i<cipher_image.getHeight(); i++){
			for(int j = 0; j<cipher_image.getWidth(); j++){
				if(key.getRGB(j, i) == BLACK){
					int temp = Get_and_Flip(original, i, j);
					cipher_image.setRGB(j, i, temp);
				}
				else{
					cipher_image.setRGB(j, i, original.getRGB(j, i));
				}
			}
		}
		return cipher_image;
	}

	// Convert a regular sized image into an image doubled in size.
	// Every original pixel will be converted into a 2x2 square as follows:
	// 1. If the original pixel was black, the 2x2 sqaure will look like:
	//        
	//                     |X| |
	//                     -----
	//                     | |X|
	//
	// 2. If the original pixel was white, the 2x2 square will look like:
	//        
	//                     | |X|
	//                     -----
	//                     |X| |
	//
	public static BufferedImage Magnify(BufferedImage img){

		BufferedImage magnified_image = new BufferedImage(
				img.getWidth()*2, img.getHeight()*2, BufferedImage.TYPE_BYTE_BINARY);

		for(int i = 0; i < img.getHeight(); i++){
			for(int j = 0; j < img.getWidth(); j++){
				if(img.getRGB(j, i) == BLACK){
					//        
					//                     |X| |
					//                     -----
					//                     | |X|
					//
					magnified_image.setRGB(j*2, i*2, BLACK);
					magnified_image.setRGB(j*2+1, i*2, WHITE);
					magnified_image.setRGB(j*2, i*2+1, WHITE);
					magnified_image.setRGB(j*2+1, i*2+1, BLACK);

				}
				else{
					//        
					//                     | |X|
					//                     -----
					//                     |X| |
					//
					magnified_image.setRGB(j*2, i*2, WHITE);
					magnified_image.setRGB(j*2+1, i*2, BLACK);
					magnified_image.setRGB(j*2, i*2+1, BLACK);
					magnified_image.setRGB(j*2+1, i*2+1, WHITE);
				}
			}
		}
		return magnified_image;
	}

	
	// Get the color of a particular bit and return the inverse of that color
	public static int Get_and_Flip(BufferedImage img, int i, int j){

		int initial = img.getRGB(j, i);

		if(initial == BLACK){
			return WHITE;
		}
		else{
			return BLACK;
		}
	}

	// Combine the two decrypted images together and return the result as output
	public static BufferedImage Decrypt(BufferedImage image1, BufferedImage image2) {

		System.out.println(" In Bufferd Decrypt Image: "+image1);
		System.out.println(" In Bufferd Decrypt Image: "+image2);
		// Ensure images are the same size 
		
		if (image1.getHeight() != image2.getHeight() || image1.getWidth() != image2.getWidth()) {
			System.out.println("The size's of your selected images are mismatched");
			return null;
		}

		//Create a new buffered image to hold the decryption
		BufferedImage output = new BufferedImage(
				image1.getWidth(), image1.getHeight(), BufferedImage.TYPE_BYTE_BINARY);

		for (int i = 0; i < image1.getHeight(); i += 2) {
			for (int j = 0; j < image1.getWidth(); j += 2) {
				if (image1.getRGB(j, i) == BLACK && image2.getRGB(j+1,  i) == BLACK){
					output.setRGB(j, i, BLACK);
					output.setRGB(j+1, i, BLACK);
					output.setRGB(j, i+1, BLACK);
					output.setRGB(j+1, i+1, BLACK);
				}
				else if (image1.getRGB(j, i) == WHITE && image2.getRGB(j+1,  i) == WHITE){
					output.setRGB(j, i, BLACK);
					output.setRGB(j+1, i, BLACK);
					output.setRGB(j, i+1, BLACK);
					output.setRGB(j+1, i+1, BLACK);
				}
				else {
					output.setRGB(j, i, WHITE);
					output.setRGB(j+1, i, WHITE);
					output.setRGB(j, i+1, WHITE);
					output.setRGB(j+1, i+1, WHITE);
				}

			}
		}
		return output;
	}

	
	
	public void generateVisualImages(BufferedImage originalImage)
	{

		new File("D:\\abcd").mkdirs();
		
		// Save and display black and white image file
		File ogImage = new File("D:\\abcd\\ogImage.png");
		ImageFunctions.Save(originalImage, ogImage);
		
		// Create image key
		BufferedImage key_image = new BufferedImage(
				originalImage.getWidth(), originalImage.getHeight(),
		        BufferedImage.TYPE_BYTE_BINARY);
		
		// Generate a random key
		//Random rand = new Random();
		try {
			SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
			
			for(int i = 0; i < key_image.getHeight(); i++){
				for(int j = 0; j < key_image.getWidth(); j++){
					
					int result = secureRandomGenerator.nextInt(100);
					if(result < 50){
						key_image.setRGB(j, i, WHITE);
					}
					else{
						key_image.setRGB(j, i, BLACK);
					}
				}
			}
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		// Save and display key image file					
		ImageFunctions.Save(key_image, new File("D:\\abcd\\key_file.png"));
		
		// Save and display magnified key image file
		BufferedImage magnified_key_image = ImageFunctions.Magnify(key_image);
		ImageFunctions.Save(magnified_key_image, new File("D:\\abcd\\image1.png"));
		image1=magnified_key_image;
		
		// Save and display magnified cipher image file
		BufferedImage magnified_cipher_image = ImageFunctions.Magnify(ImageFunctions.Create_Cipher(originalImage, key_image));
		ImageFunctions.Save(magnified_cipher_image, new File("D:\\abcd\\image2.png"));
		image2=magnified_cipher_image;
	
	}
	
	
	public BufferedImage getImage1 ()
	{
		return image1;
	}
	
	public BufferedImage getImage2 ()
	{
		return image2;
	}
	
	
	
}

