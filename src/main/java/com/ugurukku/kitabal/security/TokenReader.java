package com.ugurukku.kitabal.security;

public interface TokenReader <T>{

    T read(String token);

}
