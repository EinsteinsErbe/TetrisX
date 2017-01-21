package com.major94.TetrisX.states;

import java.awt.Graphics;

import com.major94.TetrisX.game.Game;
import com.major94.TetrisX.input.Menu;
import com.major94.TetrisX.input.MouseManager;

public class MenuState extends State{

	public MenuState(Game game){
		super(game);

		menu = new Menu(pWidth/2,100,new String[]{"START","OPTIONS","EXIT"});
	}

	@Override
	public void tick(MouseManager mm) {

		menu.tick(mm);

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


