package challenge1;

import org.json.simple.JSONArray;
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
		return (String) _object.get("source");
	}

	/**
	 * Get source text (without html).
	 * 
	 * @return
	 * @see #getSource()
	 */
	public String getSourceText() {
		return getSource().replaceAll("<a.*>(.*)</a>", "$1");
	}

	public JSONObject getCoordinates() {
		Object coords = _object.get("coordinates");

		return (JSONObject) coords;
	}
	
	public long getId() {
		return (Long) _object.get("id");
	}
	
	public String getCreatedAt() {
		return (String) _object.get("created_at");
	}

	public String getCity() {
		JSONObject object = (JSONObject) _object.get("place");

		if (object == null) {
			return null;
		}
		if (!((String) object.get("place_type")).equals("city")) {
			return null;
		}
		return (String) object.get("name");
	}

	public String getPhoto() {
		JSONObject object = (JSONObject) _object.get("entities");
		if (object == null) {
			return null;
		}

		JSONArray items = (JSONArray) object.get("media");
		if (items == null) {
			return null;
		}
		for (int i = 0; i < items.size(); i++) {
			JSONObject item = (JSONObject) items.get(i);
			if (item.get("type").equals("photo")) {
				return (String) item.get("media_url");
			}
		}

		return null;
	}

	public String getCountry() {
		JSONObject object = (JSONObject) _object.get("place");

		if (object == null) {
			return null;
		}
		if (!((String) object.get("place_type")).equals("city")) {
			return null;
		}
		return (String) object.get("country");
	}

}
