package challenge1;

import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class TweetIterator implements Iterator<Tweet> {
	
	private StringIterator _stringIterator;
	
	public TweetIterator(StringIterator stringIterator) {
		_stringIterator = stringIterator;
	}

	public boolean hasNext() {
		return _stringIterator.hasNext();
	}

	public Tweet next() {
		JSONObject object = (JSONObject) JSONValue.parse(_stringIterator.next());
		return new Tweet(object);
	}

	public void remove() {
		_stringIterator.remove();
	}
}
