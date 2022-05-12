package com.nit.sandesh.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.sandesh.entity.Comment;
import com.nit.sandesh.entity.Post;
import com.nit.sandesh.exception.ResourceNotFoundException;
import com.nit.sandesh.payloads.CommentDto;
import com.nit.sandesh.repositories.CommentRepo;
import com.nit.sandesh.repositories.PostRepo;
import com.nit.sandesh.service.ICommentsService;

@Service
public class CommentServiceImpl implements ICommentsService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "postId", postId));
		Comment comment =  this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment =  this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "commentId", commentId));
		this.commentRepo.delete(comment);
	}

}
