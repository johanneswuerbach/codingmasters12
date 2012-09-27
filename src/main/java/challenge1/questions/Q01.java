package challenge1.questions;

import challenge1.Parser;
import challenge1.RawIterator;
import challenge1.RawTweet;

public class Q01 {

	public static void answer() {
		
		Parser parser = new Parser("/Users/johannes/Documents/SAP/twitter");
		RawIterator it = parser.rawIterator();
		
		while(it.hasNext()) {
			RawTweet t = it.next();
			System.out.println(t.getFNT());
		}
		
	}

}
