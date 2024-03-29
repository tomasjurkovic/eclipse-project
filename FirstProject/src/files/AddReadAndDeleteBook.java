package files;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddReadAndDeleteBook {
	String bookName = "LearningJavaAutomation";
	String author = "TomasJurkovic";
	String isbn = "tomas";
	String aisle = "1000";
	String fullId = isbn + aisle;
	
	@Test
	public void addBook() {
		RestAssured.baseURI="http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json")
		.body(payload.Addbook(bookName, isbn, aisle, author))
		.when().post("Library/Addbook.php")
		.then().log().all().statusCode(200)
		.extract().response().asString();

		// extract id from response:
		JsonPath jp = ReusableMethods.rawToJson(response);
		
		String id = jp.getString("ID");
		
		System.out.println(id);
		
		// check if book was created successfully:
		RestAssured.baseURI="http://216.10.245.166";
		String response2 = given().log().all().queryParam("ID", fullId)
		.body("")
		.when().get("Library/GetBook.php")
		.then().log().all().statusCode(200)
		.extract().response().asString();
		
		// extract message:
		JsonPath jp2 = ReusableMethods.rawToJson(response2);
		
		// check response:
		String bookName2 = jp2.getString("book_name[0]");
		String isbn2 = jp2.getString("isbn[0]");
		String aisle2 = jp2.getString("aisle[0]");
		String author2 = jp2.getString("author[0]");
		Assert.assertEquals(bookName2, bookName);
		Assert.assertEquals(isbn2, isbn);
		Assert.assertEquals(aisle2, aisle);
		Assert.assertEquals(author2, author);
	}

	// delete existing book as well
	@Test
	public void deleteBook() {
		RestAssured.baseURI="http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json")
		.body(payload.Deletebook(fullId))
		.when().post("Library/DeleteBook.php")
		.then().log().all().statusCode(200)
		.extract().response().asString();

		// extract message from response:
		JsonPath jp = ReusableMethods.rawToJson(response);
		
		String expectedMessage = "book is successfully deleted";
		String message = jp.getString("msg");
		System.out.println(message);
		Assert.assertEquals(message, expectedMessage);
		
		// check if book was deleted successfully:
		RestAssured.baseURI="http://216.10.245.166";
		String response2 = given().log().all().queryParam("ID", fullId)
		.body("")
		.when().get("Library/GetBook.php")
		.then().log().all().statusCode(404)
		.extract().response().asString();
		
		// extract message:
		JsonPath jp2 = ReusableMethods.rawToJson(response2);
		String expectedMessage2 = "The book by requested bookid / author name does not exists!";
		String message2 = jp2.getString("msg");
		System.out.println(message2);
		Assert.assertEquals(message2, expectedMessage2);
	}
}
