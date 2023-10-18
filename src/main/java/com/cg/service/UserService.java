package com.cg.service;

import java.util.List;

import com.cg.entity.User;
import com.cg.exception.InvalidContactNumber;

public interface UserService {
	
	/**
	 * This method helps to show all users
	 * @return List<User> -- will return all users
	 */
	public List<User> showUsers();

	/**
	 * This method helps to add new user
	 * @param user -- contains user details
	 * @return User -- will return added user details
	 * @throws InvalidContactNumber -- Can throw InvalidContactNumber Exception
	 */
	public User addUser(final User user);

	/**
	 * This method helps to update the user details
	 * @param user -- contains user details
	 * @return User -- will return updated user details
	 */
	public User updateUser(final User user, final Integer userId);

	/**
	 * This method helps to delete the user 
	 * @param userId -- contains user id
	 */
	public void deleteuserByID(final Integer userId);
}
