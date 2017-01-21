package com.major94.TetrisX.input;

import net.java.games.input.Component;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Component.Identifier.Axis;
import net.java.games.input.Component.Identifier.Button;
import net.java.games.input.Component.POV;
import net.java.games.input.Controller;

public class Input implements StandardInput{

	static JInputJoystick gamepad;
	static JInputJoystick keyboard;



	public Input() {
		init();
	}

	public void init(){
		Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();

		keyboard = new JInputJoystick(Controller.Type.KEYBOARD);
		gamepad = new JInputJoystick(Controller.Type.GAMEPAD, Controller.Type.STICK);

		setDefaultKeys();
	}

	@Override
	public boolean isClicked(Key key){
		boolean state = false;
		if(gamepad.isControllerConnected()){
			state = state || gamepad.isClicked(key);
		}
		if(keyboard.isControllerConnected()){
			state = state || keyboard.isClicked(key);
		}
		return state;
	}

	@Override
	public boolean isPressed(Key key) {
		boolean state = false;
		if(gamepad.isControllerConnected()){
			state = state || gamepad.isPressed(key);
		}
		if(keyboard.isControllerConnected()){
			state = state || keyboard.isPressed(key);
		}
		return state;
	}

	private void setDefaultKeys(){
		gamepad.setKey(Key.UP, POV.UP);
		gamepad.setKey(Key.DOWN, POV.DOWN);
		gamepad.setKey(Key.LEFT, POV.LEFT);
		gamepad.setKey(Key.RIGHT, POV.RIGHT);
		gamepad.setKey(Key.ENTER, Button._0);
		gamepad.setKey(Key.DROP, Button._1);
		gamepad.setKey(Key.PAUSE, Button._9);
		gamepad.setKey(Key.R_LEFT, Button._4);
		gamepad.setKey(Key.R_RIGHT, Button._5);

		keyboard.setKey(Key.UP, Identifier.Key.UP);
		keyboard.setKey(Key.DOWN, Identifier.Key.DOWN);
		keyboard.setKey(Key.LEFT, Identifier.Key.LEFT);
		keyboard.setKey(Key.RIGHT, Identifier.Key.RIGHT);
		keyboard.setKey(Key.ENTER, Identifier.Key.RETURN);
		keyboard.setKey(Key.DROP, Identifier.Key.SPACE);
		keyboard.setKey(Key.PAUSE, Identifier.Key.P);
		keyboard.setKey(Key.R_LEFT, Identifier.Key.UP);
		keyboard.setKey(Key.R_RIGHT, Identifier.Key.DOWN);
	}

	public void poll(){
		gamepad.pollController();
		keyboard.pollController();
		/*
		Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
		while(true){
			for(int i=0; i < controllers.length; i++) {
				//System.out.println(controllers[i].getName()+": "+controllers[i].getType());
				controllers[i].poll();
				Component[] components = controllers[i].getComponents();

				for(int j=0; j < components.length; j++) {
					Component component = components[j];

					if(component.getPollData()==1.0f){
						System.out.println(component.getIdentifier().getName());
						System.out.println(controllers[i].getName()+": "+controllers[i].getType());
					}
				}
			}
		}
		*/
	}
}
