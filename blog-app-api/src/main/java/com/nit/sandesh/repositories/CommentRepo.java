package com.nit.sandesh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.sandesh.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer> {

}
