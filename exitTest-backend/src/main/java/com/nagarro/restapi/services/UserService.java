package com.nagarro.restapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nagarro.restapi.entities.User;
import com.nagarro.restapi.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class UserService {
 
	@Autowired 
	PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;
	
	public String addUser(User user) {
		
		
		User u= userRepository.findByUsername(user.getUsername()).orElseGet(() -> new User());
         
		if(u.getUsername()!=null) {
			return "this username already exist in db";
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		 userRepository.save(user);
		return "saved";
		
	}
	public long countusers() {
		return userRepository.count();
	}
	public User getUser(User user) {
		
		User u= userRepository.findByUsername(user.getUsername()).orElseGet(() -> new User());
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		boolean matches = encoder.matches(user.getPassword(),u.getPassword());
    
		if (matches) {
		    System.out.println("Password matches!");
		    return u;
		} else {
			 System.out.println("Password Not matches!");
		   return null;
		}
	}
}
