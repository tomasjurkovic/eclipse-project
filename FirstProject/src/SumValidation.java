import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void sumOfCourses() {
		// get sum of all copies of courses sold (dynamically):
		int sum = 0;
		
		JsonPath js = new JsonPath(payload.CoursePrice());
		int count = js.getInt("courses.size()");
		int totalAmount = js.getInt("dashboard.purchaseAmount");

				
		for(int i = 0; i<count; i++) {	
			int courseCopies = js.getInt("courses["+i+"].copies");
			int coursePrice = js.getInt("courses["+i+"].price");
			sum = sum + (coursePrice * courseCopies);

		}
		// verify if sum of price*copies equals to purchase amount:
		Assert.assertEquals(sum, totalAmount);
		System.out.println("Total amount is: " + sum);
	}

}
