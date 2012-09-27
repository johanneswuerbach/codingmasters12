package challenge1;

import org.json.simple.JSONObject;

public class Tweet {
	
	private JSONObject _object;

	public Tweet(JSONObject object) {
		_object = object;
	}
	
	public String getText() {
		return (String) _object.get("text");
	}

}
