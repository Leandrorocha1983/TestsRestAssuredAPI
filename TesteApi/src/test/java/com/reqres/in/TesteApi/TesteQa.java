package com.reqres.in.TesteApi;
import static io.restassured.RestAssured.given;

import org.hamcrest.core.StringContains;
import org.junit.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

@SuppressWarnings("unused")
public class TesteQa {

	/*@Test
	public void reqresapi() {
		given().when().get("https://reqres.in/api-docs/#/default/post_login").then().log().all();
	
   }
*/


	@Test 
	public void cadastroApi() {
		given()
			.contentType("application/json")
			.body("{\"username\": \"leandroroha\", \"email\": \"lrocha1983@gmail.com\", \"password\": \"123456\"}")
		.when()
			.post("https://reqres.in/api-docs/#/default/post_login")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	
		@Test 
		public void cadastroApiCampoObrigatorio() {
			given()
				.contentType("application/json")
				.body("{\"password\": \"123456\"}")
			.when().post("https://reqres.in/api-docs/#/default/post_login")
			.then()
				.log().all()
				.body("message", ContainsString("\"email\" is required"))
			   	.statusCode(200);
		
		
	
		}


		private ResponseAwareMatcher<Response> ContainsString(String string) {
			// TODO Auto-generated method stub
			return null;
		}
}