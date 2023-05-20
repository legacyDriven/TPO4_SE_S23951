package com.example.tpo_book_application_23951.api;

import com.example.tpo_book_application_23951.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class BookController {

    BookService bookService;

    @Operation(summary = "Get book by title")
    @GetMapping("/{title}")
    @ResponseStatus(OK)
    public BookDto getByTitle(@PathVariable String title) {
        return bookService.getByTitle(title);
    }

    @Operation(summary = "Add book")
    @PostMapping
    @ResponseStatus(CREATED)
    public BookDto addBook(@RequestBody CreateBookRequest request) {
        return bookService.addBook(request);
    }

    @Operation(summary = "Delete book by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<BookDto> deleteBookById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.deleteBookById(id), NO_CONTENT);
    }
}

