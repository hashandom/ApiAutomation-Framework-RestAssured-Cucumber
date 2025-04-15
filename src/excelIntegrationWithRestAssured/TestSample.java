package excelIntegrationWithRestAssured;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException {
		ArrayList<String> arrayData = new ArrayList<String>();
	 	arrayData =  DataDriven.getData("purshase");
	 	
	 	for(String value : arrayData){
	 		System.out.println(value);
	 	}

	}

}
