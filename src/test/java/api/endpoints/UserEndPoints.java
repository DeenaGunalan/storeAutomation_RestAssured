package api.endpoints;

//Created to perform CRUD operations to the User API's

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

import api.payload.User;

public class UserEndPoints {

	public static Response createUser(User payload) {

		Response res = given().accept("application/json").contentType("application/json").body(payload)
				.post(Routes.post_url);

		return res;
	}

	public static Response getUser(String userName) {

		Response res = given()

				.pathParam("username", userName).when().get(Routes.get_url);

		return res;
	}

	public static Response updateUser(String userName, User payload) {

		Response res = given().contentType("application/json").accept("application/json")
				.pathParam("username", userName).body(payload).when().put(Routes.update_url);

		return res;
	}

	public static Response deleteUser(String userName) {

		Response res = given()

				.pathParam("username", userName).when().delete(Routes.delete_url);

		return res;
	}

}
