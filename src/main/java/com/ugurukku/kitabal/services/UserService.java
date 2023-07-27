package com.ugurukku.kitabal.services;

import com.ugurukku.kitabal.dto.UserRequest;
import com.ugurukku.kitabal.entities.User;

public interface UserService {
    void add(UserRequest userRequest);

    User getByEmail(String email);

    boolean existsByEmail(String email);
}
