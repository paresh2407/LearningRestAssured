package api.endpoints;

/*
 * Swagger URI --> https://petstore.swagger.io/v2
 * 
 * Create User(Post) --> https://petstore.swagger.io/v2/user
 * Get User (Get) --> https://petstore.swagger.io/v2/user/{username}
 * Update User (Post) --> https://petstore.swagger.io/v2/user/{username}
 * Delete User (Delete) --> https://petstore.swagger.io//v2/user/{username}
 *  
 */

public class Routes {
	
	public static String base_URL = "https://petstore.swagger.io/v2";
	
//	User Module
	public static String post_URL = base_URL+"/user";
	public static  String get_URL = base_URL+"/user/{username}";
	public static String put_URL = base_URL+"/user/{username}";
	public static String delete_URL = base_URL+"/user/{username}";
	

}
