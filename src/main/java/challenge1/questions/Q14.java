package challenge1.questions;

import java.util.HashMap;
import java.util.Map.Entry;

import challenge1.Parser;
import challenge1.Tweet;
import challenge1.TweetIterator;

public class Q14 {

	public static void answer() {

		String[] week = { "C:\\twitter\\2012-08-13",
				"C:\\twitter\\2012-08-14",
				"C:\\twitter\\2012-08-15",
				"C:\\twitter\\2012-08-16",
				"C:\\twitter\\2012-08-17",
				"C:\\twitter\\2012-08-18",
				"C:\\twitter\\2012-08-19" };

		String[] sweek = { "C:\\twitter\\2012-08-13" };

		Parser parser = new Parser(week);
		TweetIterator it = parser.tweetIterator("(.*)Germany(.*)");

		HashMap<String, Integer> table = new HashMap<String, Integer>();

		while (it.hasNext()) {
			Tweet tweet = it.next();

			String country = tweet.getCountry();
			if (country != null && country.equals("Germany")) {
				String city = tweet.getCity();
				if (city != null) {
					Integer count = table.get(city);
					if (count == null) {
						count = 1;
					} else {
						count++;
					}
					table.put(city, count);
				}
			}
		}

		for (Entry<String, Integer> item : table.entrySet()) {
			System.out.println(item.getKey() + ": " + item.getValue());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Q14.answer();
	}

}
