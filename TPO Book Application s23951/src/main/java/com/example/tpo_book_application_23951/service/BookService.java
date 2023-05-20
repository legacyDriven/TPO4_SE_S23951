package com.example.tpo_book_application_23951.service;

import com.example.tpo_book_application_23951.api.BookDto;
import com.example.tpo_book_application_23951.api.CreateBookRequest;
import com.example.tpo_book_application_23951.model.Book;
import com.example.tpo_book_application_23951.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class BookService {

    BookRepository bookRepository;

    ModelMapper mapper;

    public BookDto getByTitle(String title) {
        Optional<Book> book = bookRepository.getBookByTitle(title);
        return book
                .map(b -> mapper.map(b, BookDto.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    public BookDto addBook(CreateBookRequest request) {
        Book book = mapper.map(request, Book.class);
        book = bookRepository.save(book);
        return mapper.map(book, BookDto.class);
    }

    public BookDto deleteBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }

        Book book = bookOptional.get();
        BookDto bookDto = mapper.map(book, BookDto.class);
        System.out.println(bookDto);
        bookRepository.delete(book);

        return bookDto;
    }

    public BookDto updateBookById(Long id, CreateBookRequest request) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }

        Book book = bookOptional.get();
        mapper.map(request, book); // Zaktualizuj pola książki na podstawie danych z request

        book = bookRepository.save(book); // Zapisz zaktualizowaną książkę w bazie danych

        return mapper.map(book, BookDto.class);
    }

}
