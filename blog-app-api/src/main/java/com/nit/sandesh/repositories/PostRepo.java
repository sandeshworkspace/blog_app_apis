package com.nit.sandesh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.sandesh.entity.Category;
import com.nit.sandesh.entity.Post;
import com.nit.sandesh.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);

}
