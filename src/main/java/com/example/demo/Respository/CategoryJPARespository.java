package com.example.demo.Respository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Category;

public interface CategoryJPARespository extends JpaRepository<Category, Integer>{
	List<Category> findByCategoryNameLike(String categoryName);
	
	@Query("SELECT u FROM Category u WHERE u.categoryName LIKE %:name%")
	List<Category> findByCategoryName(@Param("name") String categoryName);
	
	
	//Phan trang Pageable
	@Query("SELECT u FROM Category u")
	Page<Category> findAllPageable(Pageable pageable);
	
	@Query("SELECT u FROM Category u WHERE u.categoryName LIKE %:name%")
	Page<Category> findByCategoryNamePageable(@Param("name") String categoryName, Pageable pageable);
	
}
