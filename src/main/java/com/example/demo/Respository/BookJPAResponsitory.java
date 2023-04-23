package com.example.demo.Respository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.BookEntity;

@Repository
public interface BookJPAResponsitory extends JpaRepository<BookEntity, Integer>{
	
	@Query("SELECT u FROM BookEntity u WHERE u.bookName LIKE %:name%")
	List<BookEntity> findByBookName(@Param("name") String bookName);
	
	@Query("SELECT u FROM BookEntity u WHERE u.bookName LIKE  %:name% AND u.category.categoryId = :category")
	List<BookEntity> findByBookNameAndCategory(@Param("name") String bookName, @Param("category") int category);
	
	@Query("SELECT u FROM BookEntity u WHERE u.category.categoryId = :category")
	List<BookEntity> findByCategoryName(@Param("category") int categoryName);
	
	
	//Pageable de phan trang
	@Query("SELECT u FROM BookEntity u")
	Page<BookEntity> findAllPageable(Pageable pageable);
	
	@Query("SELECT u FROM BookEntity u WHERE u.bookName LIKE %:name%")
	Page<BookEntity> findByBookNamePageable(@Param("name") String bookName, Pageable pageable);
	
	@Query("SELECT u FROM BookEntity u WHERE u.bookName LIKE  %:name% AND u.category.categoryId = :category")
	Page<BookEntity> findByBookNameAndCategoryPageable(@Param("name") String bookName, @Param("category") int category, Pageable pageable);
	
	@Query("SELECT u FROM BookEntity u WHERE u.category.categoryId = :category")
	Page<BookEntity> findByCategoryNamePageable(@Param("category") int categoryName, Pageable pageable);
	
}
