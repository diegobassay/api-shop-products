package com.example.api_shop_products.exception;

public class IllegalArgumentException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IllegalArgumentException() {
		super("IllegalArgumentException fired...");
	}
}