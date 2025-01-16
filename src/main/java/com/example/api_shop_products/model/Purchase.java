package com.example.api_shop_products.model;
import com.example.api_shop_products.model.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column(name = "code", insertable=false, updatable=false)
	private String code;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "customer_id")
	private Integer customerId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "code", nullable = false)
    private Product product;

	public Purchase() {

	}

	public Purchase(String code, Long quantity) {
		this.code = code;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


    public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "{ id : " + id + ", code : " + code + ", quantity : " + quantity + "}";
	}

    public static interface PurchaseResult{
 
        Long getId();

        String getUserName();

        String getUserCpf();

        String getWineType();

        Long getQuantity();

        Float getTotal();

    }

}