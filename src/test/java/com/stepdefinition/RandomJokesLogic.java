package com.stepdefinition;

import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.junit.Assert;
import com.constants.HttpMethods;
import com.resourcesreader.ResourcesURLsReader;
import com.restassuredmethods.RestAssuredMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class RandomJokesLogic {
	public static Logger logger = Logger.getLogger(RandomJokesLogic.class);
	RestAssuredMethods restCall = new RestAssuredMethods();
	ResourcesURLsReader resources = new ResourcesURLsReader();
	private Response response;

	@Given("send request to randon joke url")
	public void send_request_to_randon_joke_url() {
		try {
			response = restCall.restAssuredMethods(HttpMethods.GET, "", resources.getJokesResourceURI());
			logger.info("successfully response recieved.");
		} catch (Exception e) {
			logger.error("failed " + e);
			Assert.fail("The response is not correct.");
		}
	}

	@Then("validate status code")
	public void validate_status_code() {
		try {
			int actualStatusCode = response.getStatusCode();
			assertEquals(200, actualStatusCode);
			logger.info("successfully validated  status code.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("status code is not matched.");
		}

	}

	@Then("validate random jokes data")
	public void validate_random_jokes_data() {

	}
}
