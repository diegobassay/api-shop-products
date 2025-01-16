package com.example.api_shop_products.repository;

import java.util.List;
import java.util.Optional;
import com.example.api_shop_products.model.Purchase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

	@Query(value = "select * "+
	    "from PURCHASE purchase " +
        "inner join CUSTOMER custumer on custumer.id = purchase.customer_id " +
        //"group by custumer.id, custumer.name " +
        "order by purchase.quantity desc", nativeQuery = true)
    public List<Purchase.PurchaseResult> findBetterPurchases();

    @Query(value = "select * "+
	    "from PURCHASE purchase " +
        "inner join PRODUCT product on product.code = purchase.code " +
        "inner join CUSTOMER custumer on custumer.id = purchase.customer_id " +
        "where product.purchasedYear = ?1 " +
        "order by product.purchasedYear desc", nativeQuery = true)
    public List<Purchase.PurchaseResult> findBetterPurchasesByYear(Long year);
}
