package com.aurionpro.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProxyInternet implements Internet {
	RealInternet realInternet;
	private List bannedSites;

	public ProxyInternet() {
		super();
		this.realInternet = new RealInternet();
		this.bannedSites = new ArrayList<>
		(Arrays.asList("www.flipkart.com", "www.amazon.com"));
	}

	@Override
	public void connectTo(String serverUrl) {
		if (!bannedSites.contains(serverUrl)) {
			System.out.println("Connecting to : " + serverUrl);
			realInternet.connectTo(serverUrl);
		} else {
			try {
				throw new Exception("Banned! Site");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
