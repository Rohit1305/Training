package com.aurionpro.model;

public class Country {

	private String countryCode;
	private String countryName;
	private int regionID;

	public Country(String countryCode, String countryName, int regionID) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.regionID = regionID;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getRegionID() {
		return regionID;
	}

	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}

	@Override
	public String toString() {
		return "\nCountry [countryCode: " + countryCode + ", countryName: " + countryName + ", regionID: " + regionID
				+ "]";
	}

}
