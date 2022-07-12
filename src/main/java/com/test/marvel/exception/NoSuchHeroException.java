package com.test.marvel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NoSuchHeroException extends RuntimeException{
    public NoSuchHeroException(String message){super(message);}
}
