package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CountryController {

    @RequestMapping(value="/country",method= RequestMethod.GET)
    public ResponseEntity<Country> getCountryIndia(){
        Country country=new Country("IN","India");
        return ResponseEntity.ok(country);
    }
}
