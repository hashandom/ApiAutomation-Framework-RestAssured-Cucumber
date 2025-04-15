package ecommerce;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class EcommerceApiTest {
	
	@Test
	public void login() {
		
		RequestSpecification reqSpec =	new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();
			
		
			LoginRequest login = new LoginRequest();
			login.setUserEmail("sampathdh199@gmail.com");
			login.setUserPassword("971191023V#samjoes$");
			
			
		RequestSpecification reqLogin=		
					given()
					.log().all()
					.spec( reqSpec)		
					.body(login);
		
		ResponseSpecification resSpec =	new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
		
				
		LoginResponse loginRes=reqLogin.when().post("api/ecom/auth/login")
				.then()
					.log().all()
					.spec(resSpec)
					.extract()
					.response().as(LoginResponse.class);
		
		String token = loginRes.getToken();
		String userId = loginRes.getUserId();
		System.out.println("the token is " + token);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//add product
		
		RequestSpecification addProductBaseReq =	new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization",token)
				.build();
			
			
		RequestSpecification addProductReq=		
					given()
					.log().all()
					.spec( addProductBaseReq)		
					.param("productName", "laptop")
					.param("productAddedBy",userId)
					.param("productCategory", "fashion")
					.param("productSubCategory","shirts")
					.param("productPrice","1100")
					.param("productDescription","Addias Originals")
					.param("productFor", "women")
					.multiPart("productImage", new File("C:/Users/user/Desktop/linux-file-structure.png"));

		
//		ResponseSpecification addProductBaseRes =	new ResponseSpecBuilder()
//				.expectStatusCode(200)
//				.expectContentType(ContentType.JSON)
//				.build();
		
				
		String  AddProductRes =addProductReq.when().post("api/ecom/product/add-product")
				.then()
					.log().all()
//					.spec(resSpec)
					.extract()
					.response().asString();
		
		JsonPath js = new JsonPath(AddProductRes);
		String productId = js.getString("productId");
		System.out.println("add product from the " + productId);
		
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//create order
		
		
				RequestSpecification createOrderBaseReq =	new RequestSpecBuilder()
						.setBaseUri("https://rahulshettyacademy.com")
						.setContentType(ContentType.JSON)
						.addHeader("Authorization",token)
						.build();
			
				OrderDetials order1 = new OrderDetials();
				order1.setCountry("india");
				order1.setProductOrderedId(productId);
				
				Orders productOrders = new Orders();
				List<OrderDetials> mylist = new ArrayList<>();
				mylist.add(order1);
				
				productOrders.setOrders(mylist);
				
				
					
				RequestSpecification createOrderReq=		
							given()
							.log().all()
							.spec( createOrderBaseReq)		
							.body(productOrders);
				
//				ResponseSpecification addProductBaseRes =	new ResponseSpecBuilder()
//						.expectStatusCode(200)
//						.expectContentType(ContentType.JSON)
//						.build();
				
						
				String  ordersRequest =createOrderReq.when().post("api/ecom/order/create-order")
						.then()
							.log().all()
//							.spec(resSpec)
							.extract()
							.response().asString();
				
				System.out.println("////////my order request is " + ordersRequest);
				
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
				//delete order
				
				RequestSpecification deleteOrderBaseReq =	new RequestSpecBuilder()
						.setBaseUri("https://rahulshettyacademy.com")
						.addHeader("Authorization",token)
						.build();
				
					
				RequestSpecification deleteOrderReq=		
							given()
							.log().all()
							.spec(deleteOrderBaseReq)
							.pathParams("productId",productId);
						
				
//				ResponseSpecification addProductBaseRes =	new ResponseSpecBuilder()
//						.expectStatusCode(200)
//						.expectContentType(ContentType.JSON)
//						.build();
				
						
		String delRequest =		deleteOrderReq.when().post("api/ecom/product/delete-product/{productId}")
						.then()
						.log().all()
						.extract().asString();
		
		System.out.println("****this is hte delRequest " + delRequest);
//		
				
				
		
	}
	

}
