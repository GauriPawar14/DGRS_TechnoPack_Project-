package com.example.corrugatedbox.project.entity;

import java.time.LocalDateTime;
import java.util.Set;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booking_id;
	
	 @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
	 
	 @ManyToMany(mappedBy = "bookings")
	    private Set<Payment> payments;
	
	@OneToOne
	@JoinColumn(name="o_id",nullable =  false)
	private Order order;
	
	
	@Column(name="Booking_Date",nullable=false)
	private LocalDateTime bookingdate;
	
	
	@Column(name="Total_Amount" ,nullable=false)
	private double totalamount;

	public Booking(int booking_id, User user, Order order,  LocalDateTime bookingdate,
		 double totalamount) {
		super();
		this.booking_id = booking_id;
		this.user = user;
		this.order = order;
		this.bookingdate = bookingdate;
		this.totalamount = totalamount;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public LocalDateTime getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(LocalDateTime bookingdate) {
		this.bookingdate = bookingdate;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", user=" + user + ", order=" + order + ", bookingdate="
				+ bookingdate + ", totalamount=" + totalamount + "]";
	}
	
	
	
	
	
	
	

}
