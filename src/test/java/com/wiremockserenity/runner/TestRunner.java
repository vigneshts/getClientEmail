package com.wiremockserenity.runner;

import org.junit.runner.RunWith;
import com.wiremockserenity.testbase.TestBase;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/feature/GetAsset.feature"}
        , glue = {"com.wiremockserenity.cucumber.steps"})

public class TestRunner extends TestBase {


}

