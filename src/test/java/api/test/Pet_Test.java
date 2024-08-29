package api.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.endpoints.Pet_Endpoints;
import api.payloads.Pet;
import io.restassured.response.Response;

public class Pet_Test {
	long petid;
	public Logger logger;
	Pet petdata1;
	@BeforeMethod
	void setup() {
		logger= LogManager.getLogger(this.getClass());
	}

	@Test (priority = 1)
	void createpetentry() throws IOException {
		
		logger.info("Creating entry of new pet******");
		String data=petdata1.petdata();
		Response response=Pet_Endpoints.create_new_petdata(data);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		petid=response.xmlPath().getLong("Pet.id");
		long responsetime=response.getTime();
		System.out.println("Response time :"+responsetime);
		//System.out.println("Generated petid is :"+petid);
		
	}
	
	@Test (priority = 2)
	void retrieve_pet_details() {
		logger.info("******Retrieving the data of Pets");
		Response response=Pet_Endpoints.retrieve_pet_details(petid);
	    Assert.assertEquals(response.getStatusCode(), 200);
	    System.out.println("Response time :"+response.getTime());
	    response.then().log().all();
	}
	
	@Test (priority = 3)
	void update_pet_details(){
		logger.info("*******updating the petdata******");
		String udpated_petdata=petdata1.updatepet(petid, "Prashant", "Unavailable");
		Response response=Pet_Endpoints.update_pet_details(udpated_petdata);
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("Response time :"+response.getTime());
		response.then().log().all();
		
	}
	@Test (priority = 4)
	void retrieve_pet_details_after_update() {
		logger.info("******Retrieving the data of Pets after update");
		Response response=Pet_Endpoints.retrieve_pet_details(petid);
	    Assert.assertEquals(response.getStatusCode(), 200);
	    System.out.println("Response time :"+response.getTime());
	    response.then().log().all();
	
	}	
	
	@Test (priority = 5)
	void delete_pet_details() {
		logger.info("***Deleting the user*****");
		Response response= Pet_Endpoints.delete_pet(petid);
		Assert.assertEquals(response.getStatusCode(), 200);
		 System.out.println("Response time :"+response.getTime());
		    response.then().log().all();
		
	}
	
}
