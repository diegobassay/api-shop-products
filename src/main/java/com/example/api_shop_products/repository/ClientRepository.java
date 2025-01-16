package com.example.api_shop_products.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_shop_products.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	public Optional<Client> findByCpf(String cpf);
}
