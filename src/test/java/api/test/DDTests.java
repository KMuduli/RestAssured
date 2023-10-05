package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userID,String userName, String firstName,String lastName,String userEmail, String password,String phoneNumber)
	{
		User userPayload=new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(userEmail);
		userPayload.setPassword(password);
		userPayload.setPhone(phoneNumber);
		
		Response response=UserEndPoints.createUser(userPayload);
	 
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName)
	{
		Response response=UserEndPoints.deleteUser(userName);
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}

}
