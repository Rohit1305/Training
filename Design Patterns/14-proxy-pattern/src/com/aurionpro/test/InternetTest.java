package com.aurionpro.test;

import com.aurionpro.model.ProxyInternet;
import com.aurionpro.model.RealInternet;

public class InternetTest {

	public static void main(String[] args) {
        ProxyInternet proxyInternet = new ProxyInternet();
        proxyInternet.connectTo("example.com");
        proxyInternet.connectTo("www.flipkart.com");
	}
}
