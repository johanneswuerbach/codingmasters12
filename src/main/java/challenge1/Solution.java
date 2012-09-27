package challenge1;

public class Solution
{
	public void question6()
	{
		Parser parser = new Parser( "/Users/Niklas/Desktop/tweets" );
		TweetIterator it = parser.tweetIterator();
		int all = 0;
		int insta = 0;
		int i = 0;
		
		while( it.hasNext() )
		{
			Tweet t = it.next();
			all++;
			
			if( t.getSourceText().equals( "Instagram" ) )
			{
				insta++;
			}
			
			if( ++i % 100000 == 0 )
			{
				System.out.println("All: " + all + ", Instagram: " + insta );
			}
		}
		
		System.out.println("All: " + all + ", Instagram: " + insta );
	}
}