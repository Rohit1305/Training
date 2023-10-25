package com.aurionpro.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.model.ICoach;

@RestController
public class CoachController {
	private ICoach coach1;
//	private ICoach coach2;

	public CoachController(@Qualifier(value="normalCoach") ICoach coach1) {
		super();
		this.coach1 = coach1;
//		this.coach2 = coach2;
	}
	@GetMapping("/test")
	public String showTraining() {
		
		return coach1.getTrainingPlan();
		
	}

}
