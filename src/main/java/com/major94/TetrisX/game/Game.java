package com.major94.TetrisX.game;
import java.awt.event.KeyEvent;

import com.major94.TetrisX.display.Display;
import com.major94.TetrisX.gfx.SpriteHandler;
import com.major94.TetrisX.input.Input;
import com.major94.TetrisX.input.Key;
import com.major94.TetrisX.input.MouseManager;
import com.major94.TetrisX.other.Tools;
import com.major94.TetrisX.sound.Sound;
import com.major94.TetrisX.states.GameState;
import com.major94.TetrisX.states.HighScoreState;
import com.major94.TetrisX.states.MenuState;
import com.major94.TetrisX.states.OptionsState;
import com.major94.TetrisX.states.PauseState;
import com.major94.TetrisX.states.State;


public class Game implements Runnable {

	final String title = "Game-Grundlage";
	final int FPS = 60;

	final int NANOS_PER_SEC = 1000000000;
	int time = 0;

	public Input input;

	public State gameState;
	public State menuState;
	public State optionsState;
	public State highScoreState;
	public State pauseState;

	Display display;

	public MouseManager mm;


	void start(){
		SpriteHandler.loadSprites();

		Sound.init();
		Sound.play("menu2");
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		optionsState = new OptionsState(this);
		highScoreState = new HighScoreState(this);
		pauseState = new PauseState(this);
		State.setStatus(menuState);
		
		input = new Input();

		mm = new MouseManager();
		
		display = new Display(this, title, State.width*32, State.height*32);
		display.getFrame().setFocusTraversalKeysEnabled(false);
		display.getCanvas().addMouseListener(mm);
		display.getCanvas().addMouseMotionListener(mm);
		
		//Test key setting
		input.setGamePadKey(Key.UP);

		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		double timePerTick = NANOS_PER_SEC / FPS;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while(true){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if(delta >= 1){
				tick();
				display.render();
				ticks++;
				while(delta >= 1)delta--;
			}

			if(timer >= NANOS_PER_SEC){
				time++;
				System.out.println(ticks+" fps\t\tTime: "+Tools.createSpace(4-Tools.intLength(time))+time+" s");
				State.realFps = ticks;
				ticks = 0;
				timer = 0;
			}
		}		
	}

	private void tick() {
		input.poll();
		
		for(Key k:Key.values()){
			if(input.isClicked(k)){
				System.out.println(k.toString()+" is pressed!");
			}
		}
		
		/*
		if(km.isPressed(KeyEvent.VK_ESCAPE)){
			System.exit(0);
		}
		*/
		if(State.getStatus() != null){	//Wenn ein aktueller State vorhanden ist
			//State.getStatus().tick(km, mm);	//aktueller State Tick ausführen
		}
	}
}
