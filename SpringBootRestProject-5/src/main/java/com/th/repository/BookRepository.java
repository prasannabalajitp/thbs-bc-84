package com.th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.th.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
	
}
