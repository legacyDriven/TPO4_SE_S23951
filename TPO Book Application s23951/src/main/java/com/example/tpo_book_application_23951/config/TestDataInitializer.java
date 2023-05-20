package com.example.tpo_book_application_23951.config;

import com.example.tpo_book_application_23951.model.Book;
import com.example.tpo_book_application_23951.repository.BookRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestDataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public TestDataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        // Tworzenie danych testowych
        Faker faker = new Faker();
        for (int i = 0; i < 20; i++) {
            Book book = new Book();
            book.setTitle(faker.book().title());
            book.setAuthor(faker.book().author());
            book.setIsbn(faker.code().isbn10());
            book.setPublisher(faker.book().publisher());
            book.setReleaseYear(faker.number().numberBetween(1900, 2022));
            book.setDescription(faker.lorem().sentence());
            book.setLanguage(faker.nation().language());
            book.setAvailable(faker.random().nextBoolean());

            bookRepository.save(book);
        }
    }
}

