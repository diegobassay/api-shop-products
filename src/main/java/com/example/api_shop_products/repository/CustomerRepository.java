package com.example.api_shop_products.repository;

import java.util.List;
import java.util.Optional;
import com.example.api_shop_products.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Optional<Customer> findByCpf(String cpf);

	@Query(value = "select top 3 custumer.*, sum(purchase.quantity) as quantity_total_products "+
	    "from CUSTOMER custumer " +
        "inner join PURCHASE purchase on custumer.id = purchase.customer_id " +
        "group by custumer.id, custumer.name " +
        "order by quantity_total_products desc", nativeQuery = true)
    public List<Customer.CustomerResult> findTopThreeCustomer();

	@Query(value = "select top 1 customer.name, "+
		"customer.cpf, product.wine_type as wine_most_purchased, "+
		"count(product.wine_type) as quantity_total_products "+
		"from CUSTOMER customer "+
		"	inner join PURCHASE purchase on customer.id = purchase.customer_id "+
		"	inner join PRODUCT product on product.code = purchase.code "+
		"	where customer.id = ?1 "+
		"group by  customer.name, product.wine_type "+
		"order by count(product.wine_type) desc", nativeQuery = true)
	public List<Customer.CustomerResult> findWineMostPurchasedByCustomer(Long customerId);

	
}