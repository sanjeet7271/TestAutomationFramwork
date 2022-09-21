package com.stepdefinition;

import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.junit.Assert;
import com.constants.HttpMethods;
import com.constants.HttpStatusCodes;
import com.randomjokesdto.RandomJokesDTOs;
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

	@Given("^send request to random joke url$")
	public void sendRequestToRandomJoke() {
		try {
			response = restCall.restAssuredMethods(HttpMethods.GET, "", resources.getRandomJokesResourceURI());
			logger.info("successfully response recieved.");
		} catch (Exception e) {
			logger.error("failed " + e);
			Assert.fail("The response is not correct.");
		}
	}

	@Then("^validate status code$")
	public void validateStatusCode() {
		try {
			int actualStatusCode = response.getStatusCode();
			assertEquals(actualStatusCode, HttpStatusCodes.RESPONSE_STATUS_CODE_200);
			logger.info("successfully validated  status code.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("status code is not matched.");
		}
	}

	@Then("^print all random jokes data$")
	public void printRandomJokesData() {
		try {
			RandomJokesDTOs randomJokesDetails = response.as(RandomJokesDTOs.class);
			logger.info("successfully deserialized response.");
			System.out.println(randomJokesDetails.toString());
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("status code is not matched.");
		}
	}

	@Given("^send request to particular joke with id (.*)$")
	public void sendRequestToParticularJoke(String id) {
		try {
			String resourceURI = resources.getJokesResourceURI() + id;
			response = restCall.restAssuredMethods(HttpMethods.GET, "", resourceURI);
			logger.info("successfully response recieved.");
		} catch (Exception e) {
			logger.error("failed " + e);
			Assert.fail("The response is not correct.");
		}
	}

	@Then("^verify response status code$")
	public void verifyResponseStatusCode() {
		try {
			int actualStatusCode = response.getStatusCode();
			assertEquals(actualStatusCode, HttpStatusCodes.RESPONSE_STATUS_CODE_200);
			logger.info("successfully validated  status code.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("status code is not matched.");
		}
	}

	@Then("^verify response id (.*)$")
	public void verifyResponseId(String id) {
		RandomJokesDTOs randomJokes = response.as(RandomJokesDTOs.class);
		assertEquals(randomJokes.getId(), id);
	}

	@Then("^verify response Joke (.*)$")
	public void verifyJokeText(String joke) {
		RandomJokesDTOs randomJokes = response.as(RandomJokesDTOs.class);
		assertEquals(randomJokes.getValue(), joke);
	}
	@Then("^verify response url (.*)$")
	public void verifyResponseUrl(String url) {
		RandomJokesDTOs randomJokes = response.as(RandomJokesDTOs.class);
		assertEquals(randomJokes.getUrl(), url);
	}

	@Then("^verify response created at (.*)$")
	public void verifyResponseCreatedAt(String createdAt) {
		RandomJokesDTOs randomJokes = response.as(RandomJokesDTOs.class);
		assertEquals(randomJokes.getCreatedAt(), createdAt);
	}

	@Then("^verify response updated at (.*)$")
	public void verifyResponseUpdatedAt(String updatedAt) {
		RandomJokesDTOs randomJokes = response.as(RandomJokesDTOs.class);
		assertEquals(randomJokes.getUpdatedAt(), updatedAt);
	}
}
