package com.example.demo.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.example.demo.validation.CheckDay;
import com.example.demo.validation.NullOrBlank;

@Entity
@Table(name = "book")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;

	@NullOrBlank
	@Size(min = 3, max = 10)
	private String bookName;

	private int price;

	@CheckDay
	private Date day;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
