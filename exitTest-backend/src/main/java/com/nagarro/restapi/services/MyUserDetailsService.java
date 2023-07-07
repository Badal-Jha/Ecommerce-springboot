package com.nagarro.restapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.restapi.config.MyUserDetails;
import com.nagarro.restapi.entities.User;
import com.nagarro.restapi.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Optional<User> user=userRepo.findByUsername(username);
		
	    user.orElseThrow(()->new UsernameNotFoundException("username not found "+username));
	    return user.map(u->new MyUserDetails(u)).get();
	    //return user.map(MyUserDetails::new).get() this is by method reference
	}

}
