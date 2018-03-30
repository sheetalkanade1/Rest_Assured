package com.wbl.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import com.wbl.base.BaseApiTest;


public class RestAssuredPostTest extends BaseApiTest {
	
	Response response;
	int id_put=0;
	
//add Gson to parse in pom.xml. if not used it gives" Illegalstateexception". 
	//This is a Java library that can be used to convert Java Objects into their JSON representation.
	
	@Test
	public void postdata(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", "5555");
		map.put("first_name", "Adititest");
		map.put("last_name", "Raotest");
		
		//If you want to explicitly validate that a web service returns the correct content type (JSON, in this case) 
		//and then validate statuscode
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post(endpoint+"?authentication=false")
		.then()
		.statusCode(201);
		
	}

	/*
		
		//post the data and extract the response
		@Test
		public void postData1() {
			given().
			contentType(ContentType.JSON).
			body("{\"categoryid\":\"1\","+"\"name\":\"RestAssured_6\","+"\"icon_class\":\"RestAssured-test1\"}").
			when().
			post(endpoint+"?authentication=false").then().statusCode(201).extract().response();
			
			System.out.println("This is POST response" + response.asString());
	}
		//post the data and extract the particular "id" parameter from the response
			@Test
			public void postData2() {
				given().
				contentType(ContentType.JSON).
				body("{\"categoryid\":\"1\","+"\"name\":\"RestAssured_7\","+"\"icon_class\":\"RestAssured-test2\"}").
				when().
				post(endpoint+"?authentication=false").then().statusCode(201).extract().response();
				
				System.out.println("The new added ID from response is--" + response.path("id"));
		}
			
			//post the data and extract the particular "id" parameter from the response by asserting using testng
					@Test
					public void postData3() {
						given().
						contentType(ContentType.JSON).
						body("{\"categoryid\":\"1\","+"\"name\":\"RestAssured_8\","+"\"icon_class\":\"RestAssured-test2\"}").
						when().
						post(endpoint+"?authentication=false").then().statusCode(201).extract().response();
						
						id_put=response.path("id");
						System.out.println("The new added ID from response is--" + response.path("id"));
						
						Assert.assertEquals(response.path("categoryid"), "1");
				}
		
		
		//put data..get response from POST and give it to PUT
		@Test(dependsOnMethods="postData3")
		public void putData1() {
			
			given().
			contentType(ContentType.JSON).
			body("{\"categoryid\":\"1\","+"\"name\":\"RestAssured-PUT-Modified\","+"\"icon_class\":\"RestAssured-PUT\"}").
			when().
			put(endpoint+"/"+id_put+"?authentication=false").
			then().
			statusCode(200).
			extract().
			response();
			
			System.out.println("The name of subject after PUT is--" + response.path("name"));
			
			Assert.assertEquals(response.path("categoryid"), "1");
	}
		@Test(dependsOnMethods="postData3")
		public void deleteData1() {
			
			given().
			contentType(ContentType.JSON).
			body("").
			when().
			delete(endpoint+"/"+id_put+"?authentication=false").
			then().
			statusCode(204).
			extract().
			response();
			
	}*/
}
