package com.example.tpo_book_application_23951.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "books")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Book {

    @Id
    @GeneratedValue
    Long id;

    String title;

    String author;

    String isbn;

    String publisher;

    Integer releaseYear;

    String description;

    String language;

    Boolean available;


}
