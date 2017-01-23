package com.major94.TetrisX.input;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.major94.TetrisX.other.Tools;

public class Button {
	
	int x, y;
	int width, height;
	
	public boolean mouseOnIt;
	public boolean pressed;
	public boolean clicked;
	public boolean forced;
	
	public String label;
	
	Font font, unpressedFont, pressedFont;

	public Button(int x, int y, int width, int height, String label, int fontSize) {
		this.x = x;
		this.y = y;
		this.label = label;
		
		this.width = width;
		this.height = height;
		
		mouseOnIt = false;
		pressed = false;
		clicked = false;
		forced = false;
		
		unpressedFont = new Font("Arial", 1, fontSize);
		pressedFont = new Font("Arial", 1, (int) (fontSize*0.9));
	}
	
	public Button(int x, int y, int width, int height, String label) {

		this(x,y,width,height,label,30);
	}

	public void render(Graphics g) {
		font = unpressedFont;
		if(pressed){
			g.setColor(new Color(220,220,220));
			font = pressedFont;
		}
		else if(mouseOnIt || forced){
			g.setColor(new Color(190,190,190));
		}
		else {
			g.setColor(new Color(150,150,150));
		}
		
		g.fillRect(x, y, width, height);
		Tools.drawCenteredString(x, y, width, height, label, font, Color.DARK_GRAY, g);
	}

	public void tick(Input input, MouseManager mm) {
		clicked = false;
		if(contains(mm.x, mm.y)){
			forced = false;
			
			if(pressed && !mm.pressed){
				clicked = true;
			}
			mouseOnIt = true;
			pressed = mm.pressed;
		}
		else {
			mouseOnIt = false;
			pressed = false;
		}
	}

	public boolean contains(int x, int y){
		if(x >= this.x && x <= this.x+width){
			if(y >= this.y && y <= this.y+height){
				return true;
			}
		}
		return false;
	}
}
