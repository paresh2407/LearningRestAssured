package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;

public class UserEndPoints {
	
	public static Response createUser(User payload) {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(Routes.post_URL);
		
		return response;		
	}
	
	public static Response readUser(String userName) {
		
		Response response = given()
				.pathParam("username", userName)
			.when()
				.get(Routes.get_URL);
				
		return response;
	}
	
	public static Response updateUser(String userName, User payload) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
			.when()
				.put(Routes.put_URL);
		
		return response;
	}
	
	public static Response deleteUser(String userName) {
		
		Response response = given()
				.pathParam("username", userName)
			.when()
				.delete(Routes.delete_URL);
		
		return response;
	}
	
	
	

}
