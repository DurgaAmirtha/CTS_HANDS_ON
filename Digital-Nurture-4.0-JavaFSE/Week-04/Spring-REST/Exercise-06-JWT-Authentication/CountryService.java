package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    private final List<Country> countries;

    @SuppressWarnings("unchecked")
    public CountryService() {
        LOGGER.info("CountryService initialization start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        this.countries = context.getBean("countries", List.class);
        LOGGER.info("CountryService initialization end. Loaded countries: {}", countries.size());
    }

    public List<Country> getAllCountries() {
        LOGGER.info("getAllCountries START");
        LOGGER.info("getAllCountries END");
        return countries;
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("getCountry START for code: {}", code);
        Country result = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> {
                    LOGGER.warn("Country code {} not found in list.", code);
                    return new CountryNotFoundException("Country not found");
                });
        LOGGER.info("getCountry END");
        return result;
    }
}