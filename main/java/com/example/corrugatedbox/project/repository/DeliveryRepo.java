package com.example.corrugatedbox.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corrugatedbox.project.entity.Delivery;

public interface DeliveryRepo extends JpaRepository<Delivery, Integer> {

	Delivery findByUserName(String name);

}
