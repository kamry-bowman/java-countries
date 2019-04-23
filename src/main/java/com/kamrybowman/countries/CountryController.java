package com.kamrybowman.countries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CountryController {

    @RequestMapping("/all")
    public ArrayList<Country> getAll() {
        return CountriesApplication.countryList;
    }
}
