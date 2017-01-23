package com.major94.TetrisX.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.major94.TetrisX.game.Game;
import com.major94.TetrisX.input.Input;
import com.major94.TetrisX.input.MouseManager;

public class HighScoreState extends State{

	public HighScoreState(Game game){
		super(game);
		
		//TODO LABEL erstellen		
	}


	@Override
	public void tick(Input input, MouseManager mm) {
		/*
		if(km.isPressed(KeyEvent.VK_ENTER)){
			score = 0;
			if(allKilled){

			}
			allKilled = false;
			game.gameState.init();
			setStatus(game.gameState);
		}
		*/
	}


	@Override
	public void render(Graphics g) {
		g.drawString("Enemies killed: "+score, 50, 50);
		if(allKilled){
			g.drawString("Congratulation! You killed every Enemy!", 50, 100);
		}
	}


	@Override
	public void init() {
		
	}
	
}
