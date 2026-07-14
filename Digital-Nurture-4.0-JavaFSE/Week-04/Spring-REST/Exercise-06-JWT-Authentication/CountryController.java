package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        LOGGER.info("Inside CountryController Constructor.");
        this.countryService = countryService;
    }

    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("getCountryIndia START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country india = context.getBean("in", Country.class);
        LOGGER.debug("India Country: {}", india);
        LOGGER.info("getCountryIndia END");
        return india;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("getAllCountries START");
        List<Country> list = countryService.getAllCountries();
        LOGGER.info("getAllCountries END");
        return list;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
        LOGGER.info("getCountry START for code: {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("getCountry END");
        return country;
    }
}