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

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
    @Operation(summary = "Retornar uma lista das compras ordenadas de forma crescente por valor, deve conter o nome dos clientes, cpf dos clientes, dado dos produtos, quantidade das compras e valores totais de cada compra.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Purchase.PurchaseResult list",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.PurchaseResult.class))}),
            @ApiResponse(responseCode = "404", description = "PurchaseResult not found", content = @Content)})
    @GetMapping("/compras")
    public List<Purchase.PurchaseResult> getBetterPurchases() {
		
		List<Purchase.PurchaseResult> listCustomer = purchaseService.findBetterPurchases();
        return listCustomer;
    }

    @Operation(summary = "Retornar a maior compra do ano informando os dados da compra disponibilizados, deve ter o nome do cliente, cpf do cliente, dado do produto, quantidade da compra e seu valor total.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Purchase.PurchaseResult list",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.PurchaseResult.class))}),
            @ApiResponse(responseCode = "404", description = "PurchaseResult not found", content = @Content)})
    @GetMapping("/maior-compra/{ano}")
    public List<Purchase.PurchaseResult> getBetterPurchasesByYear(@PathVariable(value = "ano") Long year) {
		
		List<Purchase.PurchaseResult> listCustomer = purchaseService.findMaxPurchasesByYear(year);
        return listCustomer;
    }

    
}