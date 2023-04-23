package com.example.demo.Service;


import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.BookEntity;
import com.example.demo.Entity.Category;
import com.example.demo.Respository.BookJPAResponsitory;
import com.example.demo.Respository.CategoryJPARespository;

@Service
public class BookService {
	@Autowired
	BookJPAResponsitory bookJPAResponsitory;

	@Autowired
	CategoryJPARespository categoryJPARespository;

	public List<BookEntity> findAll() {
		return bookJPAResponsitory.findAll();
	}

	public List<BookEntity> findByBookNameAndCategory(String bookName, int category) {
		if (bookName.isEmpty() && category == 0) {
			return bookJPAResponsitory.findAll();
		} else if(!bookName.isEmpty() && category != 0){
			return bookJPAResponsitory.findByBookNameAndCategory(bookName, category);
		}else if(bookName.isEmpty() && category != 0) {
			return bookJPAResponsitory.findByCategoryName(category);
		} else {
			return bookJPAResponsitory.findByBookName(bookName);
		}
	}
	
	public Page<BookEntity> findByBookNameAndCategoryPageable(String bookName, int category, Pageable pageable) {
		if (bookName.isEmpty() && category == 0) {
			return bookJPAResponsitory.findAllPageable(pageable);
		} else if(!bookName.isEmpty() && category != 0){
			return bookJPAResponsitory.findByBookNameAndCategoryPageable(bookName, category, pageable);
		}else if(bookName.isEmpty() && category != 0) {
			return bookJPAResponsitory.findByCategoryNamePageable(category, pageable);
		} else {
			return bookJPAResponsitory.findByBookNamePageable(bookName, pageable);
		}
	}

	public void save(BookEntity bookEntity) {
		bookJPAResponsitory.save(bookEntity);
	}

	public void remove(int id) {
		bookJPAResponsitory.deleteById(id);
	}

	public BookEntity findById(int id) {
		return bookJPAResponsitory.findById(id).orElse(null);
	}

	public List<Category> findAllCategory() {
		return categoryJPARespository.findAll();
	}

}
