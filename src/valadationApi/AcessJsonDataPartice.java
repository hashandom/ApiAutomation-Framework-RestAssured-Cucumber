package valadationApi;

import file.complexJson;
import io.restassured.path.json.JsonPath;

public class AcessJsonDataPartice {

	public static void main(String[] args) {
		int noOfCourses;
		int k = 0;
//		// TODO Auto-generated method stub
			String jsonPayload = complexJson.particeSelectJsonData();
			JsonPath jsSelect = new JsonPath(jsonPayload);
//			
//			//1. Print No of courses returned by API
//			System.out.println("no of courses" + jsSelect.getInt("courses.size()"));
//			
//			//2.Print Purchase Amount
//			System.out.println("Price of the course: " + jsSelect.getInt("dashboard.purchaseAmount"));
//
//			
//			//3. Print Title of the first course
//			System.out.println("Title of the first course: " + jsSelect.get("courses[0].title"));
//
//			//4. Print All course titles and their respective Prices
//			
			noOfCourses = jsSelect.getInt("courses.size()");
//			System.out.println(noOfCourses);
//			for(int  i=0 ; i<noOfCourses ; i++) {
//				String courseTitle = jsSelect.get("courses[" + i + "].title");
//				int coursePrise 	= jsSelect.get("courses[" + i + "].price");
//			    System.out.println("Title of the course " + (i + 1) + ": " + courseTitle + "price of the course " + coursePrise);
//			}

//			//5. Print no of copies sold by RPA Course
//			for(int j =0 ; j<noOfCourses ; j++) {
//				if(jsSelect.get("courses[" + j + "].title").equals("RPA")) {
//					int NoOfCopies = jsSelect.get("courses[" + j + "].copies");
//					System.out.println("no of copies " + NoOfCopies);
//				}
//			}
//			
			


			//6. Verify if Sum of all Course prices matches with Purchase Amount
			int sum = 0;
			int calculation;
			for (int i = 0; i < noOfCourses; i++) {
			    int price = jsSelect.getInt("courses[" + i + "].price");
			    int copies = jsSelect.getInt("courses[" + i + "].copies");
			    calculation = price*copies;
			    sum = sum + calculation;
			}

			int actualPrice = sum;
			System.out.println("Actual Price: " + actualPrice);
			int totalPrice = jsSelect.getInt("dashboard.purchaseAmount");
			System.out.println("Total Price: " + totalPrice);

	}

}
