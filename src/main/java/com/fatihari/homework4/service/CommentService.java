package com.fatihari.homework4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatihari.homework4.dao.CommentRepository;
import com.fatihari.homework4.dto.ProductCommentDTO;
import com.fatihari.homework4.entity.ProductComment;
import com.fatihari.homework4.entity.UserAccount;

@Service
public class CommentService implements ICommentService {

	private CommentRepository commentRepository;
	
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public List<ProductComment> findAllByUserAccountId(Long userId) {
		return this.commentRepository.findAllByUserAccount_Id(userId);
	}

	@Override
	public List<ProductComment> findAllByProductId(Long productId) {
		return this.commentRepository.findAllByProduct_Id(productId);
	}

	@Transactional
	@Override
	public ProductComment save(ProductComment productComment) {
		return this.commentRepository.save(productComment);
	}

	@Override
	public ProductComment findById(Long commentId) {
		Optional<ProductComment> result = this.commentRepository.findById(commentId);
		ProductComment comment = null;
		
		if(result.isPresent())
			comment = result.get();
		else
			throw new RuntimeException("Did not find comment id - " + commentId);
		return comment;
	}

	@Transactional
	@Override
	public void deleteById(Long commentId) 
	{
		this.commentRepository.deleteById(commentId);
	}

	@Override
	public List<ProductComment> findAll() {
		// TODO Auto-generated method stub
		return this.commentRepository.findAll();
	}



}
