package com.aurionpro.test;

import com.aurionpro.model.Command;
import com.aurionpro.model.Light;
import com.aurionpro.model.LightOffCommand;
import com.aurionpro.model.LightOnCommand;
import com.aurionpro.model.Switch;

public class CommandTest {

	public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        Switch lightSwitch = new Switch(lightOn, lightOff);
        lightSwitch.turnOn();
        lightSwitch.turnOff();
	}

}
