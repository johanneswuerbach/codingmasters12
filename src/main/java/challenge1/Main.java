package challenge1;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Parser parser = new Parser("/Users/johannes/Documents/SAP/twitter");
		StringIterator it = parser.stringIterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
