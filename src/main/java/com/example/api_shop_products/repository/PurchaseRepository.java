package com.example.api_shop_products.repository;

import java.util.List;
import java.util.Optional;
import com.example.api_shop_products.model.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
