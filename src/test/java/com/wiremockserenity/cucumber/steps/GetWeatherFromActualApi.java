package com.wiremockserenity.cucumber.steps;

import com.wiremockserenity.cucumber.serenity.GetWeatherFromActualSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GetWeatherFromActualApi {
    private GetWeatherFromActualSteps getWeatherFromActualSteps = new GetWeatherFromActualSteps();

    @Given("^The user requests a GET request for the ZipCode \"([^\"]*)\"$")
    public void getWeatherUsingZipCode(String zipCode) {
        getWeatherFromActualSteps.validateResponseOfZipCode(zipCode);
    }

    @Given("^The user requests a GET request for the City Name \"([^\"]*)\"$")
    public void getWeatherUsingCityName(String cityName) {
        getWeatherFromActualSteps.validateResponseOfCityName(cityName);
    }

    @Given("^The user requests a GET request for the City ID \"([^\"]*)\"$")
    public void getWeatherUsingCityID(String cityID) {
        getWeatherFromActualSteps.validateResponseOfCityID(cityID);
    }


    @Then("^The weather is returned with Status code (\\d+)$")
    public void theWeatherIsReturnedWithStatusCode(int statusCode) {
        getWeatherFromActualSteps.validateStatusCode(statusCode);
    }
}
