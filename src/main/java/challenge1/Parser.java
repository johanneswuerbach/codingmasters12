package challenge1;


public class Parser {

	private final String _directory;

	public Parser(String directory) {
		_directory = directory;
	}

	public TweetIterator tweetIterator() {
		return new TweetIterator(rawIterator());
	}
	
	public RawIterator rawIterator() {
		return new RawIterator(_directory);
	}
}
