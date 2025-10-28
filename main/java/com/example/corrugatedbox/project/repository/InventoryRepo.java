package com.example.corrugatedbox.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corrugatedbox.project.entity.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

	Inventory findByUserName(String name);

}
