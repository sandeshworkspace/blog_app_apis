package com.nit.sandesh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.sandesh.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
