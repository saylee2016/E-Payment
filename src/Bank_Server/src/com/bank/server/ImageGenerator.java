package com.bank.server;


//QR encoder
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageGenerator {

	public static BufferedImage mainFunction(String string,int h,int w, String imgPath, String imageName) {

		int width =h;
		int height = w;
		// Constructs a BufferedImage of one of the predefined image types.
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// Create a graphics which can be used to draw into the buffered image
		Graphics2D g2d = bufferedImage.createGraphics();
		// fill all the image with white
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, width, height);
		// create a circle with black
		// create a string with yellow
		g2d.setColor(Color.black);
		g2d.setFont(new Font("String", Font.BOLD,30));
		string=string.replace("", " ").trim();
		g2d.drawString(string, 75, 65);
		// Disposes of this graphics context and releases any system resources that it is using.
		g2d.dispose();
		// Save as PNG
		String filePath = imgPath+imageName;
		System.out.println("filePath:" + filePath);
		File file = new File(filePath);
		try
		{
			ImageIO.write(bufferedImage, "png", file);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		return bufferedImage;
	}
	
	
	
	
}