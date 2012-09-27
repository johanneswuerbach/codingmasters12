package challenge1.questions;

import java.util.HashSet;
import java.util.Set;

import challenge1.Parser;
import challenge1.Tweet;
import challenge1.TweetIterator;

public class Q09 {
	
	public static void anwser() {
		Parser parser = new Parser( "C:\\twitter2" );
		TweetIterator it = parser.tweetIterator();
		Set<Integer> ids = new HashSet<Integer>();
		int i = 0;
		
		while( it.hasNext() )
		{
			Tweet t = it.next();
			ids.add( (int) (( t.getId() >> 41 ) & 0x3FF) );
		}
		
		System.out.println( ids.toString() );
		System.out.println( ids.size() + "");
	}

	public static void main(String[] args) {
		Q09.anwser();
	}

}
