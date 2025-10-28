package com.example.corrugatedbox.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.corrugatedbox.project.entity.Payment;
import com.example.corrugatedbox.project.repository.PaymentRepo;

@Service
public class PaymentService implements CrudServices<Payment , Integer> {

	    		@Autowired
			    private PaymentRepo paymentRepository;

				@Override
				public Payment create(Payment payment) {
					 return paymentRepository.save(payment);
				
				}

				@Override
				public List<Payment> fetchAll() {
					 return paymentRepository.findAll();
					
				}
				
				@Override
				public  Payment fetchById(Integer id) {
					  return paymentRepository.findById(id)
				                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + id));
				}

				@Override
				public Payment update(Payment existingUser, Payment updatedUser) {
					existingUser.setP_id(updatedUser.getP_id());
					existingUser.setBooking(updatedUser.getBooking());
					existingUser.setPayment_date(updatedUser.getPayment_date());
				    existingUser.setStatus(updatedUser.getStatus());
				    

			        return(existingUser);
				}

				@Override
				public String delete(Payment user) {
					paymentRepository.delete(user);
			        return "Payment deleted successfully";
				}

				public Payment fetchUserByUserName(String name) {
					// TODO Auto-generated method stub
					return  paymentRepository.findByUserName(name);
				};
				}

				

				
	


