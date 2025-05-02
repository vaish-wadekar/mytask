package com.task.machinetask.service;

import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;

import com.task.machinetask.entity.ApiResponse;
import com.task.machinetask.entity.Product;

public interface ProductService {
	public ApiResponse addProdcut(Product product);
	public ApiResponse updateProdcut(Product product);
	public List<Product> findAllProduct();
	public ApiResponse deletedProductById(Long id);
	public  Product findProdctById(Long id);


}
