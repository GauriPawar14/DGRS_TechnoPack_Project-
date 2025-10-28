package com.example.corrugatedbox.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.corrugatedbox.project.CustomException.UserNotFoundException;
import com.example.corrugatedbox.project.Services.DeliveryService;
import com.example.corrugatedbox.project.entity.Delivery;
import com.example.corrugatedbox.project.errorresponse.ErrorResponse;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

			@Autowired
			private DeliveryService deliveryService;

			@PostMapping("/add")
			public ResponseEntity<?> registerdUser(@RequestBody Delivery delivery) {
				Delivery createdUser = deliveryService.create(delivery);
				return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
			}

			@GetMapping("/all")
			public ResponseEntity<?> getAllUserser() {
				try {
					return new ResponseEntity<>(deliveryService.fetchAll(), HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>
					(new ErrorResponse("User Fetching is failed", e.getMessage()),
							HttpStatus.BAD_REQUEST);
				}

			}
			@GetMapping("/getuser/{userId}")
			public ResponseEntity<?> getUserById(@PathVariable("userId") Integer id) {
				try {
					return  ResponseEntity.ok(deliveryService.fetchById(id));
					
				} catch (Exception e) {
					
					ErrorResponse errorResponce=
				    new ErrorResponse("User Fetching is failed", e.getMessage());
					return new ResponseEntity<>
					(errorResponce,HttpStatus.BAD_REQUEST);
				}
			}

			@PutMapping("/update/{userId}")
			public ResponseEntity<?> updateuserById(@PathVariable("userId") Integer id,
					@RequestBody Delivery updateUser) {
				try {
					Delivery existingUser=deliveryService.fetchById(id);
					
					return  ResponseEntity.ok(deliveryService.update(updateUser, existingUser));
					
				} catch (Exception e) {
					
					ErrorResponse errorResponce= new ErrorResponse("delivery updation is failed", e.getMessage());
					return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
				}
			}
			@DeleteMapping("/delete/{userId}")
			public ResponseEntity<?>deleteUserById(@PathVariable ("userId") Integer id)
			{ try {
				Delivery existingUser=deliveryService.fetchById(id);
				return ResponseEntity.ok(deliveryService.delete(existingUser));
						
			} catch (Exception e) {

				ErrorResponse errorResponce= new ErrorResponse("delivery deletion is failead", e.getMessage());
				return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
				
			}
				
			}
			@GetMapping("/getbyName/{name}")
			public ResponseEntity<?> getUserByUserName(@PathVariable String name){
				try {
					ResponseEntity res = null;
					Delivery foundUser = deliveryService.fetchUserByUserName(name);
					if(foundUser != null) {
						return res.ok(foundUser);
					
					}else {
						throw new UserNotFoundException("Invalid Username..");
					}
				
				} catch (Exception e) {
					return new ResponseEntity<>(new ErrorResponse("fetching user by username failed.", e.getMessage()),HttpStatus.BAD_REQUEST);
				}
				
				
			}
			
	}


