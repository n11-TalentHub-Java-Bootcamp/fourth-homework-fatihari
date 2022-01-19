package com.fatihari.homework4.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatihari.homework4.entity.Category;
import com.fatihari.homework4.service.ICategoryService;
import com.fatihari.homework4.service.IProductService;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    @Autowired
    private ICategoryService categoryService;

    
    @GetMapping("")
    public List<Category> findAll(){

        List<Category> kategoriList = categoryService.findAll();

        return kategoriList;
    }

   
}