package com.aurionpro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aurionpro.model.CricketCoach;
import com.aurionpro.model.ICoach;

@Configuration
public class ConfigController {

	@Bean
	public ICoach normalCoach() {
		  return new CricketCoach();
		 }
}
