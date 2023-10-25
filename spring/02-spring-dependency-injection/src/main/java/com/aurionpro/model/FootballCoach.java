package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class FootballCoach implements ICoach {
	private IDiet diet;
	

	public FootballCoach(@Qualifier(value="atheleteDiet") IDiet diet) {
		super();
		this.diet = diet;
	}

	@Override
	public String getTrainingPlan() {
		return "Practice penalty for 2 hours";
	}

	@Override
	public String getDietPlan() {
		return diet.getPlan();
	}

}
