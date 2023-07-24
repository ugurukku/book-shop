package com.ugurukku.kitabal.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "carts")
public class Cart {


    @Transient
    public static final String SEQUENCE_NAME = "carts_sequence";

    @Id
    Long id;

    @DocumentReference
    Set<Order> order;

    @DocumentReference
    @Indexed(unique = true)
    User user;

}
