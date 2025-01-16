package com.example.api_shop_products.exception;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("ResourceNotFoundException fired...");
	}
}