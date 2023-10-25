package com.aurionpro.model;

import org.springframework.stereotype.Component;

@Component
public class WeightLoss implements IDiet{

	@Override
	public String getPlan() {
		return "WeightLoss";
	}

}
