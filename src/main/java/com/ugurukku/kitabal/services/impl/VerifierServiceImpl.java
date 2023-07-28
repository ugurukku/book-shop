package com.ugurukku.kitabal.services.impl;

import com.ugurukku.kitabal.entities.Verifier;
import com.ugurukku.kitabal.exceptions.UnSuccessfulVerificationException;
import com.ugurukku.kitabal.repositories.VerifierRepository;
import com.ugurukku.kitabal.services.VerifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerifierServiceImpl implements VerifierService {

    private final VerifierRepository verifierRepository;

    @Override
    public void verify(String email, String code) {
        boolean exists = verifierRepository.existsByEmailAndCode(email, code);
        if (!exists){
            throw new UnSuccessfulVerificationException("Təsdiqləmə prosesi zamanı bir xəta baş verdi");
        }
        verifierRepository.deleteById(email);
    }

    @Override
    public void add(String email, String code) {
        Verifier verifier = Verifier.builder()
                .email(email)
                .code(code)
                .build();

        verifierRepository.save(verifier);
    }

}
