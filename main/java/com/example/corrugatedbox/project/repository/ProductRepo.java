package com.example.corrugatedbox.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corrugatedbox.project.entity.Product;
import com.example.corrugatedbox.project.entity.Size;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	Size findByUserName(String name);
	
	

}
