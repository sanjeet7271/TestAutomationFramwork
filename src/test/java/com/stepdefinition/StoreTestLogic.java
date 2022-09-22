package com.stepdefinition;

import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.junit.Assert;
import com.constants.HttpMethods;
import com.constants.HttpStatusCodes;
import com.constants.TestCaseConstants;
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
			variables.setId(TestCaseConstants.ID);
			variables.setStoreCode(TestCaseConstants.CURRENCY);
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
			logger.info(storeDetails.toString());
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
			variables.setId(TestCaseConstants.ID);
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
		try {
			StoreJson storeDetails = response.as(StoreJson.class);
			logger.info("validation started for currency.");
			logger.info(storeDetails.getData().getStore().getDefaultCurrency());
			assertEquals(storeDetails.getData().getStore().getDefaultCurrency(), TestCaseConstants.CURRENCY);
			logger.info("validation is completed with currency successful.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, status code is not matched.");
		}
	}

	@Given("^send the request to the store with id (.*) and store code (.*)$")
	public void sendRequestToStoreWithIdAndStoreCode(int id, String storeCode) {
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
	public void verifyTheResponseStatusCode() {
		try {
			int actualStatusCode = response.getStatusCode();
			assertEquals(actualStatusCode, HttpStatusCodes.RESPONSE_STATUS_CODE_200);
			logger.info("Expected!, status code is successfully validated.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, status code is not matched.");
		}
	}

	@Then("^verify each store is having alternative Locales (.*) default currency (.*) and default locale (.*)$")
	public void verifyEachStoreIsHavingAllDetails(String alternativeLocales, String defaultCurrency,
			String defaultLocale) {
		try {
			StoreJson storeDetails = response.as(StoreJson.class);
			logger.info("validation started for currency.");
			logger.info(storeDetails.getData().getStore().getDefaultCurrency());
			assertEquals(storeDetails.getData().getStore().getDefaultCurrency(), defaultCurrency);
			logger.info("validation is completed with currency successful.");
			logger.info("validation started for Alternative Locales.");
			logger.info(storeDetails.getData().getStore().getAlternativeLocales());
			assertEquals(storeDetails.getData().getStore().getAlternativeLocales().get(0), alternativeLocales);
			logger.info("validation is completed with Alternative Locales successful.");
			logger.info("validation started for default Locale");
			logger.info(storeDetails.getData().getStore().getDefaultLocale());
			assertEquals(storeDetails.getData().getStore().getDefaultLocale(), defaultLocale);
			logger.info("validation is completed with Default Locale successful.");
		} catch (AssertionError e) {
			logger.error("failed " + e);
			Assert.fail("Error!, status code is not matched.");
		}
	}
}
