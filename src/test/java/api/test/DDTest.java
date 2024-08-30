package api.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {
	
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostData(String userId, String userName, String fname, String lname, String email, String pwd, String ph) {
		
		User payload = new User();
		payload.setId(Integer.parseInt(userId));
		payload.setUserName(userName);
		payload.setFirstName(fname);
		payload.setLastName(lname);
		payload.setEmail(email);
		payload.setPassword(pwd);
		payload.setPhone(ph);
		
		Response response = UserEndPoints.createUser(payload);
		response.then().statusCode(200);
		
	}
	
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByUserName(String userName) {
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
//	@Test(priority = 3, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
//	public void testUpdateUserByUserName(String userName, String newUserName) {
//		
//		
//	}
	

}
