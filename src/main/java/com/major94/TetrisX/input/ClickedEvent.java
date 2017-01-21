package com.major94.TetrisX.input;

import net.java.games.input.Component.Identifier;

public class ClickedEvent {

	private float value;
	private Identifier id;
	
	public ClickedEvent(float value, Identifier id) {
		this.value = value;
		this.id = id;
	}

	public float getValue() {
		return value;
	}

	public Identifier getId() {
		return id;
	}
}
