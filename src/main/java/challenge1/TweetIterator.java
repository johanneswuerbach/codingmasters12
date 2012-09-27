package challenge1;

import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TweetIterator implements Iterator<Tweet> {

	private final RawIterator _stringIterator;
	private final JSONParser _parser;

	public TweetIterator(RawIterator stringIterator) {
		_stringIterator = stringIterator;
		_parser = new JSONParser();
	}

	public boolean hasNext() {
		return _stringIterator.hasNext();
	}

	public Tweet next() {
		RawTweet next = _stringIterator.next();
		JSONObject object;
		try {
			object = (JSONObject) _parser.parse(next.getData());
			return new Tweet(object);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void remove() {
		_stringIterator.remove();
	}
}
