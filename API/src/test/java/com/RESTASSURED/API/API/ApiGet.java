package com.RESTASSURED.API.API;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.*;




public class ApiGet {
	
	private static RequestSpecification requestspec;

	@BeforeClass
	public static void RequestSpec(){
		
		requestspec = new RequestSpecBuilder().
				setBaseUri("Https://reqres.in").
				setBasePath("/api/users").
				build();
		System.out.println(requestspec);
	}
	

	
	@Test
	public void CheckResponseCode(){
		given().spec(requestspec)
		.when().get("?page=2")
		.then().assertThat()
		.statusCode(200);
		
		
	}
	
	@Test
	public void CheckResponsecontent(){
		given().spec(requestspec)
		.when().get("?page=2")
		.then().assertThat()
		.contentType("application/json");
		
	}
	
	@Test
	public void Checkbadrequest(){
		given().spec(requestspec)
		.when().get("")
		.then().assertThat()
		.statusCode(404);

}
}
