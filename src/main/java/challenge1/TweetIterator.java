package challenge1;

import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class TweetIterator implements Iterator<Tweet> {
	
	private RawIterator _stringIterator;
	
	public TweetIterator(RawIterator stringIterator) {
		_stringIterator = stringIterator;
	}

	public boolean hasNext() {
		return _stringIterator.hasNext();
	}

	public Tweet next() {
		RawTweet next = _stringIterator.next();
		JSONObject object = (JSONObject) JSONValue.parse(next.getData());
		return new Tweet(object);
	}

	public void remove() {
		_stringIterator.remove();
	}
}
