package com.task.machinetask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.machinetask.entity.ApiResponse;
import com.task.machinetask.entity.Category;
import com.task.machinetask.entity.Product;
import com.task.machinetask.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> addCategory(@RequestBody Category category) {

		return new ResponseEntity<ApiResponse>(this.categoryService.AddNewCategory(category), HttpStatus.CREATED);

	}

	@PutMapping("/")
	public ResponseEntity<ApiResponse> updateCategory(@RequestBody Category category) {

		return new ResponseEntity<ApiResponse>(this.categoryService.updateCategory(category), HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable long id) {

		return new ResponseEntity<ApiResponse>(this.categoryService.deleteCategoryById(id), HttpStatus.CREATED);

	}

	@GetMapping("/")
	public ResponseEntity<List<Category>> findCategory() {

		return new ResponseEntity<List<Category>>(this.categoryService.findAllCategory(), HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> findCategoryById(@PathVariable long id) {

		return new ResponseEntity<Category>(this.categoryService.findCategoryById(id), HttpStatus.CREATED);

	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Category>> findAllProduct(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    Page<Category> pagedProducts = categoryService.findAllProduct(pageable);
	    return new ResponseEntity<>(pagedProducts, HttpStatus.OK);
	}

}
