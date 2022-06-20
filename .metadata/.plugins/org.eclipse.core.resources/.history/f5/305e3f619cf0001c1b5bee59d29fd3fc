import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.payload;


public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// validate if add place API is working as expected
		
		// three principles:
		// 1. given
		// take all input details
		
		// 2. when
		// submit the API - resource, HTTP methods
		
		// 3. Then
		// validate the response
		
		int code = 200;
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
			.body(payload.AddPlace())
			.when().post("maps/api/place/add/json")
			.then().log().all()
			.assertThat().statusCode(code) // check if status code is 200
			.body("scope", equalTo("APP")) // check if scope is "APP"
			.header("server", "Apache/2.4.41 (Ubuntu)"); // check if server is Apache...
		
	}

}
