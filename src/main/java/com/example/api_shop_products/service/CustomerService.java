package com.example.api_shop_products.service;

import java.util.List;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import com.example.api_shop_products.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.api_shop_products.repository.CustomerRepository;
import com.example.api_shop_products.exception.IllegalArgumentException;
import com.example.api_shop_products.exception.ResourceNotFoundException;

@Service
public class CustomerService {

	@Autowired
    private CustomerRepository customerRepository;
	
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
	
	public List<Customer> findTopThreeCustomer() {
		return customerRepository.findTopThreeCustomer();
	}


	public void save(Customer u) throws IllegalArgumentException {
		customerRepository.save(u);
	}

	public void delete(Customer u) throws IllegalArgumentException {
		customerRepository.delete(u);
	}
	
}