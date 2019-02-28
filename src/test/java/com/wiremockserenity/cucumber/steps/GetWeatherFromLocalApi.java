package com.wiremockserenity.cucumber.steps;

import com.wiremockserenity.cucumber.serenity.GetWeatherFromActualSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GetWeatherFromLocalApi {
    private GetWeatherFromActualSteps getWeatherFromActualSteps = new GetWeatherFromActualSteps();

    @Given("^The user requests temperature for the ZipCode \"([^\"]*)\" from local server$")
    public void getWeatherUsingZipCodeFromLocalAPI(String zipCode) {
        getWeatherFromActualSteps.validateResponseOfZipCode(zipCode);
    }

    @Given("^The user requests temperature for the City Name \"([^\"]*)\" from local server$")
    public void getWeatherUsingCityNameFromLocalAPI(String cityName) {
        getWeatherFromActualSteps.validateResponseOfCityName(cityName);
    }

    @Given("^The user requests temperature for the City ID \"([^\"]*)\" from local server$")
    public void getWeatherUsingCityIDFromLocalAPI(String cityID) {
        getWeatherFromActualSteps.validateResponseOfCityID(cityID);
    }

    @Given("^The user requests the clients from \"([^\"]*)\"$")
    public void theUserRequestsTheClientsFrom(String state) {

        getWeatherFromActualSteps.getClient(state);
    }

    @Then("^The email should be sent to the clients with assets more than a million$")
    public void theEmailShouldBeSentToTheClientsWithAssetsMoreThanAMillion() {
        getWeatherFromActualSteps.sendMail();
    }

}
