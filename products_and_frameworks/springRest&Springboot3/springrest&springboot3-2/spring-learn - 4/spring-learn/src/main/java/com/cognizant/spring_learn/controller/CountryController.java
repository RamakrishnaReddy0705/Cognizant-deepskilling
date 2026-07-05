package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
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
         Country country=new Country(code,hs.get(code));
         return ResponseEntity.ok(country);


    }
}
