package com.aurionpro.model;

public class Switch {
	private Command onCommand;
	private Command offCommand;

	public Switch(Command onCommand, Command offCommand) {
		this.onCommand = onCommand;
		this.offCommand = offCommand;
	}

	public void turnOn() {
		onCommand.execute();
	}

	public void turnOff() {
		offCommand.execute();
	}

}
