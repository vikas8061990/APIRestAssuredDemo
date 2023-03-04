package RestAssuredProjectDemo.RestAssuredProjectDemo;

import org.json.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
//import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestNG_Demo {

	int id;
	@Test
	void getUser()
	{
	given()
	.when()
		.get("https://reqres.in/api/users?page=2")
	.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
				
	}
	
	@Test
	void createUser()
	{
		HashMap data = new HashMap();
		data.put("name","vikas");
		data.put("job","trainer");
		id = given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
//		.then()
//			.statusCode(201)
//			.log().all();
		
	}
	
	@Test(dependsOnMethods = { "createUser"})
	void updateUser()
	{
		

		HashMap data = new HashMap();
		data.put("name","vikasUpdated");
		data.put("job","trainerUpdated");

		given()
		.contentType("application/json")
		.body(data)
	.when()
		.put("https://reqres.in/api/users/"+id)
	.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	void userDelete()
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
		
	}
	
}

