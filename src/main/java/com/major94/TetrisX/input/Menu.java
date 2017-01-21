package com.major94.TetrisX.input;

import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Menu {
	
	private final int width = 200;
	private final int heigth = 100;
	
	Button[] buttons;
	public int pressedButton;
	
	private Boolean ready;
	
	private int forcedButton;
	
	public Menu(int xMiddle, int yTop, String[] labels){
		
		pressedButton = -1;
		
		ready = true;
		forcedButton = 0;
		
		buttons = new Button[labels.length];
		
		for(int i=0; i<buttons.length; i++){
			buttons[i] = new Button(xMiddle-width/2, yTop+i*(heigth+10), width, heigth, labels[i]);
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

	public void tick(MouseManager mm) {
		
		pressedButton = -1;
		
		/*
		if(km.isPressed(KeyEvent.VK_TAB)){
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
			buttons[i].tick(km, mm);
			if(buttons[i].clicked){
				pressedButton = i;
				buttons[i].forced = false;
				forcedButton = 0;
			}
		}
		
		if(km.isPressed(KeyEvent.VK_ENTER)){
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
		*/
	}
}
