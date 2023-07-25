package com.ugurukku.kitabal.entities;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "orders")
public class Order {

//    @Transient
//    public static final String SEQUENCE_NAME = "orders_sequence";
//
//    @Id
//    Long id;

    @DocumentReference
    Book book;

    Integer quantity;
}
