package com.wiremockserenity.cucumber.serenity;

import com.google.gson.Gson;
import com.wiremockserenity.cucumber.model.DataModel;
import com.wiremockserenity.testbase.TestBase;
import com.wiremockserenity.utils.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.collection.IsMapContaining.hasKey;

public class GetWeatherFromActualSteps extends TestBase{
    public String email = "";
    DataModel dataModel;
    String firstName ="";
    String lastName = "";

    public void validateResponseOfZipCode(String zipCode) {
        SerenityRest.rest()
                .given()
                .when()
                .get("/weather?zip=" + zipCode + TestUtils.getAPIKey())
                .then()
                .assertThat()
                .body("$", hasKey("weather"));

    }

    public void validateResponseOfCityName(String cityName) {
        SerenityRest.rest()
                .given()
                .when()
                .get("/weather?q=" + cityName + TestUtils.getAPIKey())
                .then()
                .assertThat()
                .body("$", hasKey("weather"));

    }

    public void validateResponseOfCityID(String cityID) {
        SerenityRest.rest()
                .given()
                .when()
                .get("/weather?id=" + cityID + TestUtils.getAPIKey())
                .then()
                .assertThat()
                .body("$", hasKey("weather"));

    }

    public void validateStatusCode(int statusCode) {
        SerenityRest.rest()
                .then()
                .statusCode(200)
                .log()
                .all();
    }


    public void getClient(String state) {
        Response response = SerenityRest.rest()
                .given()
                .when()
                .get("/" + state + TestUtils.getKey());

        String bodyAsString = response.getBody().asString();
        System.out.println(response.getStatusCode());
        System.out.println("Client mutual funds investment in :" + JsonPath.from(bodyAsString).get("state").toString());

        Gson gson = new Gson();
        dataModel = gson.fromJson(bodyAsString, DataModel.class);
        if (Double.parseDouble(dataModel.getAsset().substring(1)) > 1000000) {
            email = dataModel.getEmail();
            firstName = JsonPath.from(bodyAsString).get("first_name").toString();
            lastName = JsonPath.from(bodyAsString).get("last_name").toString();
        }

    }

    @Step("Sending email to investment team")
    public void sendMail() {
        TestUtils.sendMail("Email to " + email + ".", "Client Name: " + firstName + " " + lastName);
        System.out.println("Email sent to : " + email);
    }
}
