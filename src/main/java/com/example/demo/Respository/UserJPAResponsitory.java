package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Account;

@Repository
public interface UserJPAResponsitory extends JpaRepository<Account, Integer>{	
	@Query("SELECT u FROM Account u WHERE u.email = :email and u.password = :password")
	Account findByEmailAndPass(@Param("email") String email, @Param("password") String pass);
}
