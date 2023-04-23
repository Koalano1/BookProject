package com.example.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.BookEntity;
import com.example.demo.Entity.Category;
import com.example.demo.Service.CategoryService;

@Controller
public class CategoryController {

	/*
	 * @Autowired CategoryResponsitory categrResponsitory;
	 */
	
	@Autowired
	CategoryService categoryService;

	@GetMapping({ "/category-list" })
	public String CategoryList(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword, 
	@PageableDefault(size = 2, sort = "categoryName", direction = Direction.DESC) Pageable pageable) {
		
		//List<Category> list = categoryService.findByCategoryName(keyword);		
		Page<Category> list = categoryService.findByCategoryNamePageable(keyword, pageable);
		
		model.addAttribute("keyword", keyword);	
		model.addAttribute("list", list);
		return "Category/CategoryList";
	}

	@GetMapping({ "/create-category" })
	public String CreateCategory(Model model) {
		List<BookEntity> listBook = categoryService.findAllBook();
		Category category = new Category();
		model.addAttribute("category", category);
		model.addAttribute("listBook", listBook);
		return "Category/CreateCategory";
	}

	@PostMapping({ "/create-category" })
	public String SaveCategory(@ModelAttribute("category") @Valid Category category, BindingResult bindingResult) {
		String err = categoryService.validateCategoryName(category.getCategoryName());
		if(!err.isEmpty()) {
			ObjectError error = new ObjectError("categoryError", err);
			bindingResult.addError(error);
		}
		
		if(bindingResult.hasErrors()) {
			return "Category/CreateCategory";
		}
		
		categoryService.save(category);
		return "redirect:/category-list";
	}

	@GetMapping({ "/update-category/{id}" })
	public String editCategory(@PathVariable int id, Model model, HttpSession session) {
		session.setAttribute("id", id);
		Category category = categoryService.findById(id);
		model.addAttribute("category", category);
		return "Category/CategoryUpdate";

	}

	@PostMapping({ "/update-category/{id}" })
	public String updateCategory(@ModelAttribute("category") Category category, HttpSession session) {
		category.setCategoryId((int) session.getAttribute("id"));
		categoryService.save(category);
		return "redirect:/category-list";
	}

	@GetMapping({ "/delete-category/{id}" })
	public String deleteCategory(@PathVariable int id) {
		categoryService.remove(id);
		return "redirect:/category-list";
	}

}
