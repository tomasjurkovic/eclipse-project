package files;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	String isbn = "tomas";
	String aisle = "1000";
	String fullId = isbn + aisle;
	
	@Test
	public void addBook() {
		RestAssured.baseURI="http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json")
		.body(payload.Addbook(isbn, aisle))
		.when().post("Library/Addbook.php")
		.then().log().all().statusCode(200)
		.extract().response().asString();

		// extract id from response:
		JsonPath jp = ReusableMethods.rawToJson(response);
		
		String id = jp.getString("ID");
		
		System.out.println(id);
		
	}
}
