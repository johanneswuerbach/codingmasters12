package challenge1.question2.test;

import static org.junit.Assert.*;

import java.net.URLDecoder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import challenge1.question2.CountHtmlCharacters;

public class CountHtmlCharactersTest {
	
	private CountHtmlCharacters countHtmlCharacters = null;
	private static String characterSet = "abc&rmpg&amp;&tc";
	private static int characterCount = 12;

	@Before
	public void setUp() throws Exception {
		this.countHtmlCharacters = new CountHtmlCharacters(this.characterSet);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testCountHtmlCharacters() throws Exception {
		
		assertEquals("Wrong count", this.characterCount, this.countHtmlCharacters.getCount());
	}

}
