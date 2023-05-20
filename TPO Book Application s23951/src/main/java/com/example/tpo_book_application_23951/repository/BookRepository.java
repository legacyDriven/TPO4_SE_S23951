package com.example.tpo_book_application_23951.repository;

import com.example.tpo_book_application_23951.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public Optional<Book> getBookByTitle(String title);

}
