package com.wiremockserenity.cucumber.serenity;

import com.google.gson.Gson;
import com.wiremockserenity.cucumber.model.DataModel;
import com.wiremockserenity.utils.TestUtils;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.collection.IsMapContaining.hasKey;

public class GetWeatherFromActualSteps {
    public String email = "";
    DataModel dataModel;

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

//        ResponseBody body = response.getBody();

        String bodyAsString = response.getBody().asString();
        Gson gson = new Gson();
        dataModel = gson.fromJson(bodyAsString, DataModel.class);

//        DataModel dataModel = response.as(DataModel.class,ObjectMapperType.GSON);

//        DataModel dataModel = response.as(DataModel.class);
        if (Double.parseDouble(dataModel.getAsset().substring(1)) > 1000000) {
            email = dataModel.getEmail();
        }
    }

    @Step("Sending email to investment team")
    public void sendMail() {
        System.out.println("Email sent to : " + email);
    }
}
