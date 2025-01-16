package com.example.api_shop_products.model;
import jakarta.persistence.*;

@Entity
@Table(name = "purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "code")
	private String code;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "client_id")
	private Integer clientId;

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

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "{ id : " + id + ", code : " + code + ", quantity : " + quantity + "}";
	}

}