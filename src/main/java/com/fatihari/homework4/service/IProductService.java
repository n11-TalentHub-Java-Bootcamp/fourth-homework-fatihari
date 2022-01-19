package com.fatihari.homework4.service;

import java.util.List;


import com.fatihari.homework4.entity.Product;

public interface IProductService 
{
	public List<Product> findAll();
	public Product findById(Long productId);
	public Product saveOrUpdate(Product product);
	public void delete(Product product);
	public void deleteById(Long productId);
	public Long count();
}
