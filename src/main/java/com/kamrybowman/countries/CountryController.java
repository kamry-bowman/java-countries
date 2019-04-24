package com.kamrybowman.countries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.function.Predicate;

@RestController
public class CountryController {

    private void filterCountries (Predicate<Country> filter, ArrayList<Country> list) {
        list.removeIf(filter);
    }

    private void sortCountries(ArrayList<Country> list) {
        list.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
    }

    @RequestMapping("/all")
    public ArrayList<Country> getAll() {
        return CountriesApplication.countryList;
    }

    @RequestMapping("/begin")
    public ArrayList<Country> filterBegin(@RequestParam(value="letter") String letter) {
        ArrayList<Country> result = new ArrayList<>(CountriesApplication.countryList);
        result.removeIf(country -> !country.getName().toLowerCase().startsWith(letter.toLowerCase()));
        sortCountries(result);
        return result;
    }

    @RequestMapping("/size")
    public ArrayList<Country> filterSize(@RequestParam(value="letters") int letters) {
        ArrayList<Country> result = new ArrayList<>(CountriesApplication.countryList);
        result.removeIf(country -> country.getName().length() > letters);
        sortCountries(result);
        return result;
    }
}
