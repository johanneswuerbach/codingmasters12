package challenge1.questions;

import challenge1.Parser;
import challenge1.Tweet;
import challenge1.TweetIterator;

public class Q06 {
	
	public static void answer() {
		Parser parser = new Parser( "C:\\twitter" );
		TweetIterator it = parser.tweetIterator();
		int all = 0;
		int instagram = 0;
		int i = 0;
		
		while( it.hasNext() )
		{
			Tweet t = it.next();
			all++;
			
			if( t.getSourceText().equals( "Instagram" ) )
			{
				instagram++;
			}
			
			if( ++i % 100000 == 0 )
			{
				System.out.println("All: " + all + ", Instagram: " + instagram );
			}
		}
		
		System.out.println( ( instagram / (float) all ) * 100 + "%" );
	}

	public static void main(String[] args) {
		Q06.answer();
	}

}
