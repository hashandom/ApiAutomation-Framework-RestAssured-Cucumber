package googleAuthAccess;


import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AuthAcessCode {
	
	@Test
	public void login() {
		
//		WebDriver driver = new FirefoxDriver();
//		 
//		  driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
//		 
//		  WebElement emailInputField = driver.findElement(By.xpath("//input[@id='identifierId']"));
//		  emailInputField.sendKeys("sampathdds123@gmail.com");
//		  
//		  WebElement nextButton = driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 BqKGqe Jskylb TrZEUc lw1w4b VfPpkd-ksKsZd-mWPk3d']//div[@class='VfPpkd-RLmnJb']"));
//		  nextButton.sendKeys(Keys.ENTER);
//		
//		  WebElement passwordField = driver.findElement(By.xpath("//input[@name='Passwd']"));
//		  passwordField.sendKeys("971191023V#samjoes$");
//		  
//		  WebElement nextButtonPwd = driver.findElement(By.xpath("//span[normalize-space()='Next']"));
//		  nextButtonPwd.sendKeys(Keys.ENTER);
//		  
//		  try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		  String currentUrl = driver.getCurrentUrl();
//		  String code1  = currentUrl.split("code=")[1];
//		  String code2 = code1.split("&scope")[0];
//	
//		  System.out.println("the code is " + code2);
	
	//get the access token
	String responseAccessToken =	given()
			.urlEncodingEnabled(false)
			.log().all()
			.header("Content-Type","application/json")
			.queryParam("code","4%2F0Ab_5qlm08xxsjdA6qviVA-8Sw7USvpG_i_iAXMJVZzHHBF7v6KSv5CGlBbSA0x4915PCfA")
			.queryParam("client_id","https://accounts.google.com/o/oauth2/v2/auth")
			.queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
			.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
			.queryParam("grant_type", "authorization_code")
			
		.when()
			.post("https://accounts.google.com")
		.then()
			.log().all()
			.extract().asString();
	
	JsonPath js = new JsonPath(responseAccessToken);
	String access_token = js.getString("access_token");
	
	/////////////////////////////////////////////////////////////////////////////
	//get the actual response from the actual api
	String responseActual =	given()
			.log().all()
			.header("Content-Type","application/json")
			.queryParam("access_token", access_token)
			
		.when()
			.get("https://rahulshettyacademy.com/getCourse.php")
		.then()
			.log().all()
			.extract().asString();
	System.out.println("thtis is the last url " + responseActual);

}
}