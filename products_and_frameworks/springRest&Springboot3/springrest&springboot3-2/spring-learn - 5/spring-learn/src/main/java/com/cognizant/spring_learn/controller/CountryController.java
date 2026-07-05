package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.exceptions.CountryNotFoundException;
import com.cognizant.spring_learn.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@RestController

public class CountryController {

    @RequestMapping(value="/countries/{code}",method= RequestMethod.GET)
    public ResponseEntity<Country> getCountry(@PathVariable("code") String code){
        code =code.toUpperCase();
        HashMap<String,String> hs=new HashMap<>();
         hs.put("IN","India");
        hs.put("US","United States");
        hs.put("JP","Japan");
        hs.put("DE","Germany");
        if(hs.get(code)==null){
            throw new CountryNotFoundException("Provided code is not found please check");
        }
         Country country=new Country(code,hs.get(code));
         return ResponseEntity.ok(country);


    }
//    @ExceptionHandler(CountryNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String handleException(CountryNotFoundException exception){
//        return exception.getMessage();
//    }

}
