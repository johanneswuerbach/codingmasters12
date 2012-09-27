package challenge1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object parse = JSONValue.parse( "{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}" );
		JSONObject test = (JSONObject) parse;
		
		System.out.println(test.get( "1" ));
	}

}
