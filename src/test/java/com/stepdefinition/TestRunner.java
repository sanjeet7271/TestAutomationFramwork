package com.stepdefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


/**
 * 
 * @author Sanjeet Kumar Pandit
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",
				glue = { "com/stepdefinition" },
				monochrome = true,
				plugin = {
						"pretty", "json:target/cucumber-report/cucumber.json",
						"html:target/cucumber-report/cucumber.html" }, 
				tags = "@SmokeTest or @RandomJokes")
public class TestRunner {

}
