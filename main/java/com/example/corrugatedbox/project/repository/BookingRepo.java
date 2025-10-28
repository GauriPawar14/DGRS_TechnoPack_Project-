package com.example.corrugatedbox.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corrugatedbox.project.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

	static Booking findByUserName(String name) {
		return null;
		// TODO Auto-generated method stub
	
	}

}
