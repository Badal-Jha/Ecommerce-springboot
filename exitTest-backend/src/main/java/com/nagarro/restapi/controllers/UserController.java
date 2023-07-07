package com.nagarro.restapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.restapi.entities.Product;
import com.nagarro.restapi.entities.User;
import com.nagarro.restapi.services.UserService;

@RestController
public class UserController {
    @Autowired
	UserService userService;
    
   
    @CrossOrigin()
    @PostMapping("/user/register")
    public ResponseEntity<String>  register(@RequestBody User user) {
       
    	user.setActive(true);
    	user.setRoles("ROLE_USER");
    	return ResponseEntity.ok(userService.addUser(user));
    	
    }
    
    
    //user login
    @CrossOrigin()
    @PostMapping("/user/login")
    public User login(@RequestBody User user) throws Exception{
    
    	System.out.println("lgin");
    	
    	return userService.getUser(user);
    	
  }
    
}
