package com.aurionpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.model.ICoach;

@RestController
public class CoachController2 {
	private ICoach coach1;
	private ICoach coach2;

//	public CoachController2(@Qualifier(value = "cricketCoach") ICoach coach1,@Qualifier(value = "footballCoach")ICoach coach2) {
//		super();
//		this.coach1 = coach1;
//		this.coach2 = coach2;
//	}

	@Autowired
	@Qualifier(value="cricketCoach")
	public void setCoach1(ICoach coach1) {
		this.coach1 = coach1;
	}

	@Autowired
	@Qualifier(value="footballCoach")
	public void setCoach2(ICoach coach2) {
		this.coach2 = coach2;
	}

	@GetMapping("/test2")
	public String showTraining() {
//		System.out.println(coach1 == coach2);
//		System.out.println(coach1.hashCode());
//		System.out.println(coach2.hashCode());
//		System.out.println(coach1.getTrainingPlan());
//		System.out.println(coach2.getTrainingPlan());
		
		return coach1.getDietPlan();
		
	}

}
