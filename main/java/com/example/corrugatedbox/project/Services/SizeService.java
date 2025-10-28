package com.example.corrugatedbox.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.corrugatedbox.project.CustomException.UserNotFoundException;
import com.example.corrugatedbox.project.entity.Size;
import com.example.corrugatedbox.project.repository.SizeRepo;

@Service
public class SizeService implements CrudServices<Size , Integer>{



		@Autowired
		private SizeRepo sizeRepo;

		@Override
		public Size create(Size size) {
			return sizeRepo.save(size);
		}

		@Override
		public List<Size> fetchAll() {
			
			return sizeRepo.findAll();
		}

		@Override
		public Size fetchById(Integer id) {
			return sizeRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Invalid id"));
		}

		@Override
		public Size update(Size updatedUser, Size existingUser) {
			existingUser.sets_id(updatedUser.gets_id());
			existingUser.setDepth(updatedUser.getDepth());
			existingUser.setHeight(updatedUser.getHeight());
			existingUser.setWidth(updatedUser.getWidth());

			return sizeRepo.save(existingUser);
		}

		@Override
		public String delete(Size size) {
			sizeRepo.delete(size);
			return size.gets_id() + "deleted";
		}

		public Size fetchUserByUserName(String name) {
			// TODO Auto-generated method stub
			return SizeRepo.findByUserName(name);
		}
		
		

		
	}


