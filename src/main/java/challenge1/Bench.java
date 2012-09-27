package challenge1;

public class Bench {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long start = System.currentTimeMillis();
		
		Parser parser = new Parser("C:\\twitter\\2012-08-13");
		TweetIterator it = parser.tweetIterator();
		
		int count = 0;
		int limit = 10000;
		while(it.hasNext() && count++ < limit) {
			it.next();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Readed " + limit + " tweets in " + (end - start) + "ms.");
	}

}
