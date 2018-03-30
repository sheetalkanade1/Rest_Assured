package com.wbl.test;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.wbl.base.BaseApiTest;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;



public class RestAssuredGetTest extends BaseApiTest {
	
	Response response;
	int id_put=0;
	
	
	@Test
	public void get1() {
		given().
		when().
		get(endpoint+"?authentication=false").
		then().
		statusCode(200);
		
	}
	
	
	@Test
	public void get2() {
		
		response =	given().
				when().
				get(endpoint+"?authentication=false").
				then().
				statusCode(200).
				extract().
				response();
		
		System.out.println("This is GET response" + response.asString());
		//jsonobject = new JSONObject(response.toString());
				//writeFile("/src/test/resources/output/out.json", jsonobject.toString());
	}
	
	
	//checking if response has name=george
	
	@Test
	public void get3() {
		
		/*given().
		when().
		get(endpoint+"?authentication=false").
		then().
		statusCode(200).
		body("id", equalTo(1)).
		body("first_name", equalTo("George"));*/
		
		
		String json = get(endpoint+"?authentication=false").asString();
		  JsonPath jp = new JsonPath(json);
		  jp.setRoot("data");
		  Map<String, ?> data = jp.get("find {f -> f.first_name =~ /Geo/}"); //groovy syntax to find first_name starting with Geo
		  assertEquals("George", data.get("first_name"));
		 		  
}
	
	
}