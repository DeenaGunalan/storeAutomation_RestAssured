package api.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints1;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests1 {
	
	Faker faker;
	User userPayload;
	public static Logger logger;

	@BeforeClass
	public void Setup() {
	
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger = LogManager.getLogger(this.getClass());

	}
	
	@Test(priority = 1)
	public void testPostUser() {
		
		Response postUserRes=UserEndPoints1.createUser(userPayload);
		postUserRes.then().statusCode(200).log().all();
		
		Assert.assertEquals(postUserRes.statusCode(), 200);
		
		logger.info("***User Created****");
		
	}
	
	@Test(priority = 2)
	public void testGetUser() {
		
		Response getUserRes = UserEndPoints1.getUser(this.userPayload.getUsername());
		Assert.assertEquals(getUserRes.statusCode(), 200);
		getUserRes.then().log().all();
		
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		
		Response postUserRes=UserEndPoints1.updateUser(this.userPayload.getUsername(), userPayload);
		postUserRes.then().statusCode(200).log().all();		
		Assert.assertEquals(postUserRes.statusCode(), 200);
		
		Response getUserPostUpdateRes = UserEndPoints1.getUser(this.userPayload.getUsername());
		Assert.assertEquals(getUserPostUpdateRes.statusCode(), 200);
		Assert.assertEquals(getUserPostUpdateRes.jsonPath().getString("firstName"), this.userPayload.getFirstName());
		Assert.assertEquals(getUserPostUpdateRes.jsonPath().getString("lastName"), this.userPayload.getLastName());

		
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		
		Response getUserRes = UserEndPoints1.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(getUserRes.statusCode(), 200);
		getUserRes.then().log().all();
		
	}
	
	
	
}
