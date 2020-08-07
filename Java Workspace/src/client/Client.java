package client;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Client {
	
	// Instance Variables
	public static BufferedImage image;
	public static int[] res = new int[2];
	public static Color[][] colorArray = new Color[255][255];
	public static Color c;
	public static int red;
	public static int green;
	public static int blue;
	
	// Getters
	public static BufferedImage getImage() {
		return image;
	}
	public static int[] getRes() {
		return res;
	}
	
	// Setters
	public static void setImage(String directory) {
		try {
			image = ImageIO.read(new File(directory));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setRes() {
		res[0] = image.getWidth();
		res[1] = image.getHeight();
	}
	
	public static void colorArray() {
		for (int i = 0; i < 255; i++) {
			for (int j = 0; j < 255; j++) {
				int rgb = getImage().getRGB(i, j);
				Color c = new Color (rgb);
				red = c.getRed();
				green = c.getGreen();
				blue = c.getBlue();
				colorArray[i][j] = c;
			}
		}
	}
	// Constructors
	
	// Instance Methods 
	public static void resizeImage() { // method to resize images to 255x255 for conversion
		BufferedImage dimg = new BufferedImage(255, 255, BufferedImage.TYPE_INT_ARGB); 
		// set dimensions to 255x255 because java array limit is 255. serum has max 256 waveforms per wavetable anyway
		
		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
		image = dimg;
	}
	public static void printRes() { // print resolution
		System.out.println(res[0] + "x" + res[1]);
	}
	
	
	// Void Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		setImage("C:\\Users\\LF\\Pictures\\1.jpg"); // retrieving image
		resizeImage();
		setRes(); 
		printRes(); // methods exist just to make sure resizing has happened
		colorArray();
		System.out.println(colorArray[221][241]);
		
	}

}
