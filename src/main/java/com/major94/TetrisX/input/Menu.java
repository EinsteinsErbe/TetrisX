package com.major94.TetrisX.input;

import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Menu {

	private final static int DEF_WIDTH = 200;
	private final static int DEF_HEIGHT = 100;
	
	private int width;
	private int height;

	Button[] buttons;
	public int pressedButton;

	private Boolean ready;

	private int forcedButton;

	public Menu(int xMiddle, int yTop, String[] labels){
		
		this(xMiddle, yTop, labels, DEF_WIDTH, DEF_HEIGHT);
	}

	public Menu(int xMiddle, int yTop, String[] labels, int width, int height){
		
		this.width = width;
		this.height = height;
		
		pressedButton = -1;

		ready = true;
		forcedButton = 0;

		buttons = new Button[labels.length];

		for(int i=0; i<buttons.length; i++){
			buttons[i] = new Button(xMiddle-width/2, yTop+i*(height+10), width, height, labels[i], (int) (height*0.3));
		}
	}

	public boolean buttonPressed(String label){
		if(pressedButton == -1){
			return false;
		}
		return (buttons[pressedButton].label == label);
	}

	public void render(Graphics g) {
		for(int i=0; i<buttons.length; i++){
			buttons[i].render(g);
		}
	}

	public void tick(Input input, MouseManager mm) {

		pressedButton = -1;

		//TAB
		if(input.isClicked(Key.DOWN)){
			if(ready){
				for(int i=0; i<buttons.length; i++){
					buttons[i].forced = false;
				}
				buttons[forcedButton].forced = true;
				forcedButton++;
				if(forcedButton>=buttons.length){
					forcedButton = 0;
				}
				ready = false;
			}
		}
		else {
			ready = true;
		}

		for(int i=0; i<buttons.length; i++){
			buttons[i].tick(input, mm);
			if(buttons[i].clicked){
				pressedButton = i;
				buttons[i].forced = false;
				forcedButton = 0;
			}
		}

		if(input.isClicked(Key.ENTER)){
			for(int i=0; i<buttons.length; i++){
				if(buttons[i].forced){
					pressedButton = i;
					buttons[i].forced = false;
					forcedButton = 0;
				}
			}
		}

		for(int i=0; i<buttons.length; i++){
			if(buttons[i].mouseOnIt){
				for(int j=0; j<buttons.length; j++){
					buttons[j].forced = false;
				}
				break;
			}
		}

	}
}
