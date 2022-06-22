package files;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	
	// added connection to data provider
	@Test(dataProvider="BooksData")
	public void addBook(String isbn, String aisle) {
		
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
	
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		
		// array = collection of elements => new Object[] {1,2,3,...};,
		// multidimensional array = collection of arrays => new Object[][] {array1, array2, array3,...};

		return new Object[][] {{"abcd", "245741"}, {"gfmo", "54852"}, {"tnmbj", "45752"}};
	}
}
