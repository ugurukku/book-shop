package com.ugurukku.kitabal.dto.email;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailDto {

    String recipient;
    String subject;
    String message;
    boolean isHtml;

}
