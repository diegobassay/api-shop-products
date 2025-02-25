package com.example.api_shop_products.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_shop_products.model.Customer;
import com.example.api_shop_products.model.Product;
import com.example.api_shop_products.model.ProductRecommendationResult;
import com.example.api_shop_products.service.CustomerService;
import com.example.api_shop_products.exception.ResourceNotFoundException;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Hidden
	@GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(value = "id") Long id) {
		
		Customer customer = customerService.findById(id);
        return ResponseEntity.ok().body(customer);
    }
    @Operation(summary = "Retornar o Top 3 clientes mais fieis, clientes que possuem mais compras recorrentes com maiores valores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer list",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.CustomerResult.class))}),
            @ApiResponse(responseCode = "404", description = "Customer not found", content = @Content)})
    @GetMapping("/clientes-fieis")
    public List<Customer.CustomerResult> getLoyalCustomers() {
		List<Customer.CustomerResult> listCustomer = customerService.findTopThreeCustomer();
        return listCustomer;
    }
    @Operation(summary = "Retornar uma recomendação de vinho baseado nos tipos de vinho que o cliente mais compra.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ProductRecommendationResult object",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.CustomerResult.class))}),
            @ApiResponse(responseCode = "404", description = "ProductRecommendationResult not found", content = @Content)})
	@GetMapping("/recomendacao/{client_id}/type")
    public  ProductRecommendationResult getWineRecommendation(@PathVariable(value = "client_id") Long customerId) {
        return customerService.getRecommendationsWine(customerId);
    }

	@Hidden
	@GetMapping("/cpf/{cpf}")
    public ResponseEntity<Customer> getCustomerByCpf(@PathVariable(value = "cpf") String cpf) {
		Customer customer = customerService.findByCpf(cpf);
        return ResponseEntity.ok().body(customer);
    }

	@GetMapping("/")
    public ResponseEntity<List<Customer>> getAllCustomer() {
		
		List<Customer> listCustomer = customerService.findAll();
        return ResponseEntity.ok().body(listCustomer);
    }
	@Hidden
	@PostMapping("/")
    public ResponseEntity<String> postCustomer(@RequestBody Customer customer) {
		
		try {
			@SuppressWarnings("unused")
			Customer usuario = customerService.findById(customer.getId());
			return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"timestamp\":\"" + Instant.now() + "\",\"message\":\"Customer já cadastrado\"}");
		} catch (ResourceNotFoundException e) {
			customer.setCpf(customer.getCpf());
			customerService.save(customer);
			return ResponseEntity.status(HttpStatus.OK).body("{\"timestamp\":\"" + Instant.now() + "\",\"message\":\"Customer inserido com sucesso.\"}");
	    }
    }
	@Hidden
	@PutMapping("/")
	public ResponseEntity<String> putCustomer(@RequestBody Customer custumer) {
		customerService.save(custumer);
		return ResponseEntity.status(HttpStatus.OK).body("{\"timestamp\":\"" + Instant.now() + "\",\"message\":\"Customer atualizado com sucesso.\"}");
    }
	@Hidden
	@DeleteMapping("/")
	public ResponseEntity<String> deleteCustomer(@RequestBody Customer custumer) {
		customerService.delete(custumer);
		return ResponseEntity.status(HttpStatus.OK).body("{\"timestamp\":\"" + Instant.now() + "\",\"message\":\"Customer deletado com sucesso\"}");
    }
}