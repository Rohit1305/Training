package com.aurionpro.model;

import org.springframework.stereotype.Component;

@Component
public class AtheleteDiet implements IDiet{

	@Override
	public String getPlan() {
		return "AthelleteLoss";
	}

}
