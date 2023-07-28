package com.ugurukku.kitabal.services;


public interface VerifierService {

    void verify(String email,String verificationCode);

    void add(String email,String code);


}
