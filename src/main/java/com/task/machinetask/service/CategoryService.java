package com.task.machinetask.service;

import java.util.List;


import com.task.machinetask.entity.ApiResponse;
import com.task.machinetask.entity.Category;

public interface CategoryService {
	public ApiResponse AddNewCategory(Category category);
	public ApiResponse updateCategory(Category category);
	public  Category findCategoryById(Long categoryId);
	public ApiResponse deleteCategoryById(Long categoryId);
    public List<Category> findAllCategory();
	
}
