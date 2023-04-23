package com.example.demo.Respository;

//import java.awt.print.Book;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;
//
//import org.hibernate.Session;
///*import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;*/
//import org.springframework.stereotype.Repository;

//import com.example.demo.Entity.BookEntity;
//import com.example.demo.Entity.Category;
//
//@Transactional
//@Repository
public class BookResponsitory {
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public List<BookEntity> findAll(){
//		TypedQuery<BookEntity> query = entityManager.createQuery("Select p from BookEntity p", BookEntity.class);
//		List<BookEntity> bookList = query.getResultList();
//		return bookList;
//	}
//	
//	public BookEntity findById(int id) {
//		TypedQuery<BookEntity> query = entityManager.createQuery("Select p from BookEntity p where p.id =: id", BookEntity.class);
//		query.setParameter("id", id);
//		BookEntity book = query.getSingleResult();
//		return book;
//	}
//	
//	public void save(BookEntity bookEntity) {
//		if(bookEntity.getId() == 0) {
//			entityManager.persist(bookEntity);// persist: dùng để save object 
//		} else {
//			entityManager.merge(bookEntity);//merge: tương đương như update
//		}
//	}
//	
//	public void remove(int id) {
//		BookEntity bookEntity = findById(id);
//		entityManager.remove(bookEntity);
//	}
//	
//	public List<Category> findCategory(){
//		TypedQuery<Category> query = entityManager.createQuery("Select p from Category p", Category.class);
//		List<Category> list = query.getResultList();
//		return list;
//	}
//	
	
}
