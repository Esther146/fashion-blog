package com.esther.fashion_ecommerce.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserNotFoundException extends RuntimeException{

    private String message;
    public UserNotFoundException(String s) {
        this.message = s;
    }

}
