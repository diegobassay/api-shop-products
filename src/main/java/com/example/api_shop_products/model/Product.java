package com.example.api_shop_products.model;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "code")
	private Integer code;

	@Column(name = "wineType")
	private String wineType;

	@Column(name = "price")
	private Float price;
    
    @Column(name = "harvest")
	private String harvest;

    @Column(name = "purchasedYear")
    private Integer purchasedYear;

	public Product() {

	}

	public Product(Integer code, String wineType, Float price) {
		this.code = code;
		this.wineType = wineType;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getWineType() {
		return wineType;
	}

	public void setWineType(String wineType) {
		this.wineType = wineType;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getHarvest() {
		return harvest;
	}

	public void setHarvest(String harvest) {
		this.harvest = harvest;
	}

	public Integer getPurchasedYear() {
		return purchasedYear;
	}

	public void setPurchasedYear(Integer purchasedYear) {
		this.purchasedYear = purchasedYear;
	}
	@Override
	public String toString() {
		return "{ id : " + id + ", code : " + code + ", wineType : " + wineType + ", price : " + price + "}";
	}

}