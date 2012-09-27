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

}
