package com.ugurukku.kitabal.dto.mapper;

import com.ugurukku.kitabal.dto.UserRequest;
import com.ugurukku.kitabal.dto.auth.RegisterRequest;
import com.ugurukku.kitabal.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequest userRequest);
    User toEntity(RegisterRequest registerRequest);
}
