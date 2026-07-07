package com.example.country_service.controller;

import com.example.country_service.model.Country;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController{
    private final Logger logger= LoggerFactory.getLogger(CountryController.class);
    @PostMapping("/countries")
    public Country addCountry(@RequestBody @Valid Country country) {
     return country;
    }

}
