package RestAssuredProjectDemo.RestAssuredProjectDemo;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
//import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

//Different way to create POST request

//1. Using HashMap
//2. using org.JSON
//3. using POJO Class
//4. using external json file

public class TestNG_Demo_day2 {

	@Test
	public void usingHashMap()
	{
		HashMap data = new HashMap();
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "123121231");
		
		String courseArr[]= {"C","C++"};
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location",equalTo("France"))
			.body("phone",equalTo("123121231	"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log()
			.all();	
	}

}
