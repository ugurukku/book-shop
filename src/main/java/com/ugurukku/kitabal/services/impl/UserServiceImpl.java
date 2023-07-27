package com.ugurukku.kitabal.services.impl;

import com.ugurukku.kitabal.dto.mapper.UserMapper;
import com.ugurukku.kitabal.dto.UserRequest;
import com.ugurukku.kitabal.entities.Role;
import com.ugurukku.kitabal.entities.User;
import com.ugurukku.kitabal.repositories.UserRepository;
import com.ugurukku.kitabal.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final UserMapper mapper;

    private final SequenceGeneratorService sequenceGenerator;

    private final PasswordEncoder encoder;

    @Override
    public void add(UserRequest userRequest) {
        User user = mapper.toEntity(userRequest);
        user.setPassword(encoder.encode(user.getPassword() ));
        user.setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
        user.setRole(Role.USER);
        user.setIsActive(true);

        repository.save(user);
    }

    @Override
    public User getByEmail(String email) {
        return repository.findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Istifadəçi adı və yta şifrə yanlışdır"));
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
}
