package com.fatihari.homework4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatihari.homework4.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{
	
}
