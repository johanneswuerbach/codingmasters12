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

	/**
	 * Get source such as "<a href="asdf">Twitter for android</a>".
	 * 
	 * @return
	 */
	public String getSource() {
		return (String) _object.get( "source" );
	}

	/**
	 * Get source text (without html).
	 * 
	 * @return
	 * @see #getSource()
	 */
	public String getSourceText() {
		return getSource().replaceAll( "<a.*>(.*)</a>", "$1" );
	}
	
	public JSONObject getCoordinates() {
		Object coords = _object.get( "coordinates" );
		
		return (JSONObject) coords;
	}
	
	public String getCity() {
		JSONObject object = (JSONObject) _object.get( "place" );
		
		if (object == null) {
			return null;
		}
		if (!((String) object.get("place_type")).equals("city")) {
			return null;
		}
		return (String) object.get("name");
	}

}
