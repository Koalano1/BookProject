package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.BookEntity;
import com.example.demo.Entity.Category;
import com.example.demo.Respository.BookJPAResponsitory;
import com.example.demo.Respository.CategoryJPARespository;

@Service
public class CategoryService {
	@Autowired
	CategoryJPARespository categoryJPARespository;
	
	@Autowired
	BookJPAResponsitory bookJPAResponsitory;


	public List<Category> findAll() {
		return categoryJPARespository.findAll();
	}

	public List<Category> findByCategoryName(String CategoryName) {
		if (CategoryName.isEmpty()) {
			return categoryJPARespository.findAll();		
		} else {
			return categoryJPARespository.findByCategoryName(CategoryName);
		}
	}
	
	//Phan trang
	public Page<Category> findByCategoryNamePageable(String CategoryName, Pageable pageable) {
		if (CategoryName.isEmpty()) {
			return categoryJPARespository.findAllPageable(pageable);		
		} else {
			return categoryJPARespository.findByCategoryNamePageable(CategoryName, pageable);
		}
	}

	public void save(Category category) {
		categoryJPARespository.save(category);
	}

//	public List<Category> findByName(String categoryName){
//		return categoryJPARespository.findByCategoryNameLike(categoryName);
//	}

	public String validateCategoryName(String categoryName) {
		String messenge = "";
		List<Category> list = categoryJPARespository.findByCategoryNameLike(categoryName);
		if (list.size() > 0) {
			messenge = categoryName + "Da ton tai!";
		}
		return messenge;
	}

	public void remove(int id) {
		categoryJPARespository.deleteById(id);
	}

	public Category findById(int id) {
		return categoryJPARespository.findById(id).orElse(null);
	}

	public List<BookEntity> findAllBook() {
		return bookJPAResponsitory.findAll();
	}

}
