package com.example.corrugatedbox.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.corrugatedbox.project.entity.Order;
import com.example.corrugatedbox.project.repository.OrderRepo;

@Service
public class OrderService implements CrudServices<Order , Integer>{

			@Autowired
			private OrderRepo orderRepo;

			@Override
			public Order create(Order order) {
				return orderRepo.save(order);
			}

			@Override
			public List<Order> fetchAll() {
				
				return orderRepo.findAll();
			}

			@Override
			public Order fetchById(Integer id) {
				return orderRepo.findById(id).orElseThrow();
			}

			@Override
			public Order update(Order updatedUser, Order existingUser) {
				existingUser.setO_id(updatedUser.getO_id());
				existingUser.setOrderdate(updatedUser.getOrderdate());
				existingUser.setProduct(updatedUser.getProduct());
				existingUser.setStatus(updatedUser.getStatus());
				existingUser.setTotalAmount(updatedUser.getTotalAmount());
				existingUser.setUser(updatedUser.getUser());
				

				return orderRepo.save(existingUser);
			}

			@Override
			public String delete(Order order) {
				orderRepo.delete(order);
				return order.getO_id() + "deleted";
			}

			public Order fetchUserByUserName(String name) {
				// TODO Auto-generated method stub
				return OrderRepo.findByUserName(name);
			}

			
			
			

			
		}



