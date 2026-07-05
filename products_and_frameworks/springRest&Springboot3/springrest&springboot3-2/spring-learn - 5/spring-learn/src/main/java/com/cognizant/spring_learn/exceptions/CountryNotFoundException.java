package com.cognizant.spring_learn.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Country not Found")
public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(String message){
        super(message);
    }
}
