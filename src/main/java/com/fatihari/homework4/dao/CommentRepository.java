package com.fatihari.homework4.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatihari.homework4.dto.ProductCommentDTO;
import com.fatihari.homework4.entity.Product;
import com.fatihari.homework4.entity.ProductComment;
import com.fatihari.homework4.entity.UserAccount;

public interface CommentRepository extends JpaRepository<ProductComment, Long>
{
	// In JpaRepository, the id of foreign key properties is written as "_Id".
	
	List<ProductComment> findAllByUserAccount_Id(Long userId);
	List<ProductComment> findAllByProduct_Id(Long productId);

}
