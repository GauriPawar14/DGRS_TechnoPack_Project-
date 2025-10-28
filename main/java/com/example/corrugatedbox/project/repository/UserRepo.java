package com.example.corrugatedbox.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corrugatedbox.project.entity.User;



public interface UserRepo extends JpaRepository<User, Integer>{

	User findByUserName(String name);
	

	
	

}
