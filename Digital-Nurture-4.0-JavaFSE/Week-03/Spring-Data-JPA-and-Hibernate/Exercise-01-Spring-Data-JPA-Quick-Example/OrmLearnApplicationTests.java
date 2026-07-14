package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrmLearnApplicationTests {

    @Autowired
    private CountryService countryService;

    @Test
    public void testGetAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        assertNotNull(countries);
        assertTrue(countries.size() >= 4, "Should have at least the seeded countries");
    }

    @Test
    public void testFindCountryByCodeSuccess() throws CountryNotFoundException {
        Country country = countryService.findCountryByCode("IN");
        assertNotNull(country);
        assertEquals("India", country.getName());
    }

    @Test
    public void testFindCountryByCodeNotFound() {
        assertThrows(CountryNotFoundException.class, () -> {
            countryService.findCountryByCode("XX");
        });
    }

    @Test
    public void testAddCountry() throws CountryNotFoundException {
        Country newCountry = new Country("RU", "Russia");
        countryService.addCountry(newCountry);

        Country fetched = countryService.findCountryByCode("RU");
        assertNotNull(fetched);
        assertEquals("Russia", fetched.getName());

        countryService.deleteCountry("RU");
    }

    @Test
    public void testUpdateCountry() throws CountryNotFoundException {

        countryService.updateCountry("JP", "Japan Updated");

        Country fetched = countryService.findCountryByCode("JP");
        assertEquals("Japan Updated", fetched.getName());

        countryService.updateCountry("JP", "Japan");
    }

    @Test
    public void testDeleteCountry() {
        Country temp = new Country("DE", "Germany");
        countryService.addCountry(temp);

        countryService.deleteCountry("DE");

        assertThrows(CountryNotFoundException.class, () -> {
            countryService.findCountryByCode("DE");
        });
    }
}