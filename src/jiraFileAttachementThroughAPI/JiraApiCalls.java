package jiraFileAttachementThroughAPI;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import file.Payload;
import io.restassured.RestAssured;

public class JiraApiCalls {
	
	@Test(enabled=false)
	public void createIssue() {
		RestAssured.baseURI = "https://sampathdh199.atlassian.net";
	   
			
		given()
			.log().all()
			.header("Content-Type","application/json")
			.header("Accept","application/json")
			.header("Authorization","Basic c2FtcGF0aGRoMTk5QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjB4eHhPRk94cFRDa3RKRFlOaGo2eEpzaDFReXdXVXpXOU1QbVhOQWU1NTlndWs0TFV0OTd3RkJIS3NBMGtFTzNPeWlwTFRMdV9BLUNDbFYxaVFqWVlaVm0tenJGNm9tR3dNVWxmb19oYnhiYVl1aDFBZWhaMFRMRm9pdjZKNUF3Tjc3MXBucUtKRVBLbEFrcmtjeHI1X0JXVWZhQUNteEVFcDZSTHJhOGR1S1E9QjZFMTY0NEU")
			.body(Payload.createIssuePayload())
		.when().post("rest/api/2/issue")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201);
			
			
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void addAttachments() {
		RestAssured.baseURI = "https://sampathdh199.atlassian.net";
	   
			
		given()
			.log().all()
			.header("X-Atlassian-Token","no-check")
			.header("Authorization","Basic c2FtcGF0aGRoMTk5QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjB4eHhPRk94cFRDa3RKRFlOaGo2eEpzaDFReXdXVXpXOU1QbVhOQWU1NTlndWs0TFV0OTd3RkJIS3NBMGtFTzNPeWlwTFRMdV9BLUNDbFYxaVFqWVlaVm0tenJGNm9tR3dNVWxmb19oYnhiYVl1aDFBZWhaMFRMRm9pdjZKNUF3Tjc3MXBucUtKRVBLbEFrcmtjeHI1X0JXVWZhQUNteEVFcDZSTHJhOGR1S1E9QjZFMTY0NEU")
			.multiPart("file", new File("C:\\Users\\user\\Desktop\\linux-file-structure.png"), "image/jpeg")
		.when().post("rest/api/3/issue/10006/attachments")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200);
			
			
		
	}
	

}
