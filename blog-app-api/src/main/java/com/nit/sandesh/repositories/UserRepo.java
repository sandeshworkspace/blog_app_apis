package com.nit.sandesh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.sandesh.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmail(String email);

}
