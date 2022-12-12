package api.practice;

import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetAPITest {

	
	@Test(enabled = false)
	public void getCallStatusCodeValidation() {
		RestAssured
		.given().log().all()
		.get("https://api.instantwebtools.net/v1/airlines/1")
		.then()
		.log().all()
		.statusCode(200);

	}
	
	@Test(enabled = false)
	public void getCallStatusCodeValidationFail() {
		RestAssured
		.given().log().all()
		.get("https://api.instantwebtools.net/v1/airlines/1")
		.then()
		.log().all()
		.statusCode(201);

	}
	@Test(enabled = false)
	public void getCallBodyCodeValidation() {
		RestAssured
		.given().log().all()
		.get("https://api.instantwebtools.net/v1/airlines/1")
		.then()
		.log().all()
		.statusCode(200)
		.body("name", equalTo("Quatar Airways"))
		.body("country", equalTo("Quatar"))
		.body("slogan", equalTo("Going Places Together"))
		.body("established", equalTo("1994"));

	}
	
	@Test(enabled = true)
	
	public void getCallListValidationJsonPath() {
		String response = 
		RestAssured
		.given()
		//.auth().basic("username", "password")
		.param("page", "2")
		.log().all()
		.get("https://reqres.in/api/users")
		.then()
		.extract().response().asString();
		System.out.println(response);
		JsonPath path = JsonPath.from(response);
		List<Integer> list = path.getList("data.id");
		for(int name : list) {
			System.out.println(name);
		}
		System.out.println("Size of the list is: " + list.size());
		System.out.println(path.getInt("data.id[2]")); 
	}
}
