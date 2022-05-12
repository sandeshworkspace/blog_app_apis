package com.nit.sandesh.service;

import com.nit.sandesh.payloads.CommentDto;

public interface ICommentsService {
	CommentDto createComment(CommentDto commentDto,Integer postId);
	void deleteComment(Integer commentId);

}
