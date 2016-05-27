package com.mtit.common;

/**
 * Common Exception for Order Management
 */
public class OrderException extends Exception {
	
	public OrderException() {
		super();
	}

	public OrderException(String s) {
		super(s);
	}

	public OrderException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public OrderException(Throwable throwable) {
		super(throwable);
	}
}
