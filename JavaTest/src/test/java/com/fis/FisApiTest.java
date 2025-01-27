package com.fis;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
public class FisApiTest {
    @Test
    public void verifyCurrencyResponse() {
            // Define the API endpoint
        String endpoint = "https://api.coindesk.com/v1/bpi/currentprice.json";

            // Send the GET request and get the response
        Response response = RestAssured.get(endpoint);

            // status code check
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");

            // Parse the response
        Map<String, Object> jsonResponse = response.jsonPath().getMap("$");

            // Extract the object from the response
        Map<String, Object> cur = (Map<String, Object>) jsonResponse.get("bpi");

            // Verify there are exactly 3 BPIs (USD, GBP, EUR)
        Assert.assertEquals(cur.size(), 3, "BPI count is not 3");
        Assert.assertTrue(cur.containsKey("USD"), "USD BPI is missing");
        Assert.assertTrue(cur.containsKey("GBP"), "GBP BPI is missing");
        Assert.assertTrue(cur.containsKey("EUR"), "EUR BPI is missing");

            // Verify the GBP 'description' equals 'British Pound Sterling'
        Map<String, Object> gbp = (Map<String, Object>) cur.get("GBP");
        String description = (String) gbp.get("description");
        Assert.assertEquals(description, "British Pound Sterling", "GBP description does not match");

        System.out.println("API response validation completed.");
        }
    }

