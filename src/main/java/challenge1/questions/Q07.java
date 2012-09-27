package challenge1.questions;

import challenge1.*;

public class Q07 {
	
	public static void answer() {
		
		Parser parser = new Parser("/Users/johannes/Documents/SAP/twitter/2012-08-13");
		TweetIterator it = parser.tweetIterator();
		
		while(it.hasNext()) {
			Tweet tweet = it.next();
			System.out.println(tweet.getCity());
		}
	}

}
