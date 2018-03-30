package com.wbl.test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import com.wbl.base.BaseApiTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class RestAssuredPutTest extends BaseApiTest {
	
	Response response;
	
	@Test
	public void postdata(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", "4555");
		map.put("first_name", "tAditi");
		map.put("last_name", "tRao");
		
		
		given().body (map)
	    .when ()
	    .contentType (ContentType.JSON)
	    .put (endpoint+"?authentication=false")
	    .then()
		.statusCode(200)
		.extract()
		.response();
		//Assert.assertEquals(response.path("id"), "4555");;
	}
}
