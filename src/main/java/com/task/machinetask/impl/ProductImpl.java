package com.task.machinetask.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.task.machinetask.entity.ApiResponse;
import com.task.machinetask.entity.Product;
import com.task.machinetask.repository.ProductRespository;
import com.task.machinetask.service.ProductService;



@Service
public class ProductImpl implements ProductService{
	
	 
	@Autowired
	private ProductRespository productRespository;

	@Override
	public ApiResponse addProdcut(Product product) {
		Product save = this.productRespository.save(product);
		
		ApiResponse apiResponse =new ApiResponse();
		
		if (save == null) {
			apiResponse.setMessage("some things went wrong");
			apiResponse.setStatus(false);
			return apiResponse;

		}
		apiResponse.setMessage("product added successfully");
		apiResponse.setStatus(true);

		return apiResponse;


	}

	@Override
	public ApiResponse updateProdcut(Product product) {
		Product producta = this.productRespository.findById(product.getId()).orElseThrow(()-> new IllegalArgumentException("product not found with given"+product.getId()));
		this.productRespository.save(product);
ApiResponse apiResponse =new ApiResponse();
		
		if (producta == null) {
			apiResponse.setMessage("some things went wrong");
			apiResponse.setStatus(false);
			return apiResponse;

		}
		apiResponse.setMessage("product updated successfully");
		apiResponse.setStatus(true);

		return apiResponse;

	}

	@Override
	public List<Product> findAllProduct() {
    
		return this.productRespository.findAll();
	}

	@Override
	public ApiResponse deletedProductById(Long id) {
		Product producta = this.productRespository.findById(id).orElseThrow(()-> new IllegalArgumentException("product not found with given"+id));  
		this.productRespository.delete(producta);
		return ApiResponse.builder().message("product is deleted successfully").status(true).build();
	}

	@Override
	public Product findProdctById(Long id) {
		// TODO Auto-generated method stub
		return this.productRespository.findById(id).orElseThrow(()-> new IllegalArgumentException("product not found with given"+id));  

	}

	@Override
	public Page<Product> findAllProduct(Pageable pageable) {
	    return this.productRespository.findAll(pageable);
	}

}
