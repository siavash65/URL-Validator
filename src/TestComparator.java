import static org.junit.Assert.*;

import org.junit.Test;


public class TestComparator {

	@Test
	public void testSurceURL() {
		
		String url1 = "http://www.example.com/display?lang=en&article=fred";
		String url2 = "https://www.example.com/display?lang=en&article=fred";
		String url3 = "ftp://www.example.com/display?lang=en&article=fred";
		String url4 = "http://www.example.com:80/";
		String url5 = "https://www.example.com:443/";
		String url6 = "ftp://www.example.com:20/";
		String url7 = "http://208.77.188.166/display?lang=en&article=fred";
		String url8 = "http://example.com/display?lang=en&article=fred";
		String url9 = "http://www.example.xxx:80/display?lang=en&article=fred";
		String url10 = "http://www.example.org/display?lang=en&article=fred";
		
		Parser.parse(url1);
		URL sourceurl1 = Parser.getURL();
		Parser.parse(url2);
		URL sourceurl2 = Parser.getURL();
		Parser.parse(url3);
		URL sourceurl3 = Parser.getURL();
		Parser.parse(url4);
		URL sourceurl4 = Parser.getURL();
		Parser.parse(url5);
		URL sourceurl5 = Parser.getURL();
		Parser.parse(url6);
		URL sourceurl6 = Parser.getURL();
		Parser.parse(url7);
		URL sourceurl7 = Parser.getURL();
		Parser.parse(url8);
		URL sourceurl8 = Parser.getURL();
		Parser.parse(url9);
		URL sourceurl9 = Parser.getURL();
		Parser.parse(url10);
		URL sourceurl10 = Parser.getURL();		
		
		
	    assertEquals(0,Comparator.compare(sourceurl1, sourceurl1));
	    
		assertTrue(Comparator.compare(sourceurl1, sourceurl2) < 0);
		
		assertTrue(Comparator.compare(sourceurl1, sourceurl3) > 0);
		
		assertTrue(Comparator.compare(sourceurl4, sourceurl5) < 0);
		
		assertTrue(Comparator.compare(sourceurl1, sourceurl7) > 0);
		
		assertTrue(Comparator.compare(sourceurl1, sourceurl10) < 0);
		
		assertTrue(Comparator.compare(sourceurl6, sourceurl8) < 0);
		
		assertEquals(0,Comparator.compare(sourceurl9, sourceurl9));
		
	}
		@Test
		public void testNormalURL() {
		
			String url1 = "http://www.example.com/display?lang=en&article=fred";
			String url2 = "https://www.example.com/display?lang=en&article=fred";
			String url3 = "ftp://www.example.com/display?lang=en&article=fred";
			String url4 = "http://www.example.com:80/";
			String url5 = "https://www.example.com:443/";
			String url6 = "ftp://www.example.com:20/";
			String url7 = "http://208.77.188.166/display?lang=en&article=fred";
			String url8 = "http://example.com/display?lang=en&article=fred";
			String url9 = "http://www.example.xxx:80/display?lang=en&article=fred";
			String url10 = "http://www.example.org/display?lang=en&article=fred";
			String url11 = "http://www.Example.org/display?lang=en";
			String url12 = "http://en.wikipedia.org/wiki/Unit_testing#Unit_testing_limitations";
			String url13 = "http://en.wikipedia.org/wiki/Unit_testing#Language-level_unit_testing_support";
			
			Parser.parse(url1);
			URL normalurl1 = Normalizer.nomalize(Parser.getURL());
			Parser.parse(url2);
			URL normalurl2 = Normalizer.nomalize(Parser.getURL());
			Parser.parse(url3);
			URL normalurl3 = Normalizer.nomalize(Parser.getURL());
			Parser.parse(url4);
			URL normalurl4 = Normalizer.nomalize(Parser.getURL());
			Parser.parse(url5);
			URL normalurl5 = Normalizer.nomalize(Parser.getURL());
			Parser.parse(url6);
			URL normalurl6 = Normalizer.nomalize(Parser.getURL());
			Parser.parse(url7);
			URL normalurl7 = Normalizer.nomalize(Parser.getURL());
			Parser.parse(url8);
			URL normalurl8 = Normalizer.nomalize(Parser.getURL());
			Parser.parse(url9);
			URL normalurl9 = Normalizer.nomalize(Parser.getURL());
			Parser.parse(url10);
			URL normalurl10 = Normalizer.nomalize(Parser.getURL());
			Parser.parse(url11);
			URL normalurl11 = Normalizer.nomalize(Parser.getURL());
			Parser.parse(url12);
			URL normalurl12 = Normalizer.nomalize(Parser.getURL());
			Parser.parse(url13);
			URL normalurl13 = Normalizer.nomalize(Parser.getURL());
			
			
			assertEquals(0,Comparator.compare(normalurl1, normalurl8));
			
			assertEquals(0,Comparator.compare(normalurl2, normalurl5));
			
			assertEquals(0,Comparator.compare(normalurl3, normalurl6));
			
			assertEquals(0,Comparator.compare(normalurl10, normalurl11));
			
			assertEquals(0,Comparator.compare(normalurl4, normalurl1));
			
			assertTrue(Comparator.compare(normalurl10, normalurl9) < 0);
			
			assertTrue(Comparator.compare(normalurl7, normalurl8) > 0);
			
			assertFalse(Comparator.compare(normalurl13, normalurl12) < 0);

		}		
}
