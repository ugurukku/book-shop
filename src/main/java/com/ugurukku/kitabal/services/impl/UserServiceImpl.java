package com.ugurukku.kitabal.services.impl;

import com.ugurukku.kitabal.dto.mapper.UserMapper;
import com.ugurukku.kitabal.dto.UserRequest;
import com.ugurukku.kitabal.entities.User;
import com.ugurukku.kitabal.repositories.UserRepository;
import com.ugurukku.kitabal.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final UserMapper mapper;

    private final SequenceGeneratorService sequenceGenerator;

    @Override
    public void add(UserRequest userRequest) {
        User user = mapper.toEntity(userRequest);
        user.setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));

        repository.save(user);
    }
}
