package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.user_endpoints;
import api.payloads.User;
import io.restassured.response.Response;

public class User_Tests {
	
	Faker faker;
	User userpayload;
	
	@BeforeClass
	public void SetupData() {
		faker=new Faker();
		userpayload= new User();
		
		
		// create data from faker library to import into request
		 
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername("Atish");
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		
	}
	@Test (priority = 1)
	public void testposuser()
	{
		Response response= user_endpoints.create_user(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2)
	public void testgetuserbyName() {
		System.out.println(this.userpayload.getUsername());
		System.out.println(this.userpayload.getFirstname());
		Response response=user_endpoints.read_user(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test (priority = 3)
	public void testupdateUserByName() {
		
		userpayload.setUsername("Atish");
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		Response response=user_endpoints.update_user(this.userpayload.getUsername(), userpayload);
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
		
		Response resposeafteupate=user_endpoints.read_user(this.userpayload.getUsername());
resposeafteupate.then().log().all();
	}
	
	@Test(priority = 4)
	public void testdeleteuserByName() {
		Response response=user_endpoints.delete_user(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	
	
	

}
