package com.example.corrugatedbox.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int p_id;
	
	
	@Column(name="product_Name",nullable=false)
	private String product_name;
	
	@OneToOne
    @JoinColumn(name = "s_id", nullable = false)
	private Size size;
	
	
	@Column(name="description",nullable=false)
	private String description;
	
	
	@Column(name="quantity",nullable=false)
	private Long quantity;
	
	
	
	@Column(name="Prize",nullable=false)
	private Double prize;


	

	public Product(int p_id, String product_name, Size size, String description, Long quantity, Double prize) {
		super();
		this.p_id = p_id;
		this.product_name = product_name;
		this.size = size;
		this.description = description;
		this.quantity = quantity;
		this.prize = prize;
	}


	public int getP_id() {
		return p_id;
	}


	public void setP_id(int p_id) {
		this.p_id = p_id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public Size getSize() {
		return size;
	}


	public void setSize(Size size) {
		this.size = size;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	public Double getPrize() {
		return prize;
	}


	public void setPrize(Double prize) {
		this.prize = prize;
	}


	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", product_name=" + product_name + ", size=" + size + ", description="
				+ description + ", quantity=" + quantity + ", prize=" + prize + "]";
	}

	
	
	
	
	
	
	
	
}

	
	