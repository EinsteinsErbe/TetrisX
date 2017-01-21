package com.major94.TetrisX.sound;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;
import static javax.sound.sampled.AudioSystem.getClip;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {

	final static String PATH = "res/sounds/";

	static Clip clip, clip2, clip3;

	static File[] gun = {new File(PATH+"gun.wav"), new File(PATH+"gun2.wav"), new File(PATH+"gun3.wav")};
	static File item = new File(PATH+"item.wav");

	static boolean init = false;

	static AudioInputStream audioInputStream;

	
	//------mit Volume Anpassung
	//Sound.gainControl.setValue(Sound.gainControl.getValue()+5);
	public static FloatControl gainControl;

	public static void play() throws Exception {
		AudioInputStream audioInputStream = getAudioInputStream(Sound.class.getResource("/sounds/Tetris.wav"));
		Clip clip = getClip();
		clip.open(audioInputStream);
		gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
		print();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
	}

	public static void print(){
		System.out.println(gainControl.getMinimum()+" "+gainControl.getMaximum()+" "+gainControl.getValue());
	}
	//------
	
	public static void init(){
		try {
			clip = getClip();
			clip2 = getClip();
			clip3 = getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		init = true;
	}

	public static void play(String name){
		if(init){
			clip.stop();
			clip.flush();
			clip.close();

			try {

				clip.open(loadAudioFile(name));

			} catch (IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		}
	}

	public static void resume() {	
		if(init) clip.start();
	}

	public static void stop() {	
		if(init) clip.stop();
	}

	public static void playShot(int i){	
		if(init){
			clip2.stop();
			clip2.flush();
			clip2.close();

			if(i<0){
				return;
			}
			if(i>=gun.length){
				i = gun.length-1;
			}

			try {
				audioInputStream = getAudioInputStream(gun[i]);
				clip2.open(audioInputStream);

			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
			clip2.start();
		}
	}

	public static void playItemPickup(){
		if(init){
			clip3.stop();
			clip3.flush();
			clip3.close();

			try {
				audioInputStream = getAudioInputStream(item);
				clip3.open(audioInputStream);

			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
			clip3.start();
		}
	}

	private static AudioInputStream loadAudioFile(String name){
		try {
			return getAudioInputStream(Sound.class.getResource("/sounds/"+name+".wav"));
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}