package com.restassuredmethods;

import com.constants.HttpMethods;
import com.graphqldto.GraphQLQuery;
import com.resourcesreader.ResourcesURLsReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * 
 * @author Sanjeet Kumar Pandit
 *
 */
public class RestAssuredMethods {
	ResourcesURLsReader resource = new ResourcesURLsReader();
	Response response = null;

	public Response restAssuredMethods(String requestType, GraphQLQuery queryBody, String request) {
		switch (requestType) {
		case HttpMethods.GET:
			RestAssured.baseURI = resource.getJokesBaseURI();
			response = RestAssured.given()
					.contentType(ContentType.JSON)
					.log().all()
					.when()
					.get(request)
					.then().log().all()
					.extract()
					.response();
			break;
		case HttpMethods.POST:
			RestAssured.baseURI = resource.getStoreBaseURI();
			response = RestAssured.given()
					.body(queryBody)
					.contentType(ContentType.JSON)
					.log().all()
					.when()
					.post(request)
					.then().log().all()
					.extract().response();
		case HttpMethods.PUT:
			// TODO - Kept for future references
			break;
		case HttpMethods.PATCH:
			// TODO - Kept for future references
			break;
		case HttpMethods.DELETE:
			// TODO - Kept for future references
			break;
		case HttpMethods.DEFAULT:
			// TODO - Kept for future references
			break;
		}
		return response;
	}
}
