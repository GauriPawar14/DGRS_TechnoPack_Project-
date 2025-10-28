package com.example.corrugatedbox.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corrugatedbox.project.entity.Size;

public interface SizeRepo extends JpaRepository<Size , Integer>{

	static Size findByUserName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
