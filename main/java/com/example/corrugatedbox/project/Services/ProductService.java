package com.example.corrugatedbox.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.corrugatedbox.project.entity.Product;
import com.example.corrugatedbox.project.entity.Size;
import com.example.corrugatedbox.project.repository.ProductRepo;

@Service
public class ProductService implements CrudServices<Product , Integer> {

	

			@Autowired
		    private ProductRepo productRepository;

			@Override
			public Product create(Product product) {
				 return productRepository.save(product);
			
			}

			@Override
			public List<Product> fetchAll() {
				 return productRepository.findAll();
				
			}
			
			@Override
			public  Product fetchById(Integer id) {
				  return productRepository.findById(id)
			                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
			}

			@Override
			public Product update(Product existingUser, Product updatedUser) {
				existingUser.setP_id(updatedUser.getP_id());
				existingUser.setProduct_name(updatedUser.getProduct_name());
				existingUser.setQuantity(updatedUser.getQuantity());
			    existingUser.setPrize(updatedUser.getPrize());
			    existingUser.setDescription(updatedUser.getDescription());
			    

		        return(existingUser);
			}

			@Override
			public String delete(Product user) {
				productRepository.delete(user);
		        return "User deleted successfully";
			}

			public Size fetchUserByUserName(String name) {
				// TODO Auto-generated method stub
				return productRepository.findByUserName(name);
			}

			

			
}
