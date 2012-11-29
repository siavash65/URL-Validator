import static org.junit.Assert.*;

import org.junit.Test;


public class TestParser {

	@Test
	public void test() {
		
		//Valid URLs
		String url1 = "http://www.example.com/display?lang=en&article=fred";
		String url2 = "https://www.example.com/display?lang=en&article=fred";
		String url3 = "ftp://www.example.com/display?lang=en&article=fred";
		String url4 = "http://www.example.com:80/";
		String url5 = "https://www.example.com:443/";
		String url6 = "ftp://www.example.com:20/";
		String url7 = "http://208.77.188.166/display?lang=en&article=fred";
		String url8 = "http://example.com/display?lang=en&article=fred";
		String url9 = "http://www.example.xxx/display?lang=en&article=fred";
		String url10 = "http://www.example.org/display?lang=en&article=fred";
		
		//Invalid URLs
		String url11 = "afp://www.example.com/display?lang=en&article=fred";
		String url12 = "https://www.example.cm/display?lang=en&article=fred";
		String url13 = "apt://www.example.com/display?lang=en&article=fred";
		String url14 = "http://www.example.com:8080/";
		String url15 = "https://www.example.com:43/";
		String url16 = "ftp://www.example.com:200/";
		String url17 = "http://208.77.188/display?lang=en&article=fred";
		String url18 = "http://example.can/display?lang=en&article=fred";
		String url19 = "http://www.example.have/display?lang=en&article=fred";
		String url20 = "http://www.example.notvalid/display?lang=en&article=fred";
		
		assertTrue(Parser.parse(url1));
		assertTrue(Parser.parse(url2));
		assertTrue(Parser.parse(url3));
		assertTrue(Parser.parse(url4));
		assertTrue(Parser.parse(url5));
		assertTrue(Parser.parse(url6));
		assertTrue(Parser.parse(url7));
		assertTrue(Parser.parse(url8));
		assertTrue(Parser.parse(url9));
		assertTrue(Parser.parse(url10));
		
		assertFalse(Parser.parse(url11));
		assertFalse(Parser.parse(url12));
		assertFalse(Parser.parse(url13));
		assertFalse(Parser.parse(url14));
		assertFalse(Parser.parse(url15));
		assertFalse(Parser.parse(url16));
		assertFalse(Parser.parse(url17));
		assertFalse(Parser.parse(url18));
		assertFalse(Parser.parse(url19));
		assertFalse(Parser.parse(url20));
		
	}

}
