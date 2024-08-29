package api.endpoints;

public class Routes {
	// for base URL
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	
	
	//for user module
	// design end points
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//we create url for different modules
	//Pet
		public static String get_pet_url=base_url+"/pet/{petid}";
		public static String post_pet_url=base_url+"/pet";
		public static String update_pet_url=base_url+"/pet";
		public static String delete_pet_url=base_url+"/pet/{petid}";
}
