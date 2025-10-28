package com.example.corrugatedbox.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corrugatedbox.project.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{

	Payment findByUserName(String name);

}
