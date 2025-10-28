package com.example.corrugatedbox.project.entity;

import java.time.LocalDateTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name="delivery")
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int d_id;
	
	@JoinColumn(name="booking_id",nullable= false)
	private Booking booking;
	
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	@JoinColumn(name="p_id",nullable=false)
	private Payment payment;
	
	
	@Column(name="delivery_date")
	private LocalDateTime delivery_date;
	
	
	@Column(name="address",nullable=false)
	
	private String address;
	
	
	@Column(name="shipping_cost",nullable=false)
	private Double shipping_cost;
	
	public enum DeliveryStatus{
		PENDING,
		DISPATCHED,
		DELIVERED,
		FAILED
	}
		
		@Enumerated(EnumType.STRING)
		private DeliveryStatus deliverystatus;

		public Delivery(int d_id, Booking booking, User user, Payment payment, LocalDateTime delivery_date,
				 String address, Double shipping_cost,
				DeliveryStatus deliverystatus) {
			super();
			this.d_id = d_id;
			this.booking = booking;
			this.user = user;
			this.payment = payment;
			this.delivery_date = delivery_date;
			this.address = address;
			this.shipping_cost = shipping_cost;
			this.deliverystatus = deliverystatus;
		}

		public int getD_id() {
			return d_id;
		}

		public void setD_id(int d_id) {
			this.d_id = d_id;
		}

		public Booking getBooking() {
			return booking;
		}

		public void setBooking(Booking booking) {
			this.booking = booking;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Payment getPayment() {
			return payment;
		}

		public void setPayment(Payment payment) {
			this.payment = payment;
		}

		public LocalDateTime getDelivery_date() {
			return delivery_date;
		}

		public void setDelivery_date(LocalDateTime delivery_date) {
			this.delivery_date = delivery_date;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Double getShipping_cost() {
			return shipping_cost;
		}

		public void setShipping_cost(Double shipping_cost) {
			this.shipping_cost = shipping_cost;
		}

		public DeliveryStatus getDeliverystatus() {
			return deliverystatus;
		}

		public void setDeliverystatus(DeliveryStatus deliverystatus) {
			this.deliverystatus = deliverystatus;
		}

		@Override
		public String toString() {
			return "Delivery [d_id=" + d_id + ", booking=" + booking + ", user=" + user + ", payment=" + payment
					+ ", delivery_date=" + delivery_date + ", address=" + address + ", shipping_cost=" + shipping_cost
					+ ", deliverystatus=" + deliverystatus + "]";
		}
		
		
	
	
}
