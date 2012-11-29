import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public final class Main {

	private static ArrayList<URL> validurls = new ArrayList<URL>();
	private static ArrayList<URL> normalurls = new ArrayList<URL>();
	private static ArrayList<String> invalidurls = new ArrayList<String>();
	public static final String URL_LIST_FILE = "urls.txt";
	public static void main(String[] args)
	{
	   try {
		readURLs();
	} catch (FileNotFoundException e) {
		System.out.println("File not found");
		e.printStackTrace();
	}
	}
	
	private static void readURLs()throws FileNotFoundException
	{
		Scanner input = new Scanner(new File(URL_LIST_FILE));
		String url = "";
		while (input.hasNextLine()) {
			url = input.next();
			if(Parser.parse(url)){//if the url is valid normalize it
				validurls.add(Parser.getURL());
				URL normalURL = new URL();
				normalURL = Normalizer.nomalize(Parser.getURL());
				normalurls.add(normalURL);
				System.out.println("Source:");
				System.out.println(url);
				System.out.println("Valid: true");
				System.out.println("Canonical:");
				System.out.println(normalURL.toString());
				System.out.println("Source unique: ********");
				System.out.println("Canonicalized URL unique: ***********");
				
			}
			else{
				invalidurls.add(url);
				System.out.println("Source:");
				System.out.println(url);
				System.out.println("Valid: false");
				System.out.println("Canonical:");
				System.out.println("N/A The URL is invalid");
				System.out.println("Source unique: ********");
				System.out.println("Canonicalized URL unique: N/A The URL is invalid");
				
			}	
		}
		
		input.close();
	}

	
	
}
