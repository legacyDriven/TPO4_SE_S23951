package com.example.tpo_book_application_23951.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class BookDto {

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
