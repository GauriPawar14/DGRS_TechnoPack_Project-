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
import com.example.corrugatedbox.project.Services.InventoryService;
import com.example.corrugatedbox.project.entity.Inventory;
import com.example.corrugatedbox.project.errorresponse.ErrorResponse;

@RestController
@RequestMapping("/Inventory")
public class InventoryController {
			@Autowired
			private InventoryService inventoryService;

			@PostMapping("/add")
			public ResponseEntity<?> registerdUser(@RequestBody Inventory inventory) {
				Inventory createdUser = inventoryService.create(inventory);
				return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
			}

			@GetMapping("/all")
			public ResponseEntity<?> getAllUserser() {
				try {
					return new ResponseEntity<>(inventoryService.fetchAll(), HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>
					(new ErrorResponse("User Fetching is failed", e.getMessage()),
							HttpStatus.BAD_REQUEST);
				}

			}
			@GetMapping("/getuser/{userId}")
			public ResponseEntity<?> getUserById(@PathVariable("userId") Integer id) {
				try {
					return  ResponseEntity.ok(inventoryService.fetchById(id));
					
				} catch (Exception e) {
					
					ErrorResponse errorResponce=
				    new ErrorResponse("User Fetching is failed", e.getMessage());
					return new ResponseEntity<>
					(errorResponce,HttpStatus.BAD_REQUEST);
				}
			}

			@PutMapping("/update/{userId}")
			public ResponseEntity<?> updateuserById(@PathVariable("userId") Integer id,
					@RequestBody Inventory updateUser) {
				try {
					Inventory existingUser=inventoryService.fetchById(id);
					
					return  ResponseEntity.ok(inventoryService.update(updateUser, existingUser));
					
				} catch (Exception e) {
					
					ErrorResponse errorResponce= new ErrorResponse("Inventory updation is failed", e.getMessage());
					return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
				}
			}
			@DeleteMapping("/delete/{userId}")
			public ResponseEntity<?>deleteUserById(@PathVariable ("userId") Integer id)
			{ try {
				Inventory existingUser=inventoryService.fetchById(id);
				return ResponseEntity.ok(inventoryService.delete(existingUser));
						
			} catch (Exception e) {

				ErrorResponse errorResponce= new ErrorResponse("User deletion is failead", e.getMessage());
				return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
				
			}
				
			}
			@GetMapping("/getbyName/{name}")
			public ResponseEntity<?> getUserByUserName(@PathVariable String name){
				try {
					ResponseEntity res = null;
					Inventory foundUser = inventoryService.fetchUserByUserName(name);
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


