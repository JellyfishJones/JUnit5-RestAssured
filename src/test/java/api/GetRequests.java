package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetRequests {

	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = "https://dummy.restapiexample.com";
	}

	@Test
	public void getRequest404Test() {
		System.out.println("GetRequest: 404 response test...");
		Response response = given().contentType(ContentType.JSON).when().get("/employee/719").then().extract()
				.response();
		Assertions.assertEquals(404, response.statusCode());
	}

	@Test
	public void getRequest200Test() {
		System.out.println("GetRequest: 200 response test...");
		Response response = given().header("id", "1").when().post("https://dummy.restapiexample.com/employee/1").then().extract().response();
		Assertions.assertEquals(200, response.statusCode());
		Assertions.assertEquals("1", response.jsonPath().get("id:"));
		Assertions.assertEquals("Tiger Nixon", response.jsonPath().get("employee_name:"));
		Assertions.assertEquals("320800", response.jsonPath().get("employee_salary:"));
		Assertions.assertEquals("61", response.jsonPath().get("employee_age:"));
		Assertions.assertEquals("", response.jsonPath().get("profile_image"));
		Assertions.assertEquals("Successfully! Record has been fetched.", response.jsonPath().get("message:"));
	}

}
