package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.User;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public List<User> showUsers() {
		return userRepository.findAll();
	}

	@Transactional
	@Override
	public User addUser(final User user){
		User addeduser = userRepository.save(user);
		return addeduser;
	}

	@Override
	public User updateUser(final User user, final Integer userId) {
		User updatedUser = null;
		User previousUser = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Resource not found for given id : " + userId));
		if(previousUser != null) {
			previousUser.setContact(user.getContact());
			previousUser.setEmail(user.getEmail());
			previousUser.setFirstName(user.getFirstName());
			previousUser.setLastName(user.getLastName());
			previousUser.setPassword(user.getPassword());
			previousUser.setUserId(userId);
			updatedUser = userRepository.save(previousUser);
		}
		return updatedUser;
	}

	@Override
	public void deleteuserByID(final Integer userId) {
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Resource not found for given id : " + userId));
        userRepository.deleteById(userId);

	
  }
}
