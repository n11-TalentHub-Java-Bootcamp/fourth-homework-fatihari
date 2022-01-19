package com.fatihari.homework4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatihari.homework4.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
	
}
