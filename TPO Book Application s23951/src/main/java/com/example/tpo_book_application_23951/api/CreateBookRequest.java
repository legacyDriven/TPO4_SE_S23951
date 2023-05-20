package com.example.tpo_book_application_23951.api;

import lombok.*;
import lombok.experimental.FieldDefaults;

//@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CreateBookRequest {

    String title;
    String author;
    String isbn;
    String publisher;
    Integer releaseYear;
    String description;
    String language;

}
