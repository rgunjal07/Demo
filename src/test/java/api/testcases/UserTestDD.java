package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDD {
	User userPayload;

	@Test(priority = 1, dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String userId, String UserName, String fname, String lname, String email, String pwd,
			String phone) {
		userPayload = new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPasswaord(pwd);
		userPayload.setPhone(phone);

		Response response = UserEndPoints.createUser(userPayload);
		System.out.println("Create user ");
		// log response
		response.then().log().all();

		// validation
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2, dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testDeleteUser() {

		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		System.out.println("Read delete user data");
		// log response
		response.then().log().all();

		// validation
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
