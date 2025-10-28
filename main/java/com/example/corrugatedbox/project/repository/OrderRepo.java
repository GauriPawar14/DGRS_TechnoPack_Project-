package com.example.corrugatedbox.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corrugatedbox.project.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

	static Order findByUserName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
