package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class CountryController {

    @RequestMapping(value="/countries",method= RequestMethod.GET)
    public ResponseEntity<List<Country>> getCountryIndia(){
        List<Country> countries = new ArrayList<>();
        Country india=new Country("IN","India");
        Country unitedstates =new Country("US","United States");
        Country japan =new Country("JP","Japan");
        Country germany=new Country("DE","Germany");
         countries.add(india);
         countries.add(unitedstates);
         countries.add(japan);
         countries.add(germany);
         return ResponseEntity.ok(countries);


    }
}
