package com.example.corrugatedbox.project.entity;

import java.time.LocalDateTime;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="order")
public class Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int o_id;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	  @OneToMany
	    private List<Product> products;
	
	
	@Column(name="orderdate",nullable= false)
	private LocalDateTime orderdate;
	
	public enum OrderStatus{
		PENDING,
		BOOKED,
		SHIPPED,
		DELIVERD,
		CANCELLED
}
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	
	@Column(name="TotalAmount",nullable=false)
	private double  totalAmount;

	private Product product;

	public Order(int o_id, User user, Product product, LocalDateTime orderdate, OrderStatus status,
			 double totalAmount) {
		super();
		this.o_id = o_id;
		this.user = user;
		this.product = product;
		this.orderdate = orderdate;
		this.status = status;
		this.totalAmount = totalAmount;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return getProduct();
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LocalDateTime getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDateTime orderdate) {
		this.orderdate = orderdate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Order [o_id=" + o_id + ", user=" + user + ", product=" + product + ", orderdate=" + orderdate
				+ ", status=" + status + ", totalAmount=" + totalAmount + "]";
	}

	
	
	
	
	
	

}
