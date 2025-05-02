package com.task.machinetask.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.task.machinetask.entity.ApiResponse;
import com.task.machinetask.entity.Category;
import com.task.machinetask.entity.Product;

public interface CategoryService {
	public ApiResponse AddNewCategory(Category category);
	public ApiResponse updateCategory(Category category);
	public  Category findCategoryById(Long categoryId);
	public ApiResponse deleteCategoryById(Long categoryId);
    public List<Category> findAllCategory();
	public Page<Category> findAllProduct(Pageable pageable);
	
}
