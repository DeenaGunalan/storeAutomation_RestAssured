package api.endpoints;

public class Routes {
	
	
	//URI - https://petstore.swagger.io/v2
	
	//POST - https://petstore.swagger.io/v2/user
	//PUT - https://petstore.swagger.io/v2/user/{username}
	//GET - https://petstore.swagger.io/v2/user/{username}
	//DELETE - https://petstore.swagger.io/v2/user/{username}

	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	
	//User Module
	public static String post_url = "https://petstore.swagger.io/v2/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	
	
	
	
}
