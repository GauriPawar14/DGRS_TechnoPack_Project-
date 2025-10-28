package com.example.corrugatedbox.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.corrugatedbox.project.entity.Inventory;
import com.example.corrugatedbox.project.repository.InventoryRepo;
import com.example.corrugatedbox.project.repository.OrderRepo;



@Service
public class InventoryService implements CrudServices<Inventory , Integer>{

				@Autowired
				private InventoryRepo inventoryRepo;

				@Override
				public Inventory create(Inventory inventory) {
					return inventoryRepo.save(inventory);
				}

				@Override
				public List<Inventory> fetchAll() {
					
					return inventoryRepo.findAll();
				}

				@Override
				public Inventory fetchById(Integer id) {
					return inventoryRepo.findById(id).orElseThrow();
				}

				@Override
				public Inventory update(Inventory updatedUser, Inventory existingUser) {
					existingUser.setMa_id(updatedUser.getMa_id());
					existingUser.setMa_description(updatedUser.getMa_description());
					existingUser.setMa_name(updatedUser.getMa_name());
					existingUser.setMa_price(updatedUser.getMa_price());
					existingUser.setMa_quantity(updatedUser.getMa_quantity());
					
					

					return inventoryRepo.save(existingUser);
				}

				@Override
				public String delete(Inventory inventory) {
					inventoryRepo.delete(inventory);
					return inventory.getMa_id() + "deleted";
				}

				public Inventory fetchUserByUserName(String name) {
					// TODO Auto-generated method stub
					return inventoryRepo.findByUserName(name);
				};
				

				
				
			}





