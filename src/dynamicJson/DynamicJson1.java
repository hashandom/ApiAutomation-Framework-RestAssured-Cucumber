package dynamicJson;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import file.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static  io.restassured.RestAssured.*;


public class DynamicJson1 {
	
	@Test(dataProvider="bookData")
	public void addBook(String bookName, String isbn, String aisle, String author) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	   
		String respponse=	
		given()
			.log().all()
			.header("Content-Type","application/json")
			.body(Payload.postPayload( bookName, isbn, aisle,author))
		.when().post("Library/Addbook.php")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.extract().asString();
			
		JsonPath jsAddBook = ReusableMethods.jsonToStringConversation(respponse);
		String actualId = jsAddBook.getString("ID");
		System.out.println("the actual id is"+ actualId);
	}
	
	
	@DataProvider(name="bookData")
	public Object[][] bookData() {
		return new Object [][] {{"automation edition 4","aaa4","5004","hashan14"},{"automation edition 5","aaa5","5005","hashan15"},{"automation edition 6","aaa6","5006","hashan16"}};
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	@Test(enabled=false)
	public void get_book_by_id() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	   
		given()
			.log().all()
			.header("Content-Type","application/json")
			.queryParam("ID", "bcd2926")
		.when().post("Library/GetBook.php")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	@Test(enabled=false)
	public void get_book_by_author_name() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	   
		given()
			.log().all()
			.header("Content-Type","application/json")
			.queryParam("AuthorName", "John foer")
		.when().post("Library/GetBook.php")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	@Test(enabled=false)
	public void delete_book() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	   
		given()
			.log().all()
			.body("{\r\n"
					+ "    \"ID\": \"bcd2926\"\r\n"
					+ "}")
		.when().post("Library/DeleteBook.php")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200);
	}
	

}
