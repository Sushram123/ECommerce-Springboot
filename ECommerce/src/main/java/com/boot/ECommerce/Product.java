package com.boot.ECommerce;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "product") 

public class Product { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long productId; 

    @Column(nullable = false) 
    private String name; 

    @Column(nullable = false) 
    private String description;
    
    @Column(nullable = false) 
    private double price; 

    @Column(nullable = false) 
    private int quantityAvailable;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public Product(Long productId, String name, String description, double price, int quantityAvailable) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantityAvailable = quantityAvailable;
	}

  
    // Constructors, getters and setters, and other methods are Generated here... 
    
    
}
