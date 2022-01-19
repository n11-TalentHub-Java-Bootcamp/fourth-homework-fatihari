package com.fatihari.homework4.service;

import java.util.List;
import java.util.Optional;

import com.fatihari.homework4.dto.ProductCommentDTO;
import com.fatihari.homework4.entity.ProductComment;
import com.fatihari.homework4.entity.UserAccount;

public interface ICommentService 
{
	public List<ProductComment> findAll();
	public List<ProductComment> findAllByUserAccountId(Long userId);
	public List<ProductComment> findAllByProductId(Long productId);
	public ProductComment save(ProductComment productComment);
	public ProductComment findById(Long commentId);
	public void deleteById(Long commentId);
}
