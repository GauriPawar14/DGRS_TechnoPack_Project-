package com.example.corrugatedbox.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.corrugatedbox.project.entity.Delivery;
import com.example.corrugatedbox.project.repository.DeliveryRepo;

@Service
public class DeliveryService implements CrudServices<Delivery, Integer> {

			@Autowired
		    private DeliveryRepo deliveryRepository;

			@Override
			public Delivery create(Delivery user) {
				 return deliveryRepository.save(user);
			
			}

			@Override
			public List<Delivery> fetchAll() {
				 return deliveryRepository.findAll();
				
			}
			
			@Override
			public  Delivery fetchById(Integer id) {
				  return deliveryRepository.findById(id)
			                .orElseThrow(() -> new RuntimeException( "Delivery not found with ID: " + id));
			}

			@Override
			public Delivery update(Delivery existingUser, Delivery updatedUser) {
				existingUser.setD_id(updatedUser.getD_id());
				existingUser.setDelivery_date(updatedUser.getDelivery_date());
				existingUser.setDeliverystatus(updatedUser.getDeliverystatus());
			    existingUser.setPayment(updatedUser.getPayment());
			    existingUser.setShipping_cost(updatedUser.getShipping_cost());
			    existingUser.setUser(updatedUser.getUser());
			    existingUser.setAddress(updatedUser.getAddress());
			    existingUser.setBooking(updatedUser.getBooking());

		        return(existingUser);
			}

			@Override
			public String delete(Delivery delivery) {
				deliveryRepository.delete(delivery);
		        return "delivery deleted successfully";
			}

			public Delivery fetchUserByUserName(String name) {
				
				return deliveryRepository.findByUserName(name);
			}

}