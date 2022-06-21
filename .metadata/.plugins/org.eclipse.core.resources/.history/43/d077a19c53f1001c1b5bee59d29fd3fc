import org.testng.Assert;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(payload.CoursePrice());
		int expectedCount = 3;
		int expectedAmount = 910;
		String expectedFirstCourseTitle = "Selenium Python";
		String expectedSecondCourseTitle = "Cypress";
		
		// print number of courses by API (and verify if it is equals 3):
		int count = js.getInt("courses.size()");
		System.out.println(count);
		Assert.assertEquals(count, expectedCount);
		
		// print number of totalAmount by API (and verify if it is equals 910):
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		Assert.assertEquals(totalAmount, expectedAmount);
		
		// print name of first course by API (and verify if it is equals Selenium Python):
		String firstCourse = js.getString("courses[0].title");
		System.out.println(firstCourse);
		Assert.assertEquals(firstCourse, expectedFirstCourseTitle);

		// print name of first course by API (and verify if it is equals Selenium Python):
		String secondCourse = js.getString("courses[1].title");
		System.out.println(secondCourse);
		Assert.assertEquals(secondCourse, expectedSecondCourseTitle);

	}

}
