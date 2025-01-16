package com.example.api_shop_products.repository;

import java.util.Optional;
import com.example.api_shop_products.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

	public Optional<Client> findByCpf(String cpf);
}
