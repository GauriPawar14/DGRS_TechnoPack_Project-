package com.example.corrugatedbox.project.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int p_id;

	@ManyToMany
	@JoinColumn(name="booking_id",nullable=false)
	private Booking booking;
	

	    @ManyToMany
	    @JoinTable(
	        name = "payment_booking",         // Join table name
	        joinColumns = @JoinColumn(name = "payment_id"), // Foreign key column for Payment
	        inverseJoinColumns = @JoinColumn(name = "booking_id") // Foreign key column for Booking
	    )
	    private Set<Booking> bookings;
	

	
	
	@Column(name="payment_date",nullable=false)
	private LocalDateTime payment_date;
	
	public enum PaymentStatus{
		PENDING,
		COMPLETED,
		FAILED
	}
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	public Payment(int p_id, Booking booking,  LocalDateTime payment_date, PaymentStatus status) {
		super();
		this.p_id = p_id;
		this.booking = booking;
		this.payment_date = payment_date;
		this.status = status;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public LocalDateTime getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(LocalDateTime payment_date) {
		this.payment_date = payment_date;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payment [p_id=" + p_id + ", booking=" + booking + ", payment_date=" + payment_date + ", status="
				+ status + "]";
	}

}
