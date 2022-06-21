import org.testng.Assert;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(payload.CoursePrice());
		
		// print number of courses by API (and verify if it is equals 3):
		int coursesCount = js.getInt("courses.size()");
		System.out.print(coursesCount);
		Assert.assertEquals(coursesCount, 3);

	}

}
