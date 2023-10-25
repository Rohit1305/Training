package com.aurionpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.model.ICoach;

//@RestController
public class CoachController3 {
	@Autowired
	@Qualifier(value="cricketCoach")
	private ICoach coach1;
	@Autowired
	@Qualifier(value="footballCoach")
	private ICoach coach2;

//	public CoachController3(@Qualifier(value = "cricketCoach") ICoach coach1,@Qualifier(value = "footballCoach")ICoach coach2) {
//		super();
//		this.coach1 = coach1;
//		this.coach2 = coach2;
//	}

//	@Qualifier(value="weightLoss")
//	public void setCoach1(ICoach coach1) {
//		this.coach1 = coach1;
//	}
//
//	@Qualifier(value="atheleteDiet")
//	public void setCoach2(ICoach coach2) {
//		this.coach2 = coach2;
//	}

	@GetMapping("/test3")
	public String showTraining() {
//		System.out.println(coach1 == coach2);
//		System.out.println(coach1.hashCode());
//		System.out.println(coach2.hashCode());
//		System.out.println(coach1.getTrainingPlan());
//		System.out.println(coach2.getTrainingPlan());
		
		return coach1.getDietPlan();
		
	}

}
