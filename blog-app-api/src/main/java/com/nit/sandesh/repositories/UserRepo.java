package com.nit.sandesh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.sandesh.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
