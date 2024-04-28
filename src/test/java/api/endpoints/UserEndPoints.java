package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class UserEndPoints {
	public static Response createUser(User payload) {
		Response response = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.body(payload)
		
							.when()
							.post(Routes.post_url);		
		return response;
	}
	
	public static Response getUser(String userName) {
		Response response = given()
							.accept(ContentType.JSON)
							.pathParam("userName", DEFAULT_AUTH)
		
							.when()
							.get(Routes.get_url);		
		return response;
	}
	
	public static Response updateUser(String userName, User payload) {
		Response response = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.pathParam("userName", DEFAULT_AUTH)
							.body(payload)
		
							.when()
							.put(Routes.put_url);	
		return response;
	}
	
	public static Response deleteUser(String userName) {
		Response response = given()
							.accept(ContentType.JSON)
							.pathParam("userName", DEFAULT_AUTH)		
		
							.when()
							.delete(Routes.del_url);	
		return response;
	}
	

}
