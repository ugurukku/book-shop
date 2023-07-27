package com.ugurukku.kitabal.entities;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "users")
public class User {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    Long id;

    String firstName;

    String lastName;

    String phone;

    String address;

    @Indexed(unique = true)
    String email;

    String password;

    Boolean isActive = false;

    Role role = Role.USER;

}
