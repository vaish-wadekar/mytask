package com.task.machinetask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.machinetask.entity.Product;

public interface ProductRespository  extends JpaRepository<Product, Long>{

}
