package com.wiremockserenity.cucumber.serenity;

import com.wiremockserenity.utils.TestUtils;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.collection.IsMapContaining.hasKey;

public class GetWeatherFromLocalSteps {
    private static String localHost = "http://localhost:8080";

    public void validateResponseOfZipCode(String zipCode) {
        SerenityRest.rest()
                .given()
                .when()
                .get(localHost + "/zip=" + zipCode)
                .then()
                .assertThat()
                .body("$", hasKey("weather"));

    }

    public void validateResponseOfCityName(String cityName) {
        SerenityRest.rest()
                .given()
                .when()
                .get(localHost + "/q=" + cityName)
                .then()
                .assertThat()
                .body("$", hasKey("weather"));

    }

    public void validateResponseOfCityID(String cityID) {
        SerenityRest.rest()
                .given()
                .when()
                .get(localHost + "/id=" + cityID)
                .then()
                .assertThat()
                .body("$", hasKey("weather"));

    }
}
