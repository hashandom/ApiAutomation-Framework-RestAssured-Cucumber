package dynamicJson;

public class Payload {

	public static String postPayload(String bookName, String isbn, String aisle, String author) {
	    String payload = "{\n"
	            + "\"name\":\"" + bookName + "\",\n"
	            + "\"isbn\":\"" + isbn + "\",\n"
	            + "\"aisle\":\"" + aisle + "\",\n"
	            + "\"author\":\"" + author + "\"\n"
	            + "}";
	    return payload;
	}

	}
	

