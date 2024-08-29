package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class user_endpoints {
 // Userendpoints.java
	// create to perform the CRUD actions on API's.
	
	 public static Response create_user(User payload) {
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
	.when()
		.post (Routes.post_url);
		return response;
		
	}
	 public static Response read_user(String userName) {
			Response response=given()
					.pathParam("username", userName)
					

		.when()
			.get(Routes.get_url);
			return response;
			
		}
	 public static Response update_user(String userName,User payload) {
			Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
			
			
		.when()
			.put (Routes.update_url);
			return response;
			
		}
	 public static Response delete_user(String userName) {
			Response response=given()
					.pathParam("username", userName)
					

		.when()
			.delete (Routes.delete_url);
			return response;
			
		}
	 
	 
	 
	 
	 
	
	
	
}
