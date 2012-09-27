package challenge1.questions;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import challenge1.Parser;
import challenge1.Tweet;
import challenge1.TweetIterator;

public class Q08 {
	
	public static void answer() {
		Parser parser = new Parser( "C:\\twitter" );
		TweetIterator it = parser.tweetIterator();
		
		int i = 0;
		Map<String, Integer> stats = new HashMap<String, Integer>();
		
		while( it.hasNext() )
		{
			Tweet t = it.next();
			JSONObject coordinates = t.getCoordinates();
			
			if( coordinates != null )
			{
				String type = (String) coordinates.get("type");
				
				if( !stats.containsKey(type)) {
					stats.put(type, 0);
				}
				
				Integer integer = stats.get(type);
				stats.put(type, ++integer);
			}
		}
		
		System.out.println( stats.toString() );
	}

	public static void main(String[] args) {
		Q08.answer();
	}

}
