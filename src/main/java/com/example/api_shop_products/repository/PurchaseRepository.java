package com.example.api_shop_products.repository;

import java.util.List;
import java.util.Optional;
import com.example.api_shop_products.model.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

	@Query(value = "select custumer.name as user_name, custumer.cpf as user_cpf, purchase.quantity, (sum(purchase.quantity) * sum(product.price)) as total " +
        "from PURCHASE purchase " +
        "inner join PRODUCT product on product.code = purchase.code " +
        "inner join CUSTOMER custumer on custumer.id = purchase.customer_id " +
        "group by  product.wine_type, purchase.quantity, purchase.customer_id, custumer.name, custumer.cpf " +
        "order by custumer.name, product.price asc", nativeQuery = true)
    public List<Purchase.PurchaseResult> findBetterPurchases();

    @Query(value = "select top 1 purchases_cache.id, " +
        "purchases_cache.user_name, " +
        "purchases_cache.user_cpf, " +
        "purchases_cache.quantity, " +
        "purchases_cache.wine_type, max(purchases_cache.total) as total " +
        "from ( " +
        "select purchase.id, custumer.name as user_name, " +
        "custumer.cpf as user_cpf, " +
        "product.wine_type, " +
        "product.purchased_year, " +
        "purchase.quantity, (sum(purchase.quantity) * sum(product.price)) as total " +
        "from PURCHASE purchase " +
        "inner join PRODUCT product on product.code = purchase.code " +
        "        inner join CUSTOMER custumer on custumer.id = purchase.customer_id " +
        "where product.purchased_year = ?1 " +
        "        group by   purchase.id, product.wine_type, purchase.quantity " +
        "        order by custumer.name, product.price desc " +
        ") purchases_cache " +
        "group by  purchases_cache.id " +
        "order by  max(purchases_cache.total) desc", nativeQuery = true)
    public List<Purchase.PurchaseResult> findMaxPurchasesByYear(Long year);

}
