package challenge1;

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
}