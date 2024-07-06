package com.mini.springlv2library.repository;

import com.mini.springlv2library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
