package com.major94.TetrisX.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.major94.TetrisX.game.Game;
import com.major94.TetrisX.input.Menu;
import com.major94.TetrisX.input.MouseManager;
import com.major94.TetrisX.other.Tools;

public class PauseState extends State{

	boolean ready;
	Font font;
	final Color BACKGROUND = new Color(50,50,50,150);

	public PauseState(Game game) {
		super(game);

		ready = false;
		font = new Font("Arial", 1, 50);
		
		menu = new Menu(pWidth/2,250,new String[]{"RETURN","OPTIONS","EXIT"});
	}

	@Override
	public void tick(MouseManager mm) {
		/*
		if(km.isPressed(KeyEvent.VK_P)){
			if(ready){
				ready = false;
				setStatus(game.gameState);
			}
		}
		else {
			ready = true;
		}

		menu.tick(km, mm);

		if(menu.buttonPressed("RETURN")){
			ready = false;
			setStatus(game.gameState);
		}
		if(menu.buttonPressed("OPTIONS")){
			ready = false;
			setStatus(game.optionsState);
		}
		if(menu.buttonPressed("EXIT")){
			System.exit(0);
		}
		*/
	}

	@Override
	public void render(Graphics g) {
		game.gameState.render(g);
		g.setColor(BACKGROUND);
		g.fillRect(0, 0, pWidth, pHeight);
		Tools.drawCenteredString(0,0,pWidth, pHeight/2, "PAUSED", font, Color.WHITE, g);
		
		menu.render(g);
	}

	@Override
	public void init() {
		
	}

}
