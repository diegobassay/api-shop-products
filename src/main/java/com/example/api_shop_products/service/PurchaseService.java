package com.example.api_shop_products.service;

import java.util.List;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import com.example.api_shop_products.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.api_shop_products.repository.PurchaseRepository;
import com.example.api_shop_products.exception.IllegalArgumentException;
import com.example.api_shop_products.exception.ResourceNotFoundException;

@Service
public class PurchaseService {

	@Autowired
    private PurchaseRepository purchaseRepository;
	
	public List<Purchase> findAll() {
		return purchaseRepository.findAll();
	}

	public List<Purchase.PurchaseResult> findBetterPurchases() {
		return purchaseRepository.findBetterPurchases();
	}
	public List<Purchase.PurchaseResult> findBetterPurchasesByYear(Long year) {
		return purchaseRepository.findBetterPurchasesByYear(year);
	}
	
}