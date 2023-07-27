package com.ugurukku.kitabal.security;

public interface TokenGenerator<T>{

    String generate(T t);
}
