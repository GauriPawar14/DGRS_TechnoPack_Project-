package com.example.corrugatedbox.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.corrugatedbox.project.entity.User;
import com.example.corrugatedbox.project.repository.UserRepo;

@Service
public class UserServices implements CrudServices<User, Integer> {

		@Autowired
	    private UserRepo userRepository;

		@Override
		public User create(User user) {
			 return userRepository.save(user);
		
		}

		@Override
		public List<User> fetchAll() {
			 return userRepository.findAll();
			
		}
		
		@Override
		public  User fetchById(Integer id) {
			  return userRepository.findById(id)
		                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
		}

		@Override
		public User update(User existingUser, User updatedUser) {
			existingUser.setUser_id(updatedUser.getUser_id());
			existingUser.setFname(updatedUser.getFname());
			existingUser.setLname(updatedUser.getLname());
		    existingUser.setEmail(updatedUser.getEmail());
		    existingUser.setUsername(updatedUser.getUsername());
		    existingUser.setPassword(updatedUser.getPassword());
		    existingUser.setRole(updatedUser.getRole());

	        return(existingUser);
		}

		@Override
		public String delete(User user) {
			userRepository.delete(user);
	        return "User deleted successfully";
		}

		public User fetchUserByUserName(String name) {
			return userRepository.findByUserName(name);
		}


	   

	}
