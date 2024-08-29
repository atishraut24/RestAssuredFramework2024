package api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class Pet_Endpoints {

	public static Response create_new_petdata(String string) {
		  Response response= given()
				  .contentType("application/xml")
				  .accept("application/xml")
				  .body(string)
				  
				  .when()
				  .post(Routes.post_pet_url);
		return response;
	}
	
	public static Response retrieve_pet_details(long petid) {
		Response response=given()
				.pathParam("petid", petid)
				 .accept("application/xml")
				.when()
				.post(Routes.get_pet_url);
		return response;	
	}
	
	public static Response update_pet_details( String updateddata) {
		Response response=given()
				.contentType("application/xml")
				.accept("application/xml")
				.body(updateddata)
				
				.when()
				.put(Routes.update_pet_url);
		return response;
				
	}
	
	public static Response delete_pet(long petid) {
		Response response=given()
				.pathParam("petid", petid)
				.accept("application/xml")
				
				.when()
				.delete(Routes.delete_pet_url);
		return response;
				 
	}
	
	
}
