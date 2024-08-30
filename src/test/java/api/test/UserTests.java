package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUserName(faker.funnyName().name());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		Response response = UserEndPoints.createUser(userPayload);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
//	@Test(priority = 2)
	public void testGetUser() {
		
		Response response = UserEndPoints.readUser(this.userPayload.getUserName());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
//		update user email, password and phone
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		Response response = UserEndPoints.updateUser(userPayload.getUserName(), userPayload);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
//	@Test(priority = 4)
	public void testDeleteUser() {
		Response response = UserEndPoints.deleteUser(userPayload.getUserName());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	

	
	
	
	

}
