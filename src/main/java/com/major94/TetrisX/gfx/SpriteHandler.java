package com.major94.TetrisX.gfx;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteHandler {
	
	public static BufferedImage ball, ball2, health, health_big, speed, strength;

	public static void loadSprites(){		
		ball = loadImage("ball");
		ball2 = loadImage("ball2");
		health = loadImage("heart_ball_small");
		health_big = loadImage("heart_ball");
		speed = loadImage("plus_ball_blue");
		strength = loadImage("plus_ball_green");
	}

	public static BufferedImage loadImage(String name){
		try {
			return ImageIO.read(new File("res/images/"+name+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage colorizeImage(BufferedImage image, Color color)
    {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage dyed = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = dyed.createGraphics();
        g.drawImage(image, 0,0, null);
        g.setComposite(AlphaComposite.SrcAtop);
        g.setColor(color);
        g.fillRect(0,0,w,h);
        g.dispose();
        return dyed;
    }
}