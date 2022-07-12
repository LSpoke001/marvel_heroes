package com.test.marvel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class HeroGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<HeroIncorrectData> handleException(NoSuchHeroException exception){
        HeroIncorrectData data = new HeroIncorrectData(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
