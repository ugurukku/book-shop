package com.ugurukku.kitabal.exceptions;

public class EmailAlreadyTakenException extends RuntimeException {
    public EmailAlreadyTakenException() {
        super("Bu email ilə hesab mövcuddur!");
    }
}
