package Testcasestudy;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class upskills {
	
	public static String baseurl="http://rest-api.upskills.in/";
	public static String accesstoken;
	
	
	@Test (enabled = true,priority = 0)
	public void getaccesstoken()
	{
		RestAssured.baseURI = baseurl;
		Response response =given().header("Content-Type","application/json")
				.header("Authorization", "Basic c2hvcHBpbmdfb2F1dGhfY2xpZW50OnNob3BwaW5nX29hdXRoX3NlY3JldA==")
		.when().post("api/rest/oauth2/token/client_credentials")
        .then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
		String jsonresponse = response.asString();
		System.out.println(jsonresponse);
		JsonPath objects= new JsonPath(jsonresponse);
		accesstoken =objects.getString("data.access_token");
		System.out.println(accesstoken);
	}
	@Test (enabled = false,priority = 1)
	public void register()
	{
		RestAssured.baseURI = baseurl;
		String requestbody = "{\r\n"
		+ "  \"firstname\": \"vemo\",\r\n"
		+ "  \"lastname\": \"User\",\r\n"
		+ "  \"email\": \"vkvk5555@gmail.com\",\r\n"
		+ "  \"password\": \"vk@123\",\r\n"
		+ "  \"confirm\": \"vk@123\",\r\n"
		+ "  \"telephone\": \"1-541-754-3010\",\r\n"
		+ "  \"customer_group_id\": \"1\",\r\n"
		+ "  \"agree\": \"1\",\r\n"
		+ "  \"custom_field\": {\r\n"
		+ "    \"account\": {\r\n"
		+ "      \"1\": \"+364545454\"\r\n"
		+ "    }\r\n"
		+ "  }\r\n"
		+ "}\r\n";
		
		 Response response=given().header("Content-Type","application/json")
				 .header("Authorization", "bearer "+ accesstoken)
					.body(requestbody)		
					
					//this is called resource
					.when().post("api/rest/register")
					.then()
					.assertThat().statusCode(200).contentType(ContentType.JSON)
					.extract().response();
					String jsonresponse= response.asString();
					System.out.println(jsonresponse);			
	}
	@Test (enabled = true,priority = 2)
	public void login()
	{
		RestAssured.baseURI = baseurl;
		String requestbody = "{\r\n"
				+ "  \"email\": \"vkvk5555@gmail.com\",\r\n"
				+ "  \"password\": \"vk@123\"\r\n"
				+ "}\r\n";

		
		 Response response=given().header("Content-Type","application/json")
				 .header("Authorization", "bearer "+ accesstoken)
					.body(requestbody)		
					
					//this is called resource
					.when().post("api/rest/login")
					.then()
					.assertThat().statusCode(200).contentType(ContentType.JSON)
					.extract().response();
					String jsonresponse= response.asString();
					System.out.println(jsonresponse);	
	}
	@Test (enabled = true,priority = 3)
	public void logout()
	{
		RestAssured.baseURI = baseurl;
		 Response response=given().header("Content-Type","application/json")
				 .header("Authorization", "bearer "+ accesstoken)
					.when().post("api/rest/logout")
					.then()
					.assertThat().statusCode(200).contentType(ContentType.JSON)
					.extract().response();
					String jsonresponse= response.asString();
					System.out.println(jsonresponse);	
	}
	
	
		@Test (enabled = true,priority = 4)
	public void forgotpassword()
	{
		RestAssured.baseURI = baseurl;
		String requestbody = "{\r\n"
				+ "  \"email\": \"vkvk5555@gmail.com\"\r\n"
				+ "}\r\n";
		 Response response=given().header("Content-Type","application/json")
				 .header("Authorization", "bearer "+ accesstoken)
				 .body(requestbody)
				 
					.when().post("api/rest/forgotten")
					.then()
					.assertThat().statusCode(200).contentType(ContentType.JSON)
					.extract().response();
					String jsonresponse= response.asString();
					System.out.println(jsonresponse);	
	}
		@Test (enabled = true,priority = 5)
		public void login1()
		{
			RestAssured.baseURI = baseurl;
			String requestbody = "{\r\n"
					+ "  \"email\": \"vkvk5555@gmail.com\",\r\n"
					+ "  \"password\": \"vk@123\"\r\n"
					+ "}\r\n";
				

			
			 Response response=given().header("Content-Type","application/json")
					 .header("Authorization", "bearer "+ accesstoken)
						.body(requestbody)		
						
						//this is called resource
						.when().post("api/rest/login")
						.then()
						.assertThat().statusCode(200).contentType(ContentType.JSON)
						.extract().response();
						String jsonresponse= response.asString();
						System.out.println(jsonresponse);	
		}
		
			@Test (enabled = true,priority = 6)
		public void getaccountdetails()
		{
			RestAssured.baseURI = baseurl;
			
			 Response response=given().header("Content-Type","application/json")
					 .header("Authorization", "bearer "+ accesstoken)
					 
					 
						.when().get("api/rest/account")
						.then()
						.assertThat().statusCode(200).contentType(ContentType.JSON)
						.extract().response();
						String jsonresponse= response.asString();
						System.out.println(jsonresponse);	
		}
			@Test (enabled = true,priority = 7)
			public void updateaccountdata()
			{
				RestAssured.baseURI = baseurl;
				String requestbody = "{\r\n"
						+ "  \"firstname\": \"vemo55\",\r\n"
						+ "  \"lastname\": \"User55\",\r\n"
						+ "  \"email\": \"vkvk5555@gmail.com\",\r\n"
						+ "  \"telephone\": \"1-541-754-3010\",\r\n"
						+ "  \"custom_field\": {\r\n"
						+ "    \"account\": {\r\n"
						+ "      \"1\": \"+364545454\"\r\n"
						+ "    }\r\n"
						+ "  }\r\n"
						+ "}\r\n";
				
				 Response response=given().header("Content-Type","application/json")
						 .header("Authorization", "bearer "+ accesstoken)
						 .body(requestbody)
						 
							.when().put("api/rest/account")
							.then()
							.assertThat().statusCode(200).contentType(ContentType.JSON)
							.extract().response();
							String jsonresponse= response.asString();
							System.out.println(jsonresponse);	
			}
			@Test (enabled = true,priority = 8)
			public void logout1()
			{
				RestAssured.baseURI = baseurl;
				 Response response=given().header("Content-Type","application/json")
						 .header("Authorization", "bearer "+ accesstoken)
							.when().post("api/rest/logout")
							.then()
							.assertThat().statusCode(200).contentType(ContentType.JSON)
							.extract().response();
							String jsonresponse= response.asString();
							System.out.println(jsonresponse);	
			}
	
}
