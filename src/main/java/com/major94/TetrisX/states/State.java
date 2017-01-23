package com.major94.TetrisX.states;

import java.awt.Graphics;

import com.major94.TetrisX.game.Game;
import com.major94.TetrisX.input.Input;
import com.major94.TetrisX.input.Menu;
import com.major94.TetrisX.input.MouseManager;


public abstract class State {
	protected static int thighscore = 0;
	
	public static boolean allKilled = false;
	public static int score = 0;
	public static int oldScore = 0;
	
	public static int width = 0;
	public static int height = 0;
	
	public static int pWidth = 0;
	public static int pHeight = 0;
	
	final static String levelName = "LEVEL ";
	static String levelStr;
	static int level;
	
	static int worldNo;
	
	public static MouseManager mouseManager;
	
	private static State currentStatus = null;

	public static int realFps = 0;
	
	public static void setStatus(State status){		//sets actual state to state in parameters
		currentStatus = status;
	}
	
	public static State getStatus(){
		return currentStatus;
	}
	
	public static void setHighsore(int highscore){
		thighscore = highscore;
	}
	
	public static void isHighscore(int highscore){
		oldScore = highscore;
		if(highscore > thighscore){
			thighscore = highscore;
			//Data.setHighscore(highscore);
		}
	}
	
	//Class
	protected Game game;
	
	public State(Game game){
		this.game = game; 
		
	}
	public abstract void tick(Input input, MouseManager mm);
	
	public abstract void render(Graphics g);

	public abstract void init();
	
	//public abstract void delay(int time);
}
