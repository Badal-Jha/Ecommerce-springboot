package com.nagarro.restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.restapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
     //we dont have to implement it spring will implement this
	 Optional<User> findByUsername(String username);

}
