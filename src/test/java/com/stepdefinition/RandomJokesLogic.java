package com.stepdefinition;

import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.junit.Assert;
import com.constants.HttpMethods;
import com.constants.HttpStatusCodes;
import com.graphqldto.GraphQLQuery;
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
	GraphQLQuery query = new GraphQLQuery();
	private Response response;

	@Given("^send request to random joke url$")
	public void sendRequestToRandomJoke() {
		try {
			response = restCall.restAssuredMethods(HttpMethods.GET, query, resources.getRandomJokesResourceURI());
			logger.info("Expected!, successfully response recieved.");
		} catch (Exception e) {
			logger.error("failed " + e);
			Assert.fail("Error!, The response is not correct.");
		}
	}

	@Then("^validate status code$")
	public void validateStatusCode() {
		try {
			int actualStatusCode = response.getStatusCode();
			assertEquals(actualStatusCode, HttpStatusCodes.RESPONSE_STATUS_CODE_200);
			logger.info("Expected!, status code is successfully validated.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, status code is not matched.");
		}
	}

	@Then("^print all random jokes data$")
	public void printRandomJokesData() {
		try {
			RandomJokesDTOs randomJokesDetails = response.as(RandomJokesDTOs.class);
			logger.info("Expected!, Response is deserialized successfully.");
			logger.info(randomJokesDetails.toString());
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, Response is not deserialized");
		}
	}

	@Given("^send request to particular joke with id (.*)$")
	public void sendRequestToParticularJoke(String id) {
		try {
			String resourceURI = resources.getJokesResourceURI() + id;
			response = restCall.restAssuredMethods(HttpMethods.GET, query, resourceURI);
			logger.info("Expected!, successfully response recieved.");
		} catch (Exception e) {
			logger.error("failed " + e);
			Assert.fail("Error!, The response is not correct.");
		}
	}

	@Then("^verify response status code$")
	public void verifyResponseStatusCode() {
		try {
			int actualStatusCode = response.getStatusCode();
			assertEquals(actualStatusCode, HttpStatusCodes.RESPONSE_STATUS_CODE_200);
			logger.info("Expected!, status code is successfully validated.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, status code is not matched.");
		}
	}

	@Then("^verify response id (.*)$")
	public void verifyResponseId(String id) {
		try {
			RandomJokesDTOs randomJokes = response.as(RandomJokesDTOs.class);
			assertEquals(randomJokes.getId(), id);
			logger.info("Expected!, ID is validated successfully.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, ID is not matched.");
		}
	}

	@Then("^verify response Joke (.*)$")
	public void verifyJokeText(String joke) {
		try {
			RandomJokesDTOs randomJokes = response.as(RandomJokesDTOs.class);
			assertEquals(randomJokes.getValue(), joke);
			logger.info("Expected!, joke is validated successfully.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, joke is not validated.");
		}
	}

	@Then("^verify response url (.*)$")
	public void verifyResponseUrl(String url) {
		try {
			RandomJokesDTOs randomJokes = response.as(RandomJokesDTOs.class);
			assertEquals(randomJokes.getUrl(), url);
			logger.info("Expected!, URL is validated successfully.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, URL is not validated.");
		}
	}

	@Then("^verify response created at (.*)$")
	public void verifyResponseCreatedAt(String createdAt) {
		try {
			RandomJokesDTOs randomJokes = response.as(RandomJokesDTOs.class);
			assertEquals(randomJokes.getCreatedAt(), createdAt);
			logger.info("Expected!, Created date is validated successfully.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, Created date is not validated.");
		}
	}

	@Then("^verify response updated at (.*)$")
	public void verifyResponseUpdatedAt(String updatedAt) {
		try {
			RandomJokesDTOs randomJokes = response.as(RandomJokesDTOs.class);
			assertEquals(randomJokes.getUpdatedAt(), updatedAt);
			logger.info("Expected!, Created date is validated successfully.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, updated date is not validated.");
		}
	}
}
