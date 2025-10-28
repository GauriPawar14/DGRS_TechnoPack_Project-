package com.example.corrugatedbox.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.corrugatedbox.project.entity.Booking;
import com.example.corrugatedbox.project.repository.BookingRepo;

@Service
public class BookingService implements CrudServices<Booking , Integer>{

				@Autowired
				private BookingRepo bookingRepo;

				@Override
				public Booking create(Booking booking) {
					return bookingRepo.save(booking);
				}

				@Override
				public List<Booking> fetchAll() {
					
					return bookingRepo.findAll();
				}

				@Override
				public Booking fetchById(Integer id) {
					return bookingRepo.findById(id).orElseThrow();
				}

				@Override
				public Booking update(Booking updatedUser, Booking existingUser) {
					existingUser.setBooking_id(updatedUser.getBooking_id());
					existingUser.setBookingdate(updatedUser.getBookingdate());
					existingUser.setOrder(updatedUser.getOrder());
					existingUser.setTotalamount(updatedUser.getTotalamount());
					existingUser.setUser(updatedUser.getUser());
					

					return bookingRepo.save(existingUser);
				}

				@Override
				public String delete(Booking booking) {
					bookingRepo.delete(booking);
					return booking.getBooking_id() + "deleted";
				}

				public Booking fetchUserByUserName(String name) {
					
					return BookingRepo.findByUserName(name);
				}

				
				
				

				
			}





