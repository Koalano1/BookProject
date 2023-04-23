package com.example.demo.Controller;


import org.springframework.data.domain.Pageable;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.BookEntity;
import com.example.demo.Entity.Category;
import com.example.demo.Service.BookService;

@Controller
public class BookController {
	
	/*
	 * @Autowired BookResponsitory bookRepository;
	 */
	
	@Autowired
	BookService bookService;
	
	
	@GetMapping({"/book-list"})
	public String listBook(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword, 
			@RequestParam(name = "category", defaultValue = "0") int category,
			@PageableDefault(size = 2, sort = "bookName", direction = Direction.DESC) Pageable pageable, HttpSession httpSession) {
		
		//List<BookEntity> list = bookService.findAll();
		Page<BookEntity> list = bookService.findByBookNameAndCategoryPageable(keyword, category, pageable);
		
		model.addAttribute("keyword", keyword);
		//List<BookEntity> list = bookService.findByBookNameAndCategory(keyword, category);
		List<Category> listCategory = bookService.findAllCategory();
		model.addAttribute("list", list);
		model.addAttribute("listCategory",listCategory);
		model.addAttribute("name", httpSession.getAttribute("UserName"));
		return "abc/booklist";
	}
	
	@GetMapping({"/create-book"})
	public String createBook(Model model) {
		List<Category> listCategory = bookService.findAllCategory();
		
		BookEntity book = new BookEntity();
		model.addAttribute("book", book);
		model.addAttribute("listCategory", listCategory);
		
		return "abc/CreateBook";
	}
	
	@PostMapping({"/create-book"})
	public String saveBook(@ModelAttribute ("book") @Valid BookEntity book, BindingResult bindingResult, Model model) {
		List<Category> listCategory = bookService.findAllCategory();
		if (bindingResult.hasErrors()) {
			model.addAttribute("listCategory", listCategory);
			return "abc/CreateBook";
		}
		bookService.save(book);
		return "redirect:/book-list";
	}
	
	@GetMapping({"/update-book/{bookId}"})
	public String editBook(@PathVariable int bookId, Model model, HttpSession session) {
		List<Category> listCategory = bookService.findAllCategory();
		session.setAttribute("bookId", bookId);
		BookEntity book = bookService.findById(bookId);
		model.addAttribute("book", book);
		model.addAttribute("listCategory", listCategory);
		return "abc/bookUpdate";
	}
	
	@PostMapping({"/update-book/{bookId}"})
	public String updateBook(@ModelAttribute("book") @Valid BookEntity book, BindingResult bindingResult, HttpSession session,  Model model) {
		List<Category> listCategory = bookService.findAllCategory();
		if (bindingResult.hasErrors()) {
			model.addAttribute("listCategory", listCategory);
			return "abc/CreateBook";
		}
		book.setBookId((int) session.getAttribute("bookId"));
		bookService.save(book);
		return "redirect:/book-list";
	}
	
	@GetMapping({"/delete-book/{bookId}"})
	public String deleteBook(@PathVariable int bookId) {
		bookService.remove(bookId);
		return "redirect:/book-list";
	}
	
	
}