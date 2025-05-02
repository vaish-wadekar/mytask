package com.task.machinetask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.machinetask.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
