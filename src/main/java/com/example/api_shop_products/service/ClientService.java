package com.example.api_shop_products.repository;

import java.util.List;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import com.example.api_shop_products.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.api_shop_products.repository.ClientRepository;
import com.example.api_shop_products.exception.IllegalArgumentException;
import com.example.api_shop_products.exception.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
    private ClientRepository clientRepository;
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	public Client findById(Long id) {
		return clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException()
        );
	}
	
	public Client findByCpf(String cpf) {
		return clientRepository.findByCpf(cpf).orElseThrow(
                () -> new ResourceNotFoundException()
        );
	}
	
	public void save(Client u) throws IllegalArgumentException {
		clientRepository.save(u);
	}

	public void delete(Client u) throws IllegalArgumentException {
		clientRepository.delete(u);
	}
	
}