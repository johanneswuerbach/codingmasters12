package challenge1;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Parser parser = new Parser("/Users/johannes/Documents/SAP/twitter");
		TweetIterator it = parser.tweetIterator();
		
		while(it.hasNext()) {
			Tweet t = it.next();
			System.out.println(t.getText());
		}

	}

}
