package com.aurionpro.model;

public class Player {
	public String name;
	public MarkType type;
	public Player(String name, MarkType type) {
		super();
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MarkType getType() {
		return type;
	}
	public void setType(MarkType type) {
		this.type = type;
	}
	

}
