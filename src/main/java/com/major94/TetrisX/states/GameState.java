package com.major94.TetrisX.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.major94.TetrisX.game.Game;
import com.major94.TetrisX.input.Input;
import com.major94.TetrisX.input.Key;
import com.major94.TetrisX.input.MouseManager;
import com.major94.TetrisX.other.Tools;
import com.major94.TetrisX.sound.Sound;

public class GameState extends State{

	boolean started;	//Spiel läuft

	Point randPos;
	double itemProb;
	double probFactor;

	Font titleFont;

	final String[] worldNames = {"world1", "world2"};

	public GameState(Game game){
		super(game);

		titleFont = new Font("Arial", 1, (int)(60));
		level = 1;
		worldNo = 0;


		width = 30;
		height = 20;

		pWidth = 32*width;
		pHeight = 32*height;

		init();
	}

	@Override
	public void init(){
		itemProb = 0.000002;
		probFactor = 0;

		levelStr = levelName+level+"-"+(worldNo+1);

		started = false;
	}

	@Override
	public void tick(Input input, MouseManager mm) {

		if(input.isClicked(Key.ENTER)){
			Sound.play("hawkee");
		}

		if(input.isClicked(Key.PAUSE)){
			setStatus(game.pauseState);
		}
	}

	@Override
	public void render(Graphics g) {

		if(!started){
			Tools.drawCenteredString(0, 0, pWidth, pHeight, levelStr, titleFont, Color.BLACK, g);
		}
	}
}
