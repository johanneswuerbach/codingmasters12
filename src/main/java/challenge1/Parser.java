package challenge1;


public class Parser {

	private final String _directory;

	public Parser(String directory) {
		_directory = directory;
	}

	public TweetIterator tweetIterator() {
		return new TweetIterator(stringIterator());
	}
	
	public StringIterator stringIterator() {
		return new StringIterator(_directory);
	}
}
