package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Scope("prototype")
public class CricketCoach implements ICoach {
	private IDiet diet;
	

	public CricketCoach(@Qualifier(value="weightLoss") IDiet diet) {
		super();
		this.diet = diet;
	}

	@Override
	public String getTrainingPlan() {
		return "Practice in net for 2 hours";
	}

	@Override
	public String getDietPlan() {
		return diet.getPlan();
	}


}
