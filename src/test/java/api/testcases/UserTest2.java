package api.testcases;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest2 {
	Faker faker;
	User userPayload;
	public static Logger logger;
	
	
	@BeforeClass
	public void generateTestData() {
		
		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPasswaord(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUserStates(0);
		
		logger = LogManager.getLogger("RestAssured");		
	}
	
	@Test (priority = 1)
	public void testCreateUser(){
		Response response = UserEndPoints2.createUser(userPayload);
		System.out.println("Create user ");
		// log response 
		response.then().log().all();
		
		// validation 
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//logger info
		logger.info("Create user executed.");
	}
	
	@Test (priority = 2)
	public void testGetUserData(){
		Response response = UserEndPoints2.getUser(this.userPayload.getUsername());
		System.out.println("Read get user data");
		// log response 
		response.then().log().all();
		
		// validation 
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//logger info
				logger.info("Get userdata executed."); 
		
	}
	
	@Test (priority = 3)
	public void testUpdateUser(){ 
		// new firstname 
		userPayload.setFirstName(faker.name().firstName());
		
		Response response = UserEndPoints2.updateUser(this.userPayload.getUsername(), userPayload);
		System.out.println("Resd Update user data");
		// log response 
		response.then().log().all();
		
		// validation 
		Assert.assertEquals(response.getStatusCode(), 200);
		
		// to check firstname updated or not
		Response updateResponse = UserEndPoints2.getUser(this.userPayload.getUsername());
		System.out.println("Resd After Update user data");
		updateResponse.then().log().all();	
		
		//logger info
		logger.info("Update user executed.");
		
	}
	
	@Test (priority = 4)
	public void testDeleteUser(){
		
		Response response = UserEndPoints2.deleteUser(this.userPayload.getUsername());
		System.out.println("Read delete user data");
		// log response 
		response.then().log().all();
		
		// validation 
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//logger info
		logger.info("Delete user executed.");
		
	}
	

}
