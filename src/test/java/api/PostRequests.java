package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class PostRequests {

	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/";
	}

	@Test
	public void putRequest405Test() {
		System.out.println("PutRequest: Method Not Allowed = 405 response...");
		Response koresponse = given().contentType(ContentType.JSON).when().post("/create").then().extract()
				.response();
		Assertions.assertEquals(405, koresponse.statusCode());
	}

}
