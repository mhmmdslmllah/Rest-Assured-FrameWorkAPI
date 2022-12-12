package utils;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class RestSteps {

	private String baseUrl;
	private RequestSpecification requestSpecification;
	private Response response;

	public void sentAsGet(String endpoint, Header... headers) {
		for(Header header : headers)
		requestSpecification = RestAssured.given().baseUri(baseUrl);
		response = requestSpecification
				.log().all()
				.get(endpoint);

	}

	public Response getResponse() {
		response.prettyPrint();
		return response;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;

	}

	public void responseBodyValidation(String key, Object expected) {
		response.then().body(key, Matchers.equalTo(expected));
	}

}
