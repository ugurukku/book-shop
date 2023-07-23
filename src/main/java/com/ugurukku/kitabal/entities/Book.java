package com.ugurukku.kitabal.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "books")
public class Book {

    @Transient
    public static final String SEQUENCE_NAME = "books_sequence";

    @Id
    Long id;

    String name;

    String description;

    Integer page;

    Integer rate;

    Integer stock;

    Double price;

    @DocumentReference
    Author author;

    @DocumentReference
    Category category;

    @DocumentReference
    Publisher publisher;

    @DocumentReference
    Language language;

    @DocumentReference
    List<Comment> comments;






}
