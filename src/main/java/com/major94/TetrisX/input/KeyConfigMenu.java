package com.major94.TetrisX.input;

import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class KeyConfigMenu {

	private final static int DEF_WIDTH = 300;
	private final static int DEF_HEIGHT = 100;

	private int width;
	private int height;

	Button[] buttons;
	public int pressedButton;

	private Boolean noForced;

	private int forcedButton;

	public KeyConfigMenu(int xMiddle, int yTop, String[] labels){

		this(xMiddle, yTop, labels, DEF_WIDTH, DEF_HEIGHT);
	}

	public KeyConfigMenu(int xMiddle, int yTop, Object[] labels, int width, int height){

		this.width = width;
		this.height = height;

		pressedButton = -1;

		noForced = true;
		forcedButton = 0;

		buttons = new Button[labels.length];

		for(int i=0; i<buttons.length; i++){
			buttons[i] = new Button(xMiddle-width/2, yTop+i*(height+10), width, height, labels[i].toString(), (int) (height*0.5));
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

		if(input.isClicked(Key.DOWN)){
			if(noForced){
				forcedButton = 0;
				buttons[forcedButton].forced = true;
				noForced = false;
			}
			else{
				for(int i=0; i<buttons.length; i++){
					buttons[i].forced = false;
				}

				forcedButton++;
				if(forcedButton>=buttons.length){
					forcedButton = 0;
				}

				buttons[forcedButton].forced = true;
			}
		}

		if(input.isClicked(Key.UP)){
			if(noForced){
				forcedButton = buttons.length-1;
				buttons[forcedButton].forced = true;
				noForced = false;
			}
			else{
				for(int i=0; i<buttons.length; i++){
					buttons[i].forced = false;
				}

				forcedButton--;
				if(forcedButton<0){
					forcedButton = buttons.length-1;
				}

				buttons[forcedButton].forced = true;
			}
		}

		for(int i=0; i<buttons.length; i++){
			buttons[i].tick(input, mm);
			if(buttons[i].clicked){
				pressedButton = i;
				buttons[i].forced = false;
				forcedButton = 0;
				noForced = true;
			}
		}

		if(input.isClicked(Key.ENTER)){
			for(int i=0; i<buttons.length; i++){
				if(buttons[i].forced){
					pressedButton = i;
					buttons[i].forced = false;
					forcedButton = 0;
					noForced = true;
				}
			}
		}

		for(int i=0; i<buttons.length; i++){
			if(buttons[i].mouseOnIt){
				noForced = true;
				for(int j=0; j<buttons.length; j++){
					buttons[j].forced = false;
				}
				break;
			}
		}

	}
}
