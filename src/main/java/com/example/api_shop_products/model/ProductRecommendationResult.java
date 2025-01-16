package com.example.api_shop_products.model;
import com.example.api_shop_products.model.Product.ProductResult;

public class ProductRecommendationResult{
    public String message;
    public void setMessage(String message) { this.message = message; }
    public String getMessage(){ return this.message; }
    public ProductResult product;
    public void setProduct(ProductResult product) { this.product = product; }
    public ProductResult getProduct(){ return this.product; }
}