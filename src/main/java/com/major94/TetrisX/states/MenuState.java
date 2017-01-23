package com.major94.TetrisX.states;

import java.awt.Graphics;

import com.major94.TetrisX.game.Game;
import com.major94.TetrisX.input.Input;
import com.major94.TetrisX.input.Menu;
import com.major94.TetrisX.input.MouseManager;

public class MenuState extends State{
	
	Menu menu;

	public MenuState(Game game){
		super(game);

		menu = new Menu(pWidth/2,100,new String[]{"START","OPTIONS","EXIT"});
	}

	@Override
	public void tick(Input input, MouseManager mm) {

		menu.tick(input, mm);

		if(menu.buttonPressed("START")){
			setStatus(game.gameState);
		}
		if(menu.buttonPressed("OPTIONS")){
			setStatus(game.optionsState);
		}
		if(menu.buttonPressed("EXIT")){
			System.exit(0);
		}
	}

	@Override
	public void render(Graphics g) {
		menu.render(g);
	}

	@Override
	public void init() {
		
	}
}


