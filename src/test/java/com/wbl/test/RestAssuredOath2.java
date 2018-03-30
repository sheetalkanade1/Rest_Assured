package com.wbl.test;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;


public class RestAssuredOath2 {
	
	
	private String APIUrl = "https://a.wunderlist.com/api/v1";
	private String access_Token = "aaa1a1346e49c73fd0a189f604ea04a9e4b1ee4b044102048ce3ff0ce48d";
	private String client_ID = "b932dc1dbb789fe275ea";
	@Test
	public void testA_oAuth2(){
		   given().headers("X-Access-Token",access_Token, "X-Client-ID",client_ID).    
		           auth().oauth2(access_Token).
		   when().
                  get(APIUrl + "/user").
           then().
                  statusCode(200);
	}
}
