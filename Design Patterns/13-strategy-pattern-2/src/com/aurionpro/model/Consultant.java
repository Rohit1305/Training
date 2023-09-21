package com.aurionpro.model;

public class Consultant implements IRole{

	@Override
	public String Description() {
		return "i am consultant";
	}

	@Override
	public String Responsibility() {
		return "i do consulatant related work";
	}

}
