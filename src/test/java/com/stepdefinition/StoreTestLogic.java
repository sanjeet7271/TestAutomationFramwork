package com.stepdefinition;

import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.junit.Assert;
import com.constants.HttpMethods;
import com.restassuredmethods.RestAssuredMethods;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class StoreTestLogic {
	RestAssuredMethods restCall = new RestAssuredMethods();
	public static Logger logger = Logger.getLogger(StoreTestLogic.class);
	private Response response;
	@SuppressWarnings("unused")
	private Scenario scenario;
	private String query = "{\r\n"
			+ "  \"query\": \"{ store(id: 1) { alternativeLocales code defaultCurrency defaultLocale }}\"\r\n" + "}";

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("send the request to the store")
	public void send_the_request_to_the_store() {
		try {
		response = restCall.restAssuredMethods(HttpMethods.POST, query, "");
		logger.info("successfully response recieved.");
		}catch (Exception e) {
			logger.error("failed " + e);
			Assert.fail("The response is not correct.");
		}
	}

	@Then("validate the status code from response")
	public void validate_the_status_code_from_response() {
		try {
			int actualStatusCode = response.getStatusCode();
			assertEquals(200, actualStatusCode);
			logger.info("successfully validated  status code.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("status code is not matched.");
		}
	}

	@Then("validate the currency to corresponding store code")
	public void validate_the_currency_to_corresponding_store_code() {
		
	}

}
