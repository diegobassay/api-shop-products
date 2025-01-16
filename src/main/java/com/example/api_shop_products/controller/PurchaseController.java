package com.example.api_shop_products.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_shop_products.model.Purchase;
import com.example.api_shop_products.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	

    @GetMapping("/compras")
    public List<Purchase.PurchaseResult> getBetterPurchases() {
		
		List<Purchase.PurchaseResult> listCustomer = purchaseService.findBetterPurchases();
        return listCustomer;
    }

    @GetMapping("/maior-compra/{ano}")
    public List<Purchase.PurchaseResult> getBetterPurchasesByYear(@PathVariable(value = "ano") Long year) {
		
		List<Purchase.PurchaseResult> listCustomer = purchaseService.findBetterPurchasesByYear(year);
        return listCustomer;
    }

    
}