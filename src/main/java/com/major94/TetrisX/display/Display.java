package com.major94.TetrisX.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.major94.TetrisX.game.Game;
import com.major94.TetrisX.states.State;

public class Display {

	private JFrame frame;
	private Canvas canvas;
//	private Game game;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private String title;
	private int width, height;
	
	private Font font;
	
	public Display(Game game, String title, int width, int height){
//		this.game = game;
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public void render(){
		bs = canvas.getBufferStrategy();
		if(bs == null){
			canvas.createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		font = g.getFont();
		
		if(State.getStatus() != null){	//Wenn ein aktueller State vorhanden ist
			State.getStatus().render(g);	//aktueller State Tick ausf�hren
		}
		
		//TODO necessary?
		g.setFont(font);
		g.drawString(State.realFps+" fps", width-g.getFontMetrics().stringWidth(State.realFps+" fps"), 10);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}

	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
}