package com.major94.TetrisX.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.major94.TetrisX.game.Game;
import com.major94.TetrisX.input.Button;
import com.major94.TetrisX.input.Input;
import com.major94.TetrisX.input.Menu;
import com.major94.TetrisX.input.MouseManager;
import com.major94.TetrisX.other.Tools;

public class OptionsState extends State{
	
	String text = "";
	String arrowText = "Arrow-Keys as Direction";
	String keyText = "ASDW-Keys as Direction";
	
	Font font;
	
	Button pressedButton, arrow, key;

	public OptionsState(Game game) {
		super(game);
		
		font = new Font("Arial", 1, 30);
		
		menu = new Menu(pWidth/2,200,new String[]{"MENU","ARROWS","ASDW"}, 100, 50);
		
		text = arrowText;
	}

	@Override
	public void tick(Input input, MouseManager mm) {
		
		menu.tick(input, mm);

		if(menu.buttonPressed("MENU")){
			setStatus(game.menuState);
		}
		if(menu.buttonPressed("ARROWS")){
			text = arrowText;
		}
		if(menu.buttonPressed("ASDW")){
			text = keyText;
		}
	}

	@Override
	public void render(Graphics g) {
		menu.render(g);

		Tools.drawCenteredString(0, 0, pWidth, 200, text, font, Color.BLACK, g);
	}

	@Override
	public void init() {
		
	}
}
