package com.aurionpro.exception;

@SuppressWarnings("serial")
public class TransactionNotFoundException extends Exception {
	public TransactionNotFoundException(String message) {
		super(message);
	}

}
