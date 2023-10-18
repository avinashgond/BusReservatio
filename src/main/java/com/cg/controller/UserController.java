package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.service.UserService;


@RestController
@CrossOrigin
@RequestMapping(path = "/BusApp")
public class UserController {
	
	 @Autowired
	 private UserService userService;

	   @GetMapping("/user")
	    public ResponseEntity<List<User>> showUser() {
	        List<User> userList = userService.showUsers();
	        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	    }


	   @PostMapping("/user")
	    ResponseEntity<User> addUser(@Valid @RequestBody User user){
	        User addeduser = userService.addUser(user);
	        return new ResponseEntity<User>(addeduser, HttpStatus.CREATED);
	    }

	   @PutMapping("/{userId}")
	    ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable Integer userId) {
	        User updatedUser = userService.updateUser(user, userId);
	        return new ResponseEntity<User>(updatedUser, HttpStatus.ACCEPTED);
	    }

	   @DeleteMapping("/{userId} ")
	   public ResponseEntity<String> deleteUser(@PathVariable int userId) {
		   userService.deleteuserByID(userId);
	        return new ResponseEntity<String>("User with ID" + userId + "is deleted", HttpStatus.OK);
	   }

}
