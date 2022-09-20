package com.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature", glue = { "com/stepdefinition" }, monochrome = true, plugin = {
		"pretty", "json:target/cucumber-report/cucumber.json",
		"html:target/cucumber-report/cucumber.html" }, tags = "@SmokeTest")
public class TestRunner {

}
