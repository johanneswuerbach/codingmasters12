package challenge1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;

public class Solution
{
	public void question6()
	{
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
	
	public void question8()
	{
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
	
	public void question9()
	{
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
}