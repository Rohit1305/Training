package com.aurionpro.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class TestController {

	

	@GetMapping("/test")
	public String showGreeting() {
		return "INside Test Controller!!!!!!";
	}
}
