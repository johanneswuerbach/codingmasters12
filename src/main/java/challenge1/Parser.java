package challenge1;


public class Parser {

	private final String[] _directories;
	
	public Parser(String[] directories) {
		_directories = directories;
	}

	public Parser(String directory) {
		_directories = new String[]{directory};
	}
	
	

	public TweetIterator tweetIterator() {
		return new TweetIterator(rawIterator());
	}
	
	public RawIterator rawIterator() {
		return new RawIterator(_directories);
	}
}
