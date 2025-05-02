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
import com.task.machinetask.entity.Product;
import com.task.machinetask.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> addProduct(@RequestBody Product product) {
		return new ResponseEntity<ApiResponse>(this.productService.addProdcut(product), HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<ApiResponse> updateProduct(@RequestBody Product product) {
		return new ResponseEntity<ApiResponse>(this.productService.updateProdcut(product), HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<Product>> findAllProduct() {
		return new ResponseEntity<List<Product>>(this.productService.findAllProduct(), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findProductByid(@PathVariable long id) {
		return new ResponseEntity<Product>(this.productService.findProdctById(id), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteProductByid(@PathVariable long id) {
		return new ResponseEntity<ApiResponse>(this.productService.deletedProductById(id), HttpStatus.CREATED);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Product>> findAllProduct(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    Page<Product> pagedProducts = productService.findAllProduct(pageable);
	    return new ResponseEntity<>(pagedProducts, HttpStatus.OK);
	}


}
