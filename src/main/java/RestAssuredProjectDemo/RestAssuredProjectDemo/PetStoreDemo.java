package RestAssuredProjectDemo.RestAssuredProjectDemo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.Random;   

public class PetStoreDemo {
	

	Random random = new Random();
	int num = random.nextInt(1000);  
	
	@Test (priority = 1)
	void createPet()
	{ 
		String jsonBody = "{\r\n"
				+ "    \"id\": "+num+",\r\n"
				+ "    \"category\": {\r\n"
				+ "        \"id\": "+num+",\r\n"
				+ "        \"name\": \"Tommy\"\r\n"
				+ "    },\r\n"
				+ "    \"name\": \"doggie\",\r\n"
				+ "    \"photoUrls\": [\r\n"
				+ "        \"string\"\r\n"
				+ "    ],\r\n"
				+ "    \"tags\": [\r\n"
				+ "        {\r\n"
				+ "            \"id\": 0,\r\n"
				+ "            \"name\": \"Tommy\"\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"status\": \"available\"\r\n"
				+ "}";
		given()
			.contentType("application/json")
			.body(jsonBody)
		.when()
			.post("https://petstore.swagger.io/v2/pet")
			
		.then()
			.statusCode(200)
			.log()
			.all();
	}

	//@Test
	void updatePet()
	{
		
	}

	@Test(priority = 2)
	void getPet()
	{
		String id = given()
		.when()
			.get("https://petstore.swagger.io/v2/pet/"+num).jsonPath().getString("id");
		
		System.out.println("The ID of the Pet is "+id);
		
	}


	//@Test
	void deletePet()
	{
		
	}
	

}
