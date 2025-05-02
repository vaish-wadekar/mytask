package com.task.machinetask.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.machinetask.entity.ApiResponse;
import com.task.machinetask.entity.Category;
import com.task.machinetask.repository.CategoryRepository;
import com.task.machinetask.service.CategoryService;




@Service
public class CategoryImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public ApiResponse AddNewCategory(Category category) {
		Category save = this.categoryRepository.save(category);

		ApiResponse apiResponse = new ApiResponse();

		if (save == null) {
			apiResponse.setMessage("some things went wrong");
			apiResponse.setStatus(false);
			return apiResponse;

		}
		apiResponse.setMessage("category added successfully");
		apiResponse.setStatus(true);

		return apiResponse;
	}

	@Override
	public ApiResponse updateCategory(Category category) {
		Category category12 = this.categoryRepository.findById(category.getId())
				.orElseThrow(() -> new IllegalArgumentException("category not found with given id" + category.getId()));

		this.categoryRepository.save(category);

		return ApiResponse.builder().message("category updated successfully").status(true).build();
	}

	@Override
	public Category findCategoryById(Long categoryId) {

		return this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new IllegalArgumentException("category not found with given id" + categoryId));
	}

	@Override
	public ApiResponse deleteCategoryById(Long categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new IllegalArgumentException("category not found with given id" + categoryId));
		this.categoryRepository.delete(category);
		return ApiResponse.builder().message("category deleted successfully").status(true).build();
	}

	@Override
	public List<Category> findAllCategory() {

		return this.categoryRepository.findAll();
	}

}
