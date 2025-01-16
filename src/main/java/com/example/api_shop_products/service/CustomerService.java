package com.example.api_shop_products.service;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import com.example.api_shop_products.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.api_shop_products.repository.CustomerRepository;
import com.example.api_shop_products.repository.ProductRepository;
import com.example.api_shop_products.exception.IllegalArgumentException;
import com.example.api_shop_products.exception.ResourceNotFoundException;
import com.example.api_shop_products.model.Product;
import com.example.api_shop_products.model.ProductRecommendationResult;

@Service
public class CustomerService {

	@Autowired
    private CustomerRepository customerRepository;
	
	@Autowired
    private ProductRepository productRepository;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public Customer findById(Long id) {
		return customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException()
        );
	}
	
	public Customer findByCpf(String cpf) {
		return customerRepository.findByCpf(cpf).orElseThrow(
                () -> new ResourceNotFoundException()
        );
	}

	public ProductRecommendationResult getRecommendationsWine(Long customerId) {
		List<Customer.CustomerResult> listWine = customerRepository.findWineMostPurchasedByCustomer(customerId);
		String wineType = listWine.get(0).getWineMostPurchased();
		List<Product.ProductResult> productResult = productRepository.findProductByType(wineType);
		ProductRecommendationResult product = new ProductRecommendationResult();
		product.setMessage("Vimos que você gosta muito de vindo "+wineType+", gostaria de experimentar nossa promoção especial do produto abaixo?");
    	Random rand = new Random();
		product.setProduct(productResult.get(rand.nextInt(productResult.size())));
		return product;
	}

	public List<Customer.CustomerResult> findTopThreeCustomer() {
		return customerRepository.findTopThreeCustomer();
	}


	public void save(Customer u) throws IllegalArgumentException {
		customerRepository.save(u);
	}

	public void delete(Customer u) throws IllegalArgumentException {
		customerRepository.delete(u);
	}
	
}