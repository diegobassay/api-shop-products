package com.example.api_shop_products.repository;

import java.util.List;
import java.util.Optional;
import com.example.api_shop_products.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

   @Query(value = "select * "+
        "from PRODUCT product " +
        "where product.wine_type = ?1 ", nativeQuery = true)
    public List<Product.ProductResult> findProductByType(String wineType);

}
