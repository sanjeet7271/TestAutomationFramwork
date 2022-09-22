package com.stepdefinition;

import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.junit.Assert;
import com.constants.HttpMethods;
import com.constants.HttpStatusCodes;
import com.graphqldto.GraphQLQuery;
import com.graphqldto.QueryVariables;
import com.restassuredmethods.RestAssuredMethods;
import com.storeresponsedtos.StoreJson;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class StoreTestLogic {
	RestAssuredMethods restCall = new RestAssuredMethods();
	GraphQLQuery query = new GraphQLQuery();
	QueryVariables variables = new QueryVariables();
	public static Logger logger = Logger.getLogger(StoreTestLogic.class);
	private Response response;
	@SuppressWarnings("unused")
	private Scenario scenario;

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("^send the request to the store$")
	public void sendRrequestToTheStore() {
		try {
			query.setQuery(
					"query($id:ID, $storeCode:String){store(id:$id,storeCode:$storeCode){ alternativeLocales code defaultCurrency defaultLocale } }");
			variables.setId(1);
			variables.setStoreCode("US");
			query.setVariables(variables);
			response = restCall.restAssuredMethods(HttpMethods.POST, query, "");
			logger.info("Expected!, successfully response recieved.");
		} catch (Exception e) {
			logger.error("failed " + e);
			Assert.fail("Error!, The response is not correct.");
		}
	}

	@Then("^verify the status code from response$")
	public void verifyStatusCode() {
		try {
			int actualStatusCode = response.getStatusCode();
			assertEquals(actualStatusCode, HttpStatusCodes.RESPONSE_STATUS_CODE_200);
			logger.info("Expected!, status code is successfully validated.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, status code is not matched.");
		}
	}

	@Then("^print the reponse from store$")
	public void printStoreDetails() {
		try {
			StoreJson storeDetails = response.as(StoreJson.class);
			logger.info("Expected!, Response is deserialized successfully.");
			System.out.println("Print Deserialize response : " + storeDetails.toString());
		} catch (Exception e) {
			logger.error("failed " + e);
			Assert.fail("Error!, Response is not deserialized");
		}
	}

	@Given("^send the request to the store with store code (.*)$")
	public void sendRequestToStore(String storeCode) {
		try {
			query.setQuery(
					"query($id:ID, $storeCode:String){store(id:$id,storeCode:$storeCode){ alternativeLocales code defaultCurrency defaultLocale } }");
			variables.setId(1);
			variables.setStoreCode(storeCode);
			query.setVariables(variables);
			response = restCall.restAssuredMethods(HttpMethods.POST, query, "");
			logger.info("Expected!, successfully response recieved.");
		} catch (Exception e) {
			logger.error("failed " + e);
			Assert.fail("Error!, The response is not correct.");
		}
	}

	@Then("^verify the status code$")
	public void verifyTheStatusCode() {
		try {
			int actualStatusCode = response.getStatusCode();
			assertEquals(actualStatusCode, HttpStatusCodes.RESPONSE_STATUS_CODE_200);
			logger.info("Expected!, status code is successfully validated.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, status code is not matched.");
		}
	}

	@Then("^verify each store is having currency$")
	public void verifyEachStoreIsHavingCurrency() {
		StoreJson storeDetails = response.as(StoreJson.class);
		assertEquals(storeDetails.getData().getStore().getDefaultCurrency(), "EUR");
	}
	
	@Given("^send the request to the store with id (.*) and store code (.*)$")
	public void send_the_request_to_the_store_with_id_and_store_code_de(int id, String storeCode) {
		try {
			query.setQuery(
					"query($id:ID, $storeCode:String){store(id:$id,storeCode:$storeCode){ alternativeLocales code defaultCurrency defaultLocale } }");
			variables.setId(id);
			variables.setStoreCode(storeCode);
			query.setVariables(variables);
			response = restCall.restAssuredMethods(HttpMethods.POST, query, "");
			logger.info("Expected!, successfully response recieved.");
		} catch (Exception e) {
			logger.error("failed " + e);
			Assert.fail("Error!, The response is not correct.");
		}
	}

	@Then("verify the response status code")
	public void verify_the_response_status_code() {
		try {
			int actualStatusCode = response.getStatusCode();
			assertEquals(actualStatusCode, HttpStatusCodes.RESPONSE_STATUS_CODE_200);
			logger.info("Expected!, status code is successfully validated.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, status code is not matched.");
		}
	}

	@Then("verify each store is having alternative Locales en default currency EUR and default locale de")
	public void verify_each_store_is_having_alternative_locales_en_default_currency_eur_and_default_locale_de() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
