package com.cognizant.springlearn;

import com.cognizant.springlearn.controller.CountryController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Base64;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CountryController countryController;

    @Test
    public void contextLoads() {
        assertNotNull(countryController, "CountryController should be loaded in Spring context");
    }

    @Test
    public void testGetHelloWithoutAuth() throws Exception {
        mvc.perform(get("/hello"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testAuthenticateAndAccessEndpoints() throws Exception {

        String authHeaderValue = "Basic " + Base64.getEncoder().encodeToString("user:pwd".getBytes());

        MvcResult authResult = mvc.perform(get("/authenticate")
                .header(HttpHeaders.AUTHORIZATION, authHeaderValue))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists())
                .andReturn();

        String jsonResponse = authResult.getResponse().getContentAsString();
        @SuppressWarnings("unchecked")
        Map<String, String> map = new ObjectMapper().readValue(jsonResponse, Map.class);
        String token = map.get("token");
        assertNotNull(token);
        assertFalse(token.isEmpty());

        mvc.perform(get("/hello")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isOk());

        mvc.perform(get("/country")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("IN"))
                .andExpect(jsonPath("$.name").value("India"));

        mvc.perform(get("/countries")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(4));

        mvc.perform(get("/countries/us")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("US"))
                .andExpect(jsonPath("$.name").value("United States"));

        mvc.perform(get("/countries/xx")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isNotFound());
    }
}