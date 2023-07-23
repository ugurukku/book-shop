package com.ugurukku.kitabal.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "authors")
public class Author {

    @Transient
    public static final String SEQUENCE_NAME = "authors_sequence";

    @Id
    Long id;

    String name;

    String about;


}
