package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;


public class UserEndPoints2 {
	static ResourceBundle getUrl() {
		ResourceBundle routes = ResourceBundle.getBundle("Routes");
		return routes;
		
	}
	
	public static Response createUser(User payload) {
		String post_url = getUrl().getString("post_url");
		
		Response response = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.body(payload)
		
							.when()
							.post(post_url);		
		return response;
	}
	
	public static Response getUser(String userName) {
		String get_url = getUrl().getString("get_url");
		
		Response response = given()
							.accept(ContentType.JSON)
							.pathParam("userName", DEFAULT_AUTH)
		
							.when()
							.get(get_url);		
		return response;
	}
	
	public static Response updateUser(String userName, User payload) {
		String put_url = getUrl().getString("update_url");
		
		Response response = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.pathParam("userName", DEFAULT_AUTH)
							.body(payload)
		
							.when()
							.put(put_url);	
		return response;
	}
	
	public static Response deleteUser(String userName) {
		String del_url = getUrl().getString("delete_url");
		
		Response response = given()
							.accept(ContentType.JSON)
							.pathParam("userName", DEFAULT_AUTH)		
		
							.when()
							.delete(del_url);	
		return response;
	}
	

}
