package com.aurionpro.model;

public class FixedDeposit {
	private int accountNumber;
	private String name;
	private double principal;
	private int duration;
	private FestivalType festival;

	public FixedDeposit(int accountNumber, String name, double principal, int duration, FestivalType festival) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.principal = principal;
		this.duration = duration;
		this.festival = festival;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public FestivalType getFestival() {
		return festival;
	}

	public void setFestival(FestivalType festival) {
		this.festival = festival;
	}

	private double getInterestRates() {
		if (festival.equals(FestivalType.NEWYEAR)) {
			return 8;
		}
		if (festival.equals(FestivalType.DIWALI)) {
			return 8.5;
		}
		if (festival.equals(FestivalType.HOLI)) {
			return 7.5;
		} else {
			return 6.5;
		}
	}

	@Override
	public String toString() {
		return "FixedDeposit [accountNumber=" + accountNumber + ", name=" + name + ", principal=" + principal
				+ ", duration=" + duration + ", festival=" + festival + ", Interest= " + CalculateSimpleInterest()
				+ "]";
	}

	public double CalculateSimpleInterest() {
		return (principal * getInterestRates() * duration) / 100;
	}

}