package api.endpoints;
import java.util.ResourceBundle;

//Created to perform CRUD operations to the User API's

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

import api.payload.User;

public class UserEndPoints1 {
	
	static ResourceBundle getUrl(){
		 ResourceBundle bundle =	ResourceBundle.getBundle("routes");
		 return bundle;
	}
	
	
	
	public static Response createUser(User payload) {
		
		String post_url = getUrl().getString("post_url");
		System.out.println(post_url);

		Response res = given().accept("application/json").contentType("application/json").body(payload).post(post_url);

		return res;
	}

	public static Response getUser(String userName) {
		
		String get_url = getUrl().getString("get_url");

		Response res = given()

				.pathParam("username", userName).when().get(get_url);

		return res;
	}

	public static Response updateUser(String userName, User payload) {

		String update_url = getUrl().getString("update_url");
		
		Response res = given().contentType("application/json").accept("application/json")
				.pathParam("username", userName).body(payload).when().put(update_url);

		return res;
	}

	public static Response deleteUser(String userName) {

		String delete_url = getUrl().getString("delete_url");
		
		Response res = given()

				.pathParam("username", userName).when().delete(delete_url);

		return res;
	}

}
