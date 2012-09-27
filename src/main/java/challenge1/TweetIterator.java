package challenge1;

import java.util.Iterator;

public class TweetIterator implements Iterator<Tweet> {
	
	private StringIterator _stringIterator;
	
	public TweetIterator(StringIterator stringIterator) {
		_stringIterator = stringIterator;
	}

	public boolean hasNext() {
		return _stringIterator.hasNext();
	}

	public Tweet next() {
		// TODO parse strings
		// _stringIterator.next() ;
		return null;
	}

	public void remove() {
		_stringIterator.remove();
	}
}
