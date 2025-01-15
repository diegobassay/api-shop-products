package com.example.api_shop_products.model;

import java.util.List;
import com.example.api_shop_products.model.Purchase;
import jakarta.persistence.*; // for Spring Boot 3

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "cpf")
	private String cpf;

	@OneToMany 
    @JoinColumn(name = "client_id")
	private List<Purchase> purchases;

	public Client() {

	}

	public Client(String name, String cpf, List<Purchase> purchases) {
		this.name = name;
		this.cpf = cpf;
		this.purchases = purchases;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return "{ id : " + id + ", name : " + name + ", cpf : " + cpf + ", purchases : " + purchases.size() + " }";
	}

}